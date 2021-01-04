/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：ComboBox.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.dto.easyui;

/**
 * 
 * 类名称：ComboBox <br>
 * 类描述：后台向前台返回JSON，用于easyui的datagrid <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:20:24 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ComboBox {

	/** id */
	private String id;

	/** 文本 */
	private String text;

	/** 选中 */
	private boolean selected;

	/**
	 * 返回: the id <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public String getId() {
		return id;
	}

	/**
	 * 参数: id the id to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回: the text <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public String getText() {
		return text;
	}

	/**
	 * 参数: text the text to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 返回: the selected <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * 参数: selected the selected to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:59:34
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
