/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.generate <br>
 * 文件名：AbstractGetData.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-9-上午11:19:59<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.generate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.jaf.core.dto.ColumnData;

/**
 * 
 * 类名称：AbstractGetData <br>
 * 类描述：获取数据抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-9 上午11:19:59 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractGetData {

	/** 字符类型 */
	private static final List<String> STRING_TYPE = Arrays.asList(new String[] {
			"char", "varchar", "tinytext", "text", "blob", "mediumtext",
			"mediumblob", "longtext", "longblob" });

	/** 整型类型 */
	private static final List<String> INT_TYPE = Arrays.asList(new String[] {
			"tinyint", "smallint", "mediumint", "int", "bigint" });

	/** 长整型类型 */
	private static final List<String> LONG_TYPE = Arrays
			.asList(new String[] { "bigint" });

	/** 浮点型类型 */
	private static final List<String> DOUBLE_TYPE = Arrays.asList(new String[] {
			"float", "double", "decimal" });

	/** 时间类型 */
	private static final List<String> DATE_TYPE = Arrays.asList(new String[] {
			"date", "datetime", "timestamp", "time", "year" });

	/**
	 * 方法：getTables <br>
	 * 描述：获取表格 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:29:32 <br>
	 * 
	 * @return
	 */
	public abstract List<String> getTables() throws Exception;

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：获取字段数据 查询表的字段，封装成List <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:31:09 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<ColumnData> getColumnDatas(String tableName)
			throws Exception;

	/**
	 * 方法：getColumnsMap <br>
	 * 描述：获取字段数据 查询表的字段，封装成List <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:35:41 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<Map<String, String>> getColumnsMap(String tableName)
			throws Exception;

	/**
	 * 方法：sqlTypeTrans4JavaType <br>
	 * 描述：数据库字段类型转换java数据类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:37:12 <br>
	 * 
	 * @param type
	 * @return
	 */
	public String sqlTypeTrans4JavaType(String type) {
		type = type.toLowerCase();
		if (STRING_TYPE.contains(type)) {
			return "String";
		} else if (INT_TYPE.contains(type)) {
			return "Integer";
		} else if (LONG_TYPE.contains(type)) {
			return "Long";
		} else if (DATE_TYPE.contains(type)) {
			return "java.sql.Timestamp";
		} else if (DOUBLE_TYPE.contains(type)) {
			return "Double";
		}
		return null;
	}

	/**
	 * 方法：javaType4sqlTypeTrans <br>
	 * 描述：java数据类型 转换数据库字段类型<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:37:12 <br>
	 * 
	 * @param type
	 * @return
	 */
	public String javaType4sqlTypeTrans(String type) {
		type = type.toLowerCase();
		if (STRING_TYPE.contains(type)) {
			return "String";
		} else if (INT_TYPE.contains(type)) {
			return "Integer";
		} else if (LONG_TYPE.contains(type)) {
			return "Long";
		} else if (DATE_TYPE.contains(type)) {
			return "java.sql.Timestamp";
		} else if (DOUBLE_TYPE.contains(type)) {
			return "Double";
		}
		return null;
	}

}
