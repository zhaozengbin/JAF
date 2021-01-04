/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dto <br>
 * 文件名：SysTeamDto.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 下午17:18:00 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto;

import com.jaf.core.dto.BaseDto;

/**
 * 
 * 类名称：SysTeamDto <br>
 * 类描述：系统用户组表数据传输对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysTeamDto extends BaseDto {

	/**  */

	/* 主键编号 * */
	private Integer id;

	/* 组名 * */
	private String teamName;

	/* 组描述 * */
	private String description;

	/* 创建时间 * */
	private java.sql.Timestamp createTime;

	/* 创建者 * */
	private Integer createUser;

	/* 父类编号 * */
	private Integer parentId;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the teamName <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public String getTeamName() {
		return this.teamName;
	}

	/**
	 * @param teamName
	 *            the teamName to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @retrun the description <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createUser <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public Integer getCreateUser() {
		return this.createUser;
	}

	/**
	 * @param createUser
	 *            the createUser to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	/**
	 * @retrun the parentId <br>
	 * 
	 *         时间: 2013-10-24 下午17:17:59 <br>
	 */
	public Integer getParentId() {
		return this.parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set <br>
	 *            时间: 2013-10-24 下午17:17:59 <br>
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
