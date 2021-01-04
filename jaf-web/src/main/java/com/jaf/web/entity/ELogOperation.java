/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.entity <br>
 * 文件名：ELogOperation.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午10:47:39<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.entity;

/**
 *
 * 类名称：ELogOperation <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午10:47:39 <br>
 * 修改备注：TODO <br>
 *
 */
public enum ELogOperation {
	EDITOR(1, "添加/更改 "), DELETE(2, "删除"), QUERY(3, "查询"), OTHER(4, "其它");

	/** 级别 */
	private Integer operation;

	/** 内容 */
	private String content;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午10:53:23 <br>
	 *
	 * @param operation
	 * @param content
	 */
	private ELogOperation(Integer operation, String content) {
		this.operation = operation;
		this.content = content;
	}

	/**
	 * @retrun the operation <br>
	 *
	 *         时间: 2014-4-14 上午10:56:57 <br>
	 */

	public Integer getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set <br>
	 *
	 *            时间: 2014-4-14 上午10:56:57
	 */
	public void setOperation(Integer operation) {
		this.operation = operation;
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
