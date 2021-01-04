/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.common <br>
 * 文件名：Globals.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午6:18:52<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.jaf.core.cache.AbstractCache;
import com.jaf.core.cache.adapter.CacheAdapter;
import com.jaf.core.dto.UIxml;
import com.jaf.core.dto.UIxml.UIxmlCss;
import com.jaf.core.dto.UIxml.UIxmlJs;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.core.util.PropertiesUtils;
import com.jaf.core.util.SystemUtils;
import com.jaf.core.util.XStreamUtils;

/**
 * 
 * 类名称：Globals <br>
 * 类描述：全局 配置文件信息读入 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午6:18:52 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Globals {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils.getLogger(Globals.class);

	/** 缓存操作实现类 */
	public static final AbstractCache CACHE = CacheAdapter.adapter();

	/** 人员类型 正常 */
	public static Short USER_NORMAL = 1;

	/** 人员类型 禁用 */
	public static Short USER_FORBIDDEN = 0;

	/** 超级管理员 */
	public static Short USER_ADMIN = -1;

	/** 日志级别定义 */
	public static Short LOG_LEAVEL_INFO = 1;
	public static Short LOG_LEAVEL_WARRING = 2;
	public static Short LOG_LEAVEL_ERROR = 3;

	/** 日志类型 登陆 */
	public static Short LOG_TYPE_LOGIN = 1;

	/** 日志类型 退出 */
	public static Short LOG_TYPE_EXIT = 2;

	/** 日志类型 插入 */
	public static Short LOG_TYPE_INSERT = 3;

	/** 日志类型 删除 */
	public static Short LOG_TYPE_DEL = 4;

	/** 日志类型 更新 */
	public static Short LOG_TYPE_UPDATE = 5;

	/** 日志类型 上传 */
	public static Short LOG_TYPE_UPLOAD = 6;

	/** 日志类型 其他 */
	public static Short LOG_TYPE_OTHER = 7;

	/** 词典分组定义 数据表分类 */
	public static String TypeGroup_Database = "database";

	/** 权限等级 */
	public static Short FUNCTION_LEAVE_ONE = 0;// 一级权限
	public static Short FUNCTION_LEAVE_TWO = 1;// 二级权限

	/** 权限等级前缀 一级权限 */
	public static String FUNCTION_ORDER_ONE = "ofun";

	/** 权限等级前缀 二级权限 */
	public static String FUNCTION_ORDER_TWO = "tfun";

	/** 新闻法规 新建 */
	public static Short DOCUMENT_NEW = 0;

	/** 新闻法规 发布 */
	public static Short DOCUMENT_PUBLICH = 0;

	/** 配置系统是否开启按钮权限控制 */
	public static Boolean BUTTON_AUTHORITY_CHECK = null;

	/** 系统配置文件KEY值-控制层框架类型 */
	public static String SYSTEM_CONFIG_MODEL_FRAME_TYPE = null;

	/** 系统配置文件KEY值-显示层框架类型 */
	public static String SYSTEM_CONFIG_VIEW_FRAME_TYPE = null;

	/** 系统配置文件KEY值-控制层框架类型 */
	public static String SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE = null;

	/** 系统配置文件KEY值-数据库类型 */
	public static String SYSTEM_CONFIG_SQL_TYPE = null;

	/** 系统配置文件KEY值-数据源类型 */
	public static String SYSTEM_CONFIG_DATASOURCE_TYPE = null;

	/** 缓存类型 */
	public static String SYSTEM_CACHE_TYPE = null;

	/** 注释配置文件KEY值-作者 */
	public static String NOTE_CONFIG_AUTHOR = null;

	/** 注释配置文件KEY值-创建者 */
	public static String NOTE_CONFIG_CREATE_USER = null;

	/** 注释配置文件KEY值-修改者 */
	public static String NOTE_CONFIG_MODIFY_USER = null;

	/** 注释配置文件KEY值-版权 */
	public static String NOTE_CONFIG_COPYRIGHT = null;

	/** 数据源配置文件KEY值-驱动 */
	public static String DATA_SOURCE_JDBC_DRIVER = null;

	/** 数据源配置文件KEY值-链接地址 */
	public static String DATA_SOURCE_JDBC_URL = null;

	/** 数据源配置文件KEY值-用户名 */
	public static String DATA_SOURCE_JDBC_USERNAME = null;

	/** 数据源配置文件KEY值-密码 */
	public static String DATA_SOURCE_JDBC_PASSWORD = null;

	/** UI xml注入文件信息 */
	public static Map<String, List<Object>> UI_XML = null;

	// 将数据读入系统静态变量
	static {
		readSysConfig();
		readNoteConfig();
		readDataSource();
		readAuth();
		readUIxml();
	}

	/**
	 * 方法：readSysConfig <br>
	 * 描述：读取系统配置文件及信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午2:54:46 <br>
	 */
	private static void readSysConfig() {
		// 读取系统配置文件
		LoggerUtils.info(LOGGER, "读取系统配置文件");
		ResourceBundle systemConfig = PropertiesUtils
				.getResourceBundle(PropertiesUtils.SYSTEM_CONFIG);
		if (ObjectUtils.isNotEmpty(systemConfig)) {
			// 系统配置文件KEY值-控制层框架类型
			if (ObjectUtils.isEmpty(SYSTEM_CONFIG_MODEL_FRAME_TYPE)) {
				SYSTEM_CONFIG_MODEL_FRAME_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CONFIG_MODEL_FRAME_TYPE);
			}
			// 系统配置文件KEY值-显示层框架类型
			if (ObjectUtils.isEmpty(SYSTEM_CONFIG_VIEW_FRAME_TYPE)) {
				SYSTEM_CONFIG_VIEW_FRAME_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CONFIG_VIEW_FRAME_TYPE);
			}
			// 系统配置文件KEY值-控制层框架类型
			if (ObjectUtils.isEmpty(SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE)) {
				SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE);
			}
			// 系统配置文件KEY值-数据库类型
			if (ObjectUtils.isEmpty(SYSTEM_CONFIG_SQL_TYPE)) {
				SYSTEM_CONFIG_SQL_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CONFIG_SQL_TYPE);
			}
			// 系统配置文件KEY值-数据源类型
			if (ObjectUtils.isEmpty(SYSTEM_CONFIG_DATASOURCE_TYPE)) {
				SYSTEM_CONFIG_DATASOURCE_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CONFIG_DATASOURCE_TYPE);
			}
			// 系统配置文件KEY值-缓存类型
			if (ObjectUtils.isEmpty(SYSTEM_CACHE_TYPE)) {
				SYSTEM_CACHE_TYPE = systemConfig
						.getString(PropertiesUtils.SYSTEM_CACHE_TYPE);
			}
		}
	}

	/**
	 * 方法：readNoteConfig <br>
	 * 描述：读取注释配置文件及内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午2:55:31 <br>
	 */
	private static void readNoteConfig() {
		// 读取注释配置文件
		LoggerUtils.info(LOGGER, "读取注释配置文件");
		ResourceBundle noteConfig = PropertiesUtils
				.getResourceBundle(PropertiesUtils.NOTE_CONFIG);
		if (ObjectUtils.isNotEmpty(noteConfig)) {
			// 注释文件作者信息
			if (ObjectUtils.isEmpty(NOTE_CONFIG_AUTHOR)) {
				NOTE_CONFIG_AUTHOR = noteConfig
						.getString(PropertiesUtils.NOTE_CONFIG_AUTHOR);
			}
			// 注释文件创建者信息
			if (ObjectUtils.isEmpty(NOTE_CONFIG_CREATE_USER)) {
				NOTE_CONFIG_CREATE_USER = noteConfig
						.getString(PropertiesUtils.NOTE_CONFIG_CREATE_USER);
			}
			// 注释文件修改者信息
			if (ObjectUtils.isEmpty(NOTE_CONFIG_MODIFY_USER)) {
				NOTE_CONFIG_MODIFY_USER = noteConfig
						.getString(PropertiesUtils.NOTE_CONFIG_MODIFY_USER);
			}
			// 注释文件版权信息
			if (ObjectUtils.isEmpty(NOTE_CONFIG_COPYRIGHT)) {
				NOTE_CONFIG_COPYRIGHT = noteConfig
						.getString(PropertiesUtils.NOTE_CONFIG_COPYRIGHT);
			}
		}
	}

	/**
	 * 方法：readDataSource <br>
	 * 描述：读取数据源配置文件及内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午2:58:45 <br>
	 */
	private static void readDataSource() {
		LoggerUtils.info(LOGGER, "读取:[" + SYSTEM_CONFIG_DATASOURCE_TYPE
				+ "]数据源配置文件");
		ResourceBundle dataSourceConfig = PropertiesUtils
				.getResourceBundle(SYSTEM_CONFIG_DATASOURCE_TYPE);
		if (ObjectUtils.isNotEmpty(dataSourceConfig)) {
			// 数据源配置文件KEY值-驱动
			if (ObjectUtils.isEmpty(DATA_SOURCE_JDBC_DRIVER)) {
				DATA_SOURCE_JDBC_DRIVER = dataSourceConfig
						.getString(PropertiesUtils.DATA_SOURCE_JDBC_DRIVER);
			}
			// 数据源配置文件KEY值-链接地址
			if (ObjectUtils.isEmpty(DATA_SOURCE_JDBC_URL)) {
				DATA_SOURCE_JDBC_URL = dataSourceConfig
						.getString(PropertiesUtils.DATA_SOURCE_JDBC_URL);
			}
			// 数据源配置文件KEY值-用户名
			if (ObjectUtils.isEmpty(DATA_SOURCE_JDBC_USERNAME)) {
				DATA_SOURCE_JDBC_USERNAME = dataSourceConfig
						.getString(PropertiesUtils.DATA_SOURCE_JDBC_USERNAME);
			}
			// 数据源配置文件KEY值-用户密码
			if (ObjectUtils.isEmpty(DATA_SOURCE_JDBC_PASSWORD)) {
				DATA_SOURCE_JDBC_PASSWORD = dataSourceConfig
						.getString(PropertiesUtils.DATA_SOURCE_JDBC_PASSWORD);
			}
		}
	}

	/**
	 * 方法：readAuth <br>
	 * 描述：读取权限配置文件及内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午2:59:37 <br>
	 */
	private static void readAuth() {
		LoggerUtils.info(LOGGER, "读取权限配置文件");
		ResourceBundle authConfig = PropertiesUtils
				.getResourceBundle(PropertiesUtils.AUTH_CONFIG);
		// 按钮权限开关
		if (ObjectUtils.isNotEmpty(authConfig)) {
			if (ObjectUtils.isEmpty(BUTTON_AUTHORITY_CHECK)) {
				BUTTON_AUTHORITY_CHECK = Boolean
						.valueOf(String.valueOf(authConfig
								.getString(PropertiesUtils.AUTH_CONFIG_BUTTON)));
			}
		}
	}

	/**
	 * 方法：readUIxml <br>
	 * 描述：读取UIxml配置文件及内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午3:03:22 <br>
	 */
	private static void readUIxml() {
		if (ObjectUtils.isEmpty(UI_XML)) {
			UI_XML = groupByGroupId();
		}
	}

	/**
	 * 方法：groupByGroupId <br>
	 * 描述：根据xml groupId属性分组 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 下午2:40:41 <br>
	 * 
	 * @return
	 */
	private static Map<String, List<Object>> groupByGroupId() {
		UIxml uiXml = (UIxml) XStreamUtils.fromXML(new Class[] { UIxml.class,
				UIxmlJs.class, UIxmlCss.class }, SystemUtils.getWebClass()
				+ XStreamUtils.PATH_UI_XML);
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		List<Object> list = null;
		for (UIxmlJs js : uiXml.getJs()) {
			list = map.get(js.getGroupId());
			if (ObjectUtils.isEmpty(list)) {
				list = new ArrayList<Object>();
			}
			if (!list.contains(js)) {
				list.add(js);
			}
			map.put(js.getGroupId(), list);
		}
		for (UIxmlCss css : uiXml.getCss()) {
			list = map.get(css.getGroupId());
			if (ObjectUtils.isEmpty(list)) {
				list = new ArrayList<Object>();
			}
			if (!list.contains(css)) {
				list.add(css);
			}
			map.put(css.getGroupId(), list);
		}
		return map;
	}

}
