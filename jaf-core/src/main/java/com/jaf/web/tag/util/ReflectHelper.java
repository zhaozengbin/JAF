/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.util <br>
 * 文件名：ReflectHelper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.util;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.regex.Pattern;

/**
 * 
 * 类名称：ReflectHelper <br>
 * 类描述：通过反射来动态调用get 和 set 方法 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:36:11 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ReflectHelper {

	/** 传过来的类 */
	private Class<? extends Object> cls;

	/** 传过来的对象 */
	private Object obj;

	/** 存放get方法 */
	private Hashtable<String, Method> getMethods = null;

	/** 存放set方法 */
	private Hashtable<String, Method> setMethods = null;

	/**
	 * 标题：构造器 <br>
	 * 描述：一般来说是个pojo <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:36:21 <br>
	 * 
	 * @param o
	 */
	public ReflectHelper(Object o) {
		obj = o;
		initMethods();
	}

	/**
	 * 方法：initMethods <br>
	 * 描述：初始化 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:36:31 <br>
	 */
	public void initMethods() {
		getMethods = new Hashtable<String, Method>();
		setMethods = new Hashtable<String, Method>();
		cls = obj.getClass();
		Method[] methods = cls.getMethods();
		// 定义正则表达式，从方法中过滤出getter / setter 函数.
		String gs = "get(\\w+)";
		Pattern getM = Pattern.compile(gs);
		String ss = "set(\\w+)";
		Pattern setM = Pattern.compile(ss);
		// 把方法中的"set" 或者 "get" 去掉
		String rapl = "$1";
		String param;
		for (int i = 0; i < methods.length; ++i) {
			Method m = methods[i];
			String methodName = m.getName();
			if (Pattern.matches(gs, methodName)) {
				param = getM.matcher(methodName).replaceAll(rapl).toLowerCase();
				getMethods.put(param, m);
			} else if (Pattern.matches(ss, methodName)) {
				param = setM.matcher(methodName).replaceAll(rapl).toLowerCase();
				setMethods.put(param, m);
			} else {
				// System.out.println(methodName + " 不是getter,setter方法！");
			}
		}
	}

	/**
	 * 方法：setMethodValue <br>
	 * 描述：调用set方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:36:40 <br>
	 * 
	 * @param property
	 * @param object
	 * @return
	 */
	public boolean setMethodValue(String property, Object object) {
		Method m = setMethods.get(property.toLowerCase());
		if (m != null) {
			try {
				// 调用目标类的setter函数
				m.invoke(obj, object);
				return true;
			} catch (Exception ex) {
				System.out.println("invoke getter on " + property + " error: "
						+ ex.toString());
				return false;
			}
		}
		return false;
	}

	/**
	 * 方法：getMethodValue <br>
	 * 描述：调用get方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:36:47 <br>
	 * 
	 * @param property
	 * @return
	 */
	public Object getMethodValue(String property) {
		Object value = null;
		Method m = getMethods.get(property.toLowerCase());
		if (m != null) {
			try {
				// 调用obj类的setter函数
				value = m.invoke(obj, new Object[] {});

			} catch (Exception ex) {
				System.out.println("invoke getter on " + property + " error: "
						+ ex.toString());
			}
		}
		return value;
	}

}
