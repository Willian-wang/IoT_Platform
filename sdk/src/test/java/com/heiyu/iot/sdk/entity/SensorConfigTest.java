package com.heiyu.iot.sdk.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cDataSheet;
import com.heiyu.iot.sdk.entity.Sensor.i2c.I2cSensorData;
import com.heiyu.iot.sdk.entity.configmap.SensorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:21 2020/1/26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorConfigTest {

    @Test
    public void printSensorConfigTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        SensorConfig sc= new SensorConfig();
        I2cSensorData i2cSensorData = new I2cSensorData();
        i2cSensorData.setI2cDataSheet(new I2cDataSheet[]{new I2cDataSheet()});
        sc.setSensorData(i2cSensorData);
        System.out.println(objectMapper.writeValueAsString(sc));
        System.out.println(sc);
    }
}
