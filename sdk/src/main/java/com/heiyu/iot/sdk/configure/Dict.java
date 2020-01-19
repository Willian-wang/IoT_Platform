package com.heiyu.iot.sdk.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @ClassName: Dict
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 9:30 2019/8/2
 * @Version: 1.0
 **/
@Configuration
//@ConfigurationProperties(prefix = "register")
public class Dict {

    @Value("${register.clientName}")
    private   String registerClientName;
    @Value("${register.topicName}")
    private   String registerTopicName;
    @Value("${device.id}")
    private String deviceId;
    @Value("${device.type}")
    private String deviceType;

    private String DataSendTopic ;

    private String dataReceiveTopic;

    public Dict(@Value("${device.id}") String deviceId){
        dataReceiveTopic="data/"+deviceId+"/receive";
        DataSendTopic = "data/"+deviceId+"/send";
    }

    public String getDataSendTopic() {
        return DataSendTopic;
    }

    public String getDataReceiveTopic() {
        return dataReceiveTopic;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getRegisterClientName() {
        return registerClientName;
    }

    public String getRegisterTopicName() {
        return registerTopicName;
    }
}
