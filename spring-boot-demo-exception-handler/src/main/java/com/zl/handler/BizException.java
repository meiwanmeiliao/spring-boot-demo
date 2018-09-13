package com.zl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description: 统一异常处理
 **/

@ControllerAdvice
public class BizException {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException runTimeException) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "*****");
        modelAndView.setViewName("error/500");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "");
        modelAndView.setViewName("error/500");
        return modelAndView;
    }

}
