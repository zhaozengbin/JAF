/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：EModelFrame.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午5:14:36<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 * 
 * 类名称：EModelFrame <br>
 * 类描述：模型框架类型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午5:14:36 <br>
 * 修改备注：TODO <br>
 * 
 */
public enum EModelFrame {
	Mybatis("Mybatis");

	/** 名称 */
	private String name;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午6:08:52 <br>
	 */
	EModelFrame() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午6:09:03 <br>
	 * 
	 * @param name
	 */
	private EModelFrame(String name) {
		this.name = name;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-16 下午6:09:09 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-16 下午6:09:09
	 */
	public void setName(String name) {
		this.name = name;
	}

}
