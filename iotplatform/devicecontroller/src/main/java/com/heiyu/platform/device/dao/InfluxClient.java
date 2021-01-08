package com.heiyu.platform.device.dao;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Init InfluxDB config
 * @author : William—Wang
 * @version : 1.0
 * @date : 20:12 2020/12/16
 **/
@PropertySource("classpath:spring.properties")
@Component

public class InfluxClient {
    @Value("${influxdb.token}")
    public String token;
    @Value("${influxdb.bucket}")
    public String bucket;
    @Value("${influxdb.org}")
    public String org ;

    public InfluxDBClient client ;
    @PostConstruct
    private void init(){
        client = InfluxDBClientFactory.create("http://139.186.64.38:8086", token.toCharArray());
    }

}
