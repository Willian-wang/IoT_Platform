package com.heiyu.iot.sdk.entity.Sensor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cSensorData;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:20 2020/1/25
 **/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="sensorInterfaceType")
@JsonSubTypes({
        @JsonSubTypes.Type(name="I2C",value= I2cSensorData.class),
//        @JsonSubTypes.Type(name="cat",value=Cat.class),
})
public abstract class AbstractSensorData {
    private String sensorInterfaceType;

    public String getSensorInterfaceType() {
        return sensorInterfaceType;
    }

    public void setSensorInterfaceType(String sensorInterfaceType) {
        this.sensorInterfaceType = sensorInterfaceType;
    }

    /**传感器接口类型：SPI,I2C,GPIO,UART*/

}
