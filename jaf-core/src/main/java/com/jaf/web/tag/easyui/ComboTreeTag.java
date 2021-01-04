/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：ComboTreeTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：ComboTreeTag <br>
 * 类描述：下拉树形菜单 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:29:01 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ComboTreeTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** ID */
	protected String id;

	/** 远程数据 */
	protected String url;

	/** 控件名称 */
	protected String name;

	/** 宽度 */
	protected String width;

	/** 控件值 */
	protected String value;

	/** 是否多选 */
	private boolean multiple = false;

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
		width = (width == null) ? "140" : width;
		sb.append("<script type=\"text/javascript\">" + "$(function() { "
				+ "$(\'#" + id + "\').combotree({		 " + "url :\'" + url + "\',"
				+ "width :\'" + width + "\'," + "multiple:" + multiple + ""
				+ "});		" + "});	" + "</script>");
		sb.append("<input  name=\"" + name + "\" id=\"" + id + "\" ");
		if (value != null) {
			sb.append("value=" + value + "");
		}
		sb.append(">");
		return sb.toString();
	}

}
