package com.heiyu.platform.device.service;

import com.heiyu.platform.device.common.Dict;
import com.heiyu.platform.device.dao.InfluxClient;
import com.heiyu.platform.device.entity.DataDTO;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 19:08 2020/12/17
 **/
@Service
public class DataService {

    @Autowired
    InfluxClient influxClient;

    public void deviceDataHandle(DataDTO dataDTO){
        Point point =Point.measurement(String.valueOf(dataDTO.getDeviceId()))
                .time(dataDTO.getTimestamp(), WritePrecision.MS)
                .addTag(Dict.LAB_TAG,dataDTO.getDeviceLab())
                .addTag(Dict.DEVICE_TAG, String.valueOf(dataDTO.getDeviceId()));
        point.addFields(dataDTO.getData());
        try (WriteApi writeApi = influxClient.client.getWriteApi()) {
            writeApi.writePoint(influxClient.bucket, influxClient.org, point);
        }
    }
}
