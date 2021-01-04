/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：DataGrid.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.dto.easyui;

import java.util.List;

import com.jaf.web.entity.ESort;

/**
 * 
 * 类名称：DataGrid <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:19:45 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DataGrid {

	/** 当前页 */
	private int page = 1;

	/** 每页显示记录数 */
	private int rows = 10;

	/** 排序字段名 */
	private String sort = null;

	/** 按什么排序(asc,desc) */
	private ESort order = ESort.asc;

	/** 字段 */
	private String field;

	/** 树形数据表文本字段 */
	private String treefield;

	/** 结果集 */
	private List<?> reaults;

	/** 总记录数 */
	private int total;

	/** 合计列 */
	private String footer;

	/**
	 * 返回: the page <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 参数: page the page to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 返回: the rows <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * 参数: rows the rows to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * 返回: the sort <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 参数: sort the sort to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 返回: the order <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public ESort getOrder() {
		return order;
	}

	/**
	 * 参数: order the order to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setOrder(ESort order) {
		this.order = order;
	}

	/**
	 * 返回: the field <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public String getField() {
		return field;
	}

	/**
	 * 参数: field the field to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * 返回: the treefield <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public String getTreefield() {
		return treefield;
	}

	/**
	 * 参数: treefield the treefield to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setTreefield(String treefield) {
		this.treefield = treefield;
	}

	/**
	 * 返回: the reaults <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public List<?> getReaults() {
		return reaults;
	}

	/**
	 * 参数: reaults the reaults to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setReaults(List<?> reaults) {
		this.reaults = reaults;
	}

	/**
	 * 返回: the total <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 参数: total the total to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 返回: the footer <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * 参数: footer the footer to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:55:06
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}

}
