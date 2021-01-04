/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：EViewFrame.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午2:15:14<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 * 
 * 类名称：EViewFrame <br>
 * 类描述：展示层框架枚举 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午2:15:14 <br>
 * 修改备注：TODO <br>
 * 
 */
public enum EViewFrame {
	Struts("Struts"), Struts2("Struts2"), Spring("Spring");

	/** 名称 */
	private String name;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午6:13:10 <br>
	 */
	EViewFrame() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午6:13:24 <br>
	 * 
	 * @param name
	 */
	private EViewFrame(String name) {
		this.name = name;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-16 下午6:13:30 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-16 下午6:13:30
	 */
	public void setName(String name) {
		this.name = name;
	}

}
