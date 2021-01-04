/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：ESpecialCharacters.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午12:25:21<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 * 
 * 类名称：ESpecialCharacters <br>
 * 类描述：特殊字符枚举 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午12:25:21 <br>
 * 修改备注：TODO <br>
 * 
 */
public enum ESpecialCharacters {
	ENTER("\r\t", "<br \\>"), BLANK(" ", "&nbsp"), TAB("\t", "	"), WRAP("\n",
			"<br \\>");

	/** 转义 */
	private String escape;

	/** html */
	private String html;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午12:31:45 <br>
	 */
	ESpecialCharacters() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午12:27:37 <br>
	 * 
	 * @param escape
	 * @param html
	 */
	ESpecialCharacters(String escape, String html) {
		this.escape = escape;
		this.html = html;
	}

	/**
	 * @retrun the escape <br>
	 * 
	 *         时间: 2013-7-10 下午12:27:44 <br>
	 */

	public String getEscape() {
		return escape;
	}

	/**
	 * @param escape
	 *            the escape to set <br>
	 * 
	 *            时间: 2013-7-10 下午12:27:44
	 */
	public void setEscape(String escape) {
		this.escape = escape;
	}

	/**
	 * @retrun the html <br>
	 * 
	 *         时间: 2013-7-10 下午12:27:44 <br>
	 */

	public String getHtml() {
		return html;
	}

	/**
	 * @param html
	 *            the html to set <br>
	 * 
	 *            时间: 2013-7-10 下午12:27:44
	 */
	public void setHtml(String html) {
		this.html = html;
	}

}
