package com.baiding.boot.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BaiDing on 2017/7/18.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
    private String[] URLS={"/admin/login","/admin/toLogin"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        boolean flag=false;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String path=httpServletRequest.getRequestURL().toString();
        logger.info("访问了{}接口，现在时间为{}",path,sdf.format(new Date()));
        for(String url:URLS){
            if(path.contains(url)){
                flag=true;
                break;
            }

        }
        if(!flag){
            Integer adminId=(Integer)httpServletRequest.getSession().getAttribute("adminId");
            if (adminId != null){
                logger.info("adminId:{}",adminId);
                flag = true;
            }else{
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/toLogin");
            }

        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
