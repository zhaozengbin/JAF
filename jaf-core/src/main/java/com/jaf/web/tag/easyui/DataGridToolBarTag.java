/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DataGridToolBarTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：DataGridToolBarTag <br>
 * 类描述：列表工具条标签 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:30:57 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DataGridToolBarTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 请求地址 */
	protected String url;

	/** 标签上的标题文字 */
	protected String title;

	/** 判断链接是否显示的表达式 */
	private String exp;

	/** 自定义函数名称 */
	private String funname;

	/** 图标 */
	private String icon;

	/**  */
	private String onclick;

	/**
	 * 方法: doEndTag <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @throws JspException
	 * @see com.jaf.web.tag.AbstractTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		DataGridTag parent = (DataGridTag) t;
		parent.setToolbar(url, title, icon, exp, onclick, funname);
		return EVAL_PAGE;
	}

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
		return null;
	}

	/**
	 * 返回: the url <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 参数: url the url to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回: the title <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the exp <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * 参数: exp the exp to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * 返回: the funname <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getFunname() {
		return funname;
	}

	/**
	 * 参数: funname the funname to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

	/**
	 * 返回: the icon <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 参数: icon the icon to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 返回: the onclick <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * 参数: onclick the onclick to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:16:49
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

}
