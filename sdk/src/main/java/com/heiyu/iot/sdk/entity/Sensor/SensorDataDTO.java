package com.heiyu.iot.sdk.entity.Sensor;

import com.heiyu.iot.sdk.entity.configmap.ConfigMap;
import com.heiyu.iot.sdk.entity.MessageHeader;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;

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

    private DataDTO[] dataDTO;

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

    public DataDTO DataDTOInstance(){
        return new DataDTO();
    }

    public Long getDataTimestamp() {
        return dataTimestamp;
    }

    public SensorDataDTO setDataTimestamp(Long dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
        return this;
    }

    public class DataDTO{
        private  String  dataName;
        private  Long dataId;
        private String dataType;

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

