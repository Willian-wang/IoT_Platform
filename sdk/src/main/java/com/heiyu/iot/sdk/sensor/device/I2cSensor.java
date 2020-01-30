package com.heiyu.iot.sdk.sensor.device;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * //TODO
 * @author : WangYi
 * @version : 1.0
 * @date : 22:40 2020/1/18
 **/

public class I2cSensor implements Sensor {

    private int i2cBusNum;
    private int i2cAddress;
    private Byte[] readRegister;
    private Byte[] writeRegister;



    public I2cSensor(int i2cBus, int i2cAddress, Byte[] readRegister, Byte[] writeRegister) {
        this.i2cBusNum = i2cBus;
        this.i2cAddress = i2cAddress;
        this.writeRegister = writeRegister;
        this.readRegister = readRegister;
    }


    public int[] getI2cBus() {
        int[] ids = null;
        try {
            ids = I2CFactory.getBusIds();
            System.out.println("Found follow I2C busses: " + Arrays.toString(ids));

        } catch (IOException exception) {
            System.out.println("I/O error during fetch of I2C busses occurred");
        }
        return ids;
    }

    @Override
    public HashMap<Byte, Integer> readData() {
        // get the I2C bus to communicate on
        HashMap<Byte, Integer> sensorData = new HashMap<Byte, Integer>();

        I2CDevice device = null;
        try {
            I2CBus i2c = I2CFactory.getInstance(i2cBusNum);
            device = i2c.getDevice(i2cAddress);
        } catch (I2CFactory.UnsupportedBusNumberException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (device != null) {
                for (Byte register : readRegister) {
                    sensorData.put(register, device.read(register));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensorData;
    }
}
