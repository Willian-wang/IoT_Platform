package com.heiyu.platform.device.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 默认MQTT处理类
 * @author WangYi
 * @date 17:54 2019/7/31
 * @version 1.0
 **/
public class PushCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连  
        System.out.println("连接断开，可以做重连");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
       System.out.println("接收消息主题 : " + topic);
       System.out.println("接收消息Qos : " + message.getQos());
       System.out.println("接收消息内容 : " + new String(message.getPayload()));
       System.out.println("接受消息客户端："+message.getId());
    }
}  
