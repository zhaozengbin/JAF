/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：ObjectUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午5:45:23<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * 类名称：ObjectUtils <br>
 * 类描述：对象工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午5:45:23 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ObjectUtils {

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断集合是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:00 <br>
	 * 
	 * @param collection
	 *            集合
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断集合是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:15 <br>
	 * 
	 * @param collection
	 *            集合
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断数组是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:01 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isNotEmpty(Object[] objectArrays) {
		if (objectArrays != null && objectArrays.length > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断数组是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:09 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Object[] objectArrays) {
		if (objectArrays == null || objectArrays.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断对象是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:01 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isNotEmpty(Object object) {
		if (object instanceof String) {
			String string = (String) object;
			if (string != null && !"".equals(string) && !"null".equals(string)
					&& string.trim().length() != 0) {
				return true;
			}
		} else if (object instanceof Integer) {
			Integer integer = (Integer) object;
			if (integer != null) {
				return true;
			}
		} else if (object instanceof Double) {
			Double doubles = (Double) object;
			if (doubles != null) {
				return true;
			}
		} else if (object instanceof Float) {
			Float floats = (Float) object;
			if (floats != null) {
				return true;
			}
		} else if (object != null) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断对象是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:09 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			String string = (String) object;
			if ("".equals(string) || "null".equals(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断字符串是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:51 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isEmpty(StringBuffer stringBuffer) {
		if (stringBuffer == null || "".equals(stringBuffer)) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断字符串是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:01 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isNotEmpty(StringBuffer stringBuffer) {
		if (stringBuffer != null && !"".equals(stringBuffer)
				&& stringBuffer.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断MAP是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:09 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断MAP是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:19 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		if (map != null && !map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isIn <br>
	 * 描述：判断字符串是否在数组中包含 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:29:30 <br>
	 * 
	 * @param substring
	 * @param source
	 * @return
	 */
	public static boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法：isIn <br>
	 * 描述：判断字符串是否在数组中包含 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:29:30 <br>
	 * 
	 * @param substring
	 * @param collection
	 * @return
	 */
	public static boolean isIn(String substring, Collection<String> collection) {
		if (collection == null || collection.size() == 0) {
			return false;
		}
		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			String aSource = iterator.next();
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法：decode <br>
	 * 描述：解码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:44:08 <br>
	 * 
	 * @param strIn
	 * @param sourceCode
	 * @param targetCode
	 * @return
	 */
	public static String decode(String strIn, String sourceCode,
			String targetCode) {
		String temp = code2code(strIn, sourceCode, targetCode);
		return temp;
	}

	/**
	 * 方法：StrToUTF <br>
	 * 描述： 字符串转编码转换 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:44:20 <br>
	 * 
	 * @param strIn
	 * @param sourceCode
	 * @param targetCode
	 * @return
	 */
	public static String StrToUTF(String strIn, String sourceCode,
			String targetCode) {
		strIn = "";
		try {
			strIn = new String(strIn.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return strIn;

	}

	/**
	 * 方法：code2code <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:44:29 <br>
	 * 
	 * @param strIn
	 * @param sourceCode
	 * @param targetCode
	 * @return
	 */
	private static String code2code(String strIn, String sourceCode,
			String targetCode) {
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals(""))
			return strIn;
		try {
			byte[] b = strIn.getBytes(sourceCode);
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i] + "  ");
			}
			strOut = new String(b, targetCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strOut;
	}

	/**
	 * 方法：getIntegerArry <br>
	 * 描述：获取整型数组 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:44:37 <br>
	 * 
	 * @param object
	 * @return
	 */
	public static Integer[] getIntegerArry(String[] object) {
		int len = object.length;
		Integer[] result = new Integer[len];
		try {
			for (int i = 0; i < len; i++) {
				result[i] = new Integer(object[i].trim());
			}
			return result;
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
