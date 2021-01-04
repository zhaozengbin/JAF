/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.dto.easyui <br>
 * 文件名：DateGridColumn.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午5:59:25<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.dto.easyui;

/**
 *
 * 类名称：DataGridColumn <br>
 * 类描述：列表字段模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午5:59:25 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataGridColumn {

	/** 表格列名 */
	protected String title;

	/** 数据库对应字段 */
	protected String field;

	/** 宽度 */
	protected Integer width;

	/** 跨列 */
	protected String rowspan;

	/** 跨行 */
	protected String colspan;

	/** 对齐方式 */
	protected String align;

	/** 是否排序 */
	protected boolean sortable;

	/** 是否显示复选框 */
	protected boolean checkbox;

	/** 格式化函数 */
	protected String formatter;

	/** 是否隐藏 */
	protected boolean hidden;

	protected String treefield;

	/** 是否是图片 */
	protected boolean image;

	/** 是否查询 */
	protected boolean query;

	/** 替换表达式 */
	protected String replace;

	/** 字段查询模式：single单字段查询；group范围查询 */
	protected String queryMode = "single";

	/** 列表是否自动加载数据 */
	protected boolean autoLoadData = true;

	/** 是否是冰冻列 默认不是 */
	private boolean frozenColumn = false;

	/** 自定义链接 */
	protected String url;

	/** 自定义函数名称 */
	protected String funname = "openwindow";

	protected String arg;

	protected String dictionary;

	/** 扩展属性 */
	protected String extend;

	/** 自动完成 */
	private boolean autocomplete = false;

	/** 扩展参数 */
	private String extendParams;

	/**
	 * @retrun the title <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @retrun the field <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @retrun the width <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @retrun the rowspan <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getRowspan() {
		return rowspan;
	}

	/**
	 * @param rowspan
	 *            the rowspan to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}

	/**
	 * @retrun the colspan <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getColspan() {
		return colspan;
	}

	/**
	 * @param colspan
	 *            the colspan to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	/**
	 * @retrun the align <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getAlign() {
		return align;
	}

	/**
	 * @param align
	 *            the align to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * @retrun the sortable <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isSortable() {
		return sortable;
	}

	/**
	 * @param sortable
	 *            the sortable to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * @retrun the checkbox <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isCheckbox() {
		return checkbox;
	}

	/**
	 * @param checkbox
	 *            the checkbox to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * @retrun the formatter <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getFormatter() {
		return formatter;
	}

	/**
	 * @param formatter
	 *            the formatter to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	/**
	 * @retrun the hidden <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isHidden() {
		return hidden;
	}

	/**
	 * @param hidden
	 *            the hidden to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * @retrun the treefield <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getTreefield() {
		return treefield;
	}

	/**
	 * @param treefield
	 *            the treefield to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setTreefield(String treefield) {
		this.treefield = treefield;
	}

	/**
	 * @retrun the image <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setImage(boolean image) {
		this.image = image;
	}

	/**
	 * @retrun the query <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setQuery(boolean query) {
		this.query = query;
	}

	/**
	 * @retrun the replace <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getReplace() {
		return replace;
	}

	/**
	 * @param replace
	 *            the replace to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setReplace(String replace) {
		this.replace = replace;
	}

	/**
	 * @retrun the queryMode <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getQueryMode() {
		return queryMode;
	}

	/**
	 * @param queryMode
	 *            the queryMode to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	/**
	 * @retrun the autoLoadData <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isAutoLoadData() {
		return autoLoadData;
	}

	/**
	 * @param autoLoadData
	 *            the autoLoadData to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setAutoLoadData(boolean autoLoadData) {
		this.autoLoadData = autoLoadData;
	}

	/**
	 * @retrun the frozenColumn <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public boolean isFrozenColumn() {
		return frozenColumn;
	}

	/**
	 * @param frozenColumn
	 *            the frozenColumn to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setFrozenColumn(boolean frozenColumn) {
		this.frozenColumn = frozenColumn;
	}

	/**
	 * @retrun the url <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the funname <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getFunname() {
		return funname;
	}

	/**
	 * @param funname
	 *            the funname to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

	/**
	 * @retrun the arg <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getArg() {
		return arg;
	}

	/**
	 * @param arg
	 *            the arg to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setArg(String arg) {
		this.arg = arg;
	}

	/**
	 * @retrun the dictionary <br>
	 *
	 *         时间: 2013-7-22 下午6:04:12 <br>
	 */

	public String getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary
	 *            the dictionary to set <br>
	 *
	 *            时间: 2013-7-22 下午6:04:12
	 */
	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * @retrun the extend <br>
	 *
	 *         时间: 2014-4-4 下午6:06:33 <br>
	 */

	public String getExtend() {
		return extend;
	}

	/**
	 * @param extend
	 *            the extend to set <br>
	 *
	 *            时间: 2014-4-4 下午6:06:33
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}

	/**
	 * @retrun the autocomplete <br>
	 *
	 * 时间: 2014-4-4 下午6:08:05 <br>
	 */

	public boolean isAutocomplete() {
		return autocomplete;
	}

	/**
	 * @param autocomplete the autocomplete to set <br>
	 *
	 * 时间: 2014-4-4 下午6:08:05
	 */
	public void setAutocomplete(boolean autocomplete) {
		this.autocomplete = autocomplete;
	}

	/**
	 * @retrun the extendParams <br>
	 *
	 * 时间: 2014-4-4 下午6:08:05 <br>
	 */

	public String getExtendParams() {
		return extendParams;
	}

	/**
	 * @param extendParams the extendParams to set <br>
	 *
	 * 时间: 2014-4-4 下午6:08:05
	 */
	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

}
