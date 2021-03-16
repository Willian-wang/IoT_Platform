package com.heiyu.iot.sdk.entity;

import com.heiyu.iot.sdk.entity.configmap.DeviceInf;

import static com.heiyu.iot.sdk.common.IdGenerator.getId;
import static com.heiyu.iot.sdk.entity.configmap.ConfigMap.getConfigMap;

/**
 * All message send to server is need to add this header.
 * @author : WangYi
 * @version : 1.0
 * @date : 10:44 2020/1/19
 **/

public class MessageHeader {
    private String messageId;
    //Device ID
    private Long deviceId;
    //Type of device
    private String deviceType;
    //CurrentTimeStamp
    private Long timeStamp;
    //User
    private Long userId;

    public String getDeviceLab() {
        return deviceLab;
    }

    public void setDeviceLab(String deviceLab) {
        this.deviceLab = deviceLab;
    }

    private String deviceLab;


    public MessageHeader() {
       DeviceInf deviceInf = getConfigMap().getDeviceInf();
        deviceId =  deviceInf.getDeviceId();
        deviceType = deviceInf.getDeviceType();
        userId =    deviceInf.getUserId();
        timeStamp = System.currentTimeMillis();
        messageId = String.valueOf(timeStamp)+deviceId;
        deviceLab = deviceInf.getDeviceLab();
    }


    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
