package com.heiyu.platform.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: RegisterBoot
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 9:33 2019/8/1
 * @Version: 1.0
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
