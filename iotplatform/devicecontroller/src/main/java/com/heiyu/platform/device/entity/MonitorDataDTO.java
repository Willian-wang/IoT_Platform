package com.heiyu.platform.device.entity;

import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 14:39 2021/01/09
 **/

public class MonitorDataDTO extends MessageHeader implements DataDTO{

    private HashMap<String,Object> data;

    public MonitorDataDTO() {
    }

    public MonitorDataDTO(HashMap<String, Object> monitorData) {
        this.data = monitorData;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }



    @Override
    public HashMap<String, Object> getData() {
        return data;
    }

    @Override
    public Long getTimestamp() {
        return null;
    }
}
