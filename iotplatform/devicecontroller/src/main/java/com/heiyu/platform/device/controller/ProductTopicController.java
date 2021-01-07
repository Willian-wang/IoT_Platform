package com.heiyu.platform.device.controller;

import com.heiyu.platform.device.entity.common.BasicResponseVO;
import com.heiyu.platform.device.entity.product.ProductDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品Topic（MQTT传输信息的标识符）控制类
 * @author WangYi
 * @date 15:35 2019/8/7
 * @version 1.0
 * //TODO 该类未完成
 **/
@RequestMapping("/product/topic")
@RestController
public class ProductTopicController {

    @RequestMapping(method = RequestMethod.GET)
    public BasicResponseVO<ProductDetail> getProductTopicDetail(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public BasicResponseVO<ProductDetail> getProductTopicList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/list")
    public BasicResponseVO deleteProductTopicList(@RequestBody ProductDetail[] productDetails){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public BasicResponseVO insertProductTopic(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BasicResponseVO deleteProductTopic(@RequestBody ProductDetail productDetail){

        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BasicResponseVO updateProductTopic(@RequestBody ProductDetail productDetail){

        return null;
    }
}
