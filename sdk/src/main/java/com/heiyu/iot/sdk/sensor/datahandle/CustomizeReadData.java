package com.heiyu.iot.sdk.sensor.datahandle;

import com.heiyu.iot.sdk.sensor.device.BME280;
import com.heiyu.iot.sdk.sensor.device.MAX44009;
import com.heiyu.iot.sdk.sensor.device.Sensor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.HashMap;

import static com.heiyu.iot.sdk.configure.DataDictionary.*;
import static com.heiyu.iot.sdk.configure.DataDictionary.SENSOR_SGP30;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:52 2021/01/08
 **/

public class CustomizeReadData implements Job {
    boolean firstTime = true;
    Sensor instance;

    private final HashMap<String,Class> handleClassMap = new HashMap<String,Class>();
    {
        handleClassMap.put(SENSOR_I2C, I2cReadData.class);
        handleClassMap.put(SENSOR_BME280, BME280.class);
        handleClassMap.put(SENSOR_MAX44009, MAX44009.class);
        handleClassMap.put(SENSOR_SGP30,MAX44009.class);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        if (instance != null){

        }
    }
}
