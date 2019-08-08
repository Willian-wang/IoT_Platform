package com.heiyu.platform.device.controller;

import com.heiyu.platform.device.entity.common.BasicResponseVO;
import com.heiyu.platform.device.entity.product.ProductDetail;
import com.heiyu.platform.device.service.ProductInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProductController
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 14:29 2019/8/7
 * @Version: 1.0
 **/

@RequestMapping("/product/inf")
@RestController
public class ProductInfController {

    @Autowired
    private ProductInfService productInfService;

    @RequestMapping(method = RequestMethod.GET)
    public BasicResponseVO<ProductDetail> getProductInfDetail(@RequestBody ProductDetail productDetail){
        productInfService.
        return null;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public BasicResponseVO<ProductDetail> getProductInfList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/list")
    public BasicResponseVO deleteProductInfList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public BasicResponseVO insertProductInf(@RequestBody ProductDetail productDetail){

        return null;
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
