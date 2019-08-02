package com.heiyu.iot.sdk.regist;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName: javaclass
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 14:14 2019/8/1
 * @Version: 1.0
 **/
@Service
public class RegisterTask  {

    @Autowired
    private RegisterHandle registerHandle;

    @PostConstruct
    public void startThread() {
        try {
            registerHandle.connect();
        } catch (MqttException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws MqttException, JsonProcessingException {
        registerHandle.disconnect();
    }
}
