/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysBaseUser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-11-06 下午16:19:59 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.dto.BaseDto;
import com.jaf.web.pojo.SysBaseUser;

/**
 *
 * 类名称：ISysBaseUserDao <br>
 * 类描述：系统基础用户表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-06 下午16:19:59 <br>
 * 修改备注：TODO <br>
 *
 */
public interface ISysBaseUserDao extends IBaseDao<SysBaseUser> {

	/**
	 * 方法：queryByDetailList <br>
	 * 描述：获取用户详细信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-3 下午3:36:16 <br>
	 *
	 * @param baseDto
	 * @return
	 */
	public List<SysBaseUser> queryByDetailList(BaseDto baseDto);

}
