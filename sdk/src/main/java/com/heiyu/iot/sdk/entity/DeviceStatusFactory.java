package com.heiyu.iot.sdk.entity;

import com.heiyu.iot.sdk.configure.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : WangYi
 * @date : 11:51 2019/8/2
 * @version  1.0
 **/
@Component
public class DeviceStatusFactory {

    @Autowired
    private Dict dict;

    public DeviceStatusDTO getDeviceStatus(int statusCode){
        DeviceStatusDTO deviceStatusDTO = new DeviceStatusDTO();
        deviceStatusDTO.setDeviceStatusCode((byte) statusCode);
        return deviceStatusDTO;
    }

}
