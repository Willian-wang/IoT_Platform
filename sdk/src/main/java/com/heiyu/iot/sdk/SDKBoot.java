package com.heiyu.iot.sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

/**
 * @ClassName: SDKBoot
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 13:30 2019/8/1
 * @Version: 1.0
 **/

@SpringBootApplication
public class SDKBoot {
    public static void  main(String[] str){
//        SpringApplication.run(SDKBoot.class,str);
        new SpringApplicationBuilder(SDKBoot.class)
                .web(WebApplicationType.NONE)
                .run(str);
    }
}
