/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.pojo <br>
 * 文件名：SysIcon.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午2:14:25<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.pojo;

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
public class SysIcon extends BaseBean {

	/** 图标名称 */
	private String name;

	/** 图标类型 */
	private Short type;

	/** 图标地址 */
	private String path;

	/** 图标描述 */
	private byte[] content;

	private String clas;

	private String extend;

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the type <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public Short getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setType(Short type) {
		this.type = type;
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
	 * @retrun the content <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setContent(byte[] content) {
		this.content = content;
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

	/**
	 * @retrun the extend <br>
	 * 
	 *         时间: 2013-7-22 下午2:17:03 <br>
	 */

	public String getExtend() {
		return extend;
	}

	/**
	 * @param extend
	 *            the extend to set <br>
	 * 
	 *            时间: 2013-7-22 下午2:17:03
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}

}
