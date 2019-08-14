package com.heiyu.platform.device.common;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

/**
 * 分布式ID生成器
 * @author WangYi
 */
@Component
@Async
public class IdGenerator {

    // 2019年7月17日 0点0分0秒时间戳
    static private final long initTimestamp = 1563292800000L;

    static private long lastTimestamp;

    static final private long clusterId=0;

    static final private long workerId=0;

    static private long serialNum =0 ;

    static final private int timeLength = 41;

    static final private int serialNumLength = 12;
    static final private int clusterIdLength = 2;
    static final private int workerIdLength = 8;

    static final private int workerLeft=serialNumLength;
    static final private int clusterLeft=workerLeft+workerIdLength;
    static final private int timeLeft =clusterIdLength+clusterLeft;

    public IdGenerator() throws IllegalAccessException {
        if(clusterId>Math.pow(2,clusterIdLength)-1){
            throw new IllegalArgumentException("集群数量溢出");
        }

        if(workerId>Math.pow(2,workerIdLength)-1){
            throw new IllegalAccessException("工作节点数量溢出");
        }
    }

    static public Long getId()  {
        long nowTimestamp=System.currentTimeMillis();

        if(serialNum>Math.pow(2,serialNumLength)-1){
            try{
                sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(lastTimestamp == nowTimestamp){
            serialNum++;
        }else {
            lastTimestamp = nowTimestamp;
            serialNum=0;
        }

        long Id =nowTimestamp - initTimestamp;

        Id = Id << timeLeft |
                clusterId << clusterLeft |
                workerId  << workerLeft  |
                serialNum;

        return Id;
    }
}




