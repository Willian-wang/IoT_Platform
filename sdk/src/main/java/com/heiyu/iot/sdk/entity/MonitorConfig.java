package com.heiyu.iot.sdk.entity;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 17:05 2020/1/23
 **/

public class MonitorConfig {
    /**监控的总开关*/
    private boolean monitorEnabled;
    /**CPU相关信息监控*/
    private boolean cpuInfoEnabled;
    /**内存相关信息监控*/
    private boolean memoryInfoEnabled;
    /**网络信息监控*/
    private boolean netInfoEnabled;
    /**磁盘信息监控*/
    private boolean diskInfoEnabled;
    /**监控间隔*/
    private Integer monitorInterval;

    public boolean isMonitorEnabled() {
        return monitorEnabled;
    }

    public void setMonitorEnabled(boolean monitorEnabled) {
        this.monitorEnabled = monitorEnabled;
    }

    public boolean isCpuInfoEnabled() {
        return cpuInfoEnabled;
    }

    public void setCpuInfoEnabled(boolean cpuInfoEnabled) {
        this.cpuInfoEnabled = cpuInfoEnabled;
    }

    public boolean isMemoryInfoEnabled() {
        return memoryInfoEnabled;
    }

    public void setMemoryInfoEnabled(boolean memoryInfoEnabled) {
        this.memoryInfoEnabled = memoryInfoEnabled;
    }

    public boolean isNetInfoEnabled() {
        return netInfoEnabled;
    }

    public void setNetInfoEnabled(boolean netInfoEnabled) {
        this.netInfoEnabled = netInfoEnabled;
    }

    public boolean isDiskInfoEnabled() {
        return diskInfoEnabled;
    }

    public void setDiskInfoEnabled(boolean diskInfoEnabled) {
        this.diskInfoEnabled = diskInfoEnabled;
    }

    public Integer getMonitorInterval() {
        return monitorInterval;
    }

    public void setMonitorInterval(Integer monitorInterval) {
        this.monitorInterval = monitorInterval;
    }
}
