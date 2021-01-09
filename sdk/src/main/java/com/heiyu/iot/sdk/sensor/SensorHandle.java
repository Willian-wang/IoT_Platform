package com.heiyu.iot.sdk.sensor;

import com.heiyu.iot.sdk.config.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.configure.Dict;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import com.heiyu.iot.sdk.sensor.datahandle.I2cReadData;
import com.heiyu.iot.sdk.sensor.datahandle.SendData;
import com.heiyu.iot.sdk.sensor.device.BME280;
import com.heiyu.iot.sdk.sensor.device.MAX44009;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
        handleClassMap.put(SENSOR_SGP30,MAX44009.class);
    }

    @Qualifier("schedulerFactoryBean")
    @Autowired
    private Scheduler scheduler ;

    private MqttClient client;

    @Autowired
    private Dict dict;

    @Autowired
    SensorHandle(ClientMQTT clientMQTT){
        client = clientMQTT.getClient();
    }

    public void syncSensorConfig(){

    }

    public void readSensorConfig(SensorConfig[] sensorConfigs){
        for(SensorConfig sensorConfig:sensorConfigs){
            JobDataMap jobDataMap =  new JobDataMap();
            SendData sendData = new SendData();
            sendData.setClient(client).setTopic(dict.getTopicSendSensorData());
            jobDataMap.put("sendSensorData", sendData);
            jobDataMap.put("sensorConfig", sensorConfig);
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

}
