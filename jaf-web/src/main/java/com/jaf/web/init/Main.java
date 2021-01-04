/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.init <br>
 * 文件名：Main.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-2-下午4:17:57<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.init;

import com.jaf.web.init.adapter.InitializationAdapter;

/**
 * 
 * 类名称：Main <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-2 下午4:17:57 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Main {
	public static void main(String[] args) {
		AbstractInitialization initialization = InitializationAdapter.adapter();
		try {
			initialization.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
