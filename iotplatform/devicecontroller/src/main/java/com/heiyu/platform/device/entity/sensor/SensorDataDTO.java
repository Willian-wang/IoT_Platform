package com.heiyu.platform.device.entity.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.platform.device.entity.DataDTO;
import com.heiyu.platform.device.entity.MessageHeader;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author : WangYi
 * @version : 1.0
 * @date : 10:43 2020/1/19
 *
 **/

public class SensorDataDTO extends MessageHeader implements DataDTO {

    /**传感器名称*/
    private String sensorName;
    /**传感器ID*/
    private long sensorId;

    @Override
    public Long getTimestamp() {
        return super.getTimeStamp();
    }

    @Override
    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    private HashMap<String,Object> data;

    public static SensorDataDTO getSensorDataDTOFromJson(String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(str,SensorDataDTO.class);
    }



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


}

