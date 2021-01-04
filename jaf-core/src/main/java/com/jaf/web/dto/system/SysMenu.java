/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.dto.system <br>
 * 文件名：SysMenu.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午2:03:14<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.system;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类名称：SysMenu <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午2:03:14 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysMenu {

	/** 主键编号 */
	private int id;

	/** 父菜单 */
	private SysMenu sysMenu;

	/** 菜单名称 */
	private String name;

	/** 菜单等级 */
	private Short level;

	/** 菜单地址 */
	private String url;

	/** 菜单地址打开方式 */
	private Short iframe;

	/** 菜单排序 */
	private String order;

	/** 菜单图标 */
	private SysIcon sysIcon = new SysIcon();

	/** 子菜单 */
	private List<SysMenu> sysMenus = new ArrayList<SysMenu>();

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午4:30:28 <br>
	 */
	public SysMenu() {
		super();
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午4:30:35 <br>
	 * 
	 * @param id
	 * @param sysMenu
	 * @param name
	 * @param level
	 * @param url
	 * @param iframe
	 * @param order
	 * @param sysIcon
	 * @param sysMenus
	 */
	public SysMenu(int id, SysMenu sysMenu, String name, Short level,
			String url, Short iframe, String order, SysIcon sysIcon,
			List<SysMenu> sysMenus) {
		super();
		this.id = id;
		this.sysMenu = sysMenu;
		this.name = name;
		this.level = level;
		this.url = url;
		this.iframe = iframe;
		this.order = order;
		this.sysIcon = sysIcon;
		this.sysMenus = sysMenus;
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午4:31:42 <br>
	 * 
	 * @param id
	 */
	public SysMenu(int id) {
		super();
		this.id = id;
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午4:31:04 <br>
	 * 
	 * @param sysMenu
	 */
	public SysMenu(SysMenu sysMenu) {
		super();
		this.sysMenu = sysMenu;
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午4:31:13 <br>
	 * 
	 * @param sysMenus
	 */
	public SysMenu(List<SysMenu> sysMenus) {
		super();
		this.sysMenus = sysMenus;
	}

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-7-23 下午5:09:26 <br>
	 */

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:09:26
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @retrun the sysMenu <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	/**
	 * @param sysMenu
	 *            the sysMenu to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the level <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public Short getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setLevel(Short level) {
		this.level = level;
	}

	/**
	 * @retrun the url <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the iframe <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public Short getIframe() {
		return iframe;
	}

	/**
	 * @param iframe
	 *            the iframe to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setIframe(Short iframe) {
		this.iframe = iframe;
	}

	/**
	 * @retrun the order <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public String getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @retrun the sysIcon <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public SysIcon getSysIcon() {
		return sysIcon;
	}

	/**
	 * @param sysIcon
	 *            the sysIcon to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setSysIcon(SysIcon sysIcon) {
		this.sysIcon = sysIcon;
	}

	/**
	 * @retrun the sysMenus <br>
	 * 
	 *         时间: 2013-7-22 下午2:18:37 <br>
	 */

	public List<SysMenu> getSysMenus() {
		return sysMenus;
	}

	/**
	 * @param sysMenus
	 *            the sysMenus to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:18:37
	 */
	public void setSysMenus(List<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

}
