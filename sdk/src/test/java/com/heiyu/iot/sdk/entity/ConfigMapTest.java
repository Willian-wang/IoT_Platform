package com.heiyu.iot.sdk.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.configure.ConfigMapHandleException;
import com.heiyu.iot.sdk.entity.configmap.ConfigMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 19:39 2020/1/23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigMapTest {

    @Test
    public void readConfigMapCacheTest() throws ConfigMapHandleException, JsonProcessingException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        System.out.println(objectMapper.writeValueAsString(ConfigMap.getConfigMap()));
    }


}
