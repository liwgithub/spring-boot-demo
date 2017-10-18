package com.baiding.service;

import com.baiding.model.User;
import com.baiding.model.UserMapper;
import com.baiding.redis.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by BaiDing on 2017/10/18.
 */
@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserMapper userMapper;

    @RedisCache(reidsKey = "user",timeout = 3000)
    @Override
    public User queryUserByName(String name) {
        System.out.println(new Date());
        return userMapper.findByName(name);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user.getName(),user.getAge());
    }
}
