package com.heiyu.platform.device.controller;

import com.heiyu.platform.device.entity.common.BasicResponseVO;
import com.heiyu.platform.device.entity.product.ProductDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProductionFuctionController
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 14:59 2019/8/7
 * @Version: 1.0
 **/


@RequestMapping("/product/function")
@RestController
public class ProductFunctionController {

    @RequestMapping(method = RequestMethod.GET)
    public BasicResponseVO<ProductDetail> getProductFunctionDetail(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public BasicResponseVO<ProductDetail> getProductFunctionList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/list")
    public BasicResponseVO deleteProductFunctionList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public BasicResponseVO insertProductFunction(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BasicResponseVO deleteProductFunction(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BasicResponseVO updateProductFunction(@RequestBody ProductDetail productDetail){

        return null;
    }
}
