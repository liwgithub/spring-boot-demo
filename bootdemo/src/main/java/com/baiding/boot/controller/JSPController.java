package com.baiding.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BaiDing on 2017/7/15.
 */
@Controller
@RequestMapping("/jsp")
public class JSPController {

    @RequestMapping("/name")
    public String showJsp(){
        return "name";
    }

    @RequestMapping("/two")
    @ResponseBody
    public String showTwo(){
        return "two";
    }
}
