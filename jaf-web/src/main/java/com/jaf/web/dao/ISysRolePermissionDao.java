/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysRolePermission.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:16 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.web.pojo.SysRolePermission;

/**
 * 
 * 类名称：ISysRolePermissionDao <br>
 * 类描述：系统角色权限关系表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface ISysRolePermissionDao extends IBaseDao<SysRolePermission> {
	/**
	 * 方法：queryByRoleIds <br>
	 * 描述：根据角色数组查询权限列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午11:14:36 <br>
	 * 
	 * @param user_ids
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysRolePermission> queryByRoleIds(List<Integer> roleIds)
			throws Exception;
}
