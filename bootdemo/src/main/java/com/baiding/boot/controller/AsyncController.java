package com.baiding.boot.controller;

import cn.baiding.common.AsyncTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BaiDing on 2017/7/23.
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncTest asyncTest;

    @RequestMapping("/testAsync")
    public void task1() throws Exception{
        asyncTest.doTaskOne();
        asyncTest.doTaskTwo();
        asyncTest.doTaskThree();
    }

}
