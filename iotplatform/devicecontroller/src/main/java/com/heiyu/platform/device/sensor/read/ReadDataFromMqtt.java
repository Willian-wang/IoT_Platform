package com.heiyu.platform.device.sensor.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.platform.device.entity.sensor.SensorDataDTO;
import com.heiyu.platform.device.mqtt.ClientMQTT;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;

import static com.heiyu.platform.device.entity.sensor.SensorDataDTO.getSensorDataDTOFromJson;

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
        try{
            String data =new String(message.getPayload());
            SensorDataDTO sensorDataDTO = getSensorDataDTOFromJson(data);
            System.out.println(sensorDataDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
