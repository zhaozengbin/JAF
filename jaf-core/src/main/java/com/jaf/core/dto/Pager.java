/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.dto <br>
 * 文件名：Pager.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-16-下午3:25:11<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.dto;

import com.jaf.core.entity.EDBType;

/**
 *
 * 类名称：Pager <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-16 下午3:25:11 <br>
 * 修改备注：TODO <br>
 *
 */
public class Pager {

	/** 当前页 */
	private Integer pageId = 1;

	/** 总行数 */
	private Integer rowCount = 0;

	/** 页大小 */
	private Integer pageSize = 10;

	/** 总页数 */
	private Integer pageCount = 0;

	/** 当前页起始记录 */
	private Integer pageOffset = 0;

	/** 当前页到达的记录 */
	private Integer pageTail = 0;

	/** 排序字段 */
	private String orderField;

	/** 排序条件 */
	private boolean orderDirection;

	/** 页面显示分页按钮个数 */
	private Integer length = 6;

	/** 开始分页数字 */
	private Integer startIndex = 0;

	/** 结束分页数字 */
	private Integer endIndex = 0;

	private Integer[] indexs;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午2:41:09 <br>
	 */
	public Pager() {
		this.orderDirection = true;
	}

	// Integer pid = navigate.getPageId() ; //当前页
	// Integer pcount = navigate.getPageCount(); //总页数
	// Integer length=8; //共显示几个分页数字
	// Integer startIndex = pid - (length/2);
	// Integer endIndex = 0;
	// if( startIndex < 1){
	// startIndex = 1;
	// }
	// endIndex = (startIndex+length) <= pcount ? (startIndex+length) : pcount;

	/**
	 * @retrun the length <br>
	 *
	 *         时间: 2013-6-20 下午2:38:51 <br>
	 */

	public Integer getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set <br>
	 *
	 *            时间: 2013-6-20 下午2:38:51
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @retrun the indexs <br>
	 *
	 *         时间: 2013-6-20 下午2:39:31 <br>
	 */

	public Integer[] getIndexs() {
		Integer len = getEndIndex() - getStartIndex() + 1;
		indexs = new Integer[len];
		for (Integer i = 0; i < len; i++) {
			indexs[i] = (getStartIndex() + i);
		}
		return indexs;
	}

	/**
	 * @param indexs
	 *            the indexs to set <br>
	 *
	 *            时间: 2013-6-20 下午2:39:31
	 */
	public void setIndexs(Integer[] indexs) {
		this.indexs = indexs;
	}

	/**
	 * @retrun the startIndex <br>
	 *
	 *         时间: 2013-6-20 下午2:40:33 <br>
	 */

	public Integer getStartIndex() {
		startIndex = pageId - (length / 2);
		if (startIndex < 1) {
			startIndex = 1;
		}
		return startIndex;
	}

	/**
	 * @param startIndex
	 *            the startIndex to set <br>
	 *
	 *            时间: 2013-6-20 下午2:40:33
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @retrun the endIndex <br>
	 *
	 *         时间: 2013-6-20 下午2:40:58 <br>
	 */

	public Integer getEndIndex() {
		if (getStartIndex() < 1) {
			setStartIndex(1);
		}
		endIndex = (getStartIndex() + length) <= getPageCount() ? (getStartIndex() + length)
				: getPageCount();
		return endIndex;
	}

	/**
	 * @param endIndex
	 *            the endIndex to set <br>
	 *
	 *            时间: 2013-6-20 下午2:40:58
	 */
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	/**
	 * 方法：doPage <br>
	 * 描述：数据库分页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 下午3:27:35 <br>
	 *
	 * @param dbType
	 *            数据库类型决定分页写法
	 */
	protected void doPage(EDBType dbType) {
		this.pageCount = this.rowCount / this.pageSize + 1;
		// 如果模板==0，且总数大于1，则减一
		if ((this.rowCount % this.pageSize == 0) && pageCount > 1)
			this.pageCount--;

		if (dbType == EDBType.Oracle) {
			// 如果输入也页面编号（pageId）大于总页数，将pageId设置为pageCount;
			if (this.pageId > this.pageCount)
				this.pageId = this.pageCount;
			this.pageOffset = (this.pageId - 1) * this.pageSize + 1;
			this.pageTail = this.pageOffset + this.pageSize - 1;
		} else if (dbType == EDBType.Mysql) {
			// Mysql 算法
			this.pageOffset = (this.pageId - 1) * this.pageSize;
			this.pageTail = this.pageOffset + this.pageSize;
			if ((this.pageOffset + this.pageSize) > this.rowCount) {
				this.pageTail = this.rowCount;
			}
		}
	}

	/**
	 * 方法：getOrderCondition <br>
	 * 描述：获取排序条件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午3:40:32 <br>
	 *
	 * @return
	 */
	public String getOrderCondition() {
		String condition = "";
		if (this.orderField != null && this.orderField.length() != 0) {
			condition = " order by " + orderField
					+ (orderDirection ? " " : " desc ");
		}
		return condition;
	}

	/**
	 * 方法：getMysqlQueryCondition <br>
	 * 描述：获取mysql排序查询条件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午3:41:07 <br>
	 *
	 * @return
	 */
	public String getMysqlQueryCondition() {
		String condition = "";
		condition = " limit " + pageOffset + "," + pageSize;
		return condition;
	}

	/**
	 * @retrun the pageId <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId
	 *            the pageId to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	/**
	 * @retrun the rowCount <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @retrun the pageSize <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @retrun the pageCount <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @retrun the pageOffset <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getPageOffset() {
		return pageOffset;
	}

	/**
	 * @param pageOffset
	 *            the pageOffset to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	/**
	 * @retrun the pageTail <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public Integer getPageTail() {
		return pageTail;
	}

	/**
	 * @param pageTail
	 *            the pageTail to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageTail(Integer pageTail) {
		this.pageTail = pageTail;
	}

	/**
	 * @retrun the orderField <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public String getOrderField() {
		return orderField;
	}

	/**
	 * @param orderField
	 *            the orderField to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * @retrun the orderDirection <br>
	 *
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public boolean isOrderDirection() {
		return orderDirection;
	}

	/**
	 * @param orderDirection
	 *            the orderDirection to set <br>
	 *
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setOrderDirection(boolean orderDirection) {
		this.orderDirection = orderDirection;
	}

}
