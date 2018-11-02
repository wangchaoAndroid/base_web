package com.json.jdbcdemo.controller;

import com.json.jdbcdemo.model.AppVersions;
import com.json.jdbcdemo.service.impl.AppVersionsServiceImpl;
import core.com.eryansky.common.orm.hibernate.EntityManager;
import core.com.eryansky.common.web.springmvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




/** 
 * @ClassName: BrowseController 
 * @Description: TODO(用户Controller) 
 * @author ty 
 * @date 2018-3-16 下午02:12:55 
 *  
 */
@RequestMapping("appVersion")
@Controller
public class AppVersionController extends BaseController<AppVersions, Integer> {

	@Autowired   private AppVersionsServiceImpl appVersionsService;
	@Override
	public EntityManager<AppVersions, Integer> getEntityManager() {
		return appVersionsService;
	}

	/**
	 * 用户列表 页面
	 */
	@RequestMapping(value = {""})
	public String index() {
		return "version_list";
	}
	
	/**
	 * 编辑 页面
	 */
	@RequestMapping(value = {"edit"})
	public String edit(Integer id) {
		return "version_edit";
	}

}
