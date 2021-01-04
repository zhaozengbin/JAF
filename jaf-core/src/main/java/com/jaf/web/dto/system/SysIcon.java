/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.dto.system <br>
 * 文件名：SysIcon.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午2:14:25<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.system;

/**
 * 
 * 类名称：SysIcon <br>
 * 类描述：系统图标 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午2:14:25 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysIcon {

	/** 图标地址 */
	private String path;

	private String clas;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 下午3:42:07 <br>
	 */
	public SysIcon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 下午3:42:04 <br>
	 * 
	 * @param id
	 * @param path
	 * @param clas
	 */
	public SysIcon(String path, String clas) {
		super();
		this.path = path;
		this.clas = clas;
	}

	/**
	 * @retrun the path <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @retrun the clas <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public String getClas() {
		return clas;
	}

	/**
	 * @param clas
	 *            the clas to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setClas(String clas) {
		this.clas = clas;
	}

}
