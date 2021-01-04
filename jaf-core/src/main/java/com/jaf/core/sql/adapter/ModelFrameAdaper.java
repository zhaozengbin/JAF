/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.adapter <br>
 * 文件名：ModelFrameAdaper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午5:34:38<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.adapter;

import com.jaf.core.entity.EDBType;
import com.jaf.core.entity.EModelFrame;
import com.jaf.core.sql.generate.AbstractGenerateModelFrame;
import com.jaf.core.sql.generate.AbstractGetData;
import com.jaf.core.sql.generate.GenerateByMyBatisAndMysql;
import com.jaf.core.sql.generate.GenerateByMyBatisAndOracle;
import com.jaf.core.sql.generate.GetDataProxy;

/**
 * 
 * 类名称：ModelFrameAdaper <br>
 * 类描述：生成模型层适配器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午5:34:38 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ModelFrameAdaper {

	/**
	 * 方法：chooseModelFrame <br>
	 * 描述：生成模型层适配器 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午5:35:08 <br>
	 * 
	 * @param modelFrame
	 *            模型框架类型
	 * @param dbType
	 *            数据库类型
	 * @return
	 */
	public static AbstractGenerateModelFrame adaper(EModelFrame modelFrame,
			EDBType dbType) {
		AbstractGetData getDate = new GetDataProxy();

		if (modelFrame == EModelFrame.Mybatis) {
			if (dbType == EDBType.Mysql) {
				return new GenerateByMyBatisAndMysql(getDate);
			} else if (dbType == EDBType.Oracle) {
				return new GenerateByMyBatisAndOracle(getDate);
			}
			return null;
		}
		return null;
	}
}
