/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.util <br>
 * 文件名：JDBCUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-9-上午11:05:29<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jaf.common.Globals;
import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：JDBCUtils <br>
 * 类描述：JDBC工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-9 上午11:05:29 <br>
 * 修改备注：TODO <br>
 * 
 */
public class JDBCUtils {

	/** 数据库链接 */
	private static Connection connection = null;

	/**
	 * 方法：getConnection <br>
	 * 描述：获取链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:11:02 <br>
	 * 
	 * @param driver
	 *            驱动
	 * @param url
	 *            数据库地址
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 链接
	 * @throws Exception
	 */
	public static Connection getConnection(String driver, String url,
			String userName, String password) {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 方法：getConnection <br>
	 * 描述：根据配置文件类获取数据库链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午2:30:29 <br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() {
		try {
			if (ObjectUtils.isEmpty(connection) || connection.isClosed()) {
				Class.forName(Globals.DATA_SOURCE_JDBC_DRIVER);
				connection = DriverManager.getConnection(
						Globals.DATA_SOURCE_JDBC_URL,
						Globals.DATA_SOURCE_JDBC_USERNAME,
						Globals.DATA_SOURCE_JDBC_PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 方法：close <br>
	 * 描述：关闭链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:12:22 <br>
	 * 
	 * @param connection
	 * @param statement
	 */
	public static void close(Connection connection, Statement statement) {
		close(connection);
		close(statement);
		connection = null;
	}

	/**
	 * 方法：close <br>
	 * 描述：关闭链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:13:47 <br>
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
		close(connection, statement);
		close(resultSet);
	}

	/**
	 * 方法：close <br>
	 * 描述：关闭链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:14:23 <br>
	 * 
	 * @param connection
	 */
	public static void close(Connection connection) {
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 方法：close <br>
	 * 描述：关闭链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:16:02 <br>
	 * 
	 * @param statement
	 */
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 方法：close <br>
	 * 描述：关闭链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:16:13 <br>
	 * 
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
