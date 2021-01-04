/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：SysRolePermissionVo.java <br>
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
 * 类名称：SysRolePermissionVo <br>
 * 类描述：系统角色权限关系表模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysRolePermissionVo extends BaseVo{
	
	/**  */
		/* 主键编号 **/	private Integer id;		/* 系统角色编号 **/	private Integer roleId;		/* 系统权限编号 **/	private Integer permissionId;			/**	 * @retrun the id <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getId() {	    return this.id;	}		/**	 * @param id	 *            the id to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setId(Integer id) {	    this.id=id;	}		/**	 * @retrun the roleId <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getRoleId() {	    return this.roleId;	}		/**	 * @param roleId	 *            the roleId to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setRoleId(Integer roleId) {	    this.roleId=roleId;	}		/**	 * @retrun the permissionId <br>	 * 	 *        时间: 2013-10-24 上午11:49:16 <br>	*/	public Integer getPermissionId() {	    return this.permissionId;	}		/**	 * @param permissionId	 *            the permissionId to set <br>	 *            时间: 2013-10-24 上午11:49:16 <br>	*/	public void setPermissionId(Integer permissionId) {	    this.permissionId=permissionId;	}
}
