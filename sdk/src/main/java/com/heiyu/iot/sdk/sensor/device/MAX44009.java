package com.heiyu.iot.sdk.sensor.device;

import com.heiyu.iot.sdk.entity.Sensor.SensorDataDTO;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import com.heiyu.iot.sdk.sensor.datahandle.SendSensorData;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.HashMap;
import java.util.Map;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 21:39 2021/01/04
 **/

public class MAX44009 implements Sensor, Job {
    I2CBus bus;
    I2CDevice device;

    public  MAX44009(){
        sensorInitial();
    }

    @Override
    public void sensorInitial() {
        try {
            // Create I2C bus
            bus = I2CFactory.getInstance(I2CBus.BUS_1);
            // Get I2C device, MAX44009 I2C address is 0x4A(74)
            device = bus.getDevice(0x4A);

            // Select configuration register, 0x02(02)
            // Continuous mode, Integration time = 800 ms
            device.write(0x02, (byte) 0x40);
            Thread.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sensorDestroy() {

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SensorConfig sensorConfig = (SensorConfig) jobExecutionContext.getMergedJobDataMap().get("sensorConfig");
        SendSensorData sendSensorData = (SendSensorData)jobExecutionContext.getMergedJobDataMap().get("sendSensorData");
        try {
            sendSensorData.sendData(new SensorDataDTO(sensorConfig.getSensorId()).setData((HashMap<String, Object>) readData()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> readData() throws Exception {


        // Read 2 bytes of data from address 0x03(03)
        // luminance MSB, luminance LSB
        byte[] data = new byte[2];
        device.read(0x03, data, 0, 2);

        // Convert the data to lux
        int exponent = (data[0] & 0xF0) >> 4;
        int mantissa = ((data[0] & 0x0F) << 4) | (data[1] & 0x0F);
        double luminance = Math.pow(2, exponent) * mantissa * 0.045;

        // Output data to screen
        System.out.printf("Ambient Light luminance : %.2f lux %n", luminance);

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("luminance", luminance);
        return result;
    }


}
