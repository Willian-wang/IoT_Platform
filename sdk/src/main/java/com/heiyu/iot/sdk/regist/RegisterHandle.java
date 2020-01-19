package com.heiyu.iot.sdk.regist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.iot.sdk.configure.Dict;
import com.heiyu.iot.sdk.entity.DeviceStatusFactory;
import com.heiyu.iot.sdk.mqtt.ClientMQTT;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.heiyu.iot.sdk.common.IdGenerator.getId;


/**
 * @ClassName: Main
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 13:23 2019/8/1
 * @Version: 1.0
 **/

@Service
@Order(2)
public class RegisterHandle {

    @Autowired
    private ClientMQTT clientMQTT;

    @Autowired
    private Dict dict;

    @Autowired
    private DeviceStatusFactory deviceStatusFactory;
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Async("deamonTaskExecutor")
    public void connect() throws MqttException, JsonProcessingException {
        MqttClient server = clientMQTT.getClient();
        MqttMessage msg = new MqttMessage();
        msg.setQos(1);
        msg.setPayload(objectMapper.writeValueAsBytes(deviceStatusFactory.getDeviceStatus(1)));
        server.publish(dict.getRegisterTopicName(), msg);

    }

    @Async("deamonTaskExecutor")
    public void disconnect() throws MqttException, JsonProcessingException {
        MqttClient server = clientMQTT.getClient();
        MqttMessage msg = new MqttMessage();
        msg.setQos(1);
        msg.setRetained(true);
        msg.setPayload(objectMapper.writeValueAsBytes(deviceStatusFactory.getDeviceStatus(0)));
        server.publish(dict.getRegisterTopicName(),msg);
    }
}
