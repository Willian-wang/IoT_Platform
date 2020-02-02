package com.heiyu.platform.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

/**
 * @author WangYi
 * @date 9:33 2019/8/1
 * @version 1.0
 **/

@SpringBootApplication
@MapperScan("com.heiyu.platform.device.dao")
@PropertySource("classpath:spring.properties")
public class DeviceControllerBoot {

    public static void main(String[] arg) {
        new SpringApplicationBuilder(DeviceControllerBoot.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .run(arg);
//        registerThread.registThread();
        }
}
