/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dto <br>
 * 文件名：SysPermissionDto.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:15 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto;

import com.jaf.core.dto.BaseDto;

/**
 * 
 * 类名称：SysPermissionDto <br>
 * 类描述：系统权限表数据传输对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:15 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysPermissionDto extends BaseDto {

	/**  */

	/* 主键编号 * */
	private Integer id;

	/* 权限名称 * */
	private String permissionName;

	/* 权限描述 * */
	private String description;

	/* 链接地址 * */
	private String url;

	/* 父级编号 * */
	private Integer parentId;

	/* 权重 * */
	private Integer weight;

	/* 类型 1菜单 2 按钮 * */
	private Integer type;

	/* 创建时间 * */
	private java.sql.Timestamp createTime;

	/* 创建者 * */
	private Integer createUser;

	/* 图标 * */
	private String icon;

	/** 样式 */
	private String clazz;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the permissionName <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public String getPermissionName() {
		return this.permissionName;
	}

	/**
	 * @param permissionName
	 *            the permissionName to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * @retrun the description <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @retrun the url <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the parentId <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public Integer getParentId() {
		return this.parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @retrun the weight <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public Integer getWeight() {
		return this.weight;
	}

	/**
	 * @param weight
	 *            the weight to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * @retrun the type <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createUser <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public Integer getCreateUser() {
		return this.createUser;
	}

	/**
	 * @param createUser
	 *            the createUser to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	/**
	 * @retrun the icon <br>
	 * 
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public String getIcon() {
		return this.icon;
	}

	/**
	 * @param icon
	 *            the icon to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @retrun the clazz <br>
	 * 
	 *         时间: 2013-10-25 下午3:45:19 <br>
	 */

	public String getClazz() {
		return clazz;
	}

	/**
	 * @param clazz
	 *            the clazz to set <br>
	 * 
	 *            时间: 2013-10-25 下午3:45:19
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
