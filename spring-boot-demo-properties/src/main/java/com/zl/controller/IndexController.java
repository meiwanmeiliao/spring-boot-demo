package com.zl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/6/25
 * @description:
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Value(value = "${zl.secret}")
    private String secret;

    @Value(value = "${zl.number}")
    private int id;

    @Value(value = "${zl.desc}")
    private String desc;

    @RequestMapping
    public String index() {
        return secret + ":" + id + ":" + desc;
    }

}
