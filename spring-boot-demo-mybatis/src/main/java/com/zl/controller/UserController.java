package com.zl.controller;

import com.zl.mappper.UserMapper;
import com.zl.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/13
 * @description:
 **/
@RestController
@RequestMapping()
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "select", method = RequestMethod.GET)
    public UserModel select(Long id) {
        return userMapper.selectById(id);
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public int insert() {
        UserModel userModel = new UserModel();
        userModel.setName("张三");
        userModel.setCreateTime(new Date());
        return userMapper.insert(userModel);
    }
}
