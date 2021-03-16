package com.heiyu.platform.device.entity;

import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 11:11 2021/01/10
 **/
public interface DataDTO {

    HashMap<String, Object> getData();
    Long getTimestamp();
    Long getDeviceId();
    String getDeviceLab();
}
