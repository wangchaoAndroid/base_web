package com.json.jdbcdemo.controller;

import com.json.jdbcdemo.common.HttpCode;
import com.json.jdbcdemo.common.Result;
import com.json.jdbcdemo.config.SystemConfiguration;
import com.json.jdbcdemo.mapper.UserMapper;
import com.json.jdbcdemo.pojo.Images;
import com.json.jdbcdemo.pojo.User;
import com.json.jdbcdemo.service.ImageService;
import com.json.jdbcdemo.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PictureController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UploadService uploadService;

    @Autowired
    UserMapper userMapper;
    @Autowired
    ImageService imageService;
    //图片存放地址
    @Value("${server.multipart.location}")
    private String fileSavePath;

    /**
     * 上传图片,是一个个传的
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public  Result upload(HttpServletRequest request,@RequestPart("file") MultipartFile picture) {
        logger.error(picture.getOriginalFilename());
        Result result = new Result();
        String fileType = "";
        String webUrl = "";
        String fileName = picture.getOriginalFilename();
        //System.err.println("========== file type: " + f.getContentType() + " // name: " + fileName);
        if (fileName != null) {
            fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }

        File folder = new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String now = UUID.randomUUID().toString();
        String name =now + fileType;
        File file = new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression, name);
        try {
            picture.transferTo(file);
            webUrl=SystemConfiguration.PRITURE_WEBUPLOADER_WEB + name;
            uploadService.insert(webUrl);
        } catch (Exception  e) {
            logger.error(e.getMessage());
            result.setCode(1);
            result.setMsg("上传失败");
        }

        result.setCode(0);
        result.setMsg("上传成功");
        result.setData(webUrl);

        return result;
    }


    @RequestMapping(value = "/getImages")
    @ResponseBody
    public Result getImages(){
        Result result = new Result();
        List<Images> images = imageService.getImages();
        result.setCode(HttpCode.SUCCESS);
        result.setData(images);
        result.setMsg("success");
        return result;
    }


    @RequestMapping(value = "/getUsers")
    @ResponseBody
    public Result getUsers(){
        Result result = new Result();
        List<User> user = userMapper.getAll();
        result.setCode(HttpCode.SUCCESS);
        result.setData(user);
        result.setMsg("success");
        return result;
    }

}
