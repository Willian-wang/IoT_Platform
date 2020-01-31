package com.heiyu.iot.sdk.sensor.datahandle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:00 2020/1/31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorDataTypeHandleTest {
    @Test
    public  void powTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Method doublePow10 =SensorDataTypeHandle.class.getDeclaredMethod("pow10",int.class,double.class);
        Method intPow10 =   SensorDataTypeHandle.class.getDeclaredMethod("pow10", int.class,int.class);
        doublePow10.setAccessible(true);
        intPow10.setAccessible(true);
        int numberI = 314159;
        double numberF = 314159;
        int resultI_1 = 31;
        int resultI_2 = 314159000;
        double resultF_1 = 314159000;
        double resultF_2 = 31.4159;
        Assert.assertEquals(resultI_2,intPow10.invoke(null,3 ,numberI));
        Assert.assertEquals(resultI_1,intPow10.invoke(null,-4,numberI));
        Assert.assertEquals(resultF_1,(double)doublePow10.invoke(null,3 ,numberF),0.00001);
        Assert.assertEquals(resultF_2,(double)doublePow10.invoke(null,-4,numberF),0.00001);
        Assert.assertEquals(numberI,intPow10.invoke(null,0,numberI));
        Assert.assertEquals(numberF,(double)doublePow10.invoke(null,0,numberF),0.00001);
    }

}
