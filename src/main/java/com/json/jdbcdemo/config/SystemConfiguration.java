package com.json.jdbcdemo.config;



public class SystemConfiguration
{    
    //本地测试上传路径
    //public static final String PRITURE_WEBUPLOADER_TOMCAT_compression = "C:/upoadFile/";//图片路径
    //public static final String PRITURE_WEBUPLOADER_WEB = "http://localhost:8089/boot/file/";//图片访问路径
   
   
   //本地测试上传路径  外置tomcat
   public static final String PRITURE_WEBUPLOADER_TOMCAT_compression = "/usr/img/";//图片路径
   public static final String PRITURE_WEBUPLOADER_WEB = "http://120.79.13.43:8080/pic";//图片访问路径
     
}
