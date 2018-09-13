package com.vortex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @AUTH zhuolin
 * @DATE 2018/7/31
 * @description:
 **/
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    HttpSession session;

    @RequestMapping(value = "/index1")
    public String index(ModelMap map) {
        map.put("userName", session.getAttribute("userName"));
        return "index";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public boolean login(String userName) {
        session.setAttribute("userName", userName);
        return true;
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser(String userName) {
        return session.getAttribute("userName").toString();
    }

}
