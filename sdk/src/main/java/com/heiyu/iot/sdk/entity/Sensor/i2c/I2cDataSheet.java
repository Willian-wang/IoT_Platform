package com.heiyu.iot.sdk.entity.Sensor.i2c;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorDataSheet;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:36 2020/1/26
 **/

public class I2cDataSheet extends AbstractSensorDataSheet {
    /**
     * 数据字段的数据位置类型
     * 0: Normal 常规的
     * 1: Inside 和其他数据公用字段
     * 2: Multi  需要占用多个寄存器
     **/
    private byte dataPositionType;
    /**
     * 数据字段的所在的寄存器
     * Regular，Inside: 只有一个，即占用的寄存器
     * Combination: 有多个寄存器，由高位到地位排序
     */
    private byte[] dataPosition;

    /**
     * 数据字段所在的寄存器内部的偏移量
     * Regular,Combination:默认为0
     * Inside：数据所在的位置
     */
    private byte dataOffset;

    /**
     * 数据长度
     * Regular,Combination:默认为 dataPositon.length*寄存器位数（8）
     * Inside: 为数据所占的位数
     */
    private byte dataLength;
    /**
     * 数据的读写类型
     * 0：只读
     * 1：只写
     * 2：可读可写
     */
    private byte dataIOType;


    public byte getDataPositionType() {
        return dataPositionType;
    }

    public void setDataPositionType(byte dataPositionType) {
        this.dataPositionType = dataPositionType;
    }

    public byte[] getDataPosition() {
        return dataPosition;
    }

    public void setDataPosition(byte[] dataPosition) {
        this.dataPosition = dataPosition;
    }

    public byte getDataOffset() {
        return dataOffset;
    }

    public void setDataOffset(byte dataOffset) {
        this.dataOffset = dataOffset;
    }

    public byte getDataLength() {
        return dataLength;
    }

    public void setDataLength(byte dataLength) {
        this.dataLength = dataLength;
    }

    public byte getDataIOType() {
        return dataIOType;
    }

    public void setDataIOType(byte dataIOType) {
        this.dataIOType = dataIOType;
    }
}