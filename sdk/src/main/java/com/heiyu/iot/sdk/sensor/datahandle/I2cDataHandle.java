package com.heiyu.iot.sdk.sensor.datahandle;

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

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:06 2020/1/22
 **/


public class I2cDataHandle implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("23333");
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("mqttClient"));
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("sensorConfig"));
    }



    public void i2cReadData(){



    }
}
