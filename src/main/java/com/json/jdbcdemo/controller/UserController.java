package com.json.jdbcdemo.controller;

import java.util.Date;

import com.json.jdbcdemo.model.Role;
import com.json.jdbcdemo.model.User;
import com.json.jdbcdemo.service.impl.RoleServiceImpl;
import com.json.jdbcdemo.service.impl.UserServiceImpl;
import core.com.eryansky.common.exception.ActionException;
import core.com.eryansky.common.model.Result;
import core.com.eryansky.common.orm.hibernate.EntityManager;
import core.com.eryansky.common.utils.encode.Encrypt;
import core.com.eryansky.common.web.springmvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @ClassName: BrowseController 
 * @Description: TODO(用户Controller) 
 * @author ty 
 * @date 2018-3-16 下午02:12:55 
 *  
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User, Integer> {

	@Autowired   private UserServiceImpl userService;   //这个注入是把UserServiceImpl 注入到 UserController类
	@Autowired   private RoleServiceImpl roleService;
	@Override
	public EntityManager<User, Integer> getEntityManager() {  //这个注入是把已经注入的userService   在继续注入给他继承的BaseController类
		return userService;
	}

	/**
	 * 用户列表 页面
	 */
	@RequestMapping(value = {""})
	public String index() {
		return "user";
	}

	/**
	 * 编辑用户 页面
	 */
	@RequestMapping(value = {"input"})
	public String input(@ModelAttribute("model") User user) {
		return "user_input";
	}

	/**
	 * 修改密码 页面
	 */
	@RequestMapping(value = {"password"})
	public String password() {
		return "user_password";

	}

//	/**
//	 * 保存
//	 */
//	@RequestMapping(value = {"save"})
//	@ResponseBody
//	public Result save(@ModelAttribute("model") User user) {
////		userService.evict(user);//如过本方法中有对model。setXX操作 则需执行evict方法 防止Hibernate session自动同步
//		user.setRole(null);
//		//user.setPlatform(null);
//		Result result = null;
//		// 名称重复校验
//		User nameCheckUser = userService.getUserByLoginName(user.getAccount());
//		if (nameCheckUser != null && !nameCheckUser.getId().equals(user.getId())) {
//			result = new Result(Result.WARN, "登录名为[" + user.getAccount() + "]已存在,请修正!", "loginName");
//			return result;
//		}
//
//		if (user.getId() == null) {// 新增
//			user.setPassword(Encrypt.e(user.getPassword()));
//			user.setCreateTime(new Date());
//		}
//
//		if(user.getRoleId()==null){
//			result = new Result(Result.WARN, "请选择角色", null);
//			return result;
//		}
//
//		// 添加角色
//		Role role = roleService.getById(user.getRoleId());
//		user.setRole(role);
//
////		userService.merge(user);
//		result = Result.successResult();
//		return result;
//	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = {"updateUserPassword"})
	@ResponseBody
	public Result updateUserPassword(Integer id, String newPassword) throws Exception {
		Result result;
		User user = userService.getUserById(id);
		if(user!=null){
			user.setPassword(Encrypt.e(newPassword));
//			userService.merge(user);
			result = Result.successResult();
		} else {
			throw new ActionException("用户【"+id+"】不存在或已被删除.");
		}
		return result;
	}
	
}
