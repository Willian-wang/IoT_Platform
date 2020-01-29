package com.heiyu.iot.sdk.entity.Sensor.i2c;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorData;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:37 2020/1/25
 **/

public class I2cSensorData extends AbstractSensorData {
    /**传感器数据列表*/
    private I2cDataSheet[] i2cDataSheet;
    /**i2cBus*/
    private int i2cBusNum;
    /**i2c地址*/
    private int i2cAddress;


    public I2cDataSheet[] getI2cDataSheet() {
        return i2cDataSheet;
    }

    public void setI2cDataSheet(I2cDataSheet[] i2cDataSheet) {
        this.i2cDataSheet = i2cDataSheet;
    }

    public int getI2cBusNum() {
        return i2cBusNum;
    }

    public void setI2cBusNum(int i2cBusNum) {
        this.i2cBusNum = i2cBusNum;
    }

    public int getI2cAddress() {
        return i2cAddress;
    }

    public void setI2cAddress(int i2cAddress) {
        this.i2cAddress = i2cAddress;
    }

}

