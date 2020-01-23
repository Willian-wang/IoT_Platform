package com.heiyu.iot.sdk.entity;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:03 2020/1/23
 **/

public class ConfigMap {

    private DeviceInf deviceInf;

    private DeviceStatus deviceStatus;

    private SensorConfig[] sensorConfig;

    private MonitorConfig monitorConfig;

    public DeviceInf getDeviceInf() {
        return deviceInf;
    }

    public void setDeviceInf(DeviceInf deviceInf) {
        this.deviceInf = deviceInf;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }


    public SensorConfig[] getSensorConfig() {
        return sensorConfig;
    }

    public void setSensorConfig(SensorConfig[] sensorConfig) {
        this.sensorConfig = sensorConfig;
    }

    public MonitorConfig getMonitorConfig() {
        return monitorConfig;
    }

    public void setMonitorConfig(MonitorConfig monitorConfig) {
        this.monitorConfig = monitorConfig;
    }
}
