/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.filter <br>
 * 文件名：SysContentFilter.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午11:43:25<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaf.web.util.SysContentUtils;

/**
 *
 * 类名称：SysContentFilter <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午11:43:25 <br>
 * 修改备注：TODO <br>
 *
 */
public class SysContentFilter implements Filter {

	/**
	 * 方法：init <br>
	 * 描述：TODO <br>
	 *
	 * @param filterConfig
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 方法：doFilter <br>
	 * 描述：TODO <br>
	 *
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		SysContentUtils.setRequest((HttpServletRequest) request);
		SysContentUtils.setResponse((HttpServletResponse) response);
		chain.doFilter(request, response);

	}

	/**
	 * 方法：destroy <br>
	 * 描述：TODO <br>
	 *
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

}
