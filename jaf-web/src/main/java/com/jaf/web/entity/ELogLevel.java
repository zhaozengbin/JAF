/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.entity <br>
 * 文件名：ELogLevel.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午10:47:39<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.entity;

/**
 *
 * 类名称：ELogLevel <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午10:47:39 <br>
 * 修改备注：TODO <br>
 *
 */
public enum ELogLevel {
	EDITOR(1, "增删改"), QUERY(2, "查"),OTHER(3,"其它");

	/** 级别 */
	private Integer level;

	/** 内容 */
	private String content;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午10:53:23 <br>
	 *
	 * @param level
	 * @param content
	 */
	private ELogLevel(Integer level, String content) {
		this.level = level;
		this.content = content;
	}

	/**
	 * @retrun the level <br>
	 *
	 *         时间: 2014-4-14 上午10:52:51 <br>
	 */

	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set <br>
	 *
	 *            时间: 2014-4-14 上午10:52:51
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @retrun the content <br>
	 *
	 *         时间: 2014-4-14 上午10:52:51 <br>
	 */

	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set <br>
	 *
	 *            时间: 2014-4-14 上午10:52:51
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
