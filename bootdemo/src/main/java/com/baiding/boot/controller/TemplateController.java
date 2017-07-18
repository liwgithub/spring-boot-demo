package com.baiding.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by BaiDing on 2017/7/14.
 */
@Controller
@RequestMapping("/temp")
public class TemplateController {

    @RequestMapping("/indexMy")
    public ModelAndView test(){
        return new ModelAndView("index");
    }

    @RequestMapping("/message")
    @ResponseBody
    public ModelAndView showMessage(){
        ModelAndView model=new ModelAndView("message");
        model.addObject("message","Welcome to the new World!");
        return model;
    }
}
