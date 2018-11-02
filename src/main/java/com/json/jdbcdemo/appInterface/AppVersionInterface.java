package com.json.jdbcdemo.appInterface;

import com.json.jdbcdemo.service.impl.AppVersionsServiceImpl;
import core.com.eryansky.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * app用户接口
 *
 */
@RestController
@Scope("prototype")
public class AppVersionInterface  {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired   private AppVersionsServiceImpl appVersionsService;
	
	@RequestMapping("getAppVersionInterface")
	public Result getAppVersion(Double appVersion)
	{
		if(appVersion==null)
			return Result.errorResult().setMsg("请填写当前版本号");
		return appVersionsService.getUpdates(appVersion);
	}
}
