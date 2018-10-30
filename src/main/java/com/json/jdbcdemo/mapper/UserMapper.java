package com.json.jdbcdemo.mapper;

import com.json.jdbcdemo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user")
//    @Results({
//            @Result(property = "userSex",  column = "user_sex", javaType = User.class),
//            @Result(property = "nickName", column = "nick_name")
//    })
//    @Results({@Result(property = "userName",column = "username") })
    List<User> getAll();

    @Select("SELECT * FROM user where username=  #{userName} and password= #{password}" )
    User getUserByLogin(@Param("userName") String userName,@Param("password") String password);


    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
