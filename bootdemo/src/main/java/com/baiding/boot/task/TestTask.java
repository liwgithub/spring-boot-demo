package com.baiding.boot.task;

import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sun.applet.Main;

import java.util.Date;

/**
 * Created by BaiDing on 2017/7/16.
 * @EnableScheduling 注解的作用是发现注解@Scheduled的任务并后台执行
 * @Scheduled 注解用于标注这个方法是一个定时任务的方法，有多种配置可选。
 * cron支持cron表达式，指定任务在特定时间执行；
 * fixedRate以特定频率执行任务；
 * fixedRateString以string的形式配置执行频率。
 */
@Configuration
@EnableScheduling
public class TestTask {

//    @Scheduled(cron = "0 */1 * * * ?")
//    public void task1(){
//        System.out.println("task1"+new Date());
//    }
//
//    @Scheduled(cron = "0/10 * *  * * ?")
//    public void task2(){
//        System.out.println("task2 "+new Date());
//    }



}
