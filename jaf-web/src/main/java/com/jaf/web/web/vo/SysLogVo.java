/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：SysLogVo.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2014-04-11 下午18:06:53 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.vo;

import com.jaf.core.controller.vo.BaseVo;

/**
 *
 * 类名称：SysLogVo <br>
 * 类描述：系统日志表模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-11 下午18:06:53 <br>
 * 修改备注：TODO <br>
 *
 */
public class SysLogVo extends BaseVo {

	/* 主键编号 * */
	private Integer id;

	/* 日志内容 * */
	private String content;

	/* 日志描述 * */
	private String remark;

	/* 日志级别 级别越高数据库敏感度越高 增删改为 1级 查为2级 * */
	private Integer level;

	/* 日志操作类型 1 添加/更改 、2 删除、3 查询 、4 其他 * */
	private Integer operation;

	/* 创建时间 * */
	private java.sql.Timestamp createTime;

	/* 创建者 * */
	private Integer createUser;

	/** 创建者名称 冗余 */
	private String createUserName;

	/**
	 * @retrun the id <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the content <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * @param content
	 *            the content to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @retrun the remark <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * @param remark
	 *            the remark to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @retrun the level <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * @param level
	 *            the level to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @retrun the operation <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public Integer getOperation() {
		return this.operation;
	}

	/**
	 * @param operation
	 *            the operation to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	/**
	 * @retrun the createTime <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createUser <br>
	 *
	 *         时间: 2014-04-11 下午18:06:53 <br>
	 */
	public Integer getCreateUser() {
		return this.createUser;
	}

	/**
	 * @param createUser
	 *            the createUser to set <br>
	 *            时间: 2014-04-11 下午18:06:53 <br>
	 */
	public void setCreateUser(Integer createUser) {

		this.createUser = createUser;
	}

	/**
	 * @retrun the createUserName <br>
	 *
	 *         时间: 2014-4-14 下午3:02:30 <br>
	 */

	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * @param createUserName
	 *            the createUserName to set <br>
	 *
	 *            时间: 2014-4-14 下午3:02:30
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}
