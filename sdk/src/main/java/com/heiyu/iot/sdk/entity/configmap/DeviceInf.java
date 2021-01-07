package com.heiyu.iot.sdk.entity.configmap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:04 2020/1/23
 **/

public class DeviceInf {

    /**设备ID*/
    private Long deviceId;
    /**设备类型*/
    private String deviceType;
    /**用户ID*/
    private String userId;

    public Long getDeviceId() {
        return deviceId;
    }

    public DeviceInf setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public DeviceInf setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

}
