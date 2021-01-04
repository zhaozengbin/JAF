/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DataGridButtonOptTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import com.jaf.web.entity.EOptType;
import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：DataGridButtonOptTag <br>
 * 类描述：列表操作项标签 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:30:01 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DataGridButtonOptTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 按钮累类型 */
	protected String type;

	/** 请求地址 */
	protected String url;

	/** 标签上的标题文字 */
	protected String title;

	/** 询问链接的提示语 */
	private String message;

	/** 判断链接是否显示的表达式 */

	private String exp;
	/** 自定义函数名称 */
	private String funname;

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
		parent.setButton(EOptType.valueOf(type), url, title, message, exp,
				funname);
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
	 * 返回: the type <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getType() {
		return type;
	}

	/**
	 * 参数: type the type to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 返回: the url <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 参数: url the url to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回: the title <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the message <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 参数: message the message to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 返回: the exp <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * 参数: exp the exp to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * 返回: the funname <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public String getFunname() {
		return funname;
	}

	/**
	 * 参数: funname the funname to set <br>
	 * 
	 * 时间: 2013-7-25 下午12:36:46
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

}
