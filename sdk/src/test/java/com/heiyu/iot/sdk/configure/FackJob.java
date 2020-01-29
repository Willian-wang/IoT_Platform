package com.heiyu.iot.sdk.configure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heiyu.iot.sdk.entity.ConfigMap;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 1:31 2020/1/29
 **/

public class FackJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("23333");
        ConfigMap configMap = (ConfigMap) jobExecutionContext.getMergedJobDataMap().get("sensorMap");
        try {
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
            System.out.println(objectMapper.writeValueAsString(configMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
