/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.pojo <br>
 * 文件名：SysUserTeam.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 下午17:18:00 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.pojo;

import com.jaf.web.pojo.BaseBean;

/**
 * 
 * 类名称：SysUserTeam <br>
 * 类描述：系统用户组关系表实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysUserTeam extends BaseBean {

	/* 主键编号 * */
	private Integer id;

	/* 系统用户编号 * */
	private Integer userId;

	/* 系统用户组编号 * */
	private Integer teamId;

	/* 系统用户组内级别 * */
	private Integer level;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-10-24 下午17:18:00 <br>
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 *            时间: 2013-10-24 下午17:18:00 <br>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the userId <br>
	 * 
	 *         时间: 2013-10-24 下午17:18:00 <br>
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * @param userId
	 *            the userId to set <br>
	 *            时间: 2013-10-24 下午17:18:00 <br>
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @retrun the teamId <br>
	 * 
	 *         时间: 2013-10-24 下午17:18:00 <br>
	 */
	public Integer getTeamId() {
		return this.teamId;
	}

	/**
	 * @param teamId
	 *            the teamId to set <br>
	 *            时间: 2013-10-24 下午17:18:00 <br>
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/**
	 * @retrun the level <br>
	 * 
	 *         时间: 2013-10-24 下午17:18:00 <br>
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * @param level
	 *            the level to set <br>
	 *            时间: 2013-10-24 下午17:18:00 <br>
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
}
