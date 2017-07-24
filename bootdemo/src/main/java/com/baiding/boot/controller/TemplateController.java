package com.baiding.boot.controller;

import cn.baiding.common.UserProperty;
import com.baiding.common.model.FoShanCallBackUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by BaiDing on 2017/7/14.
 */
@Controller
@RequestMapping("/temp")
public class TemplateController {

    private Logger logger= LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private FoShanCallBackUrl foShanCallBackUrl;
    @Autowired
    private UserProperty userProperty;

    @RequestMapping("/indexMy")
    public ModelAndView test(){
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return new ModelAndView("index");
    }

    @RequestMapping("/message")
    @ResponseBody
    public ModelAndView showMessage(){
        logger.info("访问了{}接口，现在时间为{}","/temp/message",new Date());
        ModelAndView model=new ModelAndView("message");
        model.addObject("message",foShanCallBackUrl.getAccountOutUrl());
        model.addObject("user",userProperty.getName());
        return model;
    }

    @RequestMapping("/version")
    public String thymeleafVersion(){
        logger.info("访问了{}接口，现在时间为{}","/temp/version",new Date());
        return "/test";
    }
}
