package com.json.jdbcdemo.dao;

import com.json.jdbcdemo.pojo.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);

    int deleteUserById(Long id);

    int updateUserById(User user);

    User queryUserById(Long id);

    List<User> queryUserList();
}
