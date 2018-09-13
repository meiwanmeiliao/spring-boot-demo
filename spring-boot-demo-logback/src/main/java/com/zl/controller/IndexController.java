package com.zl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/6/26
 * @description:
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final Logger monitorLogger = LoggerFactory.getLogger("monitor");

    @RequestMapping
    public String index() {
        logger.debug("this is a log test, debug");
        logger.info("this is a log test, info");
        logger.error("this is a log test, error");
        monitorLogger.info("====================================");
        return "hello world";
    }

    @RequestMapping(value = "/logLevel")
    public String setLoggerLevel() {
        return "hello world";
    }



}
