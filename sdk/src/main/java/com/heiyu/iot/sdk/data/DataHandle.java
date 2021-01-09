package com.heiyu.iot.sdk.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.iot.sdk.config.mqtt.ClientMQTT;
import com.heiyu.iot.sdk.configure.Dict;
import com.heiyu.iot.sdk.entity.DeviceStatusFactory;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.heiyu.iot.sdk.common.IdGenerator.getId;
import static java.lang.Thread.sleep;

/**
 * @ClassName: send
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 14:51 2019/8/2
 * @Version: 1.0
 **/
@Component
public class DataHandle {

    @Autowired
    private ClientMQTT clientMQTT;

    @Autowired
    private Dict dict;

    @Autowired
    private DeviceStatusFactory deviceStatusFactory;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Async("taskExecutor")
    public void sendData() throws JsonProcessingException, MqttException, InterruptedException {
        MqttClient server = clientMQTT.getClient();
        int n = 0;
        while (true) {
            n++;
            MqttMessage msg = new MqttMessage();
            msg.setQos(1);
            msg.setId(getId().hashCode());
            String str = "这是第" + n + "条消息";
            msg.setPayload(str.getBytes());
            server.publish(dict.getDataSendTopic(), msg);
            sleep(1000);
        }
    }

    @Async("taskExecutor")
    public void receiveData() throws MqttException {
        MqttClient server = clientMQTT.getClient();
        server.subscribe(dict.getDataReceiveTopic(), 1);
    }
}
