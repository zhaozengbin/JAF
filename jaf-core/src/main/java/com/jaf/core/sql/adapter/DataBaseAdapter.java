/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.adapter <br>
 * 文件名：DataBaseAdapter.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午6:06:00<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.adapter;

import java.sql.Connection;

import com.jaf.common.Globals;
import com.jaf.core.entity.EDBType;
import com.jaf.core.sql.generate.AbstractGetData;
import com.jaf.core.sql.generate.GetDataByMysql;
import com.jaf.core.sql.generate.GetDataByOracle;

/**
 * 
 * 类名称：DataBaseAdapter <br>
 * 类描述：数据库适配器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午6:06:00 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DataBaseAdapter {

	/**
	 * 方法：adapter <br>
	 * 描述：数据库适配器 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:09:58 <br>
	 * 
	 * @param connection
	 * 
	 * 
	 * @return
	 */
	public static AbstractGetData adapter(Connection connection) {
		if (EDBType.valueOf(Globals.SYSTEM_CONFIG_SQL_TYPE) == EDBType.Mysql) {
			return new GetDataByMysql(connection);
		} else if (EDBType.valueOf(Globals.SYSTEM_CONFIG_SQL_TYPE) == EDBType.Oracle) {
			return new GetDataByOracle(connection);
		}
		return null;
	}

	/**
	 * 方法：adapter <br>
	 * 描述：数据库适配器 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:09:58 <br>
	 * 
	 * @param dbType
	 * @param connection
	 * @return
	 */
	public static AbstractGetData adapter(EDBType dbType, Connection connection) {
		if (dbType == EDBType.Mysql) {
			return new GetDataByMysql(connection);
		} else if (dbType == EDBType.Oracle) {
			return new GetDataByOracle(connection);
		}
		return null;
	}

}
