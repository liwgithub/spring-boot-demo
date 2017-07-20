package com.baiding.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by BaiDing on 2017/7/20.
 */
@Controller
@RequestMapping("/log")
public class LogController {

    private Logger logger= LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/test")
    public ModelAndView test(){
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return new ModelAndView("index");
    }
}
