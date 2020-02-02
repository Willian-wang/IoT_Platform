package com.heiyu.platform.device.entity;

/**
 * All message send to server is need to add this header.
 * @author : WangYi
 * @version : 1.0
 * @date : 10:44 2020/1/19
 **/

public class MessageHeader {

    //Device ID
    private String deviceId;
    //Type of device
    private String deviceType;
    //CurrentTimeStamp
    private Long timeStamp;
    //User
    private String userId;

}
