/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.dao <br>
 * 文件名：SysLog.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2014-04-11 下午18:06:53 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dao;

import java.util.List;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.dto.BaseDto;
import com.jaf.web.pojo.SysLog;

/**
 *
 * 类名称：ISysLogDao <br>
 * 类描述：系统日志表数据链接对象接口 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-11 下午18:06:53 <br>
 * 修改备注：TODO <br>
 *
 */
public interface ISysLogDao extends IBaseDao<SysLog> {

	/**
	 * 方法：queryByDetailList <br>
	 * 描述：获取日志详细信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午3:09:47 <br>
	 *
	 * @param baseDto
	 * @return
	 */
	public List<SysLog> queryByDetailList(BaseDto baseDto);

	/**
	 * 方法：queryByDetailListCount <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午3:22:23 <br>
	 *
	 * @param baseDto
	 * @return
	 */
	public Integer queryByDetailListCount(BaseDto baseDto);

}
