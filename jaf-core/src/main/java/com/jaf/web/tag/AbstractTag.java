/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag <br>
 * 文件名：AbstractTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：AbstractTag <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:41:10 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractTag extends TagSupport {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/**
	 * 方法: doStartTag <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			String info = assembleStart();
			if (ObjectUtils.isNotEmpty(info)) {
				out.print(info);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 方法: doEndTag <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			String info = assembleEnd();
			if (ObjectUtils.isNotEmpty(info)) {
				out.print(info);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 方法：assembleStart <br>
	 * 描述：组装打印信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:41:30 <br>
	 * 
	 * @return
	 */
	protected abstract String assembleStart();

	/**
	 * 方法：assembleEnd <br>
	 * 描述：组装打印信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:41:38 <br>
	 * 
	 * @return
	 */
	protected abstract String assembleEnd();

}
