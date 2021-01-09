package com.heiyu.iot.sdk.sensor.datahandle;

import com.heiyu.iot.sdk.entity.Sensor.SensorDataDTO;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cDataSheet;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cSensorData;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import com.heiyu.iot.sdk.sensor.device.I2cSensor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.HashMap;
import java.util.HashSet;

import static com.heiyu.iot.sdk.sensor.datahandle.SensorDataTypeHandle.handleDataType;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:06 2020/1/22
 **/


public class I2cReadData implements Job {

    public static final byte DATA_POSITION_NORMAL = 0;
    public static final byte DATA_POSITION_INSIDE = 1;
    public static final byte DATA_POSITION_MULTI  = 2;

    public static final byte DATA_IO_TYPE_READ_ONLY      = 0;
    public static final byte DATA_IO_TYPE_WRITE_ONLY     = 1;
    public static final byte DATA_IO_TYPE_READ_AND_WRITE = 2;

    public static final byte REGISTER_LENGTH = 8;

    private HashMap<Byte, Integer> rawData;

    private SensorConfig sensorConfig;

    private I2cSensorData i2cSensorData;

    private SensorDataDTO sensorDataDTO;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        sensorConfig = (SensorConfig) jobExecutionContext.getMergedJobDataMap().get("sensorConfig");
        SendData sendData = (SendData)jobExecutionContext.getMergedJobDataMap().get("sendSensorData");
        i2cSensorData = (I2cSensorData) sensorConfig.getSensorData();
        i2cReadData(i2cSensorData);
        i2cFormatData();
        sendData.sendData(sensorDataDTO);
    }

    private void i2cReadData(I2cSensorData i2cSensorData){
        HashSet<Byte> readRegister = new HashSet<Byte>();
        HashSet<Byte> writeRegister = new HashSet<Byte>();
        for(I2cDataSheet i2cDataSheet : i2cSensorData.getI2cDataSheet()){
            byte[] array = i2cDataSheet.getDataPosition();
            switch (i2cDataSheet.getDataIOType()){
                case DATA_IO_TYPE_READ_ONLY:
                    for(byte b:array){
                        readRegister.add(b);
                    }break;
                case DATA_IO_TYPE_WRITE_ONLY:
                    for(byte b:array){
                        writeRegister.add(b);
                    }break;
                case DATA_IO_TYPE_READ_AND_WRITE:
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

    private void i2cFormatData(){
        sensorDataDTO = new SensorDataDTO(sensorConfig.getSensorId());
        HashMap<String,Object> dataMap=new HashMap<String,Object>();
        for(I2cDataSheet i2cDataSheet : i2cSensorData.getI2cDataSheet()){
            long data = 0;
            switch (i2cDataSheet.getDataPositionType()){
                case DATA_POSITION_NORMAL:
                    data = rawData.get(i2cDataSheet.getDataPosition()[0]);
                    break;
                case DATA_POSITION_INSIDE:
                    data = rawData.get(i2cDataSheet.getDataPosition()[0])
                            >>>i2cDataSheet.getDataOffset()
                            &(1<<i2cDataSheet.getDataLength() -1) ;
                    break;
                case DATA_POSITION_MULTI:
                    for(int n = i2cDataSheet.getDataPosition().length;n>0;n--){
                        data = data | rawData.get(i2cDataSheet.getDataPosition()[n-1]) << (n-1)*REGISTER_LENGTH;
                    }break;
                default:
                    break;
            }dataMap.put(i2cDataSheet.getDataName(),handleDataType(sensorConfig.getSensorId()
                    ,i2cDataSheet.getDataId()
                    ,data));
        }sensorDataDTO.setData(dataMap);
    }

}
