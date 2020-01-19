package com.heiyu.platform.device.data;

import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

/**
 * 信息处理类。这里是之前的demo,之后可能会有用
 * @author WangYi
 * @date 14:46 2019/8/2
 * @version 1.0
 **/
@Component
public class HandleData{
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Autowired
////    private ClientMQTT clientMQTT;
//
//
//
//    private final static String  REGISTER_TOPIC_NAME ="DeviceRegister";
//
//    @Async("taskExecutor")
//    public void recieveData() throws JsonProcessingException, MqttException {
////        MqttClient server = clientMQTT.getClient();
////        server.subscribe("data/+/send",1, new IMqttMessageListener() {
//            @Override
//            public void messageArrived(String topic, MqttMessage message) {
//                System.out.println("接收消息主题 : " + topic);
//                System.out.println("接收消息Qos : " + message.getQos());
//                System.out.println("接收消息内容 : " + new String(message.getPayload()));
//                System.out.println("接收消息编号：" + message.getId());
//            }
//        });
//    }
//
//    @Async("taskExecutor")
//    public void sendData() throws JsonProcessingException, MqttException, InterruptedException {
////        MqttClient server = clientMQTT.getClient();
//        int n = 0;
//        while (true){
//            n++;
//            MqttMessage msg = new MqttMessage();
//            msg.setQos(1);
//            String str = "这是第"+n+"条消息";
//            msg.setPayload(str.getBytes());
////            server.publish("data/18793278222112/receive", msg);
//            sleep(1000);
//        }
//    }

}
