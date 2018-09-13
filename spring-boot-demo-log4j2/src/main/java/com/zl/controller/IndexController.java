package com.zl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/7/13
 * @description:
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping
    public String index() {
        logger.info("=========info");
        logger.debug("=========debug");
        logger.warn("=========warn");
        logger.error("=========error");
        return "hello world";
    }




}
