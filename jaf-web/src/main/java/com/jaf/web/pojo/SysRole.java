/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.pojo <br>
 * 文件名：SysRole.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 上午11:49:15 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.pojo;

import com.jaf.web.pojo.BaseBean;

/**
 * 
 * 类名称：SysRole <br>
 * 类描述：系统角色表实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:15 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysRole extends BaseBean {
		/* 主键编号 **/	private Integer id;		/* 角色名 **/	private String roleName;		/* 角色描述 **/	private String description;		/* 创建时间 **/	private java.sql.Timestamp createTime;		/* 创建者 **/	private Integer createUser;			/**	 * @retrun the id <br>	 * 	 *        时间: 2013-10-24 上午11:49:15 <br>	*/	public Integer getId() {	    return this.id;	}		/**	 * @param id	 *            the id to set <br>	 *            时间: 2013-10-24 上午11:49:15 <br>	*/	public void setId(Integer id) {	    this.id=id;	}		/**	 * @retrun the roleName <br>	 * 	 *        时间: 2013-10-24 上午11:49:15 <br>	*/	public String getRoleName() {	    return this.roleName;	}		/**	 * @param roleName	 *            the roleName to set <br>	 *            时间: 2013-10-24 上午11:49:15 <br>	*/	public void setRoleName(String roleName) {	    this.roleName=roleName;	}		/**	 * @retrun the description <br>	 * 	 *        时间: 2013-10-24 上午11:49:15 <br>	*/	public String getDescription() {	    return this.description;	}		/**	 * @param description	 *            the description to set <br>	 *            时间: 2013-10-24 上午11:49:15 <br>	*/	public void setDescription(String description) {	    this.description=description;	}		/**	 * @retrun the createTime <br>	 * 	 *        时间: 2013-10-24 上午11:49:15 <br>	*/	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}		/**	 * @param createTime	 *            the createTime to set <br>	 *            时间: 2013-10-24 上午11:49:15 <br>	*/	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}		/**	 * @retrun the createUser <br>	 * 	 *        时间: 2013-10-24 上午11:49:15 <br>	*/	public Integer getCreateUser() {	    return this.createUser;	}		/**	 * @param createUser	 *            the createUser to set <br>	 *            时间: 2013-10-24 上午11:49:15 <br>	*/	public void setCreateUser(Integer createUser) {	    this.createUser=createUser;	}
}
