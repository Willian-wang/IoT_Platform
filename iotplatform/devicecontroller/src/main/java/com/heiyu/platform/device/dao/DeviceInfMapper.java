package com.heiyu.platform.device.dao;

import com.heiyu.platform.device.entity.product.ProductDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a007a
 * @version 1.0.0
 */
@Repository
@Mapper
@PropertySource("classpath:spring.properties")
public interface DeviceInfMapper {
    @Select("SELECT * FROM iot_product_inf")
    @ResultMap("com.heiyu.platform.device.dao.DeviceInfMapper.ProductDetailMap")
    List<ProductDetail> getAll();

}
