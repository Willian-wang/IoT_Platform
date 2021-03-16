package com.heiyu.iot.sdk.entity.Sensor;

import com.heiyu.iot.sdk.entity.DataDTO;
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
//@Document("sensorData")
public class SensorDataDTO extends MessageHeader implements DataDTO {

    /**传感器名称*/
    private String sensorName;
    /**传感器ID*/
    private long sensorId;


    @Override
    public HashMap<String, Object> getData() {
        return data;
    }

    public SensorDataDTO setData(HashMap<String, Object> data) {
        this.data = data;
        return this;
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


    public SensorDataDTO(Long sensorId){
        for(SensorConfig sensorConfig :ConfigMap.getConfigMap().getSensorConfig()){
            if(sensorConfig.getSensorId() == sensorId){
                this.sensorName = sensorConfig.getSensorName();
                this.sensorId = sensorConfig.getSensorId();
            }
        }

    }


}

