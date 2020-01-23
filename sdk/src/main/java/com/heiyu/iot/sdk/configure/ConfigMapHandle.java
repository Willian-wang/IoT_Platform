package com.heiyu.iot.sdk.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

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
        readConfigMapCache();
        syncConfigMapCache();

    }

    private void syncConfigMapCache(){

    }

    private void readConfigMapCache() throws ConfigMapHandleException {
         File file = new File(CONFIG_MAP_JSON);
         if(file.exists()){
//             String config = FileUtils TODO
         }else{
             throw new ConfigMapHandleException("Can't find configMap");
         }
    }

    private void readSensorConfigMapCache(){

    }


}
