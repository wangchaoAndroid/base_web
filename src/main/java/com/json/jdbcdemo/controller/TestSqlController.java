package com.json.jdbcdemo.controller;

import com.github.pagehelper.util.StringUtil;
import com.json.jdbcdemo.common.HttpCode;
import com.json.jdbcdemo.common.Result;
import com.json.jdbcdemo.common.utils.StringUtils;
import com.json.jdbcdemo.mapper.UserMapper;
import com.json.jdbcdemo.pojo.User;
import com.json.jdbcdemo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TestSqlController {

    private static final String BASE_PATH = "admin/";

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    LoginService loginService;

    @RequestMapping(value = "index")
    public String index(){
        return BASE_PATH+"index";
    }


    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "login")
    public String login(){
        return BASE_PATH+"login";
    }

    @ResponseBody
    @RequestMapping(value = {"loginJson.action"})
    public Result loginjson( String userName , String password){
        Result result = new Result();
        if(StringUtils.isBlank(userName)){
            result.setMsg("用户名不能为空");
            result.setCode(HttpCode.ERROR);
            result.setData(null);
            return result;
        }
        if(StringUtils.isBlank(password)){
            result.setMsg("密码不能为空");
            result.setCode(HttpCode.ERROR);
            result.setData(null);
            return result;
        }
        User user = loginService.authrationUser(userName,password);
        if(user == null){
            result.setMsg("用户名或密码不正确");
            result.setCode(HttpCode.ERROR);
            return result;
        }
        result.setCode(HttpCode.SUCCESS);
        result.setMsg("登录成功");
        result.setData("index");
//        // 1、获取Subject实例对象
//        Subject currentUser = SecurityUtils.getSubject();
//        // 3、将用户名和密码封装到UsernamePasswordToken
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        String msg;
//        // 4、认证
//        try {
//            currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
//            Session session = currentUser.getSession();
//            session.setAttribute("userName", userName);
//            result.setMsg("登录成功");
//            result.setCode(HttpCode.SUCCESS);
//            result.setData("index");
//            return result;
//            //return "/index";
//        }catch (UnknownAccountException e) {
//            e.printStackTrace();
//            msg = "UnknownAccountException -- > 账号不存在：";
//
//        } catch (IncorrectCredentialsException e) {
//            msg = "IncorrectCredentialsException -- > 密码不正确：";
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            msg="用户验证失败";
//        }
//        result.setMsg(msg);
        logger.info(userName + "------>" + password);

        return result;
    }






}
