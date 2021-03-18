package com.heiyu.platform.device.dao;

import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 20:43 2021/3/17
 **/
@Repository
public class StatusRepository {

    @Autowired
    InfluxClient influxClient;

    private HashMap<String , HashMap<String, String>> TAG_MAP = new HashMap<>();


    public void deviceStatusHandle(HashMap<String,String> tagMap,HashMap<String, Object> fieldsList){
        Point point =Point.measurement("status")
                .time(System.currentTimeMillis(), WritePrecision.MS)
                .addTags(tagMap)
                .addFields(fieldsList);
        try (WriteApi writeApi = influxClient.client.getWriteApi()) {
            writeApi.writePoint(influxClient.bucket, influxClient.org, point);
        }
    }


}
