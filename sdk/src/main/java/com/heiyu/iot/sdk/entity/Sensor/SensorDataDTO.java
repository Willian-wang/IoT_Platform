package com.heiyu.iot.sdk.entity.Sensor;

import com.heiyu.iot.sdk.entity.MessageHeader;

import java.util.Map;
import java.util.StringJoiner;

/**
 * @author : WangYi
 * @version : 1.0
 * @date : 10:43 2020/1/19
 *
 **/

public class SensorDataDTO extends MessageHeader {

    /**传感器名称*/
    private String sensorName;
    /**传感器ID*/
    private long sensorId;
    /**连接传感器设备的父节点ID*/
    private long fatherDeviceId;
    private Map<String,Object> sensorData;

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

    public long getFatherDeviceId() {
        return fatherDeviceId;
    }

    public void setFatherDeviceId(long fatherDeviceId) {
        this.fatherDeviceId = fatherDeviceId;
    }

    public Map<String, Object> getSensorData() {
        return sensorData;
    }

    public void setSensorData(Map<String, Object> sensorData) {
        this.sensorData = sensorData;
    }
}
