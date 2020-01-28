package com.heiyu.iot.sdk.entity.sensor;

import com.heiyu.iot.sdk.entity.Sensor.SensorDataDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:18 2020/1/25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorDataDTOTest {

    @Test
    public void toStringTest(){
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        System.out.println(sensorDataDTO);
    }

}
