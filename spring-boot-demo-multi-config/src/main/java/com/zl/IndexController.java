package com.zl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTH zhuolin
 * @DATE 2018/6/25
 * @description:
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping
    public String getIndex(){
        System.out.println(System.getProperties());
        return "3";
    }
}
