package com.baiding.boot.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by BaiDing on 2017/7/18.\
 * @Configuration 注解表明这个类是一个配置类
 * WebMvcConfigurerAdapter 管理了很多的配置信息，就包括了拦截器的配置。
 * 我们需要做的就是在这里通过依赖注入导入我们想注册的拦截器，
 * 然后通过重写 addInterceptors 方法来进行配置
 *
 * 这个 InterceptorRegistration 对象
 * 通常有两个方法 addPathPatterns 和 excludePathPatterns ，并且支持链式调用。
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
