/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.init <br>
 * 文件名：AbstractInitialization.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-2-下午2:12:37<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.init;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.jaf.core.sql.util.JDBCUtils;
import com.jaf.core.util.ObjectUtils;

/**
 *
 * 类名称：AbstractInitialization <br>
 * 类描述：系统初始化 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-2 下午2:12:37 <br>
 * 修改备注：TODO <br>
 *
 */
public abstract class AbstractInitialization {

	/** 数据库连接对象 */
	protected static Connection connection;

	/**
	 * 方法：execute <br>
	 * 描述：执行创建表操作 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:24:25 <br>
	 *
	 * @throws Exception
	 */
	public void execute() throws Exception {
		if (ObjectUtils.isEmpty(connection) || connection.isClosed()) {
			connection = JDBCUtils.getConnection();
		}
		createSysBaseUserTab();
		createSysUserTab();
		createSysTeamTab();
		createSysRoleTab();
		createSysPermission();
		createSysRelevance();
		createSysDictionary();
		createSysLog();
		insertInitialData();
		connection.close();
	}

	/**
	 * 方法：createSysBaseUserTab <br>
	 * 描述：创建基础系统用户表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:19:02 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysBaseUserTab() throws Exception;

	/**
	 * 方法：createSysUserTab <br>
	 * 描述：创建系统用户表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:19:02 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysUserTab() throws Exception;

	/**
	 * 方法：createSysTeamTab <br>
	 * 描述：创建系统用户组表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:19:31 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysTeamTab() throws Exception;

	/**
	 * 方法：createSysRoleTab <br>
	 * 描述：创建系统角色用户表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:20:36 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysRoleTab() throws Exception;

	/**
	 * 方法：createSysPermission <br>
	 * 描述：创建系统权限表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:22:37 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysPermission() throws Exception;

	/**
	 * 方法：createDictionary <br>
	 * 描述：创建词典表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:47:57 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysDictionary() throws Exception;

	/**
	 * 方法：createSysLog <br>
	 * 描述：创建系统日志表<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:47:57 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysLog() throws Exception;

	/**
	 * 方法：createSysRelevance <br>
	 * 描述：创建关联表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:23:34 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void createSysRelevance() throws Exception;

	/**
	 * 方法：insertInitialData <br>
	 * 描述：插入初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-23 下午6:10:17 <br>
	 *
	 * @throws Exception
	 */
	protected abstract void insertInitialData() throws Exception;

	/**
	 * 方法：getLogger <br>
	 * 描述：获取日志输出 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午2:39:59 <br>
	 *
	 * @return
	 */
	protected abstract Logger getLogger();
}
