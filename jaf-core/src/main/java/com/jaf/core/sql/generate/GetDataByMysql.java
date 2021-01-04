/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.generate <br>
 * 文件名：GetDataByMysql.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-9-上午11:26:50<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.generate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jaf.core.dto.ColumnData;

/**
 * 
 * 类名称：GetDataByMysql <br>
 * 类描述：根据Mysql获取数据 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-9 上午11:26:50 <br>
 * 修改备注：TODO <br>
 * 
 */
public class GetDataByMysql extends AbstractGetData {

	/** 数据库链接对象 */
	private Connection connection = null;

	/** 查看表 */
	private static final String SQLTables = "SHOW TABLE";


	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:37:42 <br>
	 * 
	 * @param connection
	 *            数据库连接对象
	 */
	public GetDataByMysql(Connection connection) {
		super();
		try {
			this.connection = connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：getTables <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGetData#getTables()
	 */
	@Override
	public List<String> getTables() throws Exception {
		PreparedStatement ps = connection.prepareStatement(SQLTables);
		ResultSet rs = ps.executeQuery();
		List<String> list = new ArrayList<String>();
		while (rs.next()) {
			String tableName = rs.getString(1);
			list.add(tableName);
		}
		rs.close();
		ps.close();
		return list;
	}

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGetData#getColumnDatas(java.lang.String)
	 */
	@Override
	public List<ColumnData> getColumnDatas(String tableName) throws Exception {
		String SQLColumns = "SELECT distinct COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.columns WHERE table_name =  '"
				+ tableName + "' ";
		PreparedStatement ps = connection.prepareStatement(SQLColumns);
		List<ColumnData> columnList = new ArrayList<ColumnData>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name = rs.getString(1);
			String type = rs.getString(2);
			String comment = rs.getString(3);
			type = sqlTypeTrans4JavaType(type);

			ColumnData cd = new ColumnData();
			cd.setColumnName(name);
			cd.setDataType(type);
			cd.setColumnComment(comment);
			columnList.add(cd);
		}
		rs.close();
		ps.close();
		return columnList;
	}

	/**
	 * 方法：getColumnsMap <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnsMap(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getColumnsMap(String tableName)
			throws Exception {
		String SQLColumns = "SELECT distinct COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.columns WHERE  table_schema = 'ssi' and table_name =  '"
				+ tableName + "' ";
		// String SQLColumns="desc "+tableName;
		PreparedStatement ps = connection.prepareStatement(SQLColumns);
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Map<String, String> columnsMap = new HashMap<String, String>();
			String name = rs.getString(1);
			String type = rs.getString(2);
			String comment = rs.getString(3);
			type = sqlTypeTrans4JavaType(type);
			columnsMap.put("COLUMN_NAME", name);
			columnsMap.put("DATA_TYPE", type);
			columnsMap.put("COLUMN_COMMENT", comment);
			listMap.add(columnsMap);
		}
		rs.close();
		ps.close();
		return listMap;
	}

}
