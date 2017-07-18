package com.baiding.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BaiDing on 2017/7/13.
 */
@ControllerAdvice
public class LocalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request, Exception e){
        return "对不起，服务器繁忙......";
    }
}
