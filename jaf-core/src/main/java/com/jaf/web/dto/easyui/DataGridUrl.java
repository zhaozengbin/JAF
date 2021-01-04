/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：DateGridUrl.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午5:50:53<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.easyui;

import com.jaf.web.entity.EOptType;

/**
 *
 * 类名称：DataGridUrl <br>
 * 类描述：数据表 转换对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午5:50:53 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataGridUrl {

	/** 操作链接地址 */
	private String url;

	/** 按钮名称 */
	private String title;

	/** 按钮图标 */
	private String icon;

	/** 传入参数 */
	private String value;

	/** 弹出窗宽度 */
	private String width;

	/** 弹出窗高度 */
	private String height;

	/** 按钮类型 */
	private EOptType type;

	/** 是否是操作选项以外的链接 */
	private String isbtn;

	/** 询问链接的提示语 */
	private String message;

	/** 判断链接是否显示的表达式 */
	private String exp;

	/** 自定义函数名称 */
	private String funname;

	/** 是否是单选框 */
	private boolean isRadio;

	/** 选项单击事件 */
	private String onclick;

	/**
	 * @retrun the url <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the title <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @retrun the icon <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @retrun the value <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @retrun the width <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @retrun the height <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @retrun the type <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public EOptType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setType(EOptType type) {
		this.type = type;
	}

	/**
	 * @retrun the isbtn <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getIsbtn() {
		return isbtn;
	}

	/**
	 * @param isbtn
	 *            the isbtn to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setIsbtn(String isbtn) {
		this.isbtn = isbtn;
	}

	/**
	 * @retrun the message <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @retrun the exp <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getExp() {
		return exp;
	}

	/**
	 * @param exp
	 *            the exp to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * @retrun the funname <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getFunname() {
		return funname;
	}

	/**
	 * @param funname
	 *            the funname to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

	/**
	 * @retrun the isRadio <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public boolean isRadio() {
		return isRadio;
	}

	/**
	 * @param isRadio
	 *            the isRadio to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setRadio(boolean isRadio) {
		this.isRadio = isRadio;
	}

	/**
	 * @retrun the onclick <br>
	 *
	 *         时间: 2013-7-22 下午5:58:04 <br>
	 */

	public String getOnclick() {
		return onclick;
	}

	/**
	 * @param onclick
	 *            the onclick to set <br>
	 *
	 *            时间: 2013-7-22 下午5:58:04
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

}
