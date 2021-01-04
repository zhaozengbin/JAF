/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysUserTeam.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 下午17:18:00 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.web.pojo.SysUserTeam;

/**
 *
 * 类名称：ISysUserTeamDao <br>
 * 类描述：系统用户组关系表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 *
 */
public interface ISysUserTeamDao extends IBaseDao<SysUserTeam> {

	/**
	 * 方法：queryByTeamIds <br>
	 * 描述：根据用户ID查询与组关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:43:21 <br>
	 *
	 * @param teamIds
	 * @return
	 * @throws Exception
	 */
	public List<SysUserTeam> queryByTeamIds(List<Integer> teamIds)
			throws Exception;

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
	 * 方法：deleteByTeamId <br>
	 * 描述：根据角色ID删除关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:43:21 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public void deleteByTeamId(Integer teamId) throws Exception;
}
