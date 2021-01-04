/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.pojo <br>
 * 文件名：SysUser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-04-03 下午13:45:08 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.pojo;

import com.jaf.web.pojo.BaseBean;

/**
 *
 * 类名称：SysUser <br>
 * 类描述：系统用户表实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-03 下午13:45:08 <br>
 * 修改备注：TODO <br>
 *
 */
public class SysUser extends BaseBean {


	/** 用户名称 */
	private String userName;

	/** 密码 */
	private String password;

	/** 状态 */
	private Integer status;

	/** 角色编号 多个用英文逗号分割 */
	private String roleId;

	/** 组编号 多个用英文逗号分割 */
	private String teamId;

	/** 角色名称 多个用英文逗号分割 */
	private String roleName;

	/** 组名称 多个用英文逗号分割 */
	private String teamName;

	/** 创建用户 */
	private Integer createUser;

	/**
	 * @retrun the userName <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @retrun the password <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @retrun the status <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @retrun the roleId <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @retrun the teamId <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @retrun the roleName <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @retrun the teamName <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @retrun the createUser <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28 <br>
	 */

	public Integer getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set <br>
	 *
	 * 时间: 2014-4-4 上午10:35:28
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
}