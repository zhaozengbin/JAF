/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.pojo <br>
 * 文件名：SysBaseUser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-11-06 下午16:19:59 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.pojo;

import com.jaf.web.pojo.BaseBean;

/**
 * 
 * 类名称：SysBaseUser <br>
 * 类描述：系统基础用户表实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-06 下午16:19:59 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysBaseUser extends BaseBean {

	/* 主键编号 * */
	private Integer id;

	/* 用户名 * */
	private String userName;

	/* 密码 * */
	private String password;

	/* 状态 * */
	private Integer status;

	/* 创建时间 * */
	private java.sql.Timestamp createTime;

	/* 创建者 * */
	private Integer createUser;

	/** 用于用户详细信息查询 */

	/** 角色编号 多个用英文逗号分割 */
	private String roleId;

	/** 组编号 多个用英文逗号分割 */
	private String teamId;

	/** 角色名称 多个用英文逗号分割 */
	private String roleName;

	/** 组名称 多个用英文逗号分割 */
	private String teamName;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the userName <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param userName
	 *            the userName to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @retrun the password <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @retrun the status <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 *            the status to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createUser <br>
	 * 
	 *         时间: 2013-11-06 下午16:19:59 <br>
	 */
	public Integer getCreateUser() {
		return this.createUser;
	}

	/**
	 * @param createUser
	 *            the createUser to set <br>
	 *            时间: 2013-11-06 下午16:19:59 <br>
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	/**
	 * @retrun the roleId <br>
	 * 
	 *         时间: 2013-12-24 下午3:23:46 <br>
	 */

	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set <br>
	 * 
	 *            时间: 2013-12-24 下午3:23:46
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @retrun the teamId <br>
	 * 
	 *         时间: 2013-12-24 下午3:23:46 <br>
	 */

	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId
	 *            the teamId to set <br>
	 * 
	 *            时间: 2013-12-24 下午3:23:46
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @retrun the roleName <br>
	 * 
	 *         时间: 2013-12-24 下午3:23:46 <br>
	 */

	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set <br>
	 * 
	 *            时间: 2013-12-24 下午3:23:46
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @retrun the teamName <br>
	 * 
	 *         时间: 2013-12-24 下午3:23:46 <br>
	 */

	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 *            the teamName to set <br>
	 * 
	 *            时间: 2013-12-24 下午3:23:46
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
