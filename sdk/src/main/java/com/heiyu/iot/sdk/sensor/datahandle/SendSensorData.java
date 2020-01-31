package com.heiyu.iot.sdk.sensor.datahandle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.iot.sdk.entity.Sensor.SensorDataDTO;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 23:24 2020/1/31
 **/

public class SendSensorData {

    private MqttClient client;
    private String topic;

    public MqttClient getClient() {
        return client;
    }

    public SendSensorData setClient(MqttClient client) {
        this.client = client;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public SendSensorData setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public  void sendData(SensorDataDTO sensorDataDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] payload = {};
        try {
            payload = objectMapper.writeValueAsBytes(sensorDataDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        MqttMessage msg = new MqttMessage();
        msg.setQos(0);
        msg.setRetained(false);
        msg.setPayload(payload);
        try {
            client.publish(topic,msg);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
