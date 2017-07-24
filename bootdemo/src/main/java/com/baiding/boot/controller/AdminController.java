package com.baiding.boot.controller;

import com.baiding.boot.model.User;
import com.baiding.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BaiDing on 2017/7/21.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger= LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/login")
    public  String login(User user, HttpServletRequest request){
        logger.info("用户正在登录，登录帐号密码为...{}",user.toString());
        try {
            User admin = userService.selectUserByUser(user);
            if(admin!=null){
                request.getSession().setAttribute("adminId",admin.getId());
                return "/index";
            }else{
                return "/login";
            }
        }catch(Exception e){
            logger.warn("用户正在登录，登录出现错误...",e);
            return "/login";
        }
    }

}
