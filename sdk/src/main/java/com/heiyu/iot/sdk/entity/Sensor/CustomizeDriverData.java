package com.heiyu.iot.sdk.entity.Sensor;

import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 11:11 2021/01/08
 **/

public class CustomizeDriverData extends AbstractSensorData {

    HashMap<String, Object> sensorConfigs = new HashMap<>();

    public HashMap<String, Object> getSensorConfigs() {
        return sensorConfigs;
    }

    public void setSensorConfigs(HashMap<String, Object> sensorConfigs) {
        this.sensorConfigs = sensorConfigs;
    }
}
