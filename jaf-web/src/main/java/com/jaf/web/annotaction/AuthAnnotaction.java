/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.annotaction <br>
 * 文件名：AuthAnnotaction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.annotaction;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类: AuthAnnotaction <br>
 * 描述: 权限注解 <br>
 * 作者: 赵增斌 zhaozengbin@adwo.com <br>
 * 时间: 2013-10-18 上午11:07:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface AuthAnnotaction {
	/**
	 * 方法：verifyLogin <br>
	 * 描述：否验证登陆 true=验证 ,false = 不验证 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:05:02 <br>
	 * 
	 * @return
	 */
	public boolean verifyLogin() default true;

	/**
	 * 方法：verifyURL <br>
	 * 描述：是否验证URL true=验证 ,false = 不验证 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:05:14 <br>
	 * 
	 * @return
	 */
	public boolean verifyURL() default true;

}
