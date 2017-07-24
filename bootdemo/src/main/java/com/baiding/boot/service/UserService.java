package com.baiding.boot.service;

import com.baiding.boot.dao.UserDAO;
import com.baiding.boot.model.User;

/**
 * Created by BaiDing on 2017/7/21.
 */
public interface UserService {

    User selectUserByUser(User user);
}
