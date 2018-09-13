package com.zl.controller;

import com.zl.config.AmqpComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@RestController
@RequestMapping
public class MessageController {

    @Autowired
    AmqpComponent amqpComponent;

    @RequestMapping(value = "/index")
    public void index(String message){
        amqpComponent.send(message);
    }
}
