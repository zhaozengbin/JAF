/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.generate <br>
 * 文件名：GetDataProxy.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-9-上午11:50:15<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.generate;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.jaf.common.Globals;
import com.jaf.core.dto.ColumnData;
import com.jaf.core.entity.EDBType;
import com.jaf.core.sql.adapter.DataBaseAdapter;
import com.jaf.core.sql.util.JDBCUtils;
import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：GetDataProxy <br>
 * 类描述：获取数据代理类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-9 上午11:50:15 <br>
 * 修改备注：TODO <br>
 * 
 */
public class GetDataProxy extends AbstractGetData {

	/** 数据库链接对象 */
	private Connection connection;

	/** 数据库类型 */
	private EDBType dbType;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午5:28:10 <br>
	 */
	public GetDataProxy() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-9 上午11:51:35 <br>
	 * 
	 * @param dbType
	 *            数据库类型
	 * @param connection
	 *            数据库链接
	 * 
	 */
	public GetDataProxy(EDBType dbType, Connection connection) {
		this.dbType = dbType;
		this.connection = connection;
	}

	/**
	 * 方法：getDate <br>
	 * 描述：获取数据具体实现类 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-1 下午5:08:31 <br>
	 * 
	 * @return
	 */
	public AbstractGetData getData() {
		AbstractGetData getData = null;
		connection = JDBCUtils.getConnection();
		if (ObjectUtils.isEmpty(dbType)) {
			dbType = EDBType.valueOf(Globals.SYSTEM_CONFIG_SQL_TYPE);
		}
		getData = DataBaseAdapter.adapter(dbType, connection);
		return getData;

	}

	/**
	 * 方法：getTables <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getTables()
	 */
	@Override
	public List<String> getTables() throws Exception {
		List<String> list = null;
		try {
			list = getData().getTables();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection);
		}
		return list;
	}

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnDatas(java.lang.String)
	 */
	@Override
	public List<ColumnData> getColumnDatas(String tableName) throws Exception {
		List<ColumnData> list = null;
		try {
			list = getData().getColumnDatas(tableName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection);
		}
		return list;
	}

	/**
	 * 方法：getColumnsMap <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnsMap(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getColumnsMap(String tableName)
			throws Exception {
		List<Map<String, String>> list = null;
		try {
			list = getData().getColumnsMap(tableName);
		} catch (Exception e) {
		} finally {
			JDBCUtils.close(connection);
		}
		return list;
	}

}
