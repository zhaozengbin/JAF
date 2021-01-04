/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.util <br>
 * 文件名：ListtoMenu.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午2:22:10<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.system.SysMenu;
import com.jaf.web.util.ContextHolderUtils;

/**
 *
 * 类名称：ListtoMenu <br>
 * 类描述：动态菜单栏生成 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午2:22:10 <br>
 * 修改备注：TODO <br>
 *
 */
public class ListtoMenu {

	/**
	 * 方法：getMenu <br>
	 * 描述：拼装easyui菜单JSON方式 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-22 下午2:25:09 <br>
	 *
	 * @param parent
	 *            父类菜单
	 * @param child
	 *            子类菜单
	 * @return
	 */
	public static String getMenu(List<SysMenu> parent, List<SysMenu> child) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\"menus\":[");
		for (SysMenu node : parent) {
			String iconClas = "default";// 权限图标样式
			if (node.getSysIcon() != null) {
				iconClas = node.getSysIcon().getClas();
			}
			buffer.append("{\"menuid\":\"" + node.getId() + "\",\"icon\":\""
					+ iconClas + "\"," + "\"menuname\":\"" + node.getName()
					+ "\",\"menus\":[");
			iterGet(child, node.getId(), buffer);
			buffer.append("]},");
		}
		buffer.append("]}");
		// 将,\n]替换成\n]
		String tmp = buffer.toString();
		tmp = tmp.replaceAll(",\n]", "\n]");
		tmp = tmp.replaceAll(",]}", "]}");
		return tmp;

	}

	static int count = 0;

	/**
	 * 方法：iterGet <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-22 下午2:36:38 <br>
	 *
	 * @param child
	 * @param pid
	 * @param buffer
	 */
	private static void iterGet(List<SysMenu> child, int pid,
			StringBuffer buffer) {
		for (SysMenu node : child) {
			// 查找所有父节点为pid的所有对象，然后拼接为json格式的数据
			count++;
			if (node.getSysMenu().getId() == pid) {
				buffer.append("{\"menuid\":\"" + node.getId()
						+ " \",\"icon\":\"" + node.getSysIcon().getClas()
						+ "\"," + "\"menuname\":\"" + node.getName()
						+ "\",\"url\":\""
						+ ContextHolderUtils.getRequest().getContextPath()
						+ node.getUrl() + "\"");
				if (count == child.size()) {
					buffer.append("}\n");
				}
				buffer.append("},\n");

			}
		}

	}

	/**
	 * 方法：getBootMenu <br>
	 * 描述：拼装Bootstarp菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-22 下午2:43:28 <br>
	 *
	 * @param parent
	 * @param child
	 * @return
	 */
	public static String getBootMenu(List<SysMenu> parent, List<SysMenu> child) {
		StringBuffer menuString = new StringBuffer();
		menuString.append("<ul>");
		for (SysMenu parentSysMenu : parent) {
			menuString
					.append("<li><a href=\"#\"><span class=\"icon16 icomoon-icon-stats-up\"></span><b>"
							+ parentSysMenu.getName() + "</b></a>");
			int submenusize = parentSysMenu.getSysMenus().size();
			if (submenusize == 0) {
				menuString.append("</li>");
			}
			if (submenusize > 0) {
				menuString.append("<ul class=\"sub\">");
			}
			for (SysMenu childSysMenu : child) {
				if (childSysMenu.getSysMenu().getId() == parentSysMenu.getId()) {
					menuString
							.append("<li><a href=\""
									+ childSysMenu.getUrl()
									+ "\" target=\"contentiframe\"><span class=\"icon16 icomoon-icon-file\"></span>"
									+ childSysMenu.getName() + "</a></li>");
				}
			}
			if (submenusize > 0) {
				menuString.append("</ul></li>");
			}
		}
		menuString.append("</ul>");
		return menuString.toString();

	}

	/**
	 * 方法：getEasyuiMenu <br>
	 * 描述：拼装EASYUI菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-22 下午2:43:15 <br>
	 *
	 * @param parent
	 * @param child
	 * @return
	 */
	public static String getEasyuiMenu(List<SysMenu> parent, List<SysMenu> child) {
		StringBuffer menuString = new StringBuffer();
		for (SysMenu parentSysMenu : parent) {
			menuString.append("<div  title=\"" + parentSysMenu.getName()
					+ "\" iconCls=\"" + parentSysMenu.getSysIcon().getClas()
					+ "\">");
			int submenusize = parentSysMenu.getSysMenus().size();
			if (submenusize == 0) {
				menuString.append("</div>");
			}
			if (submenusize > 0) {
				menuString.append("<ul>");
			}
			for (SysMenu childSysMenu : child) {
				if (childSysMenu.getSysMenu().getId() == parentSysMenu.getId()) {
					String icon = "folder";
					if (ObjectUtils.isNotEmpty(childSysMenu.getSysIcon())
							&& ObjectUtils.isNotEmpty(childSysMenu.getSysIcon()
									.getClas())) {
						icon = childSysMenu.getSysIcon().getClas();
					}
					// menuString.append("<li><div> <a class=\""+childSysMenu.getFunctionName()+"\" iconCls=\""+icon+"\" target=\"tabiframe\"  href=\""+childSysMenu.getFunctionUrl()+"\"> <span class=\"icon "+icon+"\" >&nbsp;</span> <span class=\"nav\">"+childSysMenu.getFunctionName()+"</span></a></div></li>");
					menuString
							.append("<li><div onclick=\"addTab(\'"
									+ childSysMenu.getName()
									+ "\',\'"
									+ ContextHolderUtils.getRequest()
											.getContextPath()
									+ childSysMenu.getUrl()
									+ "\',\'"
									+ icon
									+ "\')\"  title=\""
									+ childSysMenu.getName()
									+ "\" url=\""
									+ ContextHolderUtils.getRequest()
											.getContextPath()
									+ childSysMenu.getUrl() + "\" iconCls=\""
									+ icon + "\"> <a class=\""
									+ childSysMenu.getName()
									+ "\" href=\"#\" > <span class=\"icon "
									+ icon
									+ "\" >&nbsp;</span> <span class=\"nav\" >"
									+ childSysMenu.getName()
									+ "</span></a></div></li>");
				}
			}
			if (submenusize > 0) {
				menuString.append("</ul></div>");
			}
		}
		return menuString.toString();
	}

	/**
	 * 方法：getEasyuiMultistageMenu <br>
	 * 描述：拼装EASYUI 多级 菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:47:13 <br>
	 *
	 * @param parentList
	 * @return
	 */
	public static String getEasyuiMultistageMenu(List<SysMenu> parentList) {
		StringBuffer menuString = new StringBuffer();
		for (SysMenu function : parentList) {
			menuString
					.append("<div   title=\"" + function.getName()
							+ "\" iconCls=\"" + function.getSysIcon().getClas()
							+ "\">");
			int submenusize = function.getSysMenus().size();
			if (submenusize == 0) {
				menuString.append("</div>");
			}
			if (submenusize > 0) {
				menuString.append("<ul>");
			}
			menuString.append(getChild(function.getSysMenus()));
			if (submenusize > 0) {
				menuString.append("</ul></div>");
			}
		}
		return menuString.toString();
	}

	/**
	 * 方法：getEasyuiMultistageTree <br>
	 * 描述：拼装EASYUI 多级 菜单 下级菜单为树形 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:46:48 <br>
	 *
	 * @param parentList
	 * @return
	 */
	public static String getEasyuiMultistageTree(List<SysMenu> parentList) {
		StringBuffer menuString = new StringBuffer();
		for (SysMenu function : parentList) {
			menuString
					.append("<div title=\"" + function.getName()
							+ "\" iconCls=\"" + function.getSysIcon().getClas()
							+ "\">");
			int submenusize = function.getSysMenus().size();
			if (submenusize == 0) {
				menuString.append("</div>");
			}
			if (submenusize > 0) {
				menuString
						.append("<ul class=\"easyui-tree\"  fit=\"false\" border=\"false\">");
			}
			menuString.append(getChildOfTree(function.getSysMenus()));
			if (submenusize > 0) {
				menuString.append("</ul></div>");
			}
		}
		return menuString.toString();
	}

	/**
	 * 方法：getChild <br>
	 * 描述：获取顶级菜单的下级菜单-----面板式菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:46:39 <br>
	 *
	 * @param childList
	 * @return
	 */
	private static String getChild(List<SysMenu> childList) {
		StringBuffer menuString = new StringBuffer();
		for (SysMenu function : childList) {
			menuString.append(getLeaf(function));
		}
		return menuString.toString();
	}

	/**
	 * 方法：getChildOfTree <br>
	 * 描述： 获取树形菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:46:16 <br>
	 *
	 * @param childList
	 * @return
	 */
	private static String getChildOfTree(List<SysMenu> childList) {
		StringBuffer menuString = new StringBuffer();
		for (SysMenu function : childList) {
			menuString.append(getLeafOfTree(function));
		}
		return menuString.toString();
	}

	/**
	 * 方法：getLeaf <br>
	 * 描述：获取叶子节点 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:45:58 <br>
	 *
	 * @param function
	 * @return
	 */
	private static String getLeaf(SysMenu function) {
		StringBuffer menuString = new StringBuffer();
		String icon = "folder";
		if (function.getSysIcon().getClas() != null) {
			icon = function.getSysIcon().getClas();
		}
		menuString.append("<li><div onclick=\"addTab(\'");
		menuString.append(function.getName());
		menuString.append("\',\'");
		menuString.append(ContextHolderUtils.getRequest().getContextPath()
				+ function.getUrl());
		menuString.append("\',\'");
		menuString.append(icon);
		menuString.append("\')\"  title=\"");
		menuString.append(function.getName());
		menuString.append("\" url=\"");
		menuString.append(ContextHolderUtils.getRequest().getContextPath()
				+ function.getUrl());
		menuString.append("\" iconCls=\"");
		menuString.append(icon);
		menuString.append("\"> <a class=\"");
		menuString.append(function.getName());
		menuString.append("\" href=\"#\" > <span class=\"icon ");
		menuString.append(icon);
		menuString.append("\" >&nbsp;</span> <span class=\"nav\" >");
		menuString.append(function.getName());
		menuString.append("</span></a></div></li>");
		return menuString.toString();
	}

	/**
	 * 方法：getLeafOfTree <br>
	 * 描述：获取叶子节点 ------树形菜单的叶子节点 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-1 下午5:45:40 <br>
	 *
	 * @param function
	 * @return
	 */
	private static String getLeafOfTree(SysMenu function) {
		StringBuffer menuString = new StringBuffer();
		String icon = "folder";
		if (function.getSysIcon() != null) {
			icon = function.getSysIcon().getClas();
		}
		menuString.append("<li iconCls=\"");
		menuString.append(icon);
		menuString.append("\"> <a onclick=\"addTab(\'");
		menuString.append(function.getName());
		menuString.append("\',\'");
		menuString.append(ContextHolderUtils.getRequest().getContextPath()
				+ function.getUrl());
		menuString.append("\',\'");
		menuString.append(icon);
		menuString.append("\')\"  title=\"");
		menuString.append(function.getName());
		menuString.append("\" url=\"");
		menuString.append(ContextHolderUtils.getRequest().getContextPath()
				+ function.getUrl());
		menuString.append("\" href=\"#\" ><span class=\"nav\" >");
		menuString.append(function.getName());
		menuString.append("</span></a></li>");
		return menuString.toString();
	}

}
