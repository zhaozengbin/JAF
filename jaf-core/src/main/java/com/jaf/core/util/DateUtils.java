/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：DateUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午2:07:12<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * 类名称：DateUtils <br>
 * 类描述：日期工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午2:07:12 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DateUtils {

	/** 通用时间格式 */

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String HH_MM_SS = "HH:mm:ss";

	public static final String HH_MM_SS_SSS = "HH:mm:ss.SSS";

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String yyyyMMddHHMMSSSSS = "yyyyMMddHHmmssSSS";

	/** 时间样式 中式 美式 */

	public static final String STYLE_ZH = "zh";

	public static final String STYLE_EN = "en";

	/**
	 * 方法：formatCurrentDate <br>
	 * 描述：格式化当前时间 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:13:35 <br>
	 * 
	 * @param pattern
	 *            格式化规则
	 * @return
	 * @throws Exception
	 */
	public static String formatCurrentDate(String pattern) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 方法：formatDate <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:17:03 <br>
	 * 
	 * @param pattern
	 *            格式化规则
	 * @param date
	 *            时间
	 * @return
	 * @throws Exception
	 */
	public static String formatDate(String pattern, Date date) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 方法：parse <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:15:24 <br>
	 * 
	 * @param pattern
	 *            格式化规则
	 * @param source
	 *            时间字符串
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String pattern, String source) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(source);
	}

	/**
	 * 方法：currentDateFor12Hour <br>
	 * 描述：当前时间十二小时制 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:22:12 <br>
	 * 
	 * @param pattern1
	 *            日期格式化规则
	 * @param pattern2
	 *            时间格式化规则
	 * @return yyyy-MM-dd AM(上午)HH:mm:ss
	 */
	public static String currentDateFor12Hour(String pattern1, String pattern2) {
		GregorianCalendar ca = new GregorianCalendar();
		String time = "";
		time = new SimpleDateFormat(pattern1).format(new Date()) + " ";
		if (STYLE_ZH.equals(SystemUtils.getOSLanguage())) {
			time = time + (ca.get(GregorianCalendar.AM_PM) == 0 ? "上午" : "下午");
		} else {
			time = time + (ca.get(GregorianCalendar.AM_PM) == 0 ? "AM" : "PM");
		}
		time = time + new SimpleDateFormat(pattern2).format(new Date());
		return time;
	}

	/**
	 * 方法：dateFor12Hour <br>
	 * 描述：时间十二小时制 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:22:12 <br>
	 * 
	 * @param pattern1
	 *            日期格式化规则
	 * @param pattern2
	 *            时间格式化规则
	 * @return yyyy-MM-dd AM(上午)HH:mm:ss
	 */
	public static String dateFor12Hour(String pattern1, String pattern2,
			Date date) {
		GregorianCalendar ca = new GregorianCalendar();
		String time = "";
		time = new SimpleDateFormat(pattern1).format(date) + " ";
		if (STYLE_ZH.equals(SystemUtils.getOSLanguage())) {
			time = time + (ca.get(GregorianCalendar.AM_PM) == 0 ? "上午" : "下午");
		} else {
			time = time + (ca.get(GregorianCalendar.AM_PM) == 0 ? "AM" : "PM");
		}
		time = time + new SimpleDateFormat(pattern2).format(date);
		return time;
	}

}
