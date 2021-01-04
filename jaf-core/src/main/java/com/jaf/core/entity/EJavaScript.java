/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：EJavaScript.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午5:50:46<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 * 
 * 类名称：EJavaScript <br>
 * 类描述：JavaScript文件枚举 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午5:50:46 <br>
 * 修改备注：TODO <br>
 * 
 */
public enum EJavaScript {

	JQUERY("jquery", "jquery", "1.8.3", "js/jquery/jquery-1.8.3.js"), JQUERY_EASYUI_MIN(
			"easyui", "jquery.easyui.min", "1.3.2",
			"js/easyui/jquery.easyui.min.1.3.2.js"), JQUERY_EASYUI_LANG_ZH_CN(
			"easyui", "easyui-lang-zh_CN", "",
			"js/easyui/locale/easyui-lang-zh_CN.js"), TOOL_DATAFORMAT("tool",
			"dataformat", "", "js/tools/dataformat.js"), ;

	/** 类型 */
	private String type;

	/** 名称 */
	private String name;

	/** 版本 */
	private String version;

	/** 路径 */
	private String path;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:52:50 <br>
	 */
	EJavaScript() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午5:53:02 <br>
	 * 
	 * @param type
	 * @param name
	 * @param version
	 * @param path
	 */
	EJavaScript(String type, String name, String version, String path) {
		this.type = type;
		this.name = name;
		this.version = version;
		this.path = path;
	}

	/**
	 * @retrun the type <br>
	 * 
	 *         时间: 2013-7-16 下午6:47:06 <br>
	 */

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set <br>
	 * 
	 *            时间: 2013-7-16 下午6:47:06
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-16 下午5:53:18 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-16 下午5:53:18
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the version <br>
	 * 
	 *         时间: 2013-7-16 下午5:53:18 <br>
	 */

	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set <br>
	 * 
	 *            时间: 2013-7-16 下午5:53:18
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @retrun the path <br>
	 * 
	 *         时间: 2013-7-16 下午5:53:18 <br>
	 */

	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set <br>
	 * 
	 *            时间: 2013-7-16 下午5:53:18
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
