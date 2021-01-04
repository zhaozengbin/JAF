/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：SystemUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午2:33:58<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 
 * 类名称：SystemUtils <br>
 * 类描述：系统工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午2:33:58 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SystemUtils {

	/**
	 * 方法：getOSName <br>
	 * 描述：获取当前系统名称 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:34:56 <br>
	 * 
	 * @return
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 方法：getOSLanguage <br>
	 * 描述：获取当前操作系统的语言 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:34:37 <br>
	 * 
	 * @return 操作系统语言，例如zh（中文），en（英文）
	 */
	public static String getOSLanguage() {

		return System.getProperty("user.language");

	}

	/**
	 * 方法：getOSVersion <br>
	 * 描述：获取当前操作系统的版本 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:35:12 <br>
	 * 
	 * @return
	 */
	public static String getOSVersion() {
		return System.getProperty("os.version");
	}

	/**
	 * 方法：getOSArch <br>
	 * 描述： 获取当前系统架构 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:35:22 <br>
	 * 
	 * @return
	 */
	public static String getOSArch() {
		return System.getProperty("os.arch");
	}

	/**
	 * 方法：getUnixMACAddress <br>
	 * 描述：获取unix网卡的当前主机的MAC地址 非windows的系统默认调用本方法，如果有特殊系统请继续扩充新的取得mac地址方法<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:35:37 <br>
	 * 
	 * @return
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ifconfig");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("hwaddr");
				// index = line.toLowerCase().indexOf("硬件地址");
				if (index >= 0) {
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					// mac = line.substring(index+"硬件地址".length()+1).trim();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (process != null) {
				process.destroy();
			}
		}
		return mac;

	}

	/**
	 * 方法：getWindowsMACAddress <br>
	 * 描述：获取windows系统下的网卡的mac地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:37:02 <br>
	 * 
	 * @return
	 */
	public static String getWindowsMACAddress() {
		String mac = "";
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("physical address");
				if (index >= 0) {
					index = line.indexOf(":");
					if (index >= 0) {
						mac = line.substring(index + 1).trim();
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (process != null) {
				process.destroy();
			}
		}
		return mac;
	}

	/**
	 * 方法：getMACAddress <br>
	 * 描述：获取系统下的网卡的mac地址自动兼容unix windows <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:39:43 <br>
	 * 
	 * @return
	 */
	public static String getMACAddress() {
		if (getOSName().contains("windows")) {
			return getWindowsMACAddress();
		} else {
			return getUnixMACAddress();
		}
	}

	/**
	 * 方法：getHostName <br>
	 * 描述：获取本机主机名称 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:37:44 <br>
	 * 
	 * @return
	 */
	public static String getHostName() {
		String hostname = "";
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
			if (ia == null) {
				hostname = "some error...";
			} else {
				hostname = ia.getHostName();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return hostname;

	}

	/**
	 * 方法：getIPAddress <br>
	 * 描述：获取本机IP地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:38:09 <br>
	 * 
	 * @return
	 */
	public static String getIPAddress() {
		String ipaddr = "";
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
			if (ia == null) {
				ipaddr = "some error...";
			} else {
				ipaddr = ia.getHostAddress();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipaddr;
	}

	/**
	 * 方法：getRealPath <br>
	 * 描述：返回项目的真实路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午3:55:41 <br>
	 * 
	 * @return
	 */
	public static String getRealPath() {
		// String path = System.getProperty("user.dir");
		// String realPath = path.replace("/build/classes", "")
		// .replace("%20", " ");
		URL path = Thread.currentThread().getContextClassLoader()
				.getResource("");
		return path.getFile();
	}

	/**
	 * 方法：getClassesPath <br>
	 * 描述：返回class的路径<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午3:55:41 <br>
	 * 
	 * @return
	 */
	public static String getClassesPath(Class<?> clazz) {
		// String path = System.getProperty("user.dir");
		// String realPath = path.replace("/build/classes", "")
		// .replace("%20", " ");
		if (clazz == null) {
			clazz = SystemUtils.class;
		}
		String path = clazz.getProtectionDomain().getCodeSource().getLocation()
				.getPath();
		return path;
	}

	/**
	 * 方法：getProjectRootPath <br>
	 * 描述：返回项目的真实路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午3:55:41 <br>
	 * 
	 * @return
	 */
	public static String getProjectRootPath() {
		String path = System.getProperty("user.dir");
		return path + File.separator;
	}

	/**
	 * 方法：getWebRoot <br>
	 * 描述：获取项目根路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午1:57:07 <br>
	 * 
	 * @return
	 */
	public static String getWebRoot() {
		String path = getClassesPath(SystemUtils.class);
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/classes"));
		}
		return path;
	}

	/**
	 * 方法：getWebClass <br>
	 * 描述： 获取项目classes路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午1:57:17 <br>
	 * 
	 * @return
	 */
	public static String getWebClass() {
		String path = getClassesPath(SystemUtils.class);
		if (path.indexOf("classes") > 0) {
			path = path.substring(0,
					path.indexOf("classes") + "classes".length() + 1);
		}
		return path;
	}

}
