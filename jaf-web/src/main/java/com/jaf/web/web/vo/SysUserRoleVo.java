/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：SysUserRoleVo.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:16 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.vo;

import com.jaf.core.controller.vo.BaseVo;

/**
 * 
 * 类名称：SysUserRoleVo <br>
 * 类描述：系统用户角色关系表模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysUserRoleVo extends BaseVo {

	/**  */

	/* 主键编号 * */
	private Integer id;

	/* 系统用户编号 * */
	private Integer userId;

	/* 系统角色编号 * */
	private Integer roleId;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:16 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2013-10-24 上午11:49:16 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the userId <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:16 <br>
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * @param userId
	 *            the userId to set <br>
	 *            时间: 2013-10-24 上午11:49:16 <br>
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @retrun the roleId <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:16 <br>
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set <br>
	 *            时间: 2013-10-24 上午11:49:16 <br>
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
