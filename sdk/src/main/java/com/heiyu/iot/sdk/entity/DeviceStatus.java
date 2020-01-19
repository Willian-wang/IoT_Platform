package com.heiyu.iot.sdk.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DeviceStatus
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 15:40 2019/7/31
 * @Version: 1.0
 **/

public class DeviceStatus {
    //设备ID
    private String deviceId;
    //设备状态码
    private byte deviceStatusCode;
    //设备类型
    private String deviceType;

    private boolean deviceConnected;

    public DeviceStatus(){}

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public byte getDeviceStatusCode() {
        return deviceStatusCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceStatusCode(byte deviceStatusCode) {
        this.deviceStatusCode = deviceStatusCode;
    }

}
