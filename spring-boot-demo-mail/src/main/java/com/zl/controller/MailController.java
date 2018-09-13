package com.zl.controller;

import com.zl.config.JavaMailComponent;
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
public class MailController {

    @Autowired
    JavaMailComponent javaMailComponent;

    @RequestMapping(value = "mail")
    public String mail(String mail) {
        javaMailComponent.sendMail(mail);
        return "成功";
    }
}
