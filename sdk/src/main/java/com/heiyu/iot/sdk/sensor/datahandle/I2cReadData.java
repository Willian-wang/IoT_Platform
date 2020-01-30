package com.heiyu.iot.sdk.sensor.datahandle;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorData;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cDataSheet;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cSensorData;
import com.heiyu.iot.sdk.entity.SensorConfig;
import com.heiyu.iot.sdk.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.sensor.device.I2cSensor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:06 2020/1/22
 **/


public class I2cReadData implements Job {

    private HashMap<Byte, Integer> rawData;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SensorConfig sensorConfig = (SensorConfig) jobExecutionContext.getMergedJobDataMap().get("sensorConfig");
        MqttClient mqttClient = (MqttClient) jobExecutionContext.getMergedJobDataMap().get("mqttClient");
        i2cReadData((I2cSensorData) sensorConfig.getSensorData());
        i2cFormatData();
        sendData();
    }



    public void i2cReadData(I2cSensorData i2cSensorData){
        HashSet<Byte> readRegister = new HashSet<Byte>();
        HashSet<Byte> writeRegister = new HashSet<Byte>();
        for(I2cDataSheet i2cDataSheet : i2cSensorData.getI2cDataSheet()){
            byte[] array = i2cDataSheet.getDataPosition();
            switch (i2cDataSheet.getDataIOType()){
                case 0:
                    for(byte b:array){
                        readRegister.add(b);
                    }break;
                case 1:
                    for(byte b:array){
                        writeRegister.add(b);
                    }break;
                case 2:
                    for(byte b:array){
                        writeRegister.add(b);
                        readRegister.add(b);
                    }break;
                default:
                    break;
            }
        }
        I2cSensor i2cSensor =new I2cSensor(i2cSensorData.getI2cBusNum()
                ,i2cSensorData.getI2cAddress()
                ,readRegister.toArray(new Byte[0])
                ,writeRegister.toArray(new Byte[0]));
        rawData = i2cSensor.readData();
    }

    public void i2cFormatData(){

    }

    private void sendData(){

    }
}
