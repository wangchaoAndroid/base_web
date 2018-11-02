package com.json.jdbcdemo.appInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Lists;
import com.json.jdbcdemo.config.SystemConfiguration;
import com.json.jdbcdemo.model.AppUser;
import com.json.jdbcdemo.model.LoginInfo;
import com.json.jdbcdemo.service.impl.LoginInfoServiceImpl;
import com.json.jdbcdemo.util.SMSUtil;
import core.com.eryansky.common.model.Result;
import core.com.eryansky.common.orm.PropertyFilter;
import core.com.eryansky.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * app用户接口
 *
 */
@RestController
@Scope("prototype")
public class AppUserInterface  {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired   private LoginInfoServiceImpl loginInfoService;



	/**   登录验证
	 * @param account  账号
	 * @param passWord 密码
	 * @param xgToken  信鸽token
	 * @return
	 */
//	@RequestMapping(value = { "loginInterface"})
//	public Result Login(String account, String passWord, String xgToken) {
//
//		try {
//			Map<String,Object> map=new HashMap<String,Object>();
//			Result result = null;
//			String msg = null;
//			if(StringUtils.isBlank(account)){
//				msg = "请输入账号!";
//				result = new Result(Result.ERROR, msg, null);
//				return result;
//			}
//			if(StringUtils.isBlank(passWord)){
//				msg = "请输入密码!";
//				result = new Result(Result.ERROR, msg, null);
//				return result;
//			}
//
//			List<PropertyFilter> filters= Lists.newArrayList();
//			filters.add(new PropertyFilter("EQS_account",account));
//			filters.add(new PropertyFilter("EQS_passWord",passWord));
//			List<AppUser> appUserList= appUserService.find(filters);
//
//			if (appUserList == null||appUserList.size()==0) {
//				msg = "用户名或密码不正确!";
//				result = new Result(Result.ERROR, msg, null);
//				return result;
//			}
//
//			appUserList.get(0).setXgToken(xgToken);
//			String token=loginInfoService.saveToken(appUserList.get(0));
//			appUserList.get(0).setToken(token);
//			map.put("nickName", appUserList.get(0).getNickName());
//			map.put("sex", appUserList.get(0).getSex());
//			map.put("token", appUserList.get(0).getToken());
//			map.put("headPortrait", appUserList.get(0).getHeadPortrait());
//			result = new Result(Result.SUCCESS, "用户验证通过!", map);
//			return result;
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//
//	}



	/** app注册
	 * @param appUser  注册bean数据
	 * @param smsCode  验证码
	 * @return
	 */
//	@RequestMapping(value = { "regeditInterface"})
//	public Result regedit(@ModelAttribute("AppUser") AppUser appUser,String smsCode) {
//		Result result = new Result();
//
//		try {
//			if(StringUtils.isBlank(smsCode))
//				return result.setCode(2).setMsg("验证码不能为空");
//
//			String msg=appUser.checkDate();
//			if(msg!=null)
//				return result.setCode(2).setMsg(msg);
//
//
//			if(!appUserService.isUnique(appUser, "account"))
//			     return result.setCode(2).setMsg("该账号已存在");
//
//
//			Integer status= SMSUtil.checkSMSCode(appUser.getAccount(), smsCode);
//			if(status==0)
//				return result.setCode(2).setMsg("验证码错误");
//			if(status==2)
//				return result.setCode(2).setMsg("验证码已过期");
//
//			appUserService.save(appUser);
//			return result.setCode(1).setMsg("注册成功");
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//
//	}
//
//
//	/** 发送短信验证码
//	 * @param phone 接收验证码手机号
//	 * @return
//	 */
//	@RequestMapping(value="sendCodeInterface")
//	public Result sendCode(String phone)
//	{
//		try
//		{
//			if (StringUtils.isBlank(phone)) return Result.errorResult().setMsg("请填写手机号！");
//
//			if (!SMSUtil.sendSMSCode(phone)) return Result.errorResult().setMsg("发送失败");
//
//			return Result.successResult();
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//
//
//	/** 注销登录
//	 * @param token 登录token
//	 * @return
//	 */
//	@RequestMapping(value="logoutInterface")
//	public Result logout(String token)
//	{
//
//		Result result = new Result();
//		try
//		{
//			if(StringUtils.isBlank(token))
//			{
//				return result.setCode(2).setMsg("token不能为空");
//			}
//
//			List<PropertyFilter> filters=Lists.newArrayList();
//			filters.add(new PropertyFilter("EQI_status","1"));
//			filters.add(new PropertyFilter("EQS_token",token));
//			List<LoginInfo> list=loginInfoService.find(filters);
//			if(list==null||list.size()==0)
//				return Result.errorAuthResult();
//
//			LoginInfo loginInfo=list.get(0);
//			loginInfo.setStatus(0);
//			loginInfoService.save(loginInfo);
//			return Result.successResult();
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//
//	/** 修改密码
//	 * @param token         登录返回的token
//	 * @param newPassWord   新密码
//	 * @param oldPassWord   原密码
//	 * @return
//	 */
//	@RequestMapping(value="updatePasswordInterface")
//	public Result updatePassword(String token,String newPassWord,String oldPassWord)
//	{
//
//		Result result = new Result();
//		try
//		{
//			if(StringUtils.isBlank(token))
//			{
//				return result.setCode(2).setMsg("token不能为空");
//			}
//
//			if(StringUtils.isBlank(newPassWord))
//			{
//				return result.setCode(2).setMsg("newPassWord不能为空");
//			}
//
//			if(StringUtils.isBlank(oldPassWord))
//			{
//				return result.setCode(2).setMsg("oldPassWord不能为空");
//			}
//			List<PropertyFilter> filters=Lists.newArrayList();
//			filters.add(new PropertyFilter("EQI_status","1"));
//			filters.add(new PropertyFilter("EQS_token",token));
//			List<LoginInfo> list=loginInfoService.find(filters);
//			if(list==null||list.size()==0)
//				return Result.errorAuthResult();
//
//			AppUser appUser=list.get(0).getAppUser();
//			if(!appUser.getPassWord().equals(oldPassWord))
//				return result.setCode(2).setMsg("原密码错误!");
//			appUser.setPassWord(newPassWord);
//			appUserService.save(appUser);
//			return Result.successResult();
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//
//	/** 找回密码
//	 * @param account      账号
//	 * @param code         验证码
//	 * @param newPassWord  新密码
//	 * @return
//	 */
//	@RequestMapping(value="retrievePasswordInterface")
//	public Result retrievePassword(String account,String code,String newPassWord)
//	{
//
//		Result result = new Result();
//		try
//		{
//			if(StringUtils.isBlank(account))
//			{
//				return result.setCode(2).setMsg("account不能为空");
//			}
//
//			if(StringUtils.isBlank(code))
//			{
//				return result.setCode(2).setMsg("code不能为空");
//			}
//
//			if(StringUtils.isBlank(newPassWord))
//			{
//				return result.setCode(2).setMsg("newPassWord不能为空");
//			}
//			AppUser appUser=appUserService.findUniqueBy("account", account);
//			if(appUser==null)
//				return result.setCode(2).setMsg("未找到此账号");
//
//			Integer status=SMSUtil.checkSMSCode(account, code);
//			if(status==0)
//				return result.setCode(2).setMsg("验证码错误");
//			if(status==2)
//				return result.setCode(2).setMsg("验证码已过期");
//
//
//			appUser.setPassWord(newPassWord);
//			appUserService.save(appUser);
//			return Result.successResult();
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//
//	/**       绑定默认终端
//	 * @param token        返回的token
//	 * @param productNumber 电池编号
//	 * @return
//	 */
//	@RequestMapping(value="bindingDefaultInterface")
//	public Result bindingDefaultSimMark(String token,String productNumber)
//	{
//
//		Result result = new Result();
//		try
//		{
//
//			if(StringUtils.isBlank(token))
//			{
//				return result.setCode(2).setMsg("token不能为空");
//			}
//			if(StringUtils.isBlank(productNumber))
//			{
//				return result.setCode(2).setMsg("productNumber不能为空");
//			}
//
//			AppUser appUser=loginInfoService.getAppUserByToken(token);
//			if(appUser==null)
//			    return Result.errorAuthResult();
//
//			appUserService.save(appUser);
//			return Result.successResult();
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//	/**       获取基本信息
//	 * @param token        返回的token
//	 * @return
//	 */
//	@RequestMapping(value="getUserInfoInterface")
//	public Result getAppuserInfo(String token)
//	{
//
//		Result result = new Result();
//		Map<String,Object> map=new HashMap<String,Object>();
//		try
//		{
//
//			if(StringUtils.isBlank(token))
//			{
//				return result.setCode(2).setMsg("token不能为空");
//			}
//
//			AppUser appUser=loginInfoService.getAppUserByToken(token);
//			if(appUser==null)
//			    return Result.errorAuthResult();
//
//			appUser.setToken(token);
//
//			map.put("nickName", appUser.getNickName());
//			map.put("sex", appUser.getSex());
//			map.put("token", appUser.getToken());
//			map.put("headPortrait", appUser.getHeadPortrait());
//			result = new Result(Result.SUCCESS, "用户验证通过!", map);
//
//			return Result.successResult().setObj(map);
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(),e);
//			return Result.errorResult();
//		}
//	}
//
//	/**
//	* <p>Title: 上传头像 </p>
//	* <p>Description:    通用文件上传 </p>
//	* @param file       文件流
//	* @param fileDir    保存到哪个文件夹
//	* @param suffix     文件后缀
//	* @return
//	*/
//	@RequestMapping("/headPortraitInterface")
//	public   Result uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, String fileDir,@RequestParam(defaultValue=".png") String suffix,String token)
//	{
//		try
//		{
//			Map<String,Object> map=new HashMap<String,Object>();
//			if(StringUtils.isBlank(token))
//			{
//				return Result.warnResult().setMsg("token不能为空");
//			}
//
//			AppUser appUser=loginInfoService.getAppUserByToken(token);
//			if(appUser==null)
//			    return Result.errorAuthResult();
//
//			String dir ="";
//			if (fileDir != null && !"".equals(fileDir))
//			{
//				dir = fileDir;
//			}
//			Date date = new Date();
//			InputStream input = file.getInputStream();// 可替换为任何路径何和文件名
//			request.setCharacterEncoding("UTF-8");
//			long name = date.getTime();
//			String dd= SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression;
//			String path = dd+ dir + "/" + name + suffix;//上传路径
//			String web = SystemConfiguration.PRITURE_WEBUPLOADER_WEB + dir + "/" + name + suffix;//访问路径
//			//检查文件是否存在，不存在则创建
//	    	File  fi=new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression + dir);
//	    	if(!fi.exists()&&!fi.isDirectory())
//	    		fi.mkdirs();
//			FileOutputStream output = new FileOutputStream(path);//文件流
//			int in = input.read();
//			while (in != -1)
//			{
//				output.write(in);
//				in = input.read();
//			}
//			output.close();
//			input.close();
//			appUser.setHeadPortrait(web);
//			appUserService.save(appUser);
//
//			map.put("nickName", appUser.getNickName());
//			map.put("sex", appUser.getSex());
//			map.put("token", appUser.getToken());
//			map.put("headPortrait", appUser.getHeadPortrait());
//			return Result.successResult().setObj(map).setMsg("上传成功");
//		} catch (IOException e)
//		{
//			e.printStackTrace();
//			return Result.errorResult().setMsg("文件流异常结束，请检查文件重新上传");
//		}
//	}
}
