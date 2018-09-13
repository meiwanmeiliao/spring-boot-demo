package com.zl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/21
 * @description:
 **/
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/redis")
    public Boolean save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    @RequestMapping(value = "/get")
    public String get(String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }


}
