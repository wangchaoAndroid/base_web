package com.json.jdbcdemo.dao;

import com.json.jdbcdemo.model.User;
import core.com.eryansky.common.orm.hibernate.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    List<User> find( String username ,String password);

    @Select("select * from user where username = #{loginName} ")
    List<User>   findUserByLoginName(String loginName);

    @Select("select * from user where id = #{id} ")
    User   findUserById(Integer id);
}
