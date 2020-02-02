package com.heiyu.iot.sdk.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.configure.ConfigMapHandleException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:03 2020/1/23
 * ConfigMap is the configuration of sdk.
 * It reads configuration from the json file in java path.
 * It is singleton which means only one ConfigMap can be implemented.
 **/
public class ConfigMap {

    private static final  String CONFIG_MAP_JSON = "map.json";

    private static ConfigMap configMap = null;

    private DeviceInf deviceInf;

    private DeviceStatus deviceStatus;

    private SensorConfig[] sensorConfig;

    private MonitorConfig monitorConfig;

    public DeviceInf getDeviceInf() {
        return deviceInf;
    }

    public void setDeviceInf(DeviceInf deviceInf) {
        this.deviceInf = deviceInf;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    private ConfigMap(){}

    public SensorConfig[] getSensorConfig() {
        return sensorConfig;
    }

    public void setSensorConfig(SensorConfig[] sensorConfig) {
        this.sensorConfig = sensorConfig;
    }

    public MonitorConfig getMonitorConfig() {
        return monitorConfig;
    }

    public void setMonitorConfig(MonitorConfig monitorConfig) {
        this.monitorConfig = monitorConfig;
    }


    public static ConfigMap getConfigMap()  {
        if(configMap == null){
            synchronized (ConfigMap.class){
                if(configMap == null){
                    try {
                        configMap = readConfigMapCache();
                    } catch (ConfigMapHandleException e) {
                        e.printStackTrace();
                    }
                }
            }
        }return configMap;
    }

    private static ConfigMap readConfigMapCache() throws ConfigMapHandleException {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("./config/"+CONFIG_MAP_JSON);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(inputStream == null){
            System.out.println("Inner config used!");
            inputStream = ConfigMap.class.getClassLoader().getResourceAsStream(CONFIG_MAP_JSON);
        }
        ConfigMap configMap = null;
        try {
            configMap = objMapper.readValue(inputStream, ConfigMap.class);
            inputStream.close();
        } catch (IOException e) {
            System.out.println(e);
            throw new ConfigMapHandleException("Parse json file error: "+ e.toString());
        } return configMap;
    }

}
