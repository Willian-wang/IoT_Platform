package com.heiyu.iot.sdk.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 16:58 2020/1/23
 **/

public class ConfigMapHandleException extends Exception {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ConfigMapHandleException(String message) {
        super(message);
        logger.error(message);
    }
}
