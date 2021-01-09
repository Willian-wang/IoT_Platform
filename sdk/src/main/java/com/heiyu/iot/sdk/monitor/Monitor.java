package com.heiyu.iot.sdk.monitor;

import java.io.IOException;
import java.util.HashMap;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 11:32 2021/01/09
 **/
public interface Monitor {

    HashMap<String,Object> getMonitorData() throws IOException, InterruptedException;
}
