package com.heiyu.iot.sdk.configure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.entity.ConfigMap;
import com.heiyu.iot.sdk.sensor.SensorHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.krb5.Config;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static com.heiyu.iot.sdk.entity.ConfigMap.getConfigMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:09 2020/1/23
 **/
@Component
public class ConfigMapHandle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SensorHandle sensorHandle;


    ConfigMapHandle() throws URISyntaxException, ConfigMapHandleException {
        readConfigMap();

    }

    public  void readConfigMap() throws URISyntaxException, ConfigMapHandleException {
        ConfigMap configMap = getConfigMap();
        sensorHandle.readSensorConfig(configMap.getSensorConfig());
    }

    private void syncConfigMapCache(){

    }



    private void readSensorConfigMapCache(){

    }


}
