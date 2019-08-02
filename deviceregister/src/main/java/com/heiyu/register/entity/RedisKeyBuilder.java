package com.heiyu.register.entity;

/**
 * @ClassName: RedisKeyBuilder
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 17:54 2019/7/31
 * @Version: 1.0
 **/

public class RedisKeyBuilder {

    private final static String REGIST = "register:";
    private final static String AUTH = "auth:";
    private final static String CONNECT = "connect:";

    public static String getKey(String name){
        if("connect".equals(name)){
            return REGIST+CONNECT;
        }else{
            throw new IllegalArgumentException("RedisID生成器的参数错误");
        }
    }
}
