/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.annotaction <br>
 * 文件名：LogAnnotaction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午10:34:26<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.annotaction;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaf.web.entity.ELogLevel;
import com.jaf.web.entity.ELogOperation;

/**
 *
 * 类名称：LogAnnotaction <br>
 * 类描述：日志注解 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午10:34:26 <br>
 * 修改备注：TODO <br>
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogAnnotaction {

	/**
	 * 方法：remark <br>
	 * 描述：日志描述 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午10:36:38 <br>
	 *
	 * @return
	 */
	public String remark() default "未知操作";

	/**
	 * 方法：level <br>
	 * 描述：级别 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午10:38:49 <br>
	 *
	 * @return
	 */
	public ELogLevel level();

	/**
	 * 方法：operation <br>
	 * 描述：操作 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 上午10:42:54 <br>
	 *
	 * @return
	 */
	public ELogOperation operation();
}
