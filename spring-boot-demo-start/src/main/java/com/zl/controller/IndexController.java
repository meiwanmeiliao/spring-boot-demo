package com.zl.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @AUTH zhuolin
 * @DATE 2018/6/25
 * @description:
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {
    //http://127.0.0.1:8080/index
    @RequestMapping
    public String index() {
        return "hello World 😊";
    }

    // @RequestParam 简单类型的绑定，可以出来get和post
    //http://127.0.0.1:8080/index/get?name=adnfa
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "^.^");
        map.put("name", name);
        return map;
    }

    // @PathVariable 获得请求url中的动态参数
    //http://127.0.0.1:8080/index/get/1/ad
    @RequestMapping(value = "/get/{id}/{name}")
    public HashMap<String, Object> getMap(@PathVariable int id, @PathVariable String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        return map;
    }

}
