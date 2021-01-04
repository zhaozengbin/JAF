/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：HtmlUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午5:34:27<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * 类名称：HtmlUtils <br>
 * 类描述：HTML工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午5:34:27 <br>
 * 修改备注：TODO <br>
 * 
 */
public class HtmlUtils {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils.getLogger(HtmlUtils.class);

	/**
	 * 方法：getJSLink <br>
	 * 描述：获取JavaScript引入代码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:43:22 <br>
	 * 
	 * @param type
	 * @param src
	 * @return
	 */
	public static String getJSLink(String type, String src) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<script ");
		if (ObjectUtils.isNotEmpty(type)) {
			stringBuffer.append("type=\"" + type + "\"");
		}
		if (ObjectUtils.isNotEmpty(src)) {
			stringBuffer.append("src=\"" + src + "\"");
		}
		stringBuffer.append(">");
		stringBuffer.append("</script>");
		LoggerUtils.debug(LOGGER, "引入Javascript路径为:[" + stringBuffer + "]");
		return stringBuffer.toString();
	}

	/**
	 * 方法：getCSSLink <br>
	 * 描述：获取CSS引入代码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:48:16 <br>
	 * 
	 * @param id
	 * @param type
	 * @param rel
	 * @param href
	 * @return
	 */
	public static String getCSSLink(String id, String type, String rel,
			String href) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<link ");
		if (ObjectUtils.isNotEmpty(id)) {
			stringBuffer.append("id=\"" + id + "\"");
		}
		if (ObjectUtils.isNotEmpty(type)) {
			stringBuffer.append("type=\"" + type + "\"");
		}
		if (ObjectUtils.isNotEmpty(rel)) {
			stringBuffer.append("rel=\"" + rel + "\"");
		}
		if (ObjectUtils.isNotEmpty(href)) {
			stringBuffer.append("href=\"" + href + "\"");
		}
		stringBuffer.append(">");
		stringBuffer.append("</link>");
		LoggerUtils.debug(LOGGER, "引入CSS路径为:[" + stringBuffer + "]");
		return stringBuffer.toString();
	}

	/**
	 * 方法：writerJson <br>
	 * 描述：输出json格式 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:40:34 <br>
	 * 
	 * @param response
	 * @param jsonStr
	 */
	public static void writerJson(HttpServletResponse response, String jsonStr) {
		writer(response, jsonStr);
	}

	/**
	 * 方法：writerJson <br>
	 * 描述：输出json格式 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:40:43 <br>
	 * 
	 * @param response
	 * @param object
	 */
	public static void writerJson(HttpServletResponse response, Object object) {
		try {
			response.setContentType("application/json");
			writer(response, JSONUtils.toJSONString(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：writerHtml <br>
	 * 描述：输出HTML代码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:40:49 <br>
	 * 
	 * @param response
	 * @param htmlStr
	 */
	public static void writerHtml(HttpServletResponse response, String htmlStr) {
		writer(response, htmlStr);
	}

	/**
	 * 方法：writer <br>
	 * 描述：写文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:41:03 <br>
	 * 
	 * @param response
	 * @param str
	 */
	private static void writer(HttpServletResponse response, String str) {
		try {
			// 设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
