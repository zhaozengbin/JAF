/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.dto <br>
 * 文件名：DatabaseInfo.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-9-上午11:30:52<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.dto;

/**
 * 
 * 类名称：DatabaseInfo <br>
 * 类描述：数据库信息 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-9 上午11:30:52 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DatabaseInfo {

	/** 数据库驱动 */
	private String driver;

	/** 数据库地址 */
	private String url;

	/** 数据库用户名 */
	private String userName;

	/** 数据库密码 */
	private String password;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:35:36 <br>
	 */
	public DatabaseInfo() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:35:30 <br>
	 * 
	 * @param driver
	 * @param url
	 * @param userName
	 * @param password
	 */
	public DatabaseInfo(String driver, String url, String userName,
			String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @retrun the driver <br>
	 * 
	 *         时间: 2013-7-9 上午11:36:00 <br>
	 */

	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set <br>
	 * 
	 *            时间: 2013-7-9 上午11:36:00
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @retrun the url <br>
	 * 
	 *         时间: 2013-7-9 上午11:36:00 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 * 
	 *            时间: 2013-7-9 上午11:36:00
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the userName <br>
	 * 
	 *         时间: 2013-7-9 上午11:36:00 <br>
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set <br>
	 * 
	 *            时间: 2013-7-9 上午11:36:00
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @retrun the password <br>
	 * 
	 *         时间: 2013-7-9 上午11:36:00 <br>
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set <br>
	 * 
	 *            时间: 2013-7-9 上午11:36:00
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
