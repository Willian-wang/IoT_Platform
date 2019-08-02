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
@Component
public class DeviceStatus {
    //设备ID
    @Value("${device.id}")
    private String deviceId;
    //设备状态码
    private byte deviceStatusCode;
    //设备类型
    @Value("${device.type}")
    private String deviceType;

    public DeviceStatus(){}

    public DeviceStatus(int deviceStatusCode){
        this.deviceStatusCode = (byte) deviceStatusCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public byte getDeviceStatusCode() {
        return deviceStatusCode;
    }

    public void setDeviceStatusCode(byte deviceStatusCode) {
        this.deviceStatusCode = deviceStatusCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
