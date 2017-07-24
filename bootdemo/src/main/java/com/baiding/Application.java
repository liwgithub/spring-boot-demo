package com.baiding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by BaiDing on 2017/7/13.
 * SpringBoot默认会扫描启动类同包和子包下的注解
 * @ComponentScan 注解就是用于指定要扫描的包以及要扫描的类
 * 即使所要扫描的包或者类不再启动类包下
 *
 * @MapperScan 来扫描注册mybatis数据库接口类，其中basePackages属性表明接口类所在的包
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.baiding","com.baiding"})
@MapperScan("com.baiding.boot.dao")
@EnableAsync
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

// 下述 代码作为将工程打包成war包部署在本地tomcat所用
//public class Application extends SpringBootServletInitializer{
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class,args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(this.getClass());
//    }
//}