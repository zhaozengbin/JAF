/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysUser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2014-04-03 下午13:45:08 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.dto.BaseDto;
import com.jaf.web.pojo.SysUser;

/**
 *
 * 类名称：ISysUserDao <br>
 * 类描述：系统用户表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-03 下午13:45:08 <br>
 * 修改备注：TODO <br>
 *
 */
public interface ISysUserDao extends IBaseDao<SysUser> {

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
	public List<SysUser> queryByDetailList(BaseDto baseDto);

	/**
	 * 方法：queryDetailById <br>
	 * 描述：根据用户编号获取用户详细信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 上午11:04:56 <br>
	 *
	 * @param id
	 * @return
	 */
	public SysUser queryDetailById(Integer id);

}
