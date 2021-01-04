/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：Tab.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.dto.easyui;

/**
 * 
 * 类名称：Tab <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:22:09 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Tab {

	/** 地址 */
	private String href;

	/** iframe */
	private String iframe;

	/** id */
	private String id;

	/** 文本 */
	private String title;

	/** icon */
	private String icon = "'icon-default'";

	/** 宽度 */
	private String width;

	/** 高度 */
	private String heigth;

	/**  */
	private boolean cache;

	/**  */
	private String content;

	/**  */
	private boolean closable = true;

	/**
	 * 返回: the href <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getHref() {
		return href;
	}

	/**
	 * 参数: href the href to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * 返回: the iframe <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getIframe() {
		return iframe;
	}

	/**
	 * 参数: iframe the iframe to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}

	/**
	 * 返回: the id <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getId() {
		return id;
	}

	/**
	 * 参数: id the id to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回: the title <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the icon <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 参数: icon the icon to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 返回: the width <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 参数: width the width to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 返回: the heigth <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getHeigth() {
		return heigth;
	}

	/**
	 * 参数: heigth the heigth to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}

	/**
	 * 返回: the cache <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public boolean isCache() {
		return cache;
	}

	/**
	 * 参数: cache the cache to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setCache(boolean cache) {
		this.cache = cache;
	}

	/**
	 * 返回: the content <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 参数: content the content to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 返回: the closable <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public boolean isClosable() {
		return closable;
	}

	/**
	 * 参数: closable the closable to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:03:28
	 */
	public void setClosable(boolean closable) {
		this.closable = closable;
	}

}
