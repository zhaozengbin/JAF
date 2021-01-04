/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.system <br>
 * 文件名：SysDictionary.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-23-下午5:03:46<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.system;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类名称：SysDictionary <br>
 * 类描述：系统字典 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-23 下午5:03:46 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysDictionary {

	/** 类型分组 */
	private SysDictionaryGroup sysDictionaryGroup;

	/** 父类型 */
	private SysDictionary sysDictionary;

	/** 类型名称 */
	private String typename;

	/** 类型编码 */
	private String typecode;

	private List<SysDictionary> sysDictionarys = new ArrayList<SysDictionary>();

	/**
	 * @retrun the sysDictionaryGroup <br>
	 * 
	 *         时间: 2013-7-23 下午5:12:03 <br>
	 */

	public SysDictionaryGroup getSysDictionaryGroup() {
		return sysDictionaryGroup;
	}

	/**
	 * @param sysDictionaryGroup
	 *            the sysDictionaryGroup to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:12:03
	 */
	public void setSysDictionaryGroup(SysDictionaryGroup sysDictionaryGroup) {
		this.sysDictionaryGroup = sysDictionaryGroup;
	}

	/**
	 * @retrun the sysDictionary <br>
	 * 
	 *         时间: 2013-7-23 下午5:12:03 <br>
	 */

	public SysDictionary getSysDictionary() {
		return sysDictionary;
	}

	/**
	 * @param sysDictionary
	 *            the sysDictionary to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:12:03
	 */
	public void setSysDictionary(SysDictionary sysDictionary) {
		this.sysDictionary = sysDictionary;
	}

	/**
	 * @retrun the typename <br>
	 * 
	 *         时间: 2013-7-23 下午5:12:03 <br>
	 */

	public String getTypename() {
		return typename;
	}

	/**
	 * @param typename
	 *            the typename to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:12:03
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}

	/**
	 * @retrun the typecode <br>
	 * 
	 *         时间: 2013-7-23 下午5:12:03 <br>
	 */

	public String getTypecode() {
		return typecode;
	}

	/**
	 * @param typecode
	 *            the typecode to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:12:03
	 */
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	/**
	 * @retrun the sysDictionarys <br>
	 * 
	 *         时间: 2013-7-23 下午5:12:03 <br>
	 */

	public List<SysDictionary> getSysDictionarys() {
		return sysDictionarys;
	}

	/**
	 * @param sysDictionarys
	 *            the sysDictionarys to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:12:03
	 */
	public void setSysDictionarys(List<SysDictionary> sysDictionarys) {
		this.sysDictionarys = sysDictionarys;
	}

}
