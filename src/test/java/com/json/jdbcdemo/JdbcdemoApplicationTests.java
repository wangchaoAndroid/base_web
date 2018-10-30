package com.json.jdbcdemo;

import com.alibaba.fastjson.JSON;
import com.json.jdbcdemo.mapper.ImageMapper;
import com.json.jdbcdemo.mapper.UserMapper;
import com.json.jdbcdemo.pojo.Images;
import com.json.jdbcdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcdemoApplicationTests {


    @Autowired
    UserMapper userMapper;
    @Autowired
    ImageMapper imageMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void tesetGetAll(){
        List<User> all = userMapper.getAll();
        System.out.println(all.toString());
    }

    @Test
    public void tesetGetAllImages(){
        List<Images> all = imageMapper.getImages();
        System.out.println(all.toString());
    }

}
