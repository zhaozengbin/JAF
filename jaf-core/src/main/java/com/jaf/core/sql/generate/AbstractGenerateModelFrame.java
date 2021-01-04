/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.generate <br>
 * 文件名：AbstractGenerateModelFrame.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-上午11:07:40<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.generate;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jaf.core.dto.ColumnData;
import com.jaf.core.entity.ESpecialCharacters;
import com.jaf.core.util.DateUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：AbstractGenerateModelFrame <br>
 * 类描述：转换抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 上午11:07:40 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractGenerateModelFrame {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils
			.getLogger(AbstractGenerateModelFrame.class);

	/** 获取数据服务 */
	protected AbstractGetData getDate;

	/** 数据库字段名 ColumnData对象集合集合 */
	public static String RESULT_CREATE_SQL_KEY_COLUMNDATAS = "columnDatas";

	/** 据库字段名columnFields集合“,”分割 用于组装查询语句 */
	public static String RESULT_CREATE_SQL_KEY_columnList = "columnList";

	/** 数据库字段名 字符串数组 */
	public static String RESULT_CREATE_SQL_KEY_columnFields = "columnFields";

	/** 插入语句 */
	public static String RESULT_CREATE_SQL_KEY_insert = "insert";

	/** 修改语句 */
	public static String RESULT_CREATE_SQL_KEY_update = "update";

	/** 修改语句 */
	public static String RESULT_CREATE_SQL_KEY_updateSelective = "updateSelective";

	/** 根据ID查询语句 */
	public static String RESULT_CREATE_SQL_KEY_selectById = "selectById";

	/** 删除语句 */
	public static String RESULT_CREATE_SQL_KEY_delete = "delete";

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:19:24 <br>
	 */
	public AbstractGenerateModelFrame() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 上午11:19:48 <br>
	 * 
	 * @param getDate
	 */
	public AbstractGenerateModelFrame(AbstractGetData getDate) {
		this.getDate = getDate;
	}

	/**
	 * 方法：getBeanFeilds <br>
	 * 描述：获取实体自字段 生成实体Bean 的属性和set,get方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:32:54 <br>
	 * 
	 * @param columnDatas
	 * @return
	 * @throws Exception
	 */
	public String getBeanFeilds(List<ColumnData> columnDatas) throws Exception {
		// 获取数据列表
		LoggerUtils
				.debug(LOGGER, "根据表名获取数据结果集大小为:[" + columnDatas.size() + "]");
		StringBuffer str = new StringBuffer();
		StringBuffer getset = new StringBuffer();
		// 用来判断是否为第一个字段
		int count = 1;
		for (ColumnData d : columnDatas) {
			// 拼装字段
			String name = d.getColumnName();
			String type = d.getDataType();
			String comment = d.getColumnComment();
			if (count == 1) {
				str.append(ESpecialCharacters.ENTER.getEscape());
			}
			str.append("/* " + comment + " **/");
			str.append(ESpecialCharacters.ENTER.getEscape());
			str.append("private " + type + " " + name + ";");
			str.append(ESpecialCharacters.ENTER.getEscape());
			LoggerUtils.debug(LOGGER, "当前循环字段名:[" + name + "],类型:[" + type
					+ "]，注释:[" + comment + "]");
			// 拼装set get方法
			String maxChar = name.substring(0, 1).toUpperCase();
			String method = maxChar + name.substring(1, name.length());

			// 组装get方法
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("/**");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" * @retrun the " + name + " <br>");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" * ");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" *        时间: "
					+ DateUtils.currentDateFor12Hour(DateUtils.YYYY_MM_DD,
							DateUtils.HH_MM_SS) + " <br>");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("*/");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("public " + type + " " + "get" + method + "() {");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("    return this." + name + ";");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("}");
			// 组装set方法
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("/**");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" * @param " + name);
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" *            the " + name + " to set <br>");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append(" *            时间: "
					+ DateUtils.currentDateFor12Hour(DateUtils.YYYY_MM_DD,
							DateUtils.HH_MM_SS) + " <br>");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("*/");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("public void set" + method + "(" + type + " " + name
					+ ") {");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("    this." + name + "=" + name + ";");
			getset.append(ESpecialCharacters.ENTER.getEscape());
			getset.append("}");
		}
		String argv = str.toString();
		String method = getset.toString();
		LoggerUtils.debug(LOGGER, "拼装Feild结果为:[" + argv + "]");
		LoggerUtils.debug(LOGGER, "拼装Set,Get结果为:[" + method + "]");
		count++;
		return argv + method;

	}

	/**
	 * 方法：getTablesNameToClassName <br>
	 * 描述：通过表明获取类名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:55:35 <br>
	 * 
	 * @param tableName
	 *            表名
	 * @param delimiter
	 *            分隔符 默认为下划线"_"
	 * @return
	 */
	public String getTablesNameToClassName(String tableName, String delimiter) {
		if (ObjectUtils.isEmpty(delimiter)) {
			delimiter = "_";
		}
		String[] split = tableName.split("_");
		String tempTables = "";
		if (split.length > 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < split.length; i++) {
				String tempTableName = split[i].substring(0, 1).toUpperCase()
						+ split[i].substring(1, split[i].length());
				sb.append(tempTableName);
			}
			tempTables = sb.toString();
		} else {
			tempTables = split[0].substring(0, 1).toUpperCase()
					+ split[0].substring(1, split[0].length());
		}
		return tempTables;

	}

	/**
	 * 方法：getAutoCreateSql <br>
	 * 描述：自动生成sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:57:56 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract Map<String, Object> getAutoCreateSql(String tableName)
			throws Exception;

	/**
	 * 方法：getDeleteSql <br>
	 * 描述：获取删除sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:59:26 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getDeleteSql(String tableName, String[] columnsList)
			throws Exception;

	/**
	 * 方法：getInsertSql <br>
	 * 描述：获取插入sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:59:26 <br>
	 * 
	 * @param tableName
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract String getInsertSql(String tableName, String columns)
			throws Exception;

	/**
	 * 方法：getSelectByIdSql <br>
	 * 描述：获取根据ID查询sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:00:08 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getSelectByIdSql(String tableName,
			String[] columnsList) throws Exception;

	/**
	 * 方法：getColumnFields <br>
	 * 描述：获取所有的字段，并按","分割 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:01:24 <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract String getColumnFields(String columns) throws Exception;

	/**
	 * 方法：getColumnList <br>
	 * 描述：获取所有列 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:02:27 <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract String[] getColumnList(String columns) throws Exception;

	/**
	 * 方法：getUpdateSql <br>
	 * 描述：获取修改sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:04:07 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getUpdateSql(String tableName, String[] columnsList)
			throws Exception;

	/**
	 * 方法：getUpdateSelectiveSql <br>
	 * 描述：获取根指定条件修改sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:05:09 <br>
	 * 
	 * @param tableName
	 * @param columnList
	 * @return
	 * @throws Exception
	 */
	public abstract String getUpdateSelectiveSql(String tableName,
			List<ColumnData> columnList) throws Exception;

	/**
	 * 方法：getColumnSplit <br>
	 * 描述：获取所有列名字<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:06:34 <br>
	 * 
	 * @param columnList
	 * @return
	 * @throws Exception
	 */
	public abstract String getColumnSplit(List<ColumnData> columnList)
			throws Exception;

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：获取字段数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:21:06 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<ColumnData> getColumnDatas(String tableName)
			throws Exception;

	/**
	 * 方法：createFile <br>
	 * 描述： <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:56:38 <br>
	 * 
	 * @param path
	 * @param fileName
	 * @param str
	 * @throws Exception
	 */
	public void createFile(String path, String fileName, String str)
			throws Exception {
		FileWriter writer = new FileWriter(new File(path + fileName));
		writer.write(new String(str.getBytes("utf-8")));
		writer.flush();
		writer.close();
	}

}
