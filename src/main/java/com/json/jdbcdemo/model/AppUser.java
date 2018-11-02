package com.json.jdbcdemo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import core.com.eryansky.common.utils.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2018-08-01
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "app_user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" , "handler"})
public class AppUser  implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	/**
	 * 账号(手机号)
	 */
	private String account;
	/**
	 * 密码
	 */
	@Column(name="pass_word")
	private String passWord;
	/**
	 * 昵称
	 */
	@Column(name="nick_name")
	private String nickName;
	/**
	 * 性别:1 男 2女 3 保密
	 */
	private Integer sex;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name="create_time",updatable=false)
	private Date createTime=new Date();
	/**
	 * 信鸽token
	 */
	@Column(name="xg_token")
	private String xgToken;
    /**
     * 登录token  
     */
	@Transient
    private String token;
	/**
	 * 当前操作的电池
	 */
	@Column(name="battery_terminal_id")
	private Integer batteryTerminalId;
	
	/**
	 * 头像
	 */
	@Column(name="head_portrait")
	private String headPortrait;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getXgToken() {
		return xgToken;
	}

	public void setXgToken(String xgToken) {
		this.xgToken = xgToken;
	}

	/**  验证账号 密码 昵称不为空
	 * @return null验证通过  其他不通过
	 */
	public String checkDate()
	{
		if(StringUtils.isBlank(account))
			return "账号不能为空";
		
		if(StringUtils.isBlank(passWord))
			return "密码不能为空";
		
		if(StringUtils.isBlank(nickName))
			return "昵称不能为空";
		
        return null;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getBatteryTerminalId() {
		return batteryTerminalId;
	}

	public void setBatteryTerminalId(Integer batteryTerminalId) {
		this.batteryTerminalId = batteryTerminalId;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	
	
}
