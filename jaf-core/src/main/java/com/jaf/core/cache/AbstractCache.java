/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.cache <br>
 * 文件名：AbstractCache.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-上午10:27:48<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.cache;

/**
 * 
 * 类名称：AbstractCache <br>
 * 类描述：缓存抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 上午10:27:48 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractCache {

	/** 缓存公用KEY -用户信息 */
	public static final String CACHE_KEY_USER = "cache_user";

	/**
	 * 方法：put <br>
	 * 描述：添加缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:42:12 <br>
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return
	 */
	public abstract boolean put(String key, Object value);

	/**
	 * 方法：put <br>
	 * 描述：添加缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:53:07 <br>
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param expiry
	 *            有效时间
	 * @return
	 */
	public abstract boolean put(String key, Object value, Integer expiry);

	/**
	 * 方法：replace <br>
	 * 描述：更新缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:53:31 <br>
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return
	 */
	public abstract boolean replace(String key, Object value);

	/**
	 * 方法：replace <br>
	 * 描述：更新缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:53:45 <br>
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param expiry
	 *            有效时间
	 * @return
	 */
	public abstract boolean replace(String key, Object value, Integer expiry);

	/**
	 * 方法：get <br>
	 * 描述：获取缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:54:18 <br>
	 * 
	 * @param key
	 * @return
	 */
	public abstract Object get(String key);

	/**
	 * 方法：delete <br>
	 * 描述：删除缓存 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午10:55:16 <br>
	 * 
	 * @param key
	 *            键
	 * @return
	 */
	public abstract boolean delete(String key);
}
