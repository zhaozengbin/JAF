/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.system <br>
 * 文件名：SysDictionaryGroup.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-23-下午5:04:40<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 类名称：SysDictionaryGroup <br>
 * 类描述：系统字典分组 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-23 下午5:04:40 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysDictionaryGroup {

	public static Map<String, SysDictionaryGroup> allSysDictionaryGroups = new HashMap<String, SysDictionaryGroup>();
	public static Map<String, List<SysDictionary>> allSysDictionarys = new HashMap<String, List<SysDictionary>>();

	/** 主键编号 */
	private int id;

	/** 字典分组名字 */
	private String name;

	/** 字典分组编号 */
	private String code;

	/** 系统字典 */
	private List<SysDictionary> sysDictionarys = new ArrayList<SysDictionary>();

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-7-23 下午5:11:06 <br>
	 */

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:11:06
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-7-23 下午5:11:06 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:11:06
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the code <br>
	 * 
	 *         时间: 2013-7-23 下午5:11:06 <br>
	 */

	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:11:06
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @retrun the sysDictionarys <br>
	 * 
	 *         时间: 2013-7-23 下午5:11:06 <br>
	 */

	public List<SysDictionary> getSysDictionarys() {
		return sysDictionarys;
	}

	/**
	 * @param sysDictionarys
	 *            the sysDictionarys to set <br>
	 * 
	 *            时间: 2013-7-23 下午5:11:06
	 */
	public void setSysDictionarys(List<SysDictionary> sysDictionarys) {
		this.sysDictionarys = sysDictionarys;
	}

}
