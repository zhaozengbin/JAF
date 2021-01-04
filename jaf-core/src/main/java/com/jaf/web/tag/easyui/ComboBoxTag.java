/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：ComboBoxTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import com.jaf.web.dto.easyui.ComboBox;
import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：ComboBoxTag <br>
 * 类描述： 下拉选择框标签 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:28:33 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ComboBoxTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** ID */
	protected String id;

	/** 显示文本 */
	protected String text;

	/** 远程数据 */
	protected String url;

	/** 控件名称 */
	protected String name;

	/** 宽度 */
	protected Integer width;

	/** 下拉框宽度 */
	protected Integer listWidth;

	/** 下拉框高度 */
	protected Integer listHeight;

	/** 定义是否可以直接到文本域中键入文本 */
	protected boolean editable;

	/**
	 * 方法: assembleStart <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		return null;
	}

	/**
	 * 方法: assembleEnd <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleEnd()
	 */
	@Override
	protected String assembleEnd() {
		StringBuffer sb = new StringBuffer();
		ComboBox comboBox = new ComboBox();
		comboBox.setText(text);
		comboBox.setId(id);
		sb.append("<script type=\"text/javascript\">" + "$(function() {"
				+ "$(\'#"
				+ name
				+ "\').combobox({"
				+ "url:\'"
				+ url
				+ "&id="
				+ id
				+ "&text="
				+ text
				+ "\',"
				+ "editable:\'false\',"
				+ "valueField:\'id\',"
				+ "textField:\'text\',"
				+ "width:\'"
				+ width
				+ "\',"
				+ "listWidth:\'"
				+ listWidth
				+ "\',"
				+ "listHeight:\'"
				+ listWidth
				+ "\',"
				+ "onChange:function(){"
				+ "var val = $(\'#"
				+ name
				+ "\').combobox(\'getValues\');"
				+ "$(\'#"
				+ name
				+ "hidden\').val(val);"
				+ "}"
				+ "});"
				+ "});"
				+ "</script>");
		sb.append("<input type=\"hidden\" name=\"" + name + "\" id=\"" + name
				+ "hidden\" > " + "<input class=\"easyui-combobox\" "
				+ "multiple=\"true\" panelHeight=\"auto\" name=\"" + name
				+ "name\" id=\"" + name + "\" >");
		return sb.toString();
	}

	/**
	 * 返回: the id <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public String getId() {
		return id;
	}

	/**
	 * 参数: id the id to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回: the text <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public String getText() {
		return text;
	}

	/**
	 * 参数: text the text to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 返回: the url <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 参数: url the url to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回: the name <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public String getName() {
		return name;
	}

	/**
	 * 参数: name the name to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 返回: the width <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 参数: width the width to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 返回: the listWidth <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public Integer getListWidth() {
		return listWidth;
	}

	/**
	 * 参数: listWidth the listWidth to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setListWidth(Integer listWidth) {
		this.listWidth = listWidth;
	}

	/**
	 * 返回: the listHeight <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public Integer getListHeight() {
		return listHeight;
	}

	/**
	 * 参数: listHeight the listHeight to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setListHeight(Integer listHeight) {
		this.listHeight = listHeight;
	}

	/**
	 * 返回: the editable <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * 参数: editable the editable to set <br>
	 * 
	 * 时间: 2013-7-25 下午1:58:04
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
