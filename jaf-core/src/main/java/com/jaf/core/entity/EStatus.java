/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：EStatus.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-上午11:43:46<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 *
 * 类名称：EStatus <br>
 * 类描述：缓存枚举 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 上午11:43:46 <br>
 * 修改备注：TODO <br>
 *
 */
public enum EStatus {
	AVAILABLE(1, "可用"), UN_AVAILABLE(-1, "不可用");
	/** status */
	private Integer status;

	/** 内容 */
	private String content;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午11:45:34 <br>
	 */
	EStatus() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午11:45:46 <br>
	 *
	 * @param name
	 */
	private EStatus(Integer status, String content) {
		this.status = status;
		this.content = content;
	}

	/**
	 * @retrun the status <br>
	 *
	 *         时间: 2014-4-8 下午3:19:35 <br>
	 */

	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set <br>
	 *
	 *            时间: 2014-4-8 下午3:19:35
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @retrun the content <br>
	 *
	 *         时间: 2014-4-8 下午3:19:35 <br>
	 */

	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set <br>
	 *
	 *            时间: 2014-4-8 下午3:19:35
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
