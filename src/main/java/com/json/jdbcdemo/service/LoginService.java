package com.json.jdbcdemo.service;

import com.json.jdbcdemo.mapper.UserMapper;
import com.json.jdbcdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;

    public User authrationUser(String userName , String password){
        User userByLogin = userMapper.getUserByLogin(userName, password);
        return userByLogin;
    }

}
