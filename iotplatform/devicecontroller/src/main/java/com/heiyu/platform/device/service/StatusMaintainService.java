package com.heiyu.platform.device.service;

import com.heiyu.platform.device.common.Dict;
import com.heiyu.platform.device.dao.StatusRepository;
import com.heiyu.platform.device.entity.DataDTO;
import com.heiyu.platform.device.entity.sensor.SensorDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 15:49 2021/3/17
 **/
@Service
public class StatusMaintainService {

    @Autowired
    private StatusRepository statusRepository;

    private final Long STATUS_EXPIRE_TIME = 30*1000L;

    private int allRaspberryCount =0;
    private int allSensorCount = 0;
    private HashMap<String, TreeMap<String,Long>> lab2Raspberry = new HashMap<>();
    private HashMap<String, TreeMap<String,Long>> lab2Sensor = new HashMap<>();
    private HashMap<String, TreeMap<String,Long>> raspberry2Sensor = new HashMap<>();

    StatusMaintainService(){

    }

    public void flushDeviceStatus(DataDTO dataDTO){
        if(dataDTO instanceof  SensorDataDTO){
            putSensor((SensorDataDTO) dataDTO);
        }
        putRaspberry(dataDTO);
    }

    private void putSensor(SensorDataDTO sensorDataDTO){
        putItems(sensorDataDTO.getDeviceLab(), String.valueOf(sensorDataDTO.getSensorId()),lab2Sensor);
        putItems(String.valueOf(sensorDataDTO.getDeviceId()), String.valueOf(sensorDataDTO.getSensorId()),raspberry2Sensor );
    }

    private void putRaspberry(DataDTO dataDTO){
        putItems(dataDTO.getDeviceLab(), String.valueOf(dataDTO.getDeviceId()),lab2Raspberry);
    }

    private void putItems(String lab,String id,HashMap<String, TreeMap<String,Long>> map){
        if(!map.containsKey(lab)) {
            map.put(lab,new TreeMap<String,Long>());
        }TreeMap<String,Long> itemMap = map.get(lab);
        itemMap.put(id, System.currentTimeMillis()+ STATUS_EXPIRE_TIME);
    }



    @Scheduled(cron = "*/15 * * * * *")
    private void flushStatusMap(){

        int raspberryCount =  0;
        int sensorCount = 0;
        for(Map.Entry<String,TreeMap<String,Long>> entry : lab2Raspberry.entrySet()){
            int raspberryPerLab = flushMap(entry.getValue());
            raspberryCount += raspberryPerLab;

            int sensorPerLab = flushMap(lab2Sensor.get(entry.getKey()));
            sensorCount += sensorPerLab;

            buildLabTagMapAndFieldMap(entry.getKey(),raspberryPerLab,sensorPerLab);

        }
        allRaspberryCount = raspberryCount;
        allSensorCount = sensorCount;
        buildLabTagMapAndFieldMap("all", allRaspberryCount,allSensorCount);
    }
    private void buildLabTagMapAndFieldMap(String labTag,int raspberryPerLab,int sensorPerLab){
        HashMap<String,String> tagMap = new HashMap<String,String>();
        tagMap.put(Dict.LAB_TAG,labTag);
        HashMap<String,Object> fieldMap = new HashMap<>();
        fieldMap.put(Dict.DEVICES_PER_LAB,raspberryPerLab);
        fieldMap.put(Dict.SENSORS_PER_LAB,sensorPerLab);
        statusRepository.deviceStatusHandle(tagMap,fieldMap);
    }

    private int flushMap(  TreeMap<String,Long> map) {
        if(map == null){
            return 0;
        }
        Long timestamp = System.currentTimeMillis();
        while(!map.isEmpty() && timestamp > map.firstEntry().getValue()){
            map.pollFirstEntry();
        } return  map.size();
    }




}
