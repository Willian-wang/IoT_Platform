package com.heiyu.platform.device.controller;

import com.heiyu.platform.device.entity.common.BasicResponseVO;
import com.heiyu.platform.device.entity.product.ProductDetail;
import com.heiyu.platform.device.service.ProductInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品信息控制类，添加，删除，修改。
 * @author WangYi
 * @date 14:29 2019/8/7
 * @version 1.0
 * //TODO 该类未完成
 **/
@RequestMapping("/product/inf")
@RestController
public class ProductInfController {

    @Autowired
    private ProductInfService productInfService;

    @RequestMapping(method = RequestMethod.GET)
    public BasicResponseVO<ProductDetail> getProductInfDetail(@RequestBody ProductDetail productDetail){
        return null;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public BasicResponseVO<List<ProductDetail>> getProductInfList(@RequestBody ProductDetail productDetails){

        return new BasicResponseVO<List<ProductDetail>>(productInfService.getProductInfList(productDetails));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/list")
    public BasicResponseVO deleteProductInfList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public BasicResponseVO insertProductInf(@RequestBody ProductDetail productDetail){
        productInfService.insertProductInfService(productDetail);
        return new BasicResponseVO("success");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BasicResponseVO deleteProductInf(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BasicResponseVO updateProductInf(@RequestBody ProductDetail productDetail){

        return null;
    }
}
