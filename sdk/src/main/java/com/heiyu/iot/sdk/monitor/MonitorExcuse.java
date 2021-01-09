package com.heiyu.iot.sdk.monitor;

import com.heiyu.iot.sdk.config.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.entity.MonitorDataDTO;
import com.heiyu.iot.sdk.sensor.datahandle.SendData;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 14:34 2021/01/09
 **/

public class MonitorExcuse implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SendData dataSender = (SendData) context.getMergedJobDataMap().get("dataSender");
        ArrayList<Monitor> taskList = (ArrayList<Monitor>) context.getMergedJobDataMap().get("monitorArrayList");
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        taskList.forEach(monitor -> {
            try {
                monitor.getMonitorData().forEach(dataMap::put);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        dataSender.sendData(new MonitorDataDTO(dataMap));
    }
}
