/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DataGridTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午6:06:18<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.easyui;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.sf.json.JSONObject;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.easyui.ColumnValue;
import com.jaf.web.dto.easyui.DataGridColumn;
import com.jaf.web.dto.easyui.DataGridUrl;
import com.jaf.web.dto.system.SysDictionary;
import com.jaf.web.dto.system.SysDictionaryGroup;
import com.jaf.web.entity.EOptType;
import com.jaf.web.tag.util.TagUtils;
import com.jaf.web.util.ContextHolderUtils;

/**
 *
 * 类名称：DataGridTag <br>
 * 类描述：DATAGRID标签处理类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午6:06:18 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataGridTag extends TagSupport {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 显示字段 */
	protected String fields = "";

	/** 表格标示 */
	protected String name;

	/** 表格标示 */
	protected String title;

	/** 主键字段 */
	protected String idField = "id";

	/** 是否是树形列表 */
	protected boolean treegrid = false;

	/** 列表操作显示 */
	protected List<DataGridUrl> urlList = new ArrayList<DataGridUrl>();

	/** 工具条列表 */
	protected List<DataGridUrl> toolBarList = new ArrayList<DataGridUrl>();

	/** 列表操作显示 */
	protected List<DataGridColumn> columnList = new ArrayList<DataGridColumn>();

	/** 值替换集合 */
	protected List<ColumnValue> columnValueList = new ArrayList<ColumnValue>();

	/** 封装查询条件 */
	public Map<String, Object> map;

	/** 分页提交路径 */
	private String actionUrl;

	/** 所有条数 */
	public int allCount;

	/** 当前页 */
	public int curPage;

	/** 每页条数 */
	public int pageSize = 10;

	/** 是否显示分页 */
	public boolean pagination = true;

	/** 宽 */
	private String width;

	/** 高 */
	private String height;

	/** 是否显示复选框 */
	private boolean checkbox = false;

	/** 定义是否显示页面列表 */
	private boolean showPageList = true;

	/** 是否允许表格自动缩放，以适应父容器 */
	private boolean fit = true;

	/** 当为true时，自动展开/合同列的大小，以适应的宽度，防止横向滚动. */
	private boolean fitColumns = true;

	/** 定义的列进行排序 */
	private String sortName;

	/** 定义列的排序顺序，只能是"递增"或"降序". */
	private String sortOrder = "asc";

	/** 定义是否显示刷新按钮 */
	private boolean showRefresh = true;

	/** 定义是否显示刷新按钮 */
	private boolean showText = true;

	/** 列表样式easyui,datatables */
	private String style = "easyui";

	/** 数据加载完成调用方法 */
	private String onLoadSuccess;

	/** 单击事件调用方法 */
	private String onClick;

	/** 双击事件调用方法 */
	private String onDblClick;

	/** 查询模式 */
	private String queryMode = "single";

	/** 列表是否自动加载数据 */
	private boolean autoLoadData = true;

	/** rowStyler函数 */
	private String rowStyler;

	/** 扩展参数,easyui有的,但是暂时没有的参数进行扩展 */
	private String extendParams;

	/** 添加对区间查询的支持 */
	protected String searchFields = "";

	/** 是不是展开第一个节点 */
	private boolean openFirstNode = false;

	/** 对应的实体对象 */
	private String entityName;

	/** json转换中的系统保留字 */
	protected static Map<String, String> syscode = new HashMap<String, String>();

	static {
		syscode.put("class", "clazz");
	}

	/**
	 * 方法：setButton <br>
	 * 描述：设置操作按钮 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午4:59:00 <br>
	 *
	 * @param eOptType
	 *            操作类型
	 * @param url
	 * @param title
	 * @param message
	 * @param exp
	 * @param funname
	 */
	public void setButton(EOptType eOptType, String url, String title,
			String message, String exp, String funname) {
		DataGridUrl dateGridUrl = new DataGridUrl();
		dateGridUrl.setTitle(title);
		dateGridUrl.setUrl(url);
		dateGridUrl.setType(eOptType);
		dateGridUrl.setMessage(message);
		dateGridUrl.setExp(exp);
		dateGridUrl.setFunname(funname);
		urlList.add(dateGridUrl);
	}

	/**
	 * 方法：setToolbar <br>
	 * 描述：设置工具条 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:00:28 <br>
	 *
	 * @param url
	 * @param title
	 * @param icon
	 * @param exp
	 * @param onclick
	 * @param funname
	 */
	public void setToolbar(String url, String title, String icon, String exp,
			String onclick, String funname) {
		DataGridUrl dateGridUrl = new DataGridUrl();
		dateGridUrl.setTitle(title);
		dateGridUrl.setUrl(url);
		dateGridUrl.setType(EOptType.ToolBar);
		dateGridUrl.setIcon(icon);
		dateGridUrl.setOnclick(onclick);
		dateGridUrl.setExp(exp);
		dateGridUrl.setFunname(funname);
		toolBarList.add(dateGridUrl);
	}

	/**
	 * 方法：setColumn <br>
	 * 描述：设置字段 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:01:37 <br>
	 *
	 * @param title
	 * @param field
	 * @param width
	 * @param rowspan
	 * @param colspan
	 * @param align
	 * @param sortable
	 * @param checkbox
	 * @param formatter
	 * @param hidden
	 * @param replace
	 * @param treefield
	 * @param image
	 * @param query
	 * @param url
	 * @param funname
	 * @param arg
	 * @param queryMode
	 * @param dictionary
	 * @param frozenColumn
	 */
	public void setColumn(String title, String field, Integer width,
			String rowspan, String colspan, String align, boolean sortable,
			boolean checkbox, String formatter, boolean hidden, String replace,
			String treefield, boolean image, boolean query, String url,
			String funname, String arg, String queryMode, String dictionary,
			boolean frozenColumn, String extend, boolean isAuto,
			String extendParams) {
		DataGridColumn dateGridColumn = new DataGridColumn();
		dateGridColumn.setAlign(align);
		dateGridColumn.setCheckbox(checkbox);
		dateGridColumn.setColspan(colspan);
		dateGridColumn.setField(field);
		dateGridColumn.setFormatter(formatter);
		dateGridColumn.setHidden(hidden);
		dateGridColumn.setRowspan(rowspan);
		dateGridColumn.setSortable(sortable);
		dateGridColumn.setTitle(title);
		dateGridColumn.setWidth(width);
		dateGridColumn.setTreefield(treefield);
		dateGridColumn.setImage(image);
		dateGridColumn.setReplace(replace);
		dateGridColumn.setQuery(query);
		dateGridColumn.setUrl(url);
		dateGridColumn.setFunname(funname);
		dateGridColumn.setArg(arg);
		dateGridColumn.setExtend(extend);
		dateGridColumn.setAutocomplete(isAuto);
		dateGridColumn.setExtendParams(extendParams);
		dateGridColumn.setQueryMode(queryMode);
		dateGridColumn.setFrozenColumn(frozenColumn);
		dateGridColumn.setDictionary(dictionary);
		columnList.add(dateGridColumn);
		if (field != "opt") {
			fields += field + ",";
		}
		if (ObjectUtils.isNotEmpty(replace)) {
			String[] test = replace.split(",");
			String text = "";
			String value = "";
			for (String string : test) {
				text += string.substring(0, string.indexOf("_")) + ",";
				value += string.substring(string.indexOf("_") + 1) + ",";
			}
			setColumn(field, text, value);

		}
		if (ObjectUtils.isNotEmpty(dictionary)) {
			String text = "";
			String value = "";
			List<SysDictionary> sysDictionaryList = SysDictionaryGroup.allSysDictionarys
					.get(dictionary.toLowerCase());
			if (ObjectUtils.isNotEmpty(sysDictionaryList)) {
				for (SysDictionary sysDictionary : sysDictionaryList) {
					text += sysDictionary.getTypename() + ",";
					value += sysDictionary.getTypecode() + ",";
				}
				setColumn(field, text, value);
			}
		}
	}

	/**
	 * 方法：setColumn <br>
	 * 描述：设置字段替换值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:22:51 <br>
	 *
	 * @param name
	 * @param text
	 * @param value
	 */
	public void setColumn(String name, String text, String value) {
		ColumnValue columnValue = new ColumnValue();
		columnValue.setName(name);
		columnValue.setText(text);
		columnValue.setValue(value);
		columnValueList.add(columnValue);
	}

	/**
	 * 方法：doStartTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// 清空资源
		urlList.clear();
		toolBarList.clear();
		columnValueList.clear();
		columnList.clear();
		fields = "";
		return EVAL_PAGE;
	}

	/**
	 * 方法：doEndTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspException
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.print(end().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 方法：end <br>
	 * 描述： easyui构造方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:25:12 <br>
	 *
	 * @return
	 */
	public StringBuffer end() {
		String grid = "";
		StringBuffer sb = new StringBuffer();
		width = (width == null) ? "auto" : width;
		height = (height == null) ? "auto" : height;
		sb.append("<script type=\"text/javascript\">");
		sb.append("$(function(){");
		if (treegrid) {
			grid = "treegrid";
			sb.append("$(\'#" + name + "\').treegrid({");
			sb.append("idField:'id',");
			sb.append("treeField:'text',");
		} else {
			grid = "datagrid";
			sb.append("$(\'#" + name + "\').datagrid({");
			sb.append("idField: '" + idField + "',");
		}
		if (title != null) {
			sb.append("title: \'" + title + "\',");
		}
		if (autoLoadData)
			sb.append("url:\'"
					+ ContextHolderUtils.getRequest().getContextPath()
					+ actionUrl + "?field=" + fields + "\',");
		else {
			sb.append("url:\'',");
		}
		if (ObjectUtils.isNotEmpty(rowStyler)) {
			sb.append("rowStyler: function(index,row){ return " + rowStyler
					+ "(index,row);},");
		}
		if (ObjectUtils.isNotEmpty(extendParams)) {
			sb.append(extendParams);
		}
		if (fit) {
			sb.append("fit:true,");
		} else {
			sb.append("fit:false,");
		}
		sb.append("loadMsg: \'数据加载中...\',");
		sb.append("pageSize: " + pageSize + ",");
		sb.append("pagination:" + pagination + ",");
		sb.append("pageList:[" + pageSize * 1 + "," + pageSize * 2 + ","
				+ pageSize * 3 + "],");
		if (ObjectUtils.isNotEmpty(sortName)) {
			sb.append("sortName:'" + sortName + "',");
		}
		sb.append("sortOrder:'" + sortOrder + "',");
		sb.append("rownumbers:true,");
		sb.append("singleSelect:" + !checkbox + ",");
		if (fitColumns) {
			sb.append("fitColumns:true,");
		} else {
			sb.append("fitColumns:false,");
		}
		sb.append("showFooter:true,");
		sb.append("frozenColumns:[[");
		this.getField(sb, 0);
		sb.append("]],");
		sb.append("columns:[[");
		this.getField(sb);
		sb.append("]],");
		sb.append("onLoadSuccess:function(data){$(\"#" + name + "\")." + grid
				+ "(\"clearSelections\");");
		if (openFirstNode && treegrid) {
			sb.append(" if(data==null){");
			sb.append(" var firstNode = $(\'#" + name
					+ "\').treegrid('getRoots')[0];");
			sb.append(" $(\'#" + name + "\').treegrid('expand',firstNode.id)}");
		}
		if (ObjectUtils.isNotEmpty(onLoadSuccess)) {
			sb.append(onLoadSuccess + "(data);");
		}
		sb.append("},");
		if (ObjectUtils.isNotEmpty(onDblClick)) {
			sb.append("onDblClickRow:function(rowIndex,rowData){" + onDblClick
					+ "(rowIndex,rowData);},");
		}
		if (treegrid) {
			sb.append("onClickRow:function(rowData){");
		} else {
			sb.append("onClickRow:function(rowIndex,rowData){");
		}
		/** 行记录赋值 */
		sb.append("rowid=rowData.id;");
		sb.append("gridname=\'" + name + "\';");
		if (ObjectUtils.isNotEmpty(onClick)) {
			if (treegrid) {
				sb.append("" + onClick + "(rowData);");
			} else {
				sb.append("" + onClick + "(rowIndex,rowData);");
			}
		}
		sb.append("}");
		sb.append("});");
		this.setPager(sb, grid);
		sb.append("});");
		sb.append("function reloadTable(){");
		sb.append("try{");
		sb.append(" $(\'#\'+gridname).datagrid(\'reload\');");
		sb.append(" $(\'#\'+gridname).treegrid(\'reload\');");
		sb.append("}catch(ex){}");
		sb.append("}");
		sb.append("function reload" + name + "(){" + "$(\'#" + name + "\')."
				+ grid + "(\'reload\');" + "}");
		sb.append("function get" + name
				+ "Selected(field){return getSelected(field);}");
		sb.append("function getSelected(field){"
				+ "var row = $(\'#\'+gridname)." + grid + "(\'getSelected\');"
				+ "if(row!=null)" + "{" + "value= row[field];" + "}" + "else"
				+ "{" + "value=\'\';" + "}" + "return value;" + "}");
		sb.append("function get" + name + "Selections(field){"
				+ "var ids = [];" + "var rows = $(\'#" + name + "\')." + grid
				+ "(\'getSelections\');" + "for(var i=0;i<rows.length;i++){"
				+ "ids.push(rows[i][field]);" + "}" + "ids.join(\',\');"
				+ "return ids;" + "};");
		sb.append("function getSelectRows(){");
		sb.append(" return $(\'#" + name + "\').datagrid('getChecked');");
		sb.append("}");
		if (columnList.size() > 0) {
			sb.append("function " + name + "search(){");
			sb.append("var queryParams=$(\'#" + name
					+ "\').datagrid('options').queryParams;");
			sb.append("$(\'#"
					+ name
					+ "tb\').find('*').each(function(){queryParams[$(this).attr('name')]=$(this).val();});");
			sb.append("$(\'#" + name + "\')." + grid + "({url:'"
					+ ContextHolderUtils.getRequest().getContextPath()
					+ actionUrl + "?field=" + fields
					+ "',pageNumber:1});" + "}");
			// 高级查询执行方法
			sb.append("function dosearch(params){");
			sb.append("var jsonparams=$.parseJSON(params);");
			sb.append("$(\'#" + name + "\')." + grid + "({url:'"
					+ ContextHolderUtils.getRequest().getContextPath()
					+ actionUrl + "?field=" + fields
					+ "',queryParams:jsonparams});" + "}");
			if (toolBarList.size() > 0) {
				// searchbox框执行方法
				searchboxFun(sb, grid);
			}
			// 生成重置按钮功能js
			sb.append("function searchReset(name){");
			sb.append(" $(\"#\"+name+\"tb\").find(\":input\").val(\"\");");
			String func = name.trim() + "search();";
			sb.append(func);
			sb.append("}");
		}
		sb.append("</script>");
		sb.append("<table width=\"100%\" id=\"" + name + "\" toolbar=\"#"
				+ name + "tb\"></table>");
		sb.append("<div id=\"" + name
				+ "tb\" style=\"padding:3px; height: auto\">");
		if (hasQueryColum(columnList)) {
			sb.append("<div name=\"searchColums\">");
			// 如果表单是组合查询
			if ("group".equals(getQueryMode())) {
				for (DataGridColumn col : columnList) {
					if (col.isQuery()) {
						sb.append("<span style=\"display:-moz-inline-box;display:inline-block;\">");
						sb.append("<span style=\"display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; \" title=\""
								+ col.getTitle()
								+ "\">"
								+ col.getTitle()
								+ "：</span>");
						if ("single".equals(col.getQueryMode())) {
							if (!ObjectUtils.isEmpty(col.getReplace())) {
								sb.append("<select name=\""
										+ col.getField().replaceAll("_", "\\.")
										+ "\" WIDTH=\"100\" style=\"width: 104px\"> ");
								sb.append("<option value =\"\" >---请选择---</option>");
								String[] test = col.getReplace().split(",");
								String text = "";
								String value = "";
								for (String string : test) {
									text = string.split("_")[1];
									value = string.split("_")[0];
									sb.append("<option value =\"" + value
											+ "\">" + text + "</option>");
								}
								sb.append("</select>");
							} else if (col.isAutocomplete()) {
								sb.append(getAutoSpan(col.getField()
										.replaceAll("_", "\\."),
										extendAttribute(col.getExtend())));
							} else {
								sb.append("<input type=\"text\" name=\""
										+ col.getField().replaceAll("_", "\\.")
										+ "\" "
										+ extendAttribute(col.getExtend())
										+ " style=\"width: 100px\" />");
							}
						} else if ("group".equals(col.getQueryMode())) {
							sb.append("<input type=\"text\" name=\""
									+ col.getField()
									+ "_begin\" style=\"width: 94px\" "
									+ extendAttribute(col.getExtend()) + "/>");
							sb.append("<span style=\"display:-moz-inline-box;display:inline-block;width: 8px;text-align:right;\">~</span>");
							sb.append("<input type=\"text\" name=\""
									+ col.getField()
									+ "_end\" style=\"width: 94px\" "
									+ extendAttribute(col.getExtend()) + "/>");
						}
						sb.append("</span>");
					}
				}
			}
			sb.append("</div>");
		}
		if (toolBarList.size() == 0 && !hasQueryColum(columnList)) {
			sb.append("<div style=\"height:0px;\" >");
		} else {
			sb.append("<div style=\"height:30px;\" class=\"datagrid-toolbar\">");
		}
		sb.append("<span style=\"float:left;\" >");
		if (toolBarList.size() > 0) {
			for (DataGridUrl toolBar : toolBarList) {
				sb.append("<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" icon=\""
						+ toolBar.getIcon() + "\" ");
				if (ObjectUtils.isNotEmpty(toolBar.getOnclick())) {
					sb.append("onclick=" + toolBar.getOnclick() + "");
				} else {
					sb.append("onclick=\"" + toolBar.getFunname() + "(");
					if (!toolBar.getFunname().equals("doSubmit")) {
						sb.append("\'" + toolBar.getTitle() + "\',");
					}
					String width = null;
					if (ObjectUtils.isNotEmpty(toolBar.getWidth())) {
						width = toolBar.getWidth().contains("%") ? "'"
								+ toolBar.getWidth() + "'" : toolBar.getWidth();
					}
					String height = null;
					if (ObjectUtils.isNotEmpty(toolBar.getWidth())) {
						height = toolBar.getHeight().contains("%") ? "'"
								+ toolBar.getHeight() + "'" : toolBar
								.getHeight();
					}
					sb.append("\'"
							+ ContextHolderUtils.getRequest().getContextPath()
							+ toolBar.getUrl() + "\',\'" + name + "\'," + width
							+ "," + height + ")\"");
				}
				sb.append(">" + toolBar.getTitle() + "</a>");
			}
		}
		sb.append("</span>");
		if ("group".equals(getQueryMode()) && hasQueryColum(columnList)) {// 如果表单是组合查询
			sb.append("<span style=\"float:right\">");
			sb.append("<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" onclick=\""
					+ name + "search()\">查询</a>");
			sb.append("<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-reload\" onclick=\"searchReset('"
					+ name + "')\">重置</a>");
			sb.append("</span>");
		} else if ("single".equals(getQueryMode()) && hasQueryColum(columnList)) {// 如果表单是单查询
			sb.append("<span style=\"float:right\">");
			sb.append("<input id=\""
					+ name
					+ "searchbox\" class=\"easyui-searchbox\" data-options=\"searcher:"
					+ name + "searchbox,prompt:\'请输入关键字\',menu:\'#" + name
					+ "mm\'\"></input>");
			sb.append("<div id=\"" + name + "mm\" style=\"width:120px\">");
			for (DataGridColumn col : columnList) {
				if (col.isQuery()) {
					sb.append("<div data-options=\"name:\'"
							+ col.getField().replaceAll("_", "\\.")
							+ "\',iconCls:\'icon-ok\' "
							+ extendAttribute(col.getExtend()) + " \">"
							+ col.getTitle() + "</div> ");
				}
			}
			sb.append("</div>");
			sb.append("</span>");
		}
		sb.append("</div>");
		return sb;
	}

	/**
	 * 方法：extendAttribute <br>
	 * 描述：生成扩展属性 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午6:09:23 <br>
	 *
	 * @param field
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String extendAttribute(String field) {
		if (ObjectUtils.isEmpty(field)) {
			return "";
		}
		field = dealSyscode(field, 1);
		StringBuilder re = new StringBuilder();
		try {
			JSONObject obj = JSONObject.fromObject(field);
			Iterator<String> it = obj.keys();
			while (it.hasNext()) {
				String key = String.valueOf(it.next());
				JSONObject nextObj = ((JSONObject) obj.get(key));
				Iterator<String> itvalue = nextObj.keys();
				re.append(key + "=" + "\"");
				if (nextObj.size() <= 1) {
					String onlykey = String.valueOf(itvalue.next());
					if ("value".equals(onlykey)) {
						re.append(nextObj.get(onlykey) + "");
					} else {
						re.append(onlykey + ":" + nextObj.get(onlykey) + "");
					}
				} else {
					while (itvalue.hasNext()) {
						String multkey = String.valueOf(itvalue.next());
						String multvalue = nextObj.getString(multkey);
						re.append(multkey + ":" + multvalue + ",");
					}
					re.deleteCharAt(re.length() - 1);
				}
				re.append("\" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return dealSyscode(re.toString(), 2);
	}

	/**
	 * 方法：dealSyscode <br>
	 * 描述：处理否含有json转换中的保留字 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午6:10:07 <br>
	 *
	 * @param field
	 * @param flag
	 * @return
	 */
	private String dealSyscode(String field, int flag) {
		String change = field;
		Iterator<String> it = syscode.keySet().iterator();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = String.valueOf(syscode.get(key));
			if (flag == 1) {
				change = field.replaceAll(key, value);
			} else if (flag == 2) {
				change = field.replaceAll(value, key);
			}
		}
		return change;
	}

	/**
	 * 方法：getAutoSpan <br>
	 * 描述：获取自动补全的panel <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午6:12:20 <br>
	 *
	 * @param filed
	 * @param extend
	 * @return
	 */
	private String getAutoSpan(String filed, String extend) {
		String id = filed.replaceAll("\\.", "_");
		StringBuffer nsb = new StringBuffer();
		nsb.append("<script type=\"text/javascript\">");
		nsb.append("$(document).ready(function() {")
				.append("$(\"#"
						+ getEntityName()
						+ "_"
						+ id
						+ "\").autocomplete(\"commonController.do?getAutoList\",{")
				.append("max: 5,minChars: 2,width: 200,scrollHeight: 100,matchContains: true,autoFill: false,extraParams:{")
				.append("featureClass : \"P\",style : \"full\", maxRows : 10,labelField : \""
						+ filed + "\",valueField : \"" + filed + "\",")
				.append("searchField : \"" + filed + "\",entityName : \""
						+ getEntityName() + "\",trem: function(){return $(\"#"
						+ getEntityName() + "_" + id + "\").val();}}");
		nsb.append(",parse:function(data){return jeecgAutoParse.call(this,data);}");
		nsb.append(",formatItem:function(row, i, max){return row['" + filed
				+ "'];} ");
		nsb.append("}).result(function (event, row, formatted) {");
		nsb.append(
				"$(\"#" + getEntityName() + "_" + id + "\").val(row['" + filed
						+ "']);}); });")
				.append("</script>")
				.append("<input type=\"text\" id=\"" + getEntityName() + "_"
						+ id + "\" name=\"" + filed + "\" datatype=\"*\" "
						+ extend + " nullmsg=\"\" errormsg=\"输入错误\"/>");
		return nsb.toString();
	}

	/**
	 * 方法：getEntityName <br>
	 * 描述：获取实体类名称,没有这根据规则设置 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午6:12:38 <br>
	 *
	 * @return
	 */
	private String getEntityName() {
		if (ObjectUtils.isEmpty(entityName)) {
			entityName = ContextHolderUtils.getRequest().getContextPath()
					+ actionUrl.substring(0, actionUrl.indexOf("Controller"));
			entityName = (entityName.charAt(0) + "").toUpperCase()
					+ entityName.substring(1) + "Entity";
		}
		return entityName;
	}

	/**
	 * 方法：hasQueryColum <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:29:48 <br>
	 *
	 * @param columnList
	 * @return hasQuery true表示有查询字段,false表示没有
	 */
	protected boolean hasQueryColum(List<DataGridColumn> columnList) {
		boolean hasQuery = false;
		for (DataGridColumn col : columnList) {
			if (col.isQuery()) {
				hasQuery = true;
			}
		}
		return hasQuery;
	}

	/**
	 * 方法：getFun <br>
	 * 描述：列自定义函数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-12 下午5:15:21 <br>
	 *
	 * @param sb
	 * @param column
	 */
	protected void getFun(StringBuffer sb, DataGridColumn column) {
		String url = ContextHolderUtils.getRequest().getContextPath()
				+ column.getUrl();
		url = formatUrl(url);
		sb.append("var href=\"<a style=\'color:red\' href=\'#\' onclick="
				+ column.getFunname() + "('" + column.getTitle() + "','" + url
				+ "')>\";");
		sb.append("return href+value+\'</a>\';");

	}

	/**
	 * 方法：getOptUrl <br>
	 * 描述：拼装操作地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:30:42 <br>
	 *
	 * @param sb
	 */
	protected void getOptUrl(StringBuffer sb) {
		// 注：操作列表会带入合计列中去，故加此判断
		sb.append("if(!rec.id){return '';}");
		List<DataGridUrl> list = urlList;
		sb.append("var href='';");
		for (DataGridUrl dataGridUrl : list) {
			String url = dataGridUrl.getUrl();
			if (dataGridUrl.getValue() != null) {
				String[] testvalue = dataGridUrl.getValue().split(",");
				List<Object> value = new ArrayList<Object>();
				for (String string : testvalue) {
					value.add("\"+rec." + string + " +\"");
				}
				url = MessageFormat.format(url, value.toArray());
			}
			if (url != null && dataGridUrl.getValue() == null) {
				url = formatUrl(url);
			}
			String exp = dataGridUrl.getExp();// 判断显示表达式
			if (ObjectUtils.isNotEmpty(exp)) {
				String[] ShowbyFields = exp.split("&&");
				for (String ShowbyField : ShowbyFields) {
					int beginIndex = ShowbyField.indexOf("#");
					int endIndex = ShowbyField.lastIndexOf("#");
					String exptype = ShowbyField.substring(beginIndex + 1,
							endIndex);// 表达式类型
					String field = ShowbyField.substring(0, beginIndex);// 判断显示依据字段
					String[] values = ShowbyField.substring(endIndex + 1,
							ShowbyField.length()).split(",");// 传入字段值
					String value = "";
					for (int i = 0; i < values.length; i++) {
						value += "'" + "" + values[i] + "" + "'";
						if (i < values.length - 1) {
							value += ",";
						}
					}
					if ("eq".equals(exptype)) {
						sb.append("if($.inArray(rec." + field + ",[" + value
								+ "])>=0){");
					}
					if ("ne".equals(exptype)) {
						sb.append("if($.inArray(rec." + field + ",[" + value
								+ "])<0){");
					}
					if ("empty".equals(exptype) && value.equals("'true'")) {
						sb.append("if(rec." + field + "==''){");
					}
					if ("empty".equals(exptype) && value.equals("'false'")) {
						sb.append("if(rec." + field + "!=''){");
					}
				}
			}
			if (EOptType.Confirm.equals(dataGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=confirm(\'" + url
						+ "\',\'" + dataGridUrl.getMessage() + "\',\'" + name
						+ "\')> \";");
			}
			if (EOptType.Del.equals(dataGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=delObj(\'" + url
						+ "\',\'" + name + "\')>\";");
			}
			if (EOptType.Fun.equals(dataGridUrl.getType())) {
				String name = TagUtils.getFunction(dataGridUrl.getFunname());
				String parmars = TagUtils
						.getFunParams(dataGridUrl.getFunname());
				sb.append("href+=\"[<a href=\'#\' onclick=" + name + "("
						+ parmars + ")>\";");
			}
			if (EOptType.OpenWin.equals(dataGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=openwindow('"
						+ dataGridUrl.getTitle() + "','" + url + "','" + name
						+ "'," + dataGridUrl.getWidth() + ","
						+ dataGridUrl.getHeight() + ")>\";");
			} // update-end--Author:liuht Date:20130228 for：弹出窗口设置参数不生效
			if (EOptType.Deff.equals(dataGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'" + url + "' title=\'"
						+ dataGridUrl.getTitle() + "\'>\";");
			}
			if (EOptType.OpenTab.equals(dataGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=addOneTab('"
						+ dataGridUrl.getTitle() + "','" + url + "')>\";");
			}
			sb.append("href+=\"" + dataGridUrl.getTitle() + "</a>]\";");
			if (ObjectUtils.isNotEmpty(exp)) {
				for (int i = 0; i < exp.split("&&").length; i++) {
					sb.append("}");
				}
			}
		}
		sb.append("return href;");
	}

	/**
	 * 方法：getField <br>
	 * 描述：普通列 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:36:05 <br>
	 *
	 * @param sb
	 */
	protected void getField(StringBuffer sb) {
		getField(sb, 1);
	}

	/**
	 * 方法：getField <br>
	 * 描述：拼接字段 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:36:20 <br>
	 *
	 * @param sb
	 * @param frozen
	 *            0 冰冻列 1 普通列
	 */
	protected void getField(StringBuffer sb, int frozen) {
		// 复选框
		if (checkbox && frozen == 0) {
			sb.append("{field:\'ck\',checkbox:\'true\'},");
		}
		int i = 0;
		for (DataGridColumn column : columnList) {
			i++;
			if ((column.isFrozenColumn() && frozen == 0)
					|| (!column.isFrozenColumn() && frozen == 1)) {
				String field;
				if (treegrid) {
					field = column.getTreefield();
				} else {
					field = column.getField();
				}
				sb.append("{field:\'" + field + "\',title:\'"
						+ column.getTitle() + "\',");
				int colwidth = (column.getWidth() == null) ? column.getTitle()
						.length() * 15 : column.getWidth();
				sb.append("width:" + colwidth + "");

				// 隐藏字段
				if (!column.isHidden()) {
					sb.append(",hidden:true");
				}
				if (!treegrid) {
					// 字段排序
					if ((column.isSortable())
							&& (field.indexOf("_") <= 0 && field != "opt")) {
						sb.append(",sortable:" + column.isSortable() + "");
					}
				}
				// 显示图片
				if (column.isImage()) {
					sb.append(",formatter:function(value,rec,index){");
					sb.append(" return '<img border=\"0\" src=\"'+value+'\"/>'}");
				}
				// 自定义链接
				if (column.getUrl() != null) {
					sb.append(",formatter:function(value,rec,index){");
					this.getFun(sb, column);
					sb.append("}");
				}
				if (column.getFormatter() != null) {
					sb.append(",formatter:function(value,rec,index){");
					sb.append(" return new Date().format('"
							+ column.getFormatter() + "',value);}");
				}
				// 加入操作
				if (column.getField().equals("opt")) {
					sb.append(",formatter:function(value,rec,index){");
					// sb.append("return \"");
					this.getOptUrl(sb);
					sb.append("}");
				}
				// 值替換
				if (columnValueList.size() > 0
						&& !column.getField().equals("opt")) {
					String testString = "";
					for (ColumnValue columnValue : columnValueList) {
						if (columnValue.getName().equals(column.getField())) {
							String[] value = columnValue.getValue().split(",");
							String[] text = columnValue.getText().split(",");
							sb.append(",formatter:function(value,rec,index){");
							for (int j = 0; j < value.length; j++) {
								testString += "if(value=='" + value[j]
										+ "'){return \'" + text[j] + "\';}";
							}
							sb.append(testString);
							sb.append("else{return value;}");
							sb.append("}");
						}
					}

				}
				sb.append("}");
				// 去除末尾,
				if (i < columnList.size()) {
					sb.append(",");
				}
			}
		}
	}

	/**
	 * 方法：setPager <br>
	 * 描述：设置分页条信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:36:47 <br>
	 *
	 * @param sb
	 * @param grid
	 */
	protected void setPager(StringBuffer sb, String grid) {
		sb.append("$(\'#" + name + "\')." + grid
				+ "(\'getPager\').pagination({");
		sb.append("beforePageText:\'\'," + "afterPageText:\'/{pages}\',");
		if (showText) {
			sb.append("displayMsg:\'{from}-{to}共{total}条\',");
		} else {
			sb.append("displayMsg:\'\',");
		}
		if (showPageList == true) {
			sb.append("showPageList:true,");
			sb.append("pageList:[" + pageSize * 1 + "," + pageSize * 2 + ","
					+ pageSize * 3 + "],");
		} else {
			sb.append("showPageList:false,");
		}
		sb.append("showRefresh:" + showRefresh + "");
		sb.append("});");// end getPager
		sb.append("$(\'#" + name + "\')." + grid
				+ "(\'getPager\').pagination({");
		sb.append("onBeforeRefresh:function(pageNumber, pageSize){ $(this).pagination(\'loading\');$(this).pagination(\'loaded\'); }");
		sb.append("});");
	}

	/**
	 * 方法：searchboxFun <br>
	 * 描述：列表查询框函数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-23 下午5:37:00 <br>
	 *
	 * @param sb
	 * @param grid
	 */
	protected void searchboxFun(StringBuffer sb, String grid) {
		sb.append("function " + name + "searchbox(value,name){");
		sb.append("var queryParams=$(\'#" + name
				+ "\').datagrid('options').queryParams;");
		sb.append("queryParams[name]=value;queryParams.searchfield=name;$(\'#"
				+ name + "\')." + grid + "(\'reload\');}");
		sb.append("$(\'#" + name + "searchbox\').searchbox({");
		sb.append("searcher:function(value,name){");
		sb.append("" + name + "searchbox(value,name);");
		sb.append("},");
		sb.append("menu:\'#" + name + "mm\',");
		sb.append("prompt:\'请输入查询关键字\'");
		sb.append("});");
	}

	/**
	 * 方法：formatUrl <br>
	 * 描述：格式化URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-12 下午5:18:45 <br>
	 *
	 * @param url
	 * @return
	 */
	protected String formatUrl(String url) {
		String parurlvalue = "";
		if (url.indexOf("&") >= 0) {
			// 截取请求地址
			String beforeurl = url.substring(0, url.indexOf("&"));
			// 截取参数
			String parurl = url.substring(url.indexOf("&") + 1, url.length());
			String[] pras = parurl.split("&");
			List<Object> value = new ArrayList<Object>();
			int j = 0;
			for (int i = 0; i < pras.length; i++) {
				if (pras[i].indexOf("{") >= 0 || pras[i].indexOf("#") >= 0) {
					String field = pras[i].substring(pras[i].indexOf("{") + 1,
							pras[i].lastIndexOf("}"));
					parurlvalue += "&"
							+ pras[i].replace("{" + field + "}", "{" + j + "}");
					value.add("\"+rec." + field + " +\"");
					j++;
				} else {
					parurlvalue += "&" + pras[i];
				}
			}
			url = MessageFormat
					.format(beforeurl + parurlvalue, value.toArray());
		}
		return url;

	}

	/**
	 * 方法：setDelUrl <br>
	 * 描述：设置删除链接 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午4:14:19 <br>
	 *
	 * @param url
	 * @param title
	 * @param message
	 * @param exp
	 * @param funname
	 * @param operationCode
	 */
	public void setDelUrl(String url, String title, String message, String exp,
			String funname, String operationCode) {
		DataGridUrl dateGridUrl = new DataGridUrl();
		dateGridUrl.setTitle(title);
		dateGridUrl.setUrl(url);
		dateGridUrl.setType(EOptType.Del);
		dateGridUrl.setMessage(message);
		dateGridUrl.setExp(exp);
		dateGridUrl.setFunname(funname);
		urlList.add(dateGridUrl);
	}

	/**
	 * @retrun the fields <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setFields(String fields) {
		this.fields = fields;
	}

	/**
	 * @retrun the name <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the title <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @retrun the idField <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getIdField() {
		return idField;
	}

	/**
	 * @param idField
	 *            the idField to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setIdField(String idField) {
		this.idField = idField;
	}

	/**
	 * @retrun the treegrid <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isTreegrid() {
		return treegrid;
	}

	/**
	 * @param treegrid
	 *            the treegrid to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setTreegrid(boolean treegrid) {
		this.treegrid = treegrid;
	}

	/**
	 * @retrun the urlList <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public List<DataGridUrl> getUrlList() {
		return urlList;
	}

	/**
	 * @param urlList
	 *            the urlList to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setUrlList(List<DataGridUrl> urlList) {
		this.urlList = urlList;
	}

	/**
	 * @retrun the toolBarList <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public List<DataGridUrl> getToolBarList() {
		return toolBarList;
	}

	/**
	 * @param toolBarList
	 *            the toolBarList to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setToolBarList(List<DataGridUrl> toolBarList) {
		this.toolBarList = toolBarList;
	}

	/**
	 * @retrun the columnList <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public List<DataGridColumn> getColumnList() {
		return columnList;
	}

	/**
	 * @param columnList
	 *            the columnList to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setColumnList(List<DataGridColumn> columnList) {
		this.columnList = columnList;
	}

	/**
	 * @retrun the columnValueList <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public List<ColumnValue> getColumnValueList() {
		return columnValueList;
	}

	/**
	 * @param columnValueList
	 *            the columnValueList to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setColumnValueList(List<ColumnValue> columnValueList) {
		this.columnValueList = columnValueList;
	}

	/**
	 * @retrun the map <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map
	 *            the map to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	/**
	 * @retrun the actionUrl <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getActionUrl() {
		return actionUrl;
	}

	/**
	 * @param actionUrl
	 *            the actionUrl to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * @retrun the allCount <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public int getAllCount() {
		return allCount;
	}

	/**
	 * @param allCount
	 *            the allCount to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	/**
	 * @retrun the curPage <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public int getCurPage() {
		return curPage;
	}

	/**
	 * @param curPage
	 *            the curPage to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * @retrun the pageSize <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @retrun the pagination <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isPagination() {
		return pagination;
	}

	/**
	 * @param pagination
	 *            the pagination to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	/**
	 * @retrun the width <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @retrun the height <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @retrun the checkbox <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isCheckbox() {
		return checkbox;
	}

	/**
	 * @param checkbox
	 *            the checkbox to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * @retrun the showPageList <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isShowPageList() {
		return showPageList;
	}

	/**
	 * @param showPageList
	 *            the showPageList to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setShowPageList(boolean showPageList) {
		this.showPageList = showPageList;
	}

	/**
	 * @retrun the fit <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isFit() {
		return fit;
	}

	/**
	 * @param fit
	 *            the fit to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setFit(boolean fit) {
		this.fit = fit;
	}

	/**
	 * @retrun the fitColumns <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isFitColumns() {
		return fitColumns;
	}

	/**
	 * @param fitColumns
	 *            the fitColumns to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setFitColumns(boolean fitColumns) {
		this.fitColumns = fitColumns;
	}

	/**
	 * @retrun the sortName <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getSortName() {
		return sortName;
	}

	/**
	 * @param sortName
	 *            the sortName to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	/**
	 * @retrun the sortOrder <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the sortOrder to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @retrun the showRefresh <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isShowRefresh() {
		return showRefresh;
	}

	/**
	 * @param showRefresh
	 *            the showRefresh to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setShowRefresh(boolean showRefresh) {
		this.showRefresh = showRefresh;
	}

	/**
	 * @retrun the showText <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isShowText() {
		return showText;
	}

	/**
	 * @param showText
	 *            the showText to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setShowText(boolean showText) {
		this.showText = showText;
	}

	/**
	 * @retrun the style <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @retrun the onLoadSuccess <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getOnLoadSuccess() {
		return onLoadSuccess;
	}

	/**
	 * @param onLoadSuccess
	 *            the onLoadSuccess to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setOnLoadSuccess(String onLoadSuccess) {
		this.onLoadSuccess = onLoadSuccess;
	}

	/**
	 * @retrun the onClick <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getOnClick() {
		return onClick;
	}

	/**
	 * @param onClick
	 *            the onClick to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	/**
	 * @retrun the onDblClick <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getOnDblClick() {
		return onDblClick;
	}

	/**
	 * @param onDblClick
	 *            the onDblClick to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setOnDblClick(String onDblClick) {
		this.onDblClick = onDblClick;
	}

	/**
	 * @retrun the queryMode <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public String getQueryMode() {
		return queryMode;
	}

	/**
	 * @param queryMode
	 *            the queryMode to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	/**
	 * @retrun the autoLoadData <br>
	 *
	 *         时间: 2013-7-22 下午6:14:47 <br>
	 */

	public boolean isAutoLoadData() {
		return autoLoadData;
	}

	/**
	 * @param autoLoadData
	 *            the autoLoadData to set <br>
	 *
	 *            时间: 2013-7-22 下午6:14:47
	 */
	public void setAutoLoadData(boolean autoLoadData) {
		this.autoLoadData = autoLoadData;
	}

}
