package com.baiding.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baiding.boot.model.User;

/**
 * Created by BaiDing on 2017/7/13.
 * RestController  相当于  Controller 与 requestBody
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello MyDear liuJun";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello MyDear liuJun2";
    }

    @RequestMapping("/user")
    public User queryUser(){

        User user=new User();
        user.setAge(11);
        user.setName("张三");

        return user;
    }
}
