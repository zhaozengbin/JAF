/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.dto <br>
 * 文件名：BaseDto.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-30-下午3:48:53<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.dto;

import org.apache.commons.lang.StringUtils;

import com.jaf.core.util.ObjectUtils;

/**
 * 
 * 类名称：BaseDto <br>
 * 类描述：查询对象 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-30 下午3:48:53 <br>
 * 修改备注：TODO <br>
 * 
 */
public class BaseDto {

	private Integer id;

	/** 页数 */
	private Integer page = 1;

	/** 行数 */
	private Integer rows = 10;

	/** 排序字段 */
	private String sort;

	/** 排序规则 */
	private String order;

	/** 分页导航 */
	private Pager pager = new Pager();

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-10-25 上午9:58:29 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-10-25 上午9:58:29
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the pager <br>
	 * 
	 *         时间: 2013-6-20 下午4:14:12 <br>
	 */

	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		String orderField = "";
		if (ObjectUtils.isNotEmpty(sort)) {
			orderField = sort;
		}
		if (ObjectUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)) {
			orderField += " " + order;
		}
		pager.setOrderField(orderField);
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
