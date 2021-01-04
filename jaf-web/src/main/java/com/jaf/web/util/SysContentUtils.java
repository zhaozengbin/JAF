/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.util <br>
 * 文件名：SysContentUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午11:40:22<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 类名称：SysContentUtils <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午11:40:22 <br>
 * 修改备注：TODO <br>
 *
 */
public class SysContentUtils {
	/** 当前request */
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

	/** 当前response */
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	/**
	 * 方法：getRequest <br>
	 * 描述：获取request <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午11:41:05 <br>
	 *
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requestLocal.get();
	}

	/**
	 * 方法：setRequest <br>
	 * 描述：设置request <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午11:41:17 <br>
	 *
	 * @param request
	 */
	public static void setRequest(HttpServletRequest request) {
		requestLocal.set(request);
	}

	/**
	 * 方法：getResponse <br>
	 * 描述：获取response <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午11:41:26 <br>
	 *
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) responseLocal.get();
	}

	/**
	 * 方法：setResponse <br>
	 * 描述：设置response <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午11:41:36 <br>
	 *
	 * @param response
	 */
	public static void setResponse(HttpServletResponse response) {
		responseLocal.set(response);
	}

	/**
	 * 方法：getSession <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午11:41:45 <br>
	 *
	 * @return
	 */
	public static HttpSession getSession() {
		return (HttpSession) ((HttpServletRequest) requestLocal.get())
				.getSession();
	}
}
