package com.zl.controller;

import com.zl.entity.User;
import com.zl.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/21
 * @description:
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserCacheService userCacheService;

    @RequestMapping(value = "/selectById")
    public User selectById(Long id) {
        return userCacheService.selectById(id);
    }

    @RequestMapping(value = "/updateById")
    public User updateById() {
        User user = new User();
        user.setId(2L);
        user.setName("zhangsan");
        user.setAge(20);
        return userCacheService.updateById(user);
    }

    @RequestMapping(value = "/deleteById")
    public String deleteById(Long id) {
        return userCacheService.deleteById(id);
    }


}
