/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysUserRole.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 上午11:49:16 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.web.dto.SysUserRoleDto;
import com.jaf.web.pojo.SysUserRole;

/**
 *
 * 类名称：ISysUserRoleDao <br>
 * 类描述：系统用户角色关系表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 *
 */
public interface ISysUserRoleDao extends IBaseDao<SysUserRole> {

	/**
	 * 方法：queryByUserIds <br>
	 * 描述：根据用户编号数组查询角色列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午11:14:36 <br>
	 *
	 * @param userIds
	 *
	 * @return
	 * @throws Exception
	 */
	public List<SysUserRole> queryByUserIds(List<Integer> userIds)
			throws Exception;

	/**
	 * 方法：queryByUserId <br>
	 * 描述：根据用户ID查询与组关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:43:21 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<SysUserRole> queryByUserId(SysUserRoleDto dto) throws Exception;

	/**
	 * 方法：deleteByUserId <br>
	 * 描述：根据用户ID删除关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:43:21 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public void deleteByUserId(Integer userId) throws Exception;

	/**
	 * 方法：deleteByRoleId <br>
	 * 描述：根据角色ID删除关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:43:21 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public void deleteByRoleId(Integer roleId) throws Exception;

}
