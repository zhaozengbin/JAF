/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.init <br>
 * 文件名：Initialization.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-19-上午10:00:28<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.init;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.jaf.core.cache.AbstractCache;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：Initialization <br>
 * 类描述：初始化 初始化信息加载到缓存 抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-19 上午10:00:28 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Initialization {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils
			.getLogger(Initialization.class);

	/** 缓存类 */
	private static AbstractCache cache = null;

	/**
	 * 方法：init <br>
	 * 描述：初始化信息主类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:50:39 <br>
	 */
	public static void init() {
	}

	/**
	 * 方法：init <br>
	 * 描述：初始化信息主类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:50:39 <br>
	 * 
	 * @param resourceBundle
	 *            需要初始化的resourceBundle
	 */
	public static void init(ResourceBundle resourceBundle) {
		init();
		initCache(new ResourceBundle[] { resourceBundle });
	}

	/**
	 * 方法：init <br>
	 * 描述：初始化信息主类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:50:39 <br>
	 * 
	 * @param resourceBundles
	 *            需要初始化的resourceBundles 集合
	 */
	public static void init(ResourceBundle[] resourceBundles) {
		init();
		initCache(resourceBundles);
	}

	/**
	 * 方法：init <br>
	 * 描述：初始化信息主类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:50:39 <br>
	 * 
	 * @param key
	 *            缓存 键
	 * @param value
	 *            缓存 值
	 */
	public static void init(String key, Object value) {
		init();
		initCache(key, value);
	}

	/**
	 * 方法：initCache <br>
	 * 描述：将配置文件的信息初始化至缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:34:02 <br>
	 * 
	 * @param resourceBundles
	 */
	private static void initCache(ResourceBundle[] resourceBundles) {
		if (ObjectUtils.isNotEmpty(resourceBundles)) {
			for (ResourceBundle resourceBundle : resourceBundles) {
				Enumeration<String> keys = resourceBundle.getKeys();
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					String value = resourceBundle.getString(key);
					LoggerUtils.debug(LOGGER, "将key:[" + key + "],value:["
							+ value + "]存入缓存");
					cache.put(key, value);
				}
			}
		}
	}

	/**
	 * 方法：initCache <br>
	 * 描述：将配置文件的信息初始化至缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午10:34:02 <br>
	 * 
	 * @param key
	 * @param value
	 */
	private static void initCache(String key, Object value) {
		LoggerUtils.debug(LOGGER, "将key:[" + key + "],value:[" + value
				+ "]存入缓存");
		cache.put(key, value);
	}

}
