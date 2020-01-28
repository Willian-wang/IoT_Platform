package com.heiyu.iot.sdk.sensor;

import com.heiyu.iot.sdk.entity.SensorConfig;
import com.heiyu.iot.sdk.sensor.device.Sensor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 22:20 2020/1/22
 **/

@Component
public class SensorHandle {

   private HashMap<Long,Sensor> sensors = new HashMap<Long,Sensor>();

   public void syncSensorConfig(){

   }

   public void readSensorConfig(SensorConfig[] sensorConfigs){
       for(SensorConfig sensorConfig:sensorConfigs){

       }
   }



}
