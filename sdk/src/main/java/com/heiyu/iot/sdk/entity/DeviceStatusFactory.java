package com.heiyu.iot.sdk.entity;

import com.heiyu.iot.sdk.configure.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DevcieStatusFactory
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 11:51 2019/8/2
 * @Version: 1.0
 **/
@Component
public class DeviceStatusFactory {

    @Autowired
    private Dict dict;

    public DeviceStatus getDeviceStatus(int statusCode){
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(dict.getDeviceId());
        deviceStatus.setDeviceType(dict.getDeviceType());
        deviceStatus.setDeviceStatusCode((byte) statusCode);
        return deviceStatus;
    }

}
