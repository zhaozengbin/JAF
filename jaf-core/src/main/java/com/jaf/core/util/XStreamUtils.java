/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：XStreamUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-下午7:42:11<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

/**
 * 
 * 类名称：XStreamUtils <br>
 * 类描述：XStream工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 下午7:42:11 <br>
 * 修改备注：TODO <br>
 * 
 */
public class XStreamUtils {

	/** uixml文件地址 */
	public static final String PATH_UI_XML = "ui.xml";

	/**
	 * 方法：fromXML <br>
	 * 描述：xml转换为对象 对象需用Annotation进行注解 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 下午7:48:48 <br>
	 * 
	 * @param classes
	 * @param path
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object fromXML(Class[] classes, String path) {
		XStream xStream = new XStream(new Dom4JDriver());
		xStream.processAnnotations(classes);
		return xStream.fromXML(new File(path));
	}
}