package com.heiyu.iot.sdk.sensor;

import com.heiyu.iot.sdk.config.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.configure.DataDictionary;
import com.heiyu.iot.sdk.configure.Dict;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import com.heiyu.iot.sdk.sensor.datahandle.I2cReadData;
import com.heiyu.iot.sdk.sensor.datahandle.SendData;
import com.heiyu.iot.sdk.sensor.device.BME280;
import com.heiyu.iot.sdk.sensor.device.MAX44009;
import com.heiyu.iot.sdk.sensor.device.SGP30;
import com.heiyu.iot.sdk.sensor.device.TCA9548A;
import com.pi4j.io.i2c.I2CFactory;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.heiyu.iot.sdk.configure.DataDictionary.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:20 2020/1/22
 **/

@Component
public class SensorHandle {

    /**
     * 传感器类型与的SensorHandle对应关系
     */
    private HashMap<String,Class> handleClassMap = new HashMap<String,Class>();
    {
        handleClassMap.put(SENSOR_I2C, I2cReadData.class);
        handleClassMap.put(SENSOR_BME280, BME280.class);
        handleClassMap.put(SENSOR_MAX44009, MAX44009.class);
        handleClassMap.put(SENSOR_SGP30, SGP30.class);
        handleClassMap.put(SENSOR_TCA9548A, TCA9548A.class);
    }

    @Qualifier("schedulerFactoryBean")
    @Autowired
    private Scheduler scheduler ;

    private MqttClient client;

    public static Lock lock =new ReentrantLock();

    @Autowired
    private Dict dict;

    @Autowired
    SensorHandle(ClientMQTT clientMQTT){
        client = clientMQTT.getClient();
    }

    public static TCA9548A tca9548A;

    public void syncSensorConfig(){

    }

    public void readSensorConfig(SensorConfig[] sensorConfigs){
        for(SensorConfig sensorConfig:sensorConfigs){

            if(sensorConfig.getSensorData().getSensorInterfaceType().equals(DataDictionary.SENSOR_TCA9548A)){
                tca9548A = (TCA9548A) sensorConfig.getSensorData();
                continue;
            }

            JobDataMap jobDataMap =  new JobDataMap();
            SendData sendData = new SendData();
            sendData.setClient(client).setTopic(dict.getTopicSendSensorData());
            jobDataMap.put("sendSensorData", sendData);
            jobDataMap.put("sensorConfig", sensorConfig);
            jobDataMap.put("getDataReady",this);

            Trigger trigger = TriggerBuilder.newTrigger()
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .repeatForever()
                            .withIntervalInMilliseconds(sensorConfig.getReadFrequency()))
                    .build();
            Class clazz = handleClassMap.get(sensorConfig.getSensorData().getSensorInterfaceType());
            JobDetail job = JobBuilder.newJob(clazz)
                    .withIdentity(String.valueOf(sensorConfig.getSensorId()),"Sensor")
                    .setJobData(jobDataMap)
                    .build();
            try {
                scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    public static void detectTCA9548ASensor(String str) {
        if (tca9548A != null) {
            try {
                tca9548A.switchPort(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getReadDataReady(String deviceType){
        if(tca9548A != null){
            try {
                tca9548A.switchPort(deviceType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
