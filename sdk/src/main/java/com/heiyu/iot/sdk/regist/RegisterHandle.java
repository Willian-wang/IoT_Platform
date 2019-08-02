package com.heiyu.iot.sdk.regist;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.iot.sdk.entity.DeviceStatus;
import com.heiyu.iot.sdk.mqtt.ClientMQTT;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName: Main
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 13:23 2019/8/1
 * @Version: 1.0
 **/

@Service
public class RegisterHandle {

    @Autowired
    private ClientMQTT clientMQTT;

    @Autowired
    private DeviceStatus deviceStatus;

    private final static String REGISTER_CLIENT_NAME = "DeviceRegister";
    private final static String REGISTER_TOPIC_NAME = "DeviceRegister";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Async("taskExecutor")
    void connect() throws MqttException, JsonProcessingException {
        MqttClient server = clientMQTT.newMQTTPublish(REGISTER_CLIENT_NAME);
        MqttMessage msg = new MqttMessage();
        deviceStatus.setDeviceStatusCode((byte) 1);
        msg.setQos(1);
        msg.setPayload(objectMapper.writeValueAsBytes(deviceStatus));
        server.publish(REGISTER_TOPIC_NAME,msg);
    }

    @Async("taskExecutor")
    void disconnect() throws MqttException, JsonProcessingException {
        MqttClient server;
        if(clientMQTT.getMqttClientMap().containsKey(REGISTER_CLIENT_NAME)){
            server = clientMQTT.getMqttClientMap().get(REGISTER_CLIENT_NAME);
        }else {
            server = clientMQTT.newMQTTPublish(REGISTER_CLIENT_NAME);
        }

        MqttMessage msg = new MqttMessage();
        deviceStatus.setDeviceStatusCode((byte)0);
        msg.setQos(1);
        msg.setRetained(true);
        msg.setPayload(objectMapper.writeValueAsBytes(deviceStatus));
        server.publish(REGISTER_TOPIC_NAME,msg);

    }
}
