package com.heiyu.iot.sdk.entity;

import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 14:39 2021/01/09
 **/

public class MonitorDataDTO extends MessageHeader{

    private HashMap<String,Object> monitorData;

    public HashMap<String, Object> getMonitorData() {
        return monitorData;
    }

    public MonitorDataDTO() {
    }

    public MonitorDataDTO(HashMap<String, Object> monitorData) {
        this.monitorData = monitorData;
    }

    public void setMonitorData(HashMap<String, Object> monitorData) {
        this.monitorData = monitorData;
    }


}
