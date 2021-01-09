package com.heiyu.iot.sdk.monitor;

import com.pi4j.system.SystemInfo;

import java.io.IOException;
import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 11:35 2021/01/09
 **/

public class DiskMonitor implements Monitor {
    @Override
    public HashMap<String, Object> getMonitorData() throws IOException, InterruptedException {
        HashMap<String, Object> result = new HashMap<String, Object>();
        return result;
    }
}
