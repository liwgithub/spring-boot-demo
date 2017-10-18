package com.baiding.service;

import com.baiding.model.User;
/**
 * Created by BaiDing on 2017/10/18.
 */
public interface UserService {

     User queryUserByName(String name);

     int saveUser(User user);
}
