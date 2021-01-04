/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：Autocomplete.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.easyui;

/**
 * 
 * 类名称：Autocomplete <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:13:56 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Autocomplete {

	/** 实体名称 */
	private String entityName;

	/** 提示显示的字段 */
	private String labelField;

	/** 传递后台的字段 */
	private String valueField;

	/** 查询关键字字段 */
	private String searchField;

	/** 查询传递的值 */
	private String trem;

	private Integer maxRows;

	private Integer curPage;

	/**
	 * 返回: the entityName <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * 参数: entityName the entityName to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * 返回: the labelField <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public String getLabelField() {
		return labelField;
	}

	/**
	 * 参数: labelField the labelField to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setLabelField(String labelField) {
		this.labelField = labelField;
	}

	/**
	 * 返回: the valueField <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public String getValueField() {
		return valueField;
	}

	/**
	 * 参数: valueField the valueField to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	/**
	 * 返回: the searchField <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public String getSearchField() {
		return searchField;
	}

	/**
	 * 参数: searchField the searchField to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	/**
	 * 返回: the trem <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public String getTrem() {
		return trem;
	}

	/**
	 * 参数: trem the trem to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setTrem(String trem) {
		this.trem = trem;
	}

	/**
	 * 返回: the maxRows <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public Integer getMaxRows() {
		return maxRows;
	}

	/**
	 * 参数: maxRows the maxRows to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setMaxRows(Integer maxRows) {
		this.maxRows = maxRows;
	}

	/**
	 * 返回: the curPage <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public Integer getCurPage() {
		if (curPage == null || curPage < 1) {
			curPage = 1;
		}
		return curPage;
	}

	/**
	 * 参数: curPage the curPage to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:22:17
	 */
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

}
