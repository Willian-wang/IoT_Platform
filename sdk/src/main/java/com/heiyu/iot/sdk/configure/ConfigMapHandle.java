package com.heiyu.iot.sdk.configure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.entity.ConfigMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sun.security.krb5.Config;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:09 2020/1/23
 **/
@Component
public class ConfigMapHandle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final  String CONFIG_MAP_JSON = "map.json";

    ConfigMapHandle() throws ConfigMapHandleException {
//        readConfigMapCache();
//        syncConfigMapCache();

    }

    private void syncConfigMapCache(){

    }

    ConfigMap readConfigMapCache() throws ConfigMapHandleException, URISyntaxException {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        URI uri= this.getClass().getClassLoader().getResource(CONFIG_MAP_JSON).toURI();
        System.out.println(uri.getPath());
         File file = new File(uri.getPath());
//        File file = new File("F:/项目/IoT/SDK/target/classes/map.json");
         if(file.exists()){
             ConfigMap configMap = null;
             try {
                 configMap = objMapper.readValue(file, ConfigMap.class);
             } catch (IOException e) {
                 System.out.println(e);
                 throw new ConfigMapHandleException("Parse json file error: "+ e.toString());
             } return configMap;
         }else{
             throw new ConfigMapHandleException("Can't find configMap cache file!");
         }
    }

    private void readSensorConfigMapCache(){

    }


}
