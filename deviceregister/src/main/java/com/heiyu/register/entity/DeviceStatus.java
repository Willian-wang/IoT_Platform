package com.heiyu.register.entity;

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
    private Byte deviceStatusCode;
    //设备类型
    private String deviceType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Byte getDeviceStatusCode() {
        return deviceStatusCode;
    }

    public void setDeviceStatusCode( Byte deviceStatusCode) {
        this.deviceStatusCode = deviceStatusCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
