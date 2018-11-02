package com.json.jdbcdemo.dao;

import com.json.jdbcdemo.model.Role;
import com.json.jdbcdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    List<Role> find(String username, String password);

    @Select("select * from user where username = #{loginName} ")
    List<Role>   findRoleByLoginName(String loginName);

    @Select("select * from user where id = #{roleid} ")
    Role  findRoleById(Integer  roleid);
}
