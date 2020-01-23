package com.heiyu.iot.sdk.sensor.datahandle;

import com.heiyu.iot.sdk.sensor.device.I2cSensor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:06 2020/1/22
 **/


public class I2cDataHandle {

    @Autowired
    I2cSensor i2cSensor;

    public I2cDataHandle(){
        new I2cSensor();
        i2cSensor.getI2cBus();
    }

    public void i2cReadData(){

    }
}
