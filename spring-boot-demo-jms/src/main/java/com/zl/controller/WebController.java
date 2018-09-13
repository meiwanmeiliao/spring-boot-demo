package com.zl.controller;

import com.zl.config.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/10
 * @description:
 **/
@RestController
@RequestMapping(value = "/web")
public class WebController {

    @Autowired
    JmsComponent jmsComponent;

    @RequestMapping(value = "getMsg")
    public void getMsg(String msg){
        jmsComponent.send(msg);
    }
}
