package com.json.jdbcdemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

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
@Table(name = "login_info")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" , "handler","appUser"})
public class LoginInfo implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	/**
	 * App用户ID
	 */
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinColumn(name="app_user_id")
	private AppUser appUser;
	/**
	 * app账号
	 */
	@Transient
	private String appAccount;
	/**
	 * 登录令牌
	 */
	private String token;
	/**
	 * 创建时间
	 */
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name="create_time",updatable=false)
	private Date createTime=new Date();
	/**
	 * 0 过期  1正在使用
	 */
	private Integer status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public String getAppAccount() {
		if(appUser!=null)
			this.appAccount=appUser.getAccount();
		return appAccount;
	}

	public void setAppAccount(String appAccount) {
		this.appAccount = appAccount;
	}


}
