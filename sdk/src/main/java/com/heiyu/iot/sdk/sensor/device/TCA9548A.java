package com.heiyu.iot.sdk.sensor.device;

import com.heiyu.iot.sdk.entity.Sensor.AbstractSensorData;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 13:17 2021/3/18
 **/

public class TCA9548A  extends AbstractSensorData {

    public HashMap<String, Integer> getDevicesPortTable() {
        return devicesPortTable;
    }

    public void setDevicesPortTable(HashMap<String, Integer> devicesPortTable) {
        this.devicesPortTable = devicesPortTable;
    }

    private HashMap<String,Integer> devicesPortTable;

    public void switchPort(String deviceType) throws IOException, I2CFactory.UnsupportedBusNumberException {
        if(devicesPortTable.containsKey (deviceType)) {
            System.out.println(deviceType+" "+ devicesPortTable.get(deviceType));
            I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);
            I2CDevice tca = i2c.getDevice((byte) 0x70);

            tca.write((byte) (1 << devicesPortTable.get(deviceType)));
        }
    }

}
