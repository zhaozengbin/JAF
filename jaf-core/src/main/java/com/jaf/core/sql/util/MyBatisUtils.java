/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.util <br>
 * 文件名：MyBatisUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-30-下午5:11:08<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jaf.core.util.LoggerUtils;

/**
 * 
 * 类名称：MyBatisUtils <br>
 * 类描述：MyBatis 工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-30 下午5:11:08 <br>
 * 修改备注：TODO <br>
 * 
 */
public class MyBatisUtils {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils
			.getLogger(MyBatisUtils.class);

	public static Map<String, Object> ClassToMap(Object obj) {
		Class<?> objClass = obj.getClass();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : objClass.getFields()) {
			try {
				String getMethodName = "get"
						+ toFirstLetterUpperCase(field.getName());
				Object value = objClass.getMethod(getMethodName).invoke(obj);
				map.put(field.getName(), value);
				LOGGER.debug("Object开始转化为MAP,key:[" + field.getName()
						+ "],value:[" + value + "]");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static String toFirstLetterUpperCase(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String firstLetter = str.substring(0, 1).toUpperCase();
		return firstLetter + str.substring(1, str.length());
	}
}
