package com.json.jdbcdemo.mapper;

import com.json.jdbcdemo.pojo.Images;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {

    @Insert("INSERT INTO t_imageurl(image_url) VALUES(#{imageUrl})")
    void insert(String imageUrl);

    @Select("SELECT * FROM t_imageurl")
    @Results({@Result(property = "imageUrl",column = "image_url")})
    List<Images> getImages();
}
