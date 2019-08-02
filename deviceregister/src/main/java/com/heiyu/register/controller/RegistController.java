package com.heiyu.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.heiyu.register.entity.RedisKeyBuilder.getKey;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * @ClassName: controller
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 15:44 2019/7/31
 * @Version: 1.0
 **/

@RestController
public class RegistController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/online", method = GET)
    public String getOnliveDeviceList(String deviceType){
        return String.valueOf(redisTemplate.opsForSet().members(getKey("connect")));
    }

}
