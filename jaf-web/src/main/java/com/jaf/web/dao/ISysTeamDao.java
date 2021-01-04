/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysTeam.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-10-24 下午17:18:00 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.web.pojo.SysTeam;

/**
 * 
 * 类名称：ISysTeamDao <br>
 * 类描述：系统用户组表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface ISysTeamDao extends IBaseDao<SysTeam> {

	/**
	 * 方法：queryByIds <br>
	 * 描述： 根据ID数组查询多条系统用户组表数据<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:29:18 <br>
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public List<SysTeam> queryByIds(List<Integer> ids) throws Exception;

}
