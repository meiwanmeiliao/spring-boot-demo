package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTH zhuolin
 * @DATE 2018/7/13
 * @description:
 **/
@Controller
@RequestMapping(value = "/web")
public class WebController {

    @RequestMapping(value = "/index")
    public String index(ModelMap map) {
        map.put("title", "hello world");
        return "index";
    }
}
