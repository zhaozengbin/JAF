/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.vo <br>
 * 文件名：AjaxJsonVo.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-18-下午1:51:44<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.vo;

import java.util.Map;

/**
 *
 * 类名称：AjaxJsonVo <br>
 * 类描述：$.ajax后需要接受的JSON <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-18 下午1:51:44 <br>
 * 修改备注：TODO <br>
 *
 */
public class AjaxJsonVo {

	/** 返回页面信息 */
	public static final String MSG_NULL = "无记录";

	public static final String MSG_FAIL = "操作失败";

	public static final String MSG_EXCEPTION = "操作异常";

	/** 属性名 */
	public static final String ATTRIBUTE_NAME_VO = "vo";

	/** 是否成功 */
	private Boolean isSuccess;

	/** 提示信息 */
	private String msg = "操作成功";

	/** 其他参数 */
	private Map<String, Object> attributes;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-23 下午5:43:59 <br>
	 */
	public AjaxJsonVo() {
		super();
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-23 下午5:44:06 <br>
	 *
	 * @param isSuccess
	 * @param voList
	 * @param msg
	 * @param volist
	 * @param vo
	 */
	public AjaxJsonVo(Boolean isSuccess, String msg,
			Map<String, Object> attributes) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
		this.attributes = attributes;
	}

	/**
	 * @retrun the isSuccess <br>
	 *
	 *         时间: 2013-10-23 下午5:45:52 <br>
	 */

	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess
	 *            the isSuccess to set <br>
	 *
	 *            时间: 2013-10-23 下午5:45:52
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @retrun the msg <br>
	 *
	 *         时间: 2013-10-23 下午5:43:46 <br>
	 */

	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set <br>
	 *
	 *            时间: 2013-10-23 下午5:43:46
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @retrun the attributes <br>
	 *
	 *         时间: 2013-10-24 上午11:42:59 <br>
	 */

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set <br>
	 *
	 *            时间: 2013-10-24 上午11:42:59
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
