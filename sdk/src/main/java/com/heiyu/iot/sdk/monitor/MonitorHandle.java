package com.heiyu.iot.sdk.monitor;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 10:57 2021/01/09
 **/

import com.heiyu.iot.sdk.config.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.configure.Dict;
import com.heiyu.iot.sdk.entity.configmap.MonitorConfig;
import com.heiyu.iot.sdk.sensor.datahandle.SendData;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Dictionary;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Service
public class MonitorHandle{

    @Qualifier("schedulerFactoryBean")
    @Autowired
    private Scheduler scheduler ;

    @Autowired
    private ClientMQTT client;

    @Autowired
    private Dict dict;

    public void readMonitorConfig(MonitorConfig monitorConfig){
        ArrayList<Monitor> monitorArrayList = new ArrayList<>();

        if(!monitorConfig.isMonitorEnabled()){
            return;
        }
        if (monitorConfig.isCpuInfoEnabled()){
            monitorArrayList.add(new CPUMonitor());
        }if(monitorConfig.isDiskInfoEnabled()){
            monitorArrayList.add(new DiskMonitor());
        }if(monitorConfig.isMemoryInfoEnabled()){
            monitorArrayList.add(new MemoryMonitor());
        }if(monitorConfig.isNetInfoEnabled()){
            monitorArrayList.add(new NetworkMonitor());
        }if(monitorArrayList.isEmpty()){
            return;
        }JobDataMap jobDataMap =  new JobDataMap();
        SendData sendData = new SendData();
        jobDataMap.put("monitorArrayList",monitorArrayList);
        jobDataMap.put("dataSender",sendData.setClient(client.getClient()).setTopic(dict.getMonitorDataTopic()));
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(simpleSchedule()
                .repeatForever()
                .withIntervalInMilliseconds(monitorConfig.getMonitorInterval()))
                .build();
        Class clazz = MonitorExcuse.class;
        JobDetail job = JobBuilder.newJob(clazz)
                .withIdentity("Monitor","Monitor")
                .setJobData(jobDataMap)
                .build();
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


}
