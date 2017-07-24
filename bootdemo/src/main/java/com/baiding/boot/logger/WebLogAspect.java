package com.baiding.boot.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by BaiDing on 2017/7/21.
 *
 * 使用切面来统一全局的访问日志
 */
@Aspect
@Component
@Order(-5)
public class WebLogAspect {

    private Logger logger= LoggerFactory.getLogger(WebLogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(* com.baiding.*.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("WebLogAspect.doBefore()");

        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request=attributes.getRequest();
        //使用日志记录请求的内容
        logger.info("URL --->{} ",request.getRequestURL().toString());
        logger.info("HTTP_METHOD --->{}",request.getMethod());
        logger.info("IP --->{}",request.getRemoteAddr());
        logger.info("CLASS_METHOD --->{}",joinPoint.getSignature().getDeclaringTypeName()+
                    "."+joinPoint.getSignature().getName());
        logger.info("PARAMS --->{}", Arrays.asList(joinPoint.getArgs()));
    }


    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint){
        // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
    }
}
