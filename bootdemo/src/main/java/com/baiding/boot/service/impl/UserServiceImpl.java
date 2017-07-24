package com.baiding.boot.service.impl;

import com.baiding.boot.dao.UserDAO;
import com.baiding.boot.model.User;
import com.baiding.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BaiDing on 2017/7/21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User selectUserByUser(User user) {
        return userDAO.selectUserByUser(user);
    }
}
