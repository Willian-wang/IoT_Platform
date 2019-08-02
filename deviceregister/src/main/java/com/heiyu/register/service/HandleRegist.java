package com.heiyu.register.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.register.entity.DeviceStatus;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static com.heiyu.register.entity.RedisKeyBuilder.getKey;

/**
 * @ClassName: Regist
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 16:02 2019/7/31
 * @Version: 1.0
 **/

@Service
public class HandleRegist implements MqttCallback {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RegisterThread registerThread;

    private final static String  REGISTER_TOPIC_NAME ="DeviceRegister";

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage)  {
        try{
        DeviceStatus deviceStatus = null;

        String str =new String(mqttMessage.getPayload());
        System.out.println(str);
            try {
            if(str != "" && topic.equals(REGISTER_TOPIC_NAME)  ){

                deviceStatus = objectMapper.readValue(str, DeviceStatus.class);
                if(deviceStatus.getDeviceStatusCode() == null){
                    throw new IllegalArgumentException("无设备状态码");
                }
            }else {
                throw new IllegalArgumentException("无法序列化");
            }
        }catch (Exception e){
    //            e.printStackTrace();
        }

            switch (deviceStatus.getDeviceStatusCode()){
            case 0:
                disconnect(deviceStatus);
                break;
            case 1:
                connect(deviceStatus);
    //                Auth();
                break;
            case 2:
                connect(deviceStatus);
                break;
            default:
                throw new IllegalArgumentException("未定义状态码");
        }}catch(Exception e){
         e.printStackTrace(); }
}

    private void disconnect(DeviceStatus deviceStatus)  {
        try{
        redisTemplate.opsForSet().remove(getKey("connect"),deviceStatus.getDeviceId());

            System.out.println(objectMapper.writeValueAsString(deviceStatus));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void connect(DeviceStatus deviceStatus)  {
        redisTemplate.opsForSet().add(getKey("connect"),deviceStatus.getDeviceId());

        try {
            System.out.println(objectMapper.writeValueAsString(deviceStatus));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) { }

    @Override
    public void connectionLost(Throwable throwable) {
        try {
            registerThread.registerThread();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        System.out.println("我要重连！！！");
    }
}
