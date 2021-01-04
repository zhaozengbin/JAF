/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.ingleton <br>
 * 文件名：CaptchaServiceSingleton.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-11-5-下午5:26:21<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.ingleton;

import com.jaf.web.web.servlet.GMailEngine;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 
 * 类名称：CaptchaServiceSingleton <br>
 * 类描述：按照官方的做法： 一定为单例 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-5 下午5:26:21 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CaptchaServiceSingleton {

	/**  */
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService(
			new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000,
			75000);

	// private static ImageCaptchaService instance=new
	// DefaultManageableImageCaptchaService();
	/**
	 * 方法：getInstance <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-11-5 下午5:26:51 <br>
	 * 
	 * @return
	 */
	public static ImageCaptchaService getInstance() {
		return instance;
	}
}
