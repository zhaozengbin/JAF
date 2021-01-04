/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DataGridDelOptTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午6:06:18<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.easyui;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * 类名称：DataGridTag <br>
 * 类描述：DATAGRID标签处理类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午6:06:18 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataGridDelOptTag extends TagSupport {

	/**  */

	private static final long serialVersionUID = 1L;

	/** 链接 */
	protected String url;

	/** 标题 */
	protected String title;

	/** 询问链接的提示语 */
	private String message;

	/** 判断链接是否显示的表达式 */
	private String exp;

	/** 自定义函数名称 */
	private String funname;

	/** 按钮的操作Code */
	private String operationCode;

	/**
	 * 方法：doStartTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspTagException
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	/**
	 * 方法：doEndTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspTagException
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspTagException {
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		DataGridTag parent = (DataGridTag) t;
		parent.setDelUrl(url, title, message, exp, funname, operationCode);
		return EVAL_PAGE;
	}

	/**
	 * @retrun the url <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the title <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @retrun the message <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @retrun the exp <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * @retrun the funname <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getFunname() {
		return funname;
	}

	/**
	 * @param funname the funname to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

	/**
	 * @retrun the operationCode <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33 <br>
	 */

	public String getOperationCode() {
		return operationCode;
	}

	/**
	 * @param operationCode the operationCode to set <br>
	 *
	 * 时间: 2014-4-8 上午11:45:33
	 */
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
}
