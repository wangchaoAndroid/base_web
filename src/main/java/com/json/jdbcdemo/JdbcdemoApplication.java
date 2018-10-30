package com.json.jdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.json.jdbcdemo.mapper")
public class JdbcdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcdemoApplication.class, args);
    }
}
