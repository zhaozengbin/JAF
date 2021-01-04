/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dto <br>
 * 文件名：SysUserRoleDto.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:16 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto;

import com.jaf.core.dto.BaseDto;

/**
 * 
 * 类名称：SysUserRoleDto <br>
 * 类描述：系统用户角色关系表数据传输对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysUserRoleDto extends BaseDto {

	/**  */

	/* 主键编号 * */
	private Integer id;

	/* 系统用户编号 * */
	private Integer userId;

	/* 系统角色编号 * */
	private Integer roleId;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午12:14:24 <br>
	 */
	public SysUserRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午12:14:07 <br>
	 * 
	 * @param userId
	 * @param roleId
	 */
	public SysUserRoleDto(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

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
