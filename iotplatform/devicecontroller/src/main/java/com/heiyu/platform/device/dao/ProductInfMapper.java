package com.heiyu.platform.device.dao;

import com.heiyu.platform.device.entity.product.ProductDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用了springboot，不需要对Mybatis的Mapper接口进行实现。
 * 主要是验证Mybatis在springboot下可行。
 *
 * @author  a007a
 * @version  1.0.0
 */
@Repository
@Mapper
@PropertySource("classpath:spring.properties")
public interface ProductInfMapper {

    List<ProductDetail> getAll(ProductDetail condition );

    ProductDetail getOne(ProductDetail condition);

    void insert(ProductDetail productDetail);

    void update(ProductDetail productDetail);
}
