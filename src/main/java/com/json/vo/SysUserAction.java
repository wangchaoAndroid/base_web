package com.json.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SysUserAction extends BaseAction{
    Logger log = LoggerFactory.getLogger(SysUserAction.class);

    @RequestMapping(value = "uploadHeadPic")
    public String uploadHeadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
//        try {
//            super.upload(file, "/upload/user/",request);
//            response.getWriter().print(super.getFileName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "hello world";
    }
}
