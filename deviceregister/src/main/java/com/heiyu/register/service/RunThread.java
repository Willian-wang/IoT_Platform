package com.heiyu.register.service;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RunThread
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 11:40 2019/8/1
 * @Version: 1.0
 **/

@Service
public class RunThread implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RegisterThread registerThread;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            registerThread.registerThread();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
