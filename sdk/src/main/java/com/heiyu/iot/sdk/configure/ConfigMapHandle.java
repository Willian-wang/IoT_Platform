package com.heiyu.iot.sdk.configure;

import com.heiyu.iot.sdk.entity.configmap.ConfigMap;
import com.heiyu.iot.sdk.monitor.MonitorHandle;
import com.heiyu.iot.sdk.sensor.SensorHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

import static com.heiyu.iot.sdk.entity.configmap.ConfigMap.getConfigMap;

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

    @Autowired
    private MonitorHandle monitorHandle;

    @PostConstruct
    public  void readConfigMap() throws URISyntaxException, ConfigMapHandleException {
        ConfigMap configMap = getConfigMap();
        sensorHandle.readSensorConfig(configMap.getSensorConfig());
        monitorHandle.readMonitorConfig(configMap.getMonitorConfig());
    }

    private void syncConfigMapCache(){

    }



    private void readSensorConfigMapCache(){

    }


}
