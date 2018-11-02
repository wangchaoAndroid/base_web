package com.json.jdbcdemo.service.impl;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;
import com.json.jdbcdemo.model.AppUser;
import com.json.jdbcdemo.model.LoginInfo;
import com.json.jdbcdemo.util.PushNotiUtil;
import core.com.eryansky.common.orm.PropertyFilter;
import core.com.eryansky.common.orm.hibernate.EntityManager;
import core.com.eryansky.common.orm.hibernate.HibernateDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ty
 * @since 2018-08-01
 */
@Service
public class LoginInfoServiceImpl extends EntityManager<LoginInfo, Integer> {


	
	/**  生成新的Token  并使老的token过期
	 * @param appUser 必须是持久化的bean
	 * @return 登录token
	 */
	public String saveToken(AppUser appUser) {
		
		List<PropertyFilter> filters= Lists.newArrayList();
		filters.add(new PropertyFilter("EQI_appUser.id", appUser.getId()+""));
		filters.add(new PropertyFilter("EQI_status", "1"));
//		List<LoginInfo> loginInfoList=loginInfoDao.find(filters);
//		if(loginInfoList!=null&&loginInfoList.size()>0)
//		{
//			AppUser oldAppUser=loginInfoList.get(0).getAppUser();
////			if(!appUser.getXgToken().equals(oldAppUser.getXgToken()))
////			  PushNotiUtil.pushSingleMsg(oldAppUser.getXgToken(), "{\"cmd\":\"remoteLogin\",\"title\":\"您的账号已在其他设备登录，请重新登录或者修改密码!\"}", null, 2);
//			loginInfoDao.updateBySql("update login_info  set `status`=0 where app_user_id="+appUser.getId(),null);
//		}
//
//		LoginInfo loginInfo=new LoginInfo();
//		String token=UUID.randomUUID().toString();
//		loginInfo.setAppUser(appUser);
//		loginInfo.setStatus(1);
//		loginInfo.setToken(token);
//		save(loginInfo);
//
//		appUserService.save(appUser);//重新保存xgToken
		return "1234";
	}
	/**  根据token获取登录账号
	 * @param token
	 * @return  
	 */
//	public AppUser  getAppUserByToken(String token)
//	{
//		List<PropertyFilter> filters=Lists.newArrayList();
//		filters.add(new PropertyFilter("EQI_status","1"));
//		filters.add(new PropertyFilter("EQS_token",token));
//		List<LoginInfo> list=find(filters);
//		return list==null||list.size()==0?null:list.get(0).getAppUser();
//	}
}
