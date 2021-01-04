/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dto <br>
 * 文件名：SysDictionaryDto.java <br>
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
 * 类名称：SysDictionaryDto <br>
 * 类描述：系统词典数据传输对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysDictionaryDto extends BaseDto{
	
	/**  */
		/* 主键编号 **/	private Integer id;		/* 字典分组编号 **/	private Integer groupid;		/* 字典名称 **/	private String name;		/* 字典编号 **/	private String code;		/* 创建时间 **/	private java.sql.Timestamp createTime;		/* 创建者 **/	private Integer createUser;			/**	 * @retrun the id <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getId() {	    return this.id;	}		/**	 * @param id	 *            the id to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setId(Integer id) {	    this.id=id;	}		/**	 * @retrun the groupid <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getGroupid() {	    return this.groupid;	}		/**	 * @param groupid	 *            the groupid to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setGroupid(Integer groupid) {	    this.groupid=groupid;	}		/**	 * @retrun the name <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public String getName() {	    return this.name;	}		/**	 * @param name	 *            the name to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setName(String name) {	    this.name=name;	}		/**	 * @retrun the code <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public String getCode() {	    return this.code;	}		/**	 * @param code	 *            the code to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setCode(String code) {	    this.code=code;	}		/**	 * @retrun the createTime <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}		/**	 * @param createTime	 *            the createTime to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}		/**	 * @retrun the createUser <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getCreateUser() {	    return this.createUser;	}		/**	 * @param createUser	 *            the createUser to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setCreateUser(Integer createUser) {	    this.createUser=createUser;	}
}
