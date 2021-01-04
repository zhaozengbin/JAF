/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：MenuTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午12:05:59<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.easyui;

import java.util.List;
import java.util.Map;

import com.jaf.web.dto.system.SysMenu;
import com.jaf.web.tag.AbstractTag;
import com.jaf.web.tag.util.ListtoMenu;

/**
 *
 * 类名称：MenuTag<br>
 * 类描述：菜单标签 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午12:05:59 <br>
 * 修改备注：TODO <br>
 *
 */
public class MenuTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 一级菜单 */
	protected List<SysMenu> parentSysMenu;

	/** 二级菜单 */
	protected List<SysMenu> childSysMenu;

	/** 菜单MAP */
	protected Map<Integer, List<SysMenu>> menuFun;

	/**
	 * 方法: assembleStart <br>
	 * 描述: TODO
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		return null;
	}

	/**
	 * 方法: assembleEnd <br>
	 * 描述: TODO
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleEnd()
	 */
	@Override
	protected String assembleEnd() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div id=\"nav\" class=\"easyui-accordion\" fit=\"true\" border=\"false\">");
		sb.append(ListtoMenu.getEasyuiMultistageTree(parentSysMenu));
		sb.append("</div>");
		return sb.toString();
	}

	/**
	 * @retrun the parentSysMenu <br>
	 *
	 *         时间: 2013-7-22 下午2:19:26 <br>
	 */

	public List<SysMenu> getParentSysMenu() {
		return parentSysMenu;
	}

	/**
	 * @param parentSysMenu
	 *            the parentSysMenu to set <br>
	 *
	 *            时间: 2013-7-22 下午2:19:26
	 */
	public void setParentSysMenu(List<SysMenu> parentSysMenu) {
		this.parentSysMenu = parentSysMenu;
	}

	/**
	 * @retrun the childSysMenu <br>
	 *
	 *         时间: 2013-7-22 下午2:19:26 <br>
	 */

	public List<SysMenu> getChildSysMenu() {
		return childSysMenu;
	}

	/**
	 * @param childSysMenu
	 *            the childSysMenu to set <br>
	 *
	 *            时间: 2013-7-22 下午2:19:26
	 */
	public void setChildSysMenu(List<SysMenu> childSysMenu) {
		this.childSysMenu = childSysMenu;
	}

	/**
	 * 返回: the menuFun <br>
	 *
	 * 时间: 2014-4-1 下午5:06:04
	 */
	public Map<Integer, List<SysMenu>> getMenuFun() {
		return menuFun;
	}

	/**
	 * 参数: menuFun the menuFun to set <br>
	 *
	 * 时间: 2014-4-1 下午5:06:04
	 */
	public void setMenuFun(Map<Integer, List<SysMenu>> menuFun) {
		this.menuFun = menuFun;
	}

}
