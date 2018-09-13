package com.zl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/12
 * @description:
 **/
@RestController
@RequestMapping()
public class SessionController {

    @RequestMapping(value = "getSessionId")
    public String getSessionId(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("springboot");
        if (o == null) {
            o = "spring boot 牛逼了!!!有端口" + request.getLocalPort() + "生成";
            request.getSession().setAttribute("springboot", "abdfashdf[adfasf"+ UUID.randomUUID().toString());
        }
        return "端口=" + request.getLocalPort() + " sessionId=" + request.getSession().getId() + "<br/>" + o +":"+request.getSession().getAttribute("springboot");
    }

}
