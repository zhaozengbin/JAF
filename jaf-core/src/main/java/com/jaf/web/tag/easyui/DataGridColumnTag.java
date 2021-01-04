/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DataGridColumnTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import com.jaf.web.tag.AbstractTag;

/**
 *
 * 类名称：DataGridColumnTag <br>
 * 类描述： 列表字段处理项目 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:30:27 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataGridColumnTag extends AbstractTag {

	/** 序列号 */
	private static final long serialVersionUID = 1L;

	/** 列的标题文字 */
	protected String title;

	/** 列的字段名 */
	protected String field;

	/** 列的宽度 */
	protected Integer width;

	/** 指一个单元格占据多少行 */
	protected String rowspan;

	/** 指一个单元格占据多少列 */
	protected String colspan;

	/** 指如何对齐此列的数据，可以用 'left'、'right'、'center' */
	protected String align;

	/** True 就允许此列被排序 */
	protected boolean sortable = true;

	/** True 就显示 checkbox */
	protected boolean checkbox;

	/** 单元格的格式化函数，需要三个参数： value： 字段的值 rowData： 行的记录数据 rowIndex： 行的索引 */
	protected String formatter;

	/** True 就隐藏此列 */
	protected boolean hidden = true;

	/** 替换 */
	protected String replace;

	/** 树字段 */
	protected String treefield;

	/** 图片 */
	protected boolean image;

	/** 查询 */
	protected boolean query = false;

	/** 字段查询模式：single单字段查询；scope范围查询 */
	private String queryMode = "single";

	/** 搜索 */
	protected boolean bSearchable = true;

	/** 实现冰冻列 是否是冰冻列 默认不是 */
	private boolean frozenColumn = false;

	/** 自定义链接 */
	protected String url;

	/** 自定义函数名称 */
	protected String funname = "openwindow";

	/** 自定义链接传入参数字段 */
	protected String arg;

	/** 数据字典组编码 */
	protected String dictionary;

	/** 扩展属性 */
	protected String extend;

	/** 自动完成 */
	private boolean autocomplete = false;

	/** 扩展参数 */
	private String extendParams;

	/**
	 * 方法: doEndTag <br>
	 * 描述: TODO
	 *
	 * @return
	 * @throws JspException
	 * @see com.jaf.web.tag.AbstractTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		DataGridTag parent = (DataGridTag) t;
		parent.setColumn(title, field, width, rowspan, colspan, align,
				sortable, checkbox, formatter, hidden, replace, treefield,
				image, query, url, funname, arg, queryMode, dictionary,
				frozenColumn, extend, autocomplete, extendParams);
		return EVAL_PAGE;
	}

	/**
	 * 方法: assembleStart <br>
	 * 描述: TODO
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		return null;
	}

	/**
	 * 方法: assembleEnd <br>
	 * 描述: TODO
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleEnd()
	 */
	@Override
	protected String assembleEnd() {
		return null;
	}

	/**
	 * 返回: the title <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the field <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getField() {
		return field;
	}

	/**
	 * 参数: field the field to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * 返回: the width <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 参数: width the width to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 返回: the rowspan <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getRowspan() {
		return rowspan;
	}

	/**
	 * 参数: rowspan the rowspan to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}

	/**
	 * 返回: the colspan <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getColspan() {
		return colspan;
	}

	/**
	 * 参数: colspan the colspan to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	/**
	 * 返回: the align <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * 参数: align the align to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * 返回: the sortable <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isSortable() {
		return sortable;
	}

	/**
	 * 参数: sortable the sortable to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * 返回: the checkbox <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isCheckbox() {
		return checkbox;
	}

	/**
	 * 参数: checkbox the checkbox to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * 返回: the formatter <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getFormatter() {
		return formatter;
	}

	/**
	 * 参数: formatter the formatter to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	/**
	 * 返回: the hidden <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * 参数: hidden the hidden to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * 返回: the replace <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getReplace() {
		return replace;
	}

	/**
	 * 参数: replace the replace to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setReplace(String replace) {
		this.replace = replace;
	}

	/**
	 * 返回: the treefield <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getTreefield() {
		return treefield;
	}

	/**
	 * 参数: treefield the treefield to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setTreefield(String treefield) {
		this.treefield = treefield;
	}

	/**
	 * 返回: the image <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isImage() {
		return image;
	}

	/**
	 * 参数: image the image to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setImage(boolean image) {
		this.image = image;
	}

	/**
	 * 返回: the query <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isQuery() {
		return query;
	}

	/**
	 * 参数: query the query to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setQuery(boolean query) {
		this.query = query;
	}

	/**
	 * 返回: the queryMode <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getQueryMode() {
		return queryMode;
	}

	/**
	 * 参数: queryMode the queryMode to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	/**
	 * 返回: the bSearchable <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isbSearchable() {
		return bSearchable;
	}

	/**
	 * 参数: bSearchable the bSearchable to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setbSearchable(boolean bSearchable) {
		this.bSearchable = bSearchable;
	}

	/**
	 * 返回: the frozenColumn <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public boolean isFrozenColumn() {
		return frozenColumn;
	}

	/**
	 * 参数: frozenColumn the frozenColumn to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setFrozenColumn(boolean frozenColumn) {
		this.frozenColumn = frozenColumn;
	}

	/**
	 * 返回: the url <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 参数: url the url to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回: the funname <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getFunname() {
		return funname;
	}

	/**
	 * 参数: funname the funname to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setFunname(String funname) {
		this.funname = funname;
	}

	/**
	 * 返回: the arg <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getArg() {
		return arg;
	}

	/**
	 * 参数: arg the arg to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setArg(String arg) {
		this.arg = arg;
	}

	/**
	 * 返回: the dictionary <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public String getDictionary() {
		return dictionary;
	}

	/**
	 * 参数: dictionary the dictionary to set <br>
	 *
	 * 时间: 2013-7-25 下午12:10:22
	 */
	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * @retrun the extend <br>
	 *
	 *         时间: 2014-4-4 下午6:22:24 <br>
	 */

	public String getExtend() {
		return extend;
	}

	/**
	 * @param extend
	 *            the extend to set <br>
	 *
	 *            时间: 2014-4-4 下午6:22:24
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}

	/**
	 * @retrun the autocomplete <br>
	 *
	 *         时间: 2014-4-4 下午6:22:24 <br>
	 */

	public boolean isAutocomplete() {
		return autocomplete;
	}

	/**
	 * @param autocomplete
	 *            the autocomplete to set <br>
	 *
	 *            时间: 2014-4-4 下午6:22:24
	 */
	public void setAutocomplete(boolean autocomplete) {
		this.autocomplete = autocomplete;
	}

	/**
	 * @retrun the extendParams <br>
	 *
	 *         时间: 2014-4-4 下午6:22:24 <br>
	 */

	public String getExtendParams() {
		return extendParams;
	}

	/**
	 * @param extendParams
	 *            the extendParams to set <br>
	 *
	 *            时间: 2014-4-4 下午6:22:24
	 */
	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

}
