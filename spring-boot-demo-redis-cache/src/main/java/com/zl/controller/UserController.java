package com.zl.controller;

import com.zl.entity.User;
import com.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/31
 * @description:
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public User get(@RequestParam(defaultValue = "1") Long id) {
        return userService.selectById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public User update(@RequestParam(defaultValue = "1") Long id) {
        User bean = userService.selectById(id);
        bean.setName("测试");
        bean.setAge(12);
        userService.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam(defaultValue = "1") Long id) {
        return userService.deleteById(id);
    }
}
