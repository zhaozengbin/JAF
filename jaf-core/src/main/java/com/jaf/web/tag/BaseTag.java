/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag <br>
 * 文件名：BaseTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午5:20:58<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.jaf.common.Globals;
import com.jaf.core.dto.UIxml.UIxmlCss;
import com.jaf.core.dto.UIxml.UIxmlJs;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：BaseTag <br>
 * 类描述：标签基础类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午5:20:58 <br>
 * 修改备注：TODO <br>
 * 
 */
public class BaseTag extends TagSupport {

	/** 序列号 */
	private static final long serialVersionUID = 1L;

	/** 加载类型 */
	protected String type = "default";

	/**
	 * 方法：doStartTag <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * 方法：doEndTag <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			StringBuffer sb = new StringBuffer();

			String types[] = type.split(",");
			// 从缓存里面获取UI 相关依赖
			Map<String, List<Object>> uiXmlMap = Globals.UI_XML;
			// 循环匹配 找到页面需要依赖的ui
			for (String key : types) {
				if (ObjectUtils.isIn(key, uiXmlMap.keySet())) {
					for (Object object : uiXmlMap.get(key)) {
						// 判断是否为JS依赖库
						if (object instanceof UIxmlCss) {
							// 判断是否为CSS依赖库
							UIxmlCss css = (UIxmlCss) object;
							sb.append(HtmlUtils.getCSSLink(
									css.getId(),
									css.getType(),
									css.getRel(),
									((HttpServletRequest) pageContext
											.getRequest()).getContextPath()
											+ "/" + css.getHref()));
						} else if (object instanceof UIxmlJs) {
							UIxmlJs js = (UIxmlJs) object;
							sb.append(HtmlUtils.getJSLink(
									js.getType(),
									((HttpServletRequest) pageContext
											.getRequest()).getContextPath()
											+ "/" + js.getSrc()));
						}
					}
				}
			}
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * @retrun the type <br>
	 * 
	 *         时间: 2013-7-19 下午2:54:34 <br>
	 */

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set <br>
	 * 
	 *            时间: 2013-7-19 下午2:54:34
	 */
	public void setType(String type) {
		this.type = type;
	}

}
