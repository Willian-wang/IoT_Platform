package com.heiyu.iot.sdk.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * //TODO 未与平台端匹配
 * @ Author : WangYi
 * @ Date : 15:40 2019/7/31
 * @ Version : 1.0
 **/

public class DeviceStatusDTO extends MessageHeader {
    //设备状态码
    private byte deviceStatusCode;

    private boolean deviceConnected;

    public byte getDeviceStatusCode() {
        return deviceStatusCode;
    }



    public DeviceStatusDTO(){}



    public void setDeviceStatusCode(byte deviceStatusCode) {
        this.deviceStatusCode = deviceStatusCode;
    }

    public boolean isDeviceConnected() {
        return deviceConnected;
    }

    public void setDeviceConnected(boolean deviceConnected) {
        this.deviceConnected = deviceConnected;
    }
}
