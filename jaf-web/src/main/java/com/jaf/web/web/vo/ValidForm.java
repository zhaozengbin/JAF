/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：ValidForm.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-11-下午1:40:02<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.vo;

/**
 *
 * 类名称：ValidForm <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-11 下午1:40:02 <br>
 * 修改备注：TODO <br>
 *
 */
public class ValidForm {

	/** 是否成功 */
	private String status = "y";

	/** 提示信息 */
	private String info = "验证通过";

	/** 成功状态 */
	public static final String STATUS_SUCCESS = "y";

	/** 失败状态 */
	public static final String STATUS_FAIL = "n";

	/** 成功状态信息 */
	public static final String INFO_SUCCESS = "验证通过";

	/** 失败状态信息 */
	public static final String INFO_FAIL = "验证不通过";

	/**
	 * @retrun the status <br>
	 *
	 *         时间: 2014-4-11 下午1:41:05 <br>
	 */

	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set <br>
	 *
	 *            时间: 2014-4-11 下午1:41:05
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @retrun the info <br>
	 *
	 *         时间: 2014-4-11 下午1:41:05 <br>
	 */

	public String getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set <br>
	 *
	 *            时间: 2014-4-11 下午1:41:05
	 */
	public void setInfo(String info) {
		this.info = info;
	}

}
