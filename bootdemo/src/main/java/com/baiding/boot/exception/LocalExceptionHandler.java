package com.baiding.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BaiDing on 2017/7/13.
 * 通过 @ControllerAdvice 注解可以将对于控制器的全局配置放在同一个位置
 * @ControllerAdvice 注解将作用在所有注解了 @RequestMapping 的控制器的方法上
 * @ExceptionHandler 用于全局处理控制器里的异常。
 */
@ControllerAdvice
public class LocalExceptionHandler {

    // 定义全局异常处理，value属性可以过滤拦截条件，此处拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request, Exception e){
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return msg;
    }
}
