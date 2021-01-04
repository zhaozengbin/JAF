/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.velocity.adapter <br>
 * 文件名：VelocityAdapter.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午2:04:49<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.velocity.adapter;

import com.jaf.core.entity.EControllerFrame;
import com.jaf.core.entity.EModelFrame;
import com.jaf.core.entity.EViewFrame;
import com.jaf.core.velocity.AbstractVelocity;
import com.jaf.core.velocity.Velocity4SpringMVCAndMyBatis;

/**
 * 
 * 类名称：VelocityAdapter <br>
 * 类描述：模版适配器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午2:04:49 <br>
 * 修改备注：TODO <br>
 * 
 */
public class VelocityAdapter {

	/**
	 * 方法：adapter <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午2:18:32 <br>
	 * 
	 * @param viewFrame
	 *            展示层框架 EViewFrame
	 * @param controllerFrame
	 *            控制层框架 EControllerFrame
	 * @param modelFrame
	 *            模型层框架 EModelFrame
	 * @return
	 */
	public static AbstractVelocity adapter(EViewFrame viewFrame,
			EControllerFrame controllerFrame, EModelFrame modelFrame) {
		if (viewFrame == EViewFrame.Spring
				&& controllerFrame == EControllerFrame.Spring
				&& modelFrame == EModelFrame.Mybatis) {
			return new Velocity4SpringMVCAndMyBatis();
		}
		return null;
	}
}
