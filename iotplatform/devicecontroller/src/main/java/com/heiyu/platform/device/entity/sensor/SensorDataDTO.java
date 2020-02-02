package com.heiyu.platform.device.entity.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.platform.device.entity.MessageHeader;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;

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

    private DataDTO[] dataDTO;

    public static SensorDataDTO getSensorDataDTOFromJson(String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(str,SensorDataDTO.class);
    }

    public DataDTO[] getDataDTO() {
        return dataDTO;
    }

    public void setDataDTO(DataDTO[] dataDTO) {
        this.dataDTO = dataDTO;
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

    public long getFatherDeviceId() {
        return fatherDeviceId;
    }

    public void setFatherDeviceId(long fatherDeviceId) {
        this.fatherDeviceId = fatherDeviceId;
    }

    public DataDTO DataDTOInstance(){
        return new DataDTO();
    }

    public static class DataDTO{
        private String dataName;
        private Long dataId;
        private String dataType;

        public DataDTO(){}

        public Object getData() {
            return data;
        }

        public DataDTO setData(Object data) {
            this.data = data;
            return this;
        }

        private Object data;



        public String getDataName() {
            return dataName;
        }

        public DataDTO setDataName(String dataName) {
            this.dataName = dataName;
            return this;
        }

        public Long getDataId() {
            return dataId;
        }

        public DataDTO setDataId(Long dataId) {
            this.dataId = dataId;
            return this;
        }
        public String getDataType() {
            return dataType;
        }

        public DataDTO setDataType(String dataType) {
            this.dataType = dataType;
            return this;
        }
    }
}

