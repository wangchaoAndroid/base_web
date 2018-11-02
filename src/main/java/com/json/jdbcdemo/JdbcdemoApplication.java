package com.json.jdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.json.jdbcdemo.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class JdbcdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcdemoApplication.class, args);
    }
}
