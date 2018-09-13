package com.zl.controller;

import com.zl.config.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@RestController
@RequestMapping()
public class MessageController {

    @Autowired
    JmsComponent jmsComponent;

    @RequestMapping(value = "/index")
    public String index(String message){
        jmsComponent.send(message);
        return message;
    }
}
