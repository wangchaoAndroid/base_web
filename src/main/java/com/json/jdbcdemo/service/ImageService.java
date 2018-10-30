package com.json.jdbcdemo.service;

import com.json.jdbcdemo.mapper.ImageMapper;
import com.json.jdbcdemo.pojo.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageMapper imageMapper;

    public List<Images> getImages(){
        return imageMapper.getImages();
    }
}
