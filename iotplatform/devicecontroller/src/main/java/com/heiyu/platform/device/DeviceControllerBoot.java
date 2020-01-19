package com.heiyu.platform.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * �豸���Ʒ���
 *    ����IOTƽ̨�Ĳ�Ʒ��Ϣ�����豸��Ϣ�����豸��ģ�͵Ľ����ȹ��ܡ�
 * @author WangYi
 * @date 9:33 2019/8/1
 * @version 1.0
 **/

@SpringBootApplication
@MapperScan("com.heiyu.platform.device.dao")
@PropertySource("classpath:spring.properties")
public class DeviceControllerBoot {

    public static void main(String[] arg) {
        SpringApplication.run(DeviceControllerBoot.class, arg);
//        registerThread.registThread();
        }
}
