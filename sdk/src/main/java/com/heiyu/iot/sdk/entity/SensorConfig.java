package com.heiyu.iot.sdk.entity;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorData;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:04 2020/1/23
 **/

public class SensorConfig {

    /**传感器名称*/
    private String sensorName;
    /**传感器ID*/
    private long sensorId;
    /**配置文件版本，为生成配置文件的时间戳*/
    private long configVersion;
    /**连接传感器设备的父节点ID*/
    private long fatherDeviceId;
    /**传感器类型*/
    private String sensorType;
    /**传感器数据定义*/
    private AbstractSensorData sensorData;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public long getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(long configVersion) {
        this.configVersion = configVersion;
    }

    public long getFatherDeviceId() {
        return fatherDeviceId;
    }

    public void setFatherDeviceId(long fatherDeviceId) {
        this.fatherDeviceId = fatherDeviceId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public AbstractSensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(AbstractSensorData sensorData) {
        this.sensorData = sensorData;
    }
}
