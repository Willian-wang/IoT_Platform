package com.heiyu.iot.sdk.monitor;

import com.pi4j.system.SystemInfo;

import java.io.IOException;
import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 11:34 2021/01/09
 **/

public class MemoryMonitor implements Monitor{
    @Override
    public HashMap<String, Object> getMonitorData() throws IOException, InterruptedException {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("Total Memory" , SystemInfo.getMemoryTotal());
        result.put("Used Memory" , SystemInfo.getMemoryUsed());
        result.put("Free Memory" , SystemInfo.getMemoryFree());
        result.put("Shared Memory" , SystemInfo.getMemoryShared());
        result.put("Memory Buffers" , SystemInfo.getMemoryBuffers());
        result.put("Cached Memory" , SystemInfo.getMemoryCached());
        result.put("SDRAM_C Voltage" , SystemInfo.getMemoryVoltageSDRam_C());
        result.put("SDRAM_I Voltage" , SystemInfo.getMemoryVoltageSDRam_I());
        result.put("SDRAM_P Voltage" , SystemInfo.getMemoryVoltageSDRam_P());
        return  result;
    }
}
