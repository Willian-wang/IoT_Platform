package com.heiyu.platform.device.service;

import com.heiyu.platform.device.dao.ProductInfMapper;
import com.heiyu.platform.device.entity.product.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 信息处理的Service类
 * @author WangYi
 * @date 16:10 2019/8/7
 * @version 1.0
 **/

@Service
public class ProductInfService {

    @Autowired
    private ProductInfMapper  productInfMapper;

    public void insertProductInfService(ProductDetail productDetail){
        productDetail.setBasicInf();
        productInfMapper.insert(productDetail);
    }


   
    public ProductDetail getProductInfDetail(@RequestBody ProductDetail productDetail){
        return productInfMapper.getOne(productDetail);
    }


    public List<ProductDetail> getProductInfList(@RequestBody ProductDetail productDetails){

        return productInfMapper.getAll(productDetails);
    }

    public void deleteProductInfList(@RequestBody ProductDetail[] productDetails){


    }

    public void deleteProductInfService(@RequestBody ProductDetail productDetail){


    }


    public void updateProductInfService(@RequestBody ProductDetail productDetail){


    }

}
