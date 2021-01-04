/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：LoggerUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-上午11:44:43<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * 
 * 类名称：LoggerUtils <br>
 * 类描述：日志工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 上午11:44:43 <br>
 * 修改备注：TODO <br>
 * 
 */
public class LoggerUtils {

	/**
	 * 方法：getLogger <br>
	 * 描述：获取日志输出类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:55:09 <br>
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clazz) {
		return LogManager.getLogger(clazz);
	}

	/**
	 * 方法：info <br>
	 * 描述：输出INFO级别日志 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:57:06 <br>
	 * 
	 * @param logger
	 * @param content
	 */
	@SuppressWarnings("deprecation")
	public static void info(Logger logger, String content) {
		if (logger.isEnabledFor(Priority.INFO)) {
			logger.info("----------" + content + "----------");
		}
	}

	/**
	 * 方法：debug <br>
	 * 描述：输出DEBUG级别日志 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:57:06 <br>
	 * 
	 * @param logger
	 * @param content
	 */
	@SuppressWarnings("deprecation")
	public static void debug(Logger logger, String content) {
		if (logger.isEnabledFor(Priority.DEBUG)) {
			logger.debug("----------" + content + "----------");
		}
	}

	/**
	 * 方法：error <br>
	 * 描述：输出ERROR级别日志 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:57:06 <br>
	 * 
	 * @param logger
	 * @param content
	 */
	@SuppressWarnings("deprecation")
	public static void error(Logger logger, String content) {
		if (logger.isEnabledFor(Priority.ERROR)) {
			logger.error("----------" + content + "----------");
		}
	}

	/**
	 * 方法：warn <br>
	 * 描述：输出WARN级别日志 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:57:06 <br>
	 * 
	 * @param logger
	 * @param content
	 */
	@SuppressWarnings("deprecation")
	public static void war(Logger logger, String content) {
		if (logger.isEnabledFor(Priority.WARN)) {
			logger.warn("----------" + content + "----------");
		}
	}
}
