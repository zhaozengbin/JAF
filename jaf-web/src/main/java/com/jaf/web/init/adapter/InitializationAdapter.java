/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.init.adapter <br>
 * 文件名：InitializationAdapter.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-2-下午4:15:30<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.init.adapter;

import com.jaf.common.Globals;
import com.jaf.core.entity.EDBType;
import com.jaf.web.init.AbstractInitialization;
import com.jaf.web.init.InitializationByMysql;

/**
 * 
 * 类名称：InitializationAdapter <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-2 下午4:15:30 <br>
 * 修改备注：TODO <br>
 * 
 */
public class InitializationAdapter {

	/**
	 * 方法：adapter <br>
	 * 描述：初始化适配器 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-2 下午4:15:56 <br>
	 */
	public static AbstractInitialization adapter() {
		EDBType eDBType = EDBType.valueOf(Globals.SYSTEM_CONFIG_SQL_TYPE);
		if (EDBType.Mysql == eDBType) {
			return new InitializationByMysql();
		}
		return null;
	}
}
