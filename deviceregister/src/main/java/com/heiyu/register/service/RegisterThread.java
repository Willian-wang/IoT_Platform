package com.heiyu.register.service;

import com.heiyu.register.mqtt.ClientMQTT;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RegistThread
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 10:57 2019/8/1
 * @Version: 1.0
 **/

@Service
public class RegisterThread {

    @Autowired
    private ClientMQTT clientMQTT;

    @Autowired
    private HandleRegist handleRegist;


    @Async("taskExecutor")
    public void registerThread() throws MqttException {
        clientMQTT.newMQTTSubscribe("DeviceRegister", new String[]{"DeviceRegister"},new int[]{1},handleRegist);
    }
}
