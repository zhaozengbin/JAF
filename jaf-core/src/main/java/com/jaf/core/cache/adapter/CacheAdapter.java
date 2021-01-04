/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.cache.adapter <br>
 * 文件名：CacheAdapter.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-上午11:41:55<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.cache.adapter;

import com.jaf.common.Globals;
import com.jaf.core.cache.AbstractCache;
import com.jaf.core.cache.EhCache;
import com.jaf.core.cache.Memcached;
import com.jaf.core.entity.ECacheFrame;

/**
 * 
 * 类名称：CacheAdapter <br>
 * 类描述：缓存适配器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 上午11:41:55 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CacheAdapter {

	/** 系统缓存key - 系统字典 */
	public static final String CACHE_KEY_SYS_DICTIONARY = "SysDictionary";

	/**
	 * 方法：adapter <br>
	 * 描述：缓存适配器 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-19 上午11:21:58 <br>
	 * 
	 * @return
	 */
	public static AbstractCache adapter() {
		if (ECacheFrame.MEMCACHED.getName().equalsIgnoreCase(
				Globals.SYSTEM_CACHE_TYPE)) {
			return new Memcached();
		} else if (ECacheFrame.EHCACHE.getName().equalsIgnoreCase(
				Globals.SYSTEM_CACHE_TYPE)) {
			return new EhCache();
		}
		return null;
	}
}
