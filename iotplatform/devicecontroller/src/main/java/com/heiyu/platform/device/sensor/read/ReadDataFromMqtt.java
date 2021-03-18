package com.heiyu.platform.device.sensor.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.platform.device.dao.mongo.SensorDataDao;
import com.heiyu.platform.device.entity.DataDTO;
import com.heiyu.platform.device.entity.MonitorDataDTO;
import com.heiyu.platform.device.entity.sensor.SensorDataDTO;
import com.heiyu.platform.device.mqtt.ClientMQTT;
import com.heiyu.platform.device.service.DataService;
import com.heiyu.platform.device.service.StatusMaintainService;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:46 2020/2/2
 **/
@Component
public class ReadDataFromMqtt implements IMqttMessageListener {

    @Autowired
    ClientMQTT clientMQTT;

    MqttClient mqttClient;

    @Autowired
    SensorDataDao sensorDataDao;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DataService dataService;

    @Autowired
    StatusMaintainService statusMaintainService;

    @PostConstruct
    public void getSubsribe(){
        mqttClient =  clientMQTT.getClient();
        try {
            mqttClient.subscribe("/data/#", this);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void messageArrived(String topic, MqttMessage message)  {
        DataDTO data;
        try{
            if(topic.contains("monitor")){
                data = objectMapper.readValue(message.toString(), MonitorDataDTO.class);
            }else if(topic.contains("sensor")){
                data = objectMapper.readValue(message.toString(),SensorDataDTO.class);
            }else{
                return;
            }
            dataService.deviceDataHandle(data);
            statusMaintainService.flushDeviceStatus(data);
            System.out.println(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
