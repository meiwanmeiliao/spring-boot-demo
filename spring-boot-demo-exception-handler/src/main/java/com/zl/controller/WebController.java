package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
@Controller
@RequestMapping(value = "/web")
public class WebController {


    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap) {
        modelMap.put("title", "😭");
        return "index";
    }

    @RequestMapping(value = "/error")
    public String error() {
        String a = null;
        return a.toUpperCase();
    }
}
