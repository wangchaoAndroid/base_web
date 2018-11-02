package com.json.jdbcdemo.dao;

import com.json.jdbcdemo.model.Menu;
import com.json.jdbcdemo.model.Role;
import core.com.eryansky.common.orm.hibernate.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from Menu r where r.status = #{status} and parentId = #{parentId} order by r.orderNo desc")
    List<Menu> find(Integer parentId, Integer status);

    @Select("select * from user where username = #{loginName} ")
    List<Menu>   findRoleByLoginName(String loginName);

    @Select("select * from user where id = #{roleid} ")
    Role  findRoleById(Integer roleid);
}
