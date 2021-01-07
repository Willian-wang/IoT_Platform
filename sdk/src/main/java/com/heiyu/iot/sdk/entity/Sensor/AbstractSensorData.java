package com.heiyu.iot.sdk.entity.Sensor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cSensorData;
import com.heiyu.iot.sdk.sensor.device.Sensor;

import static com.heiyu.iot.sdk.configure.DataDictionary.SENSOR_I2C;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:20 2020/1/25
 **/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,visible = true, include=JsonTypeInfo.As.PROPERTY, property="sensorInterfaceType")
@JsonSubTypes({
        @JsonSubTypes.Type(name=SENSOR_I2C ,value= I2cSensorData.class),
//        @JsonSubTypes.Type(name="cat",value= Sensor.class),
})
public abstract class AbstractSensorData {

    /**传感器接口类型：SPI,I2C,GPIO,UART*/
    @JsonTypeId
    private String sensorInterfaceType;

    public String getSensorInterfaceType() {
        return sensorInterfaceType;
    }

    public void setSensorInterfaceType(String sensorInterfaceType) {
        this.sensorInterfaceType = sensorInterfaceType;
    }

    /**
     * 获取传感器数据定义表的方法接口
     * @return 传感器数据定义表
     */
    public abstract AbstractSensorDataSheet[] getDataSheets();

}
