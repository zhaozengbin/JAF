/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.cache <br>
 * 文件名：Memcached.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-上午10:23:16<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.cache;

import java.util.ResourceBundle;

import com.jaf.core.util.PropertiesUtils;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * 
 * 类名称：Memcached <br>
 * 类描述：Memcached缓存类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 上午10:23:16 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Memcached extends AbstractCache {

	/** memcached客户端单例 */
	private static MemCachedClient cachedClient = new MemCachedClient();

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 上午11:22:43 <br>
	 */
	public Memcached() {

		// 读取系统配置文件
		ResourceBundle resourceBundle = PropertiesUtils
				.getResourceBundle(PropertiesUtils.MECACHED_CONFIG);

		// 获取连接池的实例
		SockIOPool pool = SockIOPool.getInstance();

		// 设置服务器信息
		pool.setServers(getUrls(resourceBundle));
		pool.setWeights(getWeights(resourceBundle));

		// 设置初始连接数、最小连接数、最大连接数、最大处理时间
		pool.setInitConn(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_INITCONNECTION)));
		pool.setMinConn(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_MINCONNECTION)));
		pool.setMaxConn(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_MAXCONNECTION)));
		pool.setMaxIdle(1000 * 60 * Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_MAXIDLE)));

		// 设置连接池守护线程的睡眠时间
		pool.setMaintSleep(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_MAINTSLEEP)));

		// 设置TCP参数，连接超时
		pool.setNagle(Boolean.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_NAGLE)));
		pool.setSocketTO(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_SOCKET)));
		pool.setSocketConnectTO(Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_SOCKETCONNECTION)));

		// 初始化并启动连接池
		pool.initialize();

		// 压缩设置，超过指定大小的都压缩
		// cachedClient.setCompressEnable(true);
		// cachedClient.setCompressThreshold(1024*1024);
	}

	/**
	 * 方法：put <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#put(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public boolean put(String key, Object value) {
		return cachedClient.set(key, value);
	}

	/**
	 * 方法：put <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @param value
	 * @param expiry
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#put(java.lang.String,
	 *      java.lang.Object, java.lang.Integer)
	 */
	@Override
	public boolean put(String key, Object value, Integer expiry) {
		return cachedClient.set(key, value, expiry);
	}

	/**
	 * 方法：replace <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#update(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public boolean replace(String key, Object value) {
		return cachedClient.replace(key, value);
	}

	/**
	 * 方法：replace <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @param value
	 * @param expiry
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#update(java.lang.String,
	 *      java.lang.Object, java.lang.Integer)
	 */
	@Override
	public boolean replace(String key, Object value, Integer expiry) {
		return cachedClient.replace(key, value, expiry);
	}

	/**
	 * 方法：get <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		return cachedClient.get(key);
	}

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 
	 * @param key
	 * @return
	 * @see com.jaf.core.cache.AbstractCache#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String key) {
		return cachedClient.delete(key);
	}

	/**
	 * 方法：getUrls <br>
	 * 描述：获取地址列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 下午3:24:11 <br>
	 * 
	 * @param resourceBundle
	 * @return
	 */
	private String[] getUrls(ResourceBundle resourceBundle) {
		// 设置缓存服务器地址 兼容多个
		String[] urls = null;
		String urlsString = resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_URLS);
		if (urlsString.contains(",")) {
			urls = urlsString.split(",");
		} else {
			urls = new String[] { urlsString };
		}
		return urls;
	}

	/**
	 * 方法：getWeights <br>
	 * 描述：获取权重列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 下午3:25:19 <br>
	 * 
	 * @param resourceBundle
	 * @return
	 */
	private Integer[] getWeights(ResourceBundle resourceBundle) {
		// 设置权重 兼容多个
		Integer[] weights = null;
		String weightsString = resourceBundle
				.getString(PropertiesUtils.MECACHED_CONFIG_WEIGHTS);
		if (weightsString.contains(",")) {
			String[] weightsArray = weightsString.split(",");
			weights = new Integer[weightsArray.length];
			for (int i = 0; i < weightsArray.length; i++) {
				weights[i] = Integer.valueOf(weightsArray[i]);
			}
		} else {
			weights = new Integer[] { Integer.valueOf(weightsString) };
		}
		return weights;
	}

}
