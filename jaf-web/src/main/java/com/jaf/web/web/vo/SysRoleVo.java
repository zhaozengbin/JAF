/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：SysRoleVo.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:15 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.vo;

import com.jaf.core.controller.vo.BaseVo;

/**
 *
 * 类名称：SysRoleVo <br>
 * 类描述：系统角色表模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:15 <br>
 * 修改备注：TODO <br>
 *
 */
public class SysRoleVo extends BaseVo {

	/**  */

	/* 主键编号 * */
	private Integer id;

	/* 角色名 * */
	private String roleName;

	/* 角色描述 * */
	private String description;

	/* 创建时间 * */
	private java.sql.Timestamp createTime;

	/* 创建者 * */
	private Integer createUser;

	/** 冗余 是否选中 */
	private Boolean selected;

	/** 冗余 是否可编辑 */
	private Boolean isModify;

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
	 * @retrun the roleName <br>
	 *
	 *         时间: 2013-10-24 上午11:49:15 <br>
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set <br>
	 *            时间: 2013-10-24 上午11:49:15 <br>
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * @retrun the selected <br>
	 *
	 *         时间: 2014-4-2 下午5:41:50 <br>
	 */

	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set <br>
	 *
	 *            时间: 2014-4-2 下午5:41:50
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	/**
	 * @retrun the isModify <br>
	 *
	 *         时间: 2014-4-2 下午6:26:49 <br>
	 */

	public Boolean getIsModify() {
		return isModify;
	}

	/**
	 * @param isModify
	 *            the isModify to set <br>
	 *
	 *            时间: 2014-4-2 下午6:26:49
	 */
	public void setIsModify(Boolean isModify) {
		this.isModify = isModify;
	}

}
