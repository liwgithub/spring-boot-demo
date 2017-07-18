package com.baiding.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by BaiDing on 2017/7/13.
 */
@SpringBootApplication
@MapperScan("com.baiding.boot.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
