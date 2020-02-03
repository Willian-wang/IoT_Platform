package com.heiyu.platform.device.dao.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Save and Require SensorDataMap.
 * @author : William—Wang
 * @version : 1.0
 * @date : 21:16 2020/2/3
 **/

@Repository
public class SensorDataDao {


    @Autowired
    private MongoTemplate mongoTemplate;




}
