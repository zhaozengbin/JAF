/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：TabsTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import java.util.ArrayList;
import java.util.List;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.easyui.Tab;
import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：TabsTag <br>
 * 类描述：选项卡标签 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:32:05 <br>
 * 修改备注：TODO <br>
 * 
 */
public class TabsTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 容器ID */
	private String id;

	/** 宽度 */
	private String width;

	/** 高度 */
	private String height;

	/** 简洁模式 */
	private boolean plain;

	/** 铺满浏览器 */
	private boolean fit = true;

	/** 边框 */
	private boolean border;

	/** 滚动增量 */
	private String scrollIncrement;

	/** 滚动时间 */
	private String scrollDuration;

	/** 工具栏 */
	private boolean tools;

	/** 是否创建父容器 */
	private boolean tabs = true;

	/** 是否是iframe方式 */
	private boolean iframe = true;

	/** 选项卡位置 */
	private String tabPosition = "top";

	private List<Tab> tabList = new ArrayList<Tab>();

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
		if (iframe) {
			sb.append("<script type=\"text/javascript\">");
			sb.append("$(function(){");
			if (tabList.size() > 0) {
				for (Tab tab : tabList) {
					sb.append("add" + id + "(\'" + tab.getTitle() + "\',\'"
							+ tab.getHref() + "\',\'" + tab.getId() + "\',\'"
							+ tab.getIcon() + "\',\'" + tab.isClosable()
							+ "\');");
				}
			}
			sb.append("function add" + id + "(title,url,id,icon,closable) {");
			sb.append("$(\'#" + id + "\').tabs(\'add\',{");
			sb.append("id:id,");
			sb.append("title:title,");
			if (iframe) {
				sb.append("content:createFrame" + id + "(id),");
			} else {
				sb.append("href:url,");
			}
			sb.append("closable:closable=(closable =='false')?false : true,");
			sb.append("icon:icon");
			sb.append("});");
			sb.append("}");
			sb.append("$(\'#" + id + "\').tabs(");
			sb.append("{");
			sb.append("onSelect : function(title) {");
			sb.append("var p = $(this).tabs(\'getTab\', title);");
			if (tabList.size() > 0) {
				for (Tab tab : tabList) {
					sb.append("if (title == \'" + tab.getTitle() + "\') {");
					sb.append("p.find(\'iframe\').attr(\'src\',");
					sb.append("\'" + tab.getHref() + "\');}");
				}
			}
			sb.append("}");
			sb.append("});");

			sb.append("function createFrame" + id + "(id)");
			sb.append("{");
			sb.append("var s = \'<iframe id=\"\'+id+\'\" scrolling=\"no\" frameborder=\"0\"  src=\"about:jeecg\" width=\""
					+ (ObjectUtils.isNotEmpty(width) ? width : "100%")
					+ "\" height=\""
					+ (ObjectUtils.isNotEmpty(height) ? height : "99.5%")
					+ "\"></iframe>\';");
			sb.append("return s;");
			sb.append("}");
			sb.append("});");
			sb.append("</script>");
		}
		if (tabs) {
			// ----------------------------------------------------------------
			// update-end--Author:wangyang Date:20130413 for：自动缩放
			// ----------------------------------------------------------------
			// 增加width属性，fit属性之前写死，改为由页面设定，不填默认true
			sb.append("<div id=\""
					+ id
					+ "\" tabPosition=\""
					+ tabPosition
					+ "\" border=flase style=\"margin:0px;padding:0px;overflow:hidden;width:"
					+ (ObjectUtils.isNotEmpty(height) ? height : "auto")
					+ ";\" class=\"easyui-tabs\" fit=\"" + fit + "\">");
			// ----------------------------------------------------------------
			// update-end--Author:wangyang Date:20130413 for：自动缩放
			// ----------------------------------------------------------------
			if (!iframe) {
				for (Tab tab : tabList) {
					if (tab.getHref() != null) {
						sb.append("<div title=\""
								+ tab.getTitle()
								+ "\" href=\""
								+ tab.getHref()
								+ "\" style=\"margin:0px;padding:0px;overflow:hidden;\"></div>");
					} else {
						sb.append("<div title=\""
								+ tab.getTitle()
								+ "\"  style=\"margin:0px;padding:0px;overflow:hidden;\">");
						sb.append("<iframe id=\"\'"
								+ tab.getId()
								+ "\'\" scrolling=\"no\" frameborder=\"0\"  src=\""
								+ tab.getIframe()
								+ "\" width=\""
								+ (ObjectUtils.isNotEmpty(width) ? height
										: "100%")
								+ "\" height=\""
								+ (ObjectUtils.isNotEmpty(height) ? height
										: "99.5%") + "\"></iframe>\';");
						sb.append("</div>");
					}

				}
			}
			sb.append("</div>");

		}
		return sb.toString();
	}

	/**
	 * 方法：setTab <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:32:23 <br>
	 * 
	 * @param id
	 * @param title
	 * @param iframe
	 * @param href
	 * @param iconCls
	 * @param cache
	 * @param content
	 * @param width
	 * @param heigth
	 * @param closable
	 */
	public void setTab(String id, String title, String iframe, String href,
			String iconCls, boolean cache, String content, String width,
			String heigth, boolean closable) {
		Tab tab = new Tab();
		tab.setId(id);
		tab.setTitle(title);
		tab.setHref(href);
		tab.setCache(cache);
		tab.setIframe(iframe);
		tab.setContent(content);
		tab.setHeigth(heigth);
		tab.setIcon(iconCls);
		tab.setWidth(width);
		tab.setClosable(closable);
		tabList.add(tab);
	}

	/**
	 * 返回: the id <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getId() {
		return id;
	}

	/**
	 * 参数: id the id to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回: the width <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 参数: width the width to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 返回: the height <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 参数: height the height to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * 返回: the plain <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isPlain() {
		return plain;
	}

	/**
	 * 参数: plain the plain to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setPlain(boolean plain) {
		this.plain = plain;
	}

	/**
	 * 返回: the fit <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isFit() {
		return fit;
	}

	/**
	 * 参数: fit the fit to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setFit(boolean fit) {
		this.fit = fit;
	}

	/**
	 * 返回: the border <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isBorder() {
		return border;
	}

	/**
	 * 参数: border the border to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setBorder(boolean border) {
		this.border = border;
	}

	/**
	 * 返回: the scrollIncrement <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getScrollIncrement() {
		return scrollIncrement;
	}

	/**
	 * 参数: scrollIncrement the scrollIncrement to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setScrollIncrement(String scrollIncrement) {
		this.scrollIncrement = scrollIncrement;
	}

	/**
	 * 返回: the scrollDuration <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getScrollDuration() {
		return scrollDuration;
	}

	/**
	 * 参数: scrollDuration the scrollDuration to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setScrollDuration(String scrollDuration) {
		this.scrollDuration = scrollDuration;
	}

	/**
	 * 返回: the tools <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isTools() {
		return tools;
	}

	/**
	 * 参数: tools the tools to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setTools(boolean tools) {
		this.tools = tools;
	}

	/**
	 * 返回: the tabs <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isTabs() {
		return tabs;
	}

	/**
	 * 参数: tabs the tabs to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setTabs(boolean tabs) {
		this.tabs = tabs;
	}

	/**
	 * 返回: the iframe <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public boolean isIframe() {
		return iframe;
	}

	/**
	 * 参数: iframe the iframe to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setIframe(boolean iframe) {
		this.iframe = iframe;
	}

	/**
	 * 返回: the tabPosition <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public String getTabPosition() {
		return tabPosition;
	}

	/**
	 * 参数: tabPosition the tabPosition to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setTabPosition(String tabPosition) {
		this.tabPosition = tabPosition;
	}

	/**
	 * 返回: the tabList <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public List<Tab> getTabList() {
		return tabList;
	}

	/**
	 * 参数: tabList the tabList to set <br>
	 * 
	 * 时间: 2013-7-25 下午3:15:57
	 */
	public void setTabList(List<Tab> tabList) {
		this.tabList = tabList;
	}

}
