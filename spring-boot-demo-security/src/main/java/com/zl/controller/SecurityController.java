package com.zl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuolin
 * @program: spring-boot-demo
 * @date 2019/1/7
 * @description: ${description}
 **/
@Controller
public class SecurityController {

    @RequestMapping("/")
    public String index(ModelMap map){
        map.put("title","title00");
        map.put("content","content11111");
        map.put("etraInfo","额外信息,只对管理员显示.0320");
        return "hello";
    }

    @RequestMapping("/map1")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String map1(){
        return "map1";
    }

    @RequestMapping("/map2")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String map2(ModelMap map){
        return "map2";
    }
}
