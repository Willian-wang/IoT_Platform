package com.heiyu.iot.sdk.configure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 21:07 2020/1/31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictTest {

    @Autowired
    Dict dict;

    @Test
    public void getTopicTest(){
        System.out.println(dict.getTopic());
    }

}
