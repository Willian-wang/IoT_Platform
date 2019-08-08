package com.heiyu.iot.sdk.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heiyu.iot.sdk.data.DataHandle;
import com.heiyu.iot.sdk.regist.RegisterHandle;
import org.checkerframework.checker.units.qual.A;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
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
public class StartThread {

    @Autowired
    private RegisterHandle registerHandle;

    @Autowired
    private DataHandle dataHandle;

    @PostConstruct
    public void startThread() {
        try {
            registerHandle.connect();
            dataHandle.receiveData();
            dataHandle.sendData();
        } catch (MqttException | JsonProcessingException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws MqttException, JsonProcessingException {
        registerHandle.disconnect();
    }
}
