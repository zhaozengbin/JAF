/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：PropertiesUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午4:55:56<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * 类名称：PropertiesUtils <br>
 * 类描述：Properties工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午4:55:56 <br>
 * 修改备注：TODO <br>
 * 
 */
public class PropertiesUtils {

	/** 注释配置文件 */
	public static final String NOTE_CONFIG = "noteconfig";

	/** 注释配置文件KEY值-作者 */
	public static final String NOTE_CONFIG_AUTHOR = "author";

	/** 注释配置文件KEY值-创建者 */
	public static final String NOTE_CONFIG_CREATE_USER = "create.user";

	/** 注释配置文件KEY值-修改者 */
	public static final String NOTE_CONFIG_MODIFY_USER = "modify.user";

	/** 注释配置文件KEY值-版权 */
	public static final String NOTE_CONFIG_COPYRIGHT = "copyright";

	/** 系统配置文件 */
	public static final String SYSTEM_CONFIG = "sysconfig";

	/** 系统配置文件KEY值-控制层框架类型 */
	public static final String SYSTEM_CONFIG_MODEL_FRAME_TYPE = "model.frame.type";

	/** 系统配置文件KEY值-显示层框架类型 */
	public static final String SYSTEM_CONFIG_VIEW_FRAME_TYPE = "view.frame.type";

	/** 系统配置文件KEY值-控制层框架类型 */
	public static final String SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE = "controller.frame.type";

	/** 系统配置文件KEY值-数据库类型 */
	public static final String SYSTEM_CONFIG_SQL_TYPE = "sql.type";

	/** 系统配置文件KEY值-数据源类型 */
	public static final String SYSTEM_CONFIG_DATASOURCE_TYPE = "datasource.type";

	/** 缓存类型 */
	public static final String SYSTEM_CACHE_TYPE = "cache.type";

	/** 权限配置文件 */
	public static final String AUTH_CONFIG = "authconfig";

	/** 权限配置文件KEY值-按钮权限开关 */
	public static final String AUTH_CONFIG_BUTTON = "auth.button";

	/** 数据源配置文件KEY值-驱动 */
	public static final String DATA_SOURCE_JDBC_DRIVER = "jdbc.driver";

	/** 数据源配置文件KEY值-链接地址 */
	public static final String DATA_SOURCE_JDBC_URL = "jdbc.url";

	/** 数据源配置文件KEY值-用户名 */
	public static final String DATA_SOURCE_JDBC_USERNAME = "jdbc.username";

	/** 数据源配置文件KEY值-密码 */
	public static final String DATA_SOURCE_JDBC_PASSWORD = "jdbc.password";

	/** Memcached配置文件 */
	public static final String MECACHED_CONFIG = "mecached";

	/** 缓存服务地址 如果不需要则为空 */
	public static final String MECACHED_CONFIG_URLS = "cache.urls";

	/** 权重 */
	public static final String MECACHED_CONFIG_WEIGHTS = "cache.weights";

	/** 初始链接 */
	public static final String MECACHED_CONFIG_INITCONNECTION = "cache.initConnection";

	/** 最小连接数 */
	public static final String MECACHED_CONFIG_MINCONNECTION = "cache.minConnection";

	/** 最大连接数 */
	public static final String MECACHED_CONFIG_MAXCONNECTION = "cache.maxConnection";

	/** 最大处理时间 */
	public static final String MECACHED_CONFIG_MAXIDLE = "cache.maxIdle";

	/** 连接池守护线程的睡眠时间 */
	public static final String MECACHED_CONFIG_MAINTSLEEP = "cache.maintSleep";

	/** TCP参数，连接超时 */
	public static final String MECACHED_CONFIG_NAGLE = "cache.nagle";

	/** 连接池守护线程的睡眠时间 */
	public static final String MECACHED_CONFIG_SOCKET = "cache.socket";

	/** 连接池守护线程的睡眠时间 */
	public static final String MECACHED_CONFIG_SOCKETCONNECTION = "cache.socketConnection";

	/** Ehcache配置文件 */
	public static final String EHCACHE_CONFIG = "ehcache";

	/** 缓存名 */
	public static final String EHCACHE_CONFIG_NAME = "cache.name";

	/** 最多保存多少元素 */
	public static final String EHCACHE_CONFIG_MAXELEMENTSINMEMORY = "cache.maxElementsInMemory";

	/** 失效策略 FIFO:先进先出 LFU:最少被使用 LRU:最近最少被使用 */
	public static final String EHCACHE_CONFIG_MEMORYSTOREEVICTIONPOLICY = "cache.memoryStoreEvictionPolicy";

	/** 当缓存中元素的数量超过限制时, 是否把这些元素持久化到硬盘 */
	public static final String EHCACHE_CONFIG_OVERFLOWTODISK = "cache.overflowToDisk";

	/** 缓存到硬盘的位置 */
	public static final String EHCACHE_CONFIG_DISKSTOREPATH = "cache.diskStorePath";

	/** Element是否永久有效，一但设置了，timeout将不起作用 */
	public static final String EHCACHE_CONFIG_ETERNAL = "cache.eternal";

	/**
	 * Element在失效前允许存活时间。最大时间介于创建时间和失效时间之间。仅当element不是永久有效时使用，默认是0.，
	 * 也就是element存活时间无穷大
	 */
	public static final String EHCACHE_CONFIG_TIMETOLIVESECONDS = "cache.timeToLiveSeconds";

	/** Element在失效前的允许闲置时间。仅当element不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大 */
	public static final String EHCACHE_CONFIG_TIMETOIDLESECONDS = "cache.timeToIdleSeconds";

	/** 是否缓存虚拟机重启期数据 */
	public static final String EHCACHE_CONFIG_DISKPERSISTENT = "cache.diskPersistent";

	/** 磁盘失效线程运行时间间隔，默认是120秒 */
	public static final String EHCACHE_CONFIG_DISKEXPIRYTHREADINTERVALSECONDS = "cache.diskExpiryThreadIntervalSeconds";

	/**
	 * 里面包含了一些CacheEventListener,当在cache上有
	 * operation发生时，这些listener就被通知。这也是ehcache实现分布式缓存的实现方式。当前ehcache支持三种类型的
	 * CacheEventListenr:jms,rmi,jgroup.这也就是ehcache三种分布式缓存的实现方式
	 */
	public static final String EHCACHE_CONFIG_REGISTEREDEVENTLISTENERS = "cache.registeredEventListeners";

	/** 指定相应的BootstrapCacheLoader，用于在初始化缓存，以及自动设置 */
	public static final String EHCACHE_CONFIG_BOOTSTRAPCACHELOADER = "cache.bootstrapCacheLoader";

	/** 磁盘中最大缓存对象数，若是0表示无穷大 */
	public static final String EHCACHE_CONFIG_MAXELEMENTSONDISK = "cache.maxElementsOnDisk";

	/** 这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区 */
	public static final String EHCACHE_CONFIG_DISKSPOOLBUFFERSIZEMB = "cache.diskSpoolBufferSizeMB";

	/** 内存数量最大时是否清除 */
	public static final String EHCACHE_CONFIG_CLEARONFLUSH = "cache.clearOnFlush";

	/**
	 * 方法：getResourceBundle <br>
	 * 描述：获取配置文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午5:00:00 <br>
	 * 
	 * @param configName
	 *            配置文件名
	 * @return
	 */
	public static ResourceBundle getResourceBundle(String configName) {
		Locale locale = Locale.getDefault();
		return ResourceBundle.getBundle(configName, locale);
	}
}
