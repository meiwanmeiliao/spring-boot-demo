package com.zl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/1
 * @description:
 **/
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.put("title", "😊");
        return "index";
    }
}
