package com.heiyu.iot.sdk.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.iot.sdk.entity.DeviceStatus;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;


/**
 * 模拟一个客户端接收消息
 * @author rao
 *
 */
@Component
@PropertySource("classpath:config.properties")
public class ClientMQTT {

    // broker Url
    public   String HOST;
    // 默认topic
    public  String DEFAULT_TOPIC;
    // 客户端ID
    private String CLIENT_ID;
    // 用户名
    private  String USERNAME;
    // 密码
    private  String PASSWORD;

    private Map<String,MqttClient>  mqttClientMap =new HashMap<>();
    private MqttConnectOptions options;
    @SuppressWarnings("unused")
    private ScheduledExecutorService scheduler;

    public Map<String, MqttClient> getMqttClientMap() {
        return mqttClientMap;
    }

    public ClientMQTT(
            @Value("${mqtt.url}")String HOST,
            @Value("${mqtt.default.topic}") String DEFAULT_TOPIC,
            @Value("${device.id}") String CLIENT_ID,
            @Value("${mqtt.username}") String USERNAME ,  //非必须
            @Value("${mqtt.password}")String PASSWORD  ,//非必须
            @Value("${device.type}") String DEVICE_TYPE
    ) {
        this.HOST = HOST;
        this.DEFAULT_TOPIC = DEFAULT_TOPIC;
        this.CLIENT_ID = CLIENT_ID;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        try {
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            // 设置连接的用户名
            options.setUserName(USERNAME);
            // 设置连接的密码
            options.setPassword(PASSWORD.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            String topic = DEFAULT_TOPIC;
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setDeviceStatusCode((byte)0);
            deviceStatus.setDeviceType(DEVICE_TYPE);
            deviceStatus.setDeviceId(CLIENT_ID);
            String will = new ObjectMapper().writeValueAsString(deviceStatus);
           //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic, will.getBytes(), 2, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void newMQTTSubscribe(String clientName ) throws MqttException {
        MqttClient client = new MqttClient(HOST, CLIENT_ID, new MemoryPersistence());
        // 添加消息处理类
        client.setCallback(new PushCallback());
        // 发起连接
        client.connect(options);
        // 订阅消息
        client.subscribe(DEFAULT_TOPIC, 1);
        // 添加到ClientMap中
        mqttClientMap.put(clientName,client);
    }

    public void newMQTTSubscribe(String clientName, String[] topic, int Qos[] , MqttCallback pushCallback) throws MqttException {
        // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
        MqttClient client = new MqttClient(HOST, CLIENT_ID, new MemoryPersistence());
        // 添加消息处理类
        client.setCallback(pushCallback);
        // 发起连接
        client.connect(options);
        //订阅消息
        client.subscribe(topic, Qos);
        // 添加到ClientMap中
        mqttClientMap.put(clientName,client);
    }

    public MqttClient newMQTTPublish(String clientName,MqttCallback pushCallback) throws MqttException {
        // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
        MqttClient client = new MqttClient(HOST, CLIENT_ID, new MemoryPersistence());
        // 添加消息处理类
        client.setCallback(pushCallback);
        // 发起连接
        client.connect(options);
        //订阅消息
        mqttClientMap.put(clientName,client);
        return client;
    }

    public MqttClient newMQTTPublish(String clientName) throws MqttException {
        MqttClient client = new MqttClient(HOST, CLIENT_ID, new MemoryPersistence());
        client.setCallback(new PushCallback());
        client.connect(options);
        mqttClientMap.put(clientName,client);
        return client;
    }

    public void SendMassage(MqttClient mqttClient,String message){

    }
}