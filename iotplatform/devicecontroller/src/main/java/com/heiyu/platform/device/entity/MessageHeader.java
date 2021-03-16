package com.heiyu.platform.device.entity;

/**
 * All message send to server is need to add this header.
 * @author : WangYi
 * @version : 1.0
 * @date : 10:44 2020/1/19
 **/

public class MessageHeader {

    private Long messageId;
    //Device ID
    private Long deviceId;
    //Type of device
    private String deviceType;
    //CurrentTimeStamp
    private  Long timeStamp;
    //User
    private String userId;

    public String getDeviceLab() {
        return deviceLab;
    }

    public void setDeviceLab(String deviceLab) {
        this.deviceLab = deviceLab;
    }

    private String deviceLab;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
