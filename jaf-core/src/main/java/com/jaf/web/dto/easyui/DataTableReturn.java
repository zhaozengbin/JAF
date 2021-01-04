/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：DataTableReturn.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.dto.easyui;

import java.util.List;

/**
 * 
 * 类名称：DataTableReturn <br>
 * 类描述：期望的返回数据格式 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:21:41 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DataTableReturn {

	/* 过滤前总记录数 */
	private Integer iTotalRecords;

	/** 过滤后总记录数 */
	private Integer iTotalDisplayRecords;

	/** 页面发来的参数，原样返回 */
	private Integer sEcho;

	/** 返回的具体数据 */
	private List<?> aaData;

	/**
	 * 返回: the iTotalRecords <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	/**
	 * 参数: iTotalRecords the iTotalRecords to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	/**
	 * 返回: the iTotalDisplayRecords <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	/**
	 * 参数: iTotalDisplayRecords the iTotalDisplayRecords to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	/**
	 * 返回: the sEcho <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public Integer getsEcho() {
		return sEcho;
	}

	/**
	 * 参数: sEcho the sEcho to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	/**
	 * 返回: the aaData <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public List<?> getAaData() {
		return aaData;
	}

	/**
	 * 参数: aaData the aaData to set <br>
	 * 
	 * 时间: 2013-7-26 下午3:57:03
	 */
	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}

}
