package com.json.jdbcdemo.service;

import com.json.jdbcdemo.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
    @Autowired
    ImageMapper imageMapper;

    public void insert(String imageUrl){
        imageMapper.insert(imageUrl);
    }
}
