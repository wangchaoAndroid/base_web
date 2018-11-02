package com.json.jdbcdemo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.json.jdbcdemo.model.AppVersions;
import core.com.eryansky.common.model.Result;
import core.com.eryansky.common.orm.PropertyFilter;
import core.com.eryansky.common.orm.hibernate.EntityManager;
import core.com.eryansky.common.orm.hibernate.HibernateDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AppVersionsServiceImpl extends EntityManager<AppVersions, Integer> {



	/** 
	 * <p>Title: 获得更新</p> 
	 * <p>Description: </p> 
	 * @param appVersions  当前应用版本号
	 * @return 
	 */

	public Result getUpdates(Double appVersions) {
		// TODO Auto-generated method stub
		Result result=new Result();

		AppVersions updateVersion=null;
		List<PropertyFilter>  filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("EQI_status","1"));
//		List<AppVersions> appVersionsList=findJoin(filters);
//		for(AppVersions versions:appVersionsList)
//		{
//			if(appVersions<versions.getAppVersion())
//			{
//				appVersions=versions.getAppVersion();
//				updateVersion=versions;
//			}
//		}
		if(updateVersion==null)
		{
			return result.setMsg("当前是最新版本").setCode(0);
		}
		else
		{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("updateUrl", updateVersion.getUpdatePath());
			map.put("appVersion", updateVersion.getAppVersion());
			map.put("isForce", updateVersion.getIsForce());
			map.put("remarks", updateVersion.getRemarks());
			return result.setMsg("发现最新版本").setCode(1).setObj(map);
		}
	}

	/** 
	 * <p>Title: 启用版本</p> 
	 * <p>Description: </p> id
	 * @param
	 * @return 
	 */
	public Result startUsingAppversion(Integer id) {
		// TODO Auto-generated method stub
		Result result=new Result();
//		AppVersions appVersions=getById(id);
//		List<PropertyFilter>  filters=new ArrayList<PropertyFilter>();
//		filters.add(new PropertyFilter("EQI_status","1"));
//		List<AppVersions> appVersionsList=findJoin(filters);
//		if(appVersionsList!=null&&appVersionsList.size()>0)
//		{
//			appVersionsList.get(0).setStatus(0);
//			save(appVersionsList.get(0));
//		}
//		appVersions.setStatus(1);
//		save(appVersions);
		return result.setCode(1).setMsg("操作成功");
	}

}
