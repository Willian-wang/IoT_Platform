package com.heiyu.iot.sdk.entity.Sensor;

import com.heiyu.iot.sdk.entity.configmap.ConfigMap;
import com.heiyu.iot.sdk.entity.MessageHeader;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;

import java.util.HashMap;

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
    private Long fatherDeviceId;
    /**数据时间戳*/
    private Long dataTimestamp;

    public HashMap<String, Object> getData() {
        return data;
    }

    public SensorDataDTO setData(HashMap<String, Object> data) {
        this.data = data;
        return null;
    }

    private HashMap<String,Object> data;

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

    public SensorDataDTO(Long sensorId){
        for(SensorConfig sensorConfig :ConfigMap.getConfigMap().getSensorConfig()){
            if(sensorConfig.getSensorId() == sensorId){
                this.sensorName = sensorConfig.getSensorName();
                this.sensorId = sensorConfig.getSensorId();
                this.fatherDeviceId = sensorConfig.getFatherDeviceId();
                dataTimestamp = System.currentTimeMillis();
            }
        }

    }

    public Long getDataTimestamp() {
        return dataTimestamp;
    }

    public SensorDataDTO setDataTimestamp(Long dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
        return this;
    }

}

