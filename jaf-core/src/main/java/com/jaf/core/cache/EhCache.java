/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.cache <br>
 * 文件名：EhCache.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-下午2:04:52<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.cache;

import java.util.ResourceBundle;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.event.RegisteredEventListeners;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import com.jaf.core.util.PropertiesUtils;

/**
 * 
 * 类名称：EhCache <br>
 * 类描述：ehcache缓存 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 下午2:04:52 <br>
 * 修改备注：TODO <br>
 * 
 */
public class EhCache extends AbstractCache {

	/** 缓存管理 */
	private static CacheManager singletonManager = CacheManager.create();

	/** Cache缓存 */
	private static Cache cache = null;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 下午2:50:21 <br>
	 */
	public EhCache() {
		// 设置相关属性
		ResourceBundle resourceBundle = PropertiesUtils
				.getResourceBundle(PropertiesUtils.EHCACHE_CONFIG);
		String name = resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_NAME);
		int maxElementsInMemory = Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_MAXELEMENTSINMEMORY));
		MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = getMemoryStoreEvictionPolicy(PropertiesUtils.EHCACHE_CONFIG_MEMORYSTOREEVICTIONPOLICY);
		boolean overflowToDisk = Boolean.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_OVERFLOWTODISK));
		String diskStorePath = resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_DISKSTOREPATH);
		boolean eternal = Boolean.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_ETERNAL));
		long timeToLiveSeconds = Long.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_TIMETOLIVESECONDS));
		long timeToIdleSeconds = Long.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_TIMETOIDLESECONDS));
		boolean diskPersistent = Boolean.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_DISKPERSISTENT));
		long diskExpiryThreadIntervalSeconds = Long
				.valueOf(resourceBundle
						.getString(PropertiesUtils.EHCACHE_CONFIG_DISKEXPIRYTHREADINTERVALSECONDS));
		RegisteredEventListeners registeredEventListeners = null;
		BootstrapCacheLoader bootstrapCacheLoader = null;
		int maxElementsOnDisk = Integer.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_MAXELEMENTSONDISK));
		int diskSpoolBufferSizeMB = Integer
				.valueOf(resourceBundle
						.getString(PropertiesUtils.EHCACHE_CONFIG_DISKSPOOLBUFFERSIZEMB));
		boolean clearOnFlush = Boolean.valueOf(resourceBundle
				.getString(PropertiesUtils.EHCACHE_CONFIG_CLEARONFLUSH));
		boolean isTerracottaClustered = false;
		boolean terracottaCoherentReads = false;

		cache = new Cache(name, maxElementsInMemory, memoryStoreEvictionPolicy,
				overflowToDisk, diskStorePath, eternal, timeToLiveSeconds,
				timeToIdleSeconds, diskPersistent,
				diskExpiryThreadIntervalSeconds, registeredEventListeners,
				bootstrapCacheLoader, maxElementsOnDisk, diskSpoolBufferSizeMB,
				clearOnFlush, isTerracottaClustered, terracottaCoherentReads);
		singletonManager.addCache(cache);
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
		Element element = new Element(key, value);
		cache.put(element);
		return true;
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
		Element element = new Element(key, value);
		cache.put(element);
		return true;
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
		Element element = new Element(key, value);
		cache.replace(element);
		return true;
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
		Element element = new Element(key, value);
		cache.replace(element);
		return true;
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
		return cache.get(key);
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
		return cache.remove(key);
	}

	/**
	 * 方法：getMemoryStoreEvictionPolicy <br>
	 * 描述：根据配置文件获取失效策略 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-18 下午6:07:36 <br>
	 * 
	 * @param type
	 * @return
	 */
	private MemoryStoreEvictionPolicy getMemoryStoreEvictionPolicy(String type) {
		if (type.equals("FIFO")) {
			return MemoryStoreEvictionPolicy.FIFO;
		} else if (type.equals("LFU")) {
			return MemoryStoreEvictionPolicy.LFU;
		} else if (type.equals("LRU")) {
			return MemoryStoreEvictionPolicy.LRU;
		}
		return null;
	}
}
