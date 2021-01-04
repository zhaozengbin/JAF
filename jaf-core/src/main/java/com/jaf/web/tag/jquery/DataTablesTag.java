/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.jquery <br>
 * 文件名：DataTablesTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-12-下午5:02:29<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.jquery;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.easyui.ColumnValue;
import com.jaf.web.dto.easyui.DataGridColumn;
import com.jaf.web.dto.easyui.DataGridUrl;
import com.jaf.web.entity.EOptType;
import com.jaf.web.tag.AbstractTag;
import com.jaf.web.tag.util.TagUtils;

/**
 *
 * 类名称：DataTablesTag <br>
 * 类描述：jquery DataTables插件 标签<br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-12 下午5:02:29 <br>
 * 修改备注：TODO <br>
 *
 */
public class DataTablesTag extends AbstractTag {

	/**  */
	private static final long serialVersionUID = 1L;

	/** 表格标示 */
	protected String name;

	/** 主键字段 */
	protected String idField = "id";

	/** 列表样式easyui,datatables */
	private String style = "datatables";

	/** 是否显示复选框 */
	private boolean checkbox = false;

	/** 列表操作显示 */
	protected List<DataGridColumn> columnList = new ArrayList<DataGridColumn>();

	/** 列表操作显示 */
	protected List<DataGridUrl> urlList = new ArrayList<DataGridUrl>();

	/** 值替换集合 */
	protected List<ColumnValue> columnValueList = new ArrayList<ColumnValue>();

	/** 是否是树形列表 */
	protected boolean treegrid = false;

	/**
	 * 方法：doStartTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspException
	 * @see com.jaf.web.tag.AbstractTag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * 方法：doEndTag <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @throws JspException
	 * @see com.jaf.web.tag.AbstractTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.print(assembleEnd().toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 方法：assembleStart <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		return null;
	}

	/**
	 * 方法：assembleEnd <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleEnd()
	 */
	@Override
	protected String assembleEnd() {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append("$(document).ready(function() {");
		sb.append("var oTable = $(\'#" + name + "\').dataTable({");
		// 当datatable获取数据时候是否显示正在处理提示信息"
		sb.append("\"bProcessing\" : true,");
		// 是否分页"
		sb.append("\"bPaginate\" : true,");
		// 分页样式full_numbers,"
		sb.append("\"sPaginationType\" : \"full_numbers\",");
		// 是否使用内置的过滤功能"
		sb.append("\"bFilter\" : true,");
		// 排序功能"
		sb.append("\"bSort\" : true, ");
		// 自动宽度"
		sb.append("\"bAutoWidth\" : true,");
		// 是否允许用户自定义每页显示条数"
		sb.append("\"bLengthChange\" : true,");
		// 页脚信息"
		sb.append("\"bInfo\" : true,");
		sb.append("\"sAjaxSource\" : \"userController.do?test\",");
		sb.append("\"bServerSide\" : true,");// 指定从服务器端获取数据
		sb.append("\"oLanguage\" : {" + "\"sLengthMenu\" : \" _MENU_ 条记录\","
				+ "\"sZeroRecords\" : \"没有检索到数据\","
				+ "\"sInfo\" : \"第 _START_ 至 _END_ 条数据 共 _TOTAL_ 条\","
				+ "\"sInfoEmtpy\" : \"没有数据\","
				+ "\"sProcessing\" : \"正在加载数据...\"," + "\"sSearch\" : \"搜索\","
				+ "\"oPaginate\" : {" + "\"sFirst\" : \"首页\","
				+ "\"sPrevious\" : \"前页\", " + "\"sNext\" : \"后页\","
				+ "\"sLast\" : \"尾页\"" + "}" + "},"); // 汉化
		// 获取数据的处理函数 \"data\" : {_dt_json : JSON.stringify(aoData)},
		sb.append("\"fnServerData\" : function(sSource, aoData, fnCallback, oSettings) {");
		// + "\"data\" : {_dt_json : JSON.stringify(aoData)},"
		sb.append("oSettings.jqXHR = $.ajax({" + "\"dataType\" : \'json\',"
				+ "\"type\" : \"POST\"," + "\"url\" : sSource,"
				+ "\"data\" : aoData," + "\"success\" : fnCallback" + "});},");
		// sb.append("\"aaSorting\": [[0 , \"desc\" ],[1 , \"asc\" ]],");
		// sb.append("\"aoColumnDefs\":[");
		// sb.append("{\"sClass\" : \"center\",\"aTargets\" : [ 0, 1, 2, 3 ]},");
		// sb.append("{\"bSearchable\":false,\"aTargets\" : [ 0, 1 ]},");
		// sb.append("{\"bVisible\" : false,\"aTargets\" : [ 0 ]},");
		// sb.append("{\"bSortable\" : true,\"aTargets\" : [ 0, 1 ]} ],");
		sb.append("\"aoColumns\" : [ ");
		int i = 0;
		for (DataGridColumn column : columnList) {
			i++;
			sb.append("{");
			sb.append("\"sTitle\":\"" + column.getTitle() + "\"");
			if (column.getField().equals("opt")) {
				sb.append(",\"mData\":\"" + idField + "\"");
				sb.append(",\"sWidth\":\"20%\"");
				sb.append(",\"bSortable\":false");
				sb.append(",\"bSearchable\":false");
				sb.append(",\"mRender\" : function(data, type, rec) {");
				this.getOptUrl(sb);
				sb.append("}");
			} else {
				int colwidth = (column.getWidth() == null) ? column.getTitle()
						.length() * 15 : column.getWidth();
				sb.append(",\"sName\":\"" + column.getField() + "\"");
				sb.append(",\"mDataProp\":\"" + column.getField() + "\"");
				sb.append(",\"mData\":\"" + column.getField() + "\"");
				sb.append(",\"sWidth\":\"" + colwidth + "\"");
				sb.append(",\"bSortable\":" + column.isSortable() + "");
				sb.append(",\"bVisible\":" + column.isHidden() + "");
				sb.append(",\"bSearchable\":" + column.isQuery() + "");
			}
			sb.append("}");
			if (i < columnList.size())
				sb.append(",");
		}

		sb.append("]" + "});" + "});" + "</script>");
		sb.append("<table width=\"100%\"  class=\"" + style + "\" id=\"" + name
				+ "\" toolbar=\"#" + name + "tb\"></table>");
		return sb.toString();
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
		// datagrid标签没有封装合计功能
		// 注：操作列表会带入合计列中去，故加此判断
		sb.append("if(!rec.id){return '';}");
		// datagrid标签没有封装合计功能
		List<DataGridUrl> list = urlList;
		sb.append("var href='';");
		for (DataGridUrl dateGridUrl : list) {
			String url = dateGridUrl.getUrl();
			if (dateGridUrl.getValue() != null) {
				String[] testvalue = dateGridUrl.getValue().split(",");
				List<Object> value = new ArrayList<Object>();
				for (String string : testvalue) {
					value.add("\"+rec." + string + " +\"");
				}
				url = MessageFormat.format(url, value.toArray());
			}
			if (url != null && dateGridUrl.getValue() == null) {

				url = formatUrl(url);
			}
			String exp = dateGridUrl.getExp();
			// 判断显示表达式
			if (ObjectUtils.isNotEmpty(exp)) {
				String[] ShowbyFields = exp.split("&&");
				for (String ShowbyField : ShowbyFields) {
					int beginIndex = ShowbyField.indexOf("#");
					int endIndex = ShowbyField.lastIndexOf("#");
					// 表达式类型
					String exptype = ShowbyField.substring(beginIndex + 1,
							endIndex);
					// 判断显示依据字段
					String field = ShowbyField.substring(0, beginIndex);
					// 传入字段值
					String[] values = ShowbyField.substring(endIndex + 1,
							ShowbyField.length()).split(",");
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

			if (EOptType.Confirm.equals(dateGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=confirm(\'" + url
						+ "\',\'" + dateGridUrl.getMessage() + "\',\'" + name
						+ "\')> \";");
			}
			if (EOptType.Del.equals(dateGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=delObj(\'" + url
						+ "\',\'" + name + "\')>\";");
			}
			if (EOptType.Fun.equals(dateGridUrl.getType())) {
				String name = TagUtils.getFunction(dateGridUrl.getFunname());
				String parmars = TagUtils
						.getFunParams(dateGridUrl.getFunname());
				sb.append("href+=\"[<a href=\'#\' onclick=" + name + "("
						+ parmars + ")>\";");
			}
			if (EOptType.OpenWin.equals(dateGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'#\' onclick=openwindow('"
						+ dateGridUrl.getTitle() + "','" + url + "','" + name
						+ "','" + dateGridUrl.getWidth() + "','"
						+ dateGridUrl.getHeight() + "')>\";");
			}
			if (EOptType.Deff.equals(dateGridUrl.getType())) {
				sb.append("href+=\"[<a href=\'" + url + "' title=\'"
						+ dateGridUrl.getTitle() + "\'>\";");
			}
			sb.append("href+=\"" + dateGridUrl.getTitle() + "</a>]\";");

			if (ObjectUtils.isNotEmpty(exp)) {
				for (int i = 0; i < exp.split("&&").length; i++) {
					sb.append("}");
				}

			}
		}
		sb.append("return href;");
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
		String url = column.getUrl();
		url = formatUrl(url);
		sb.append("var href=\"<a style=\'color:red\' href=\'#\' onclick="
				+ column.getFunname() + "('" + column.getTitle() + "','" + url
				+ "')>\";");
		sb.append("return href+value+\'</a>\';");

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
										+ "'){return \'" + text[j] + "\'}";
							}
							sb.append(testString);
							sb.append("else{return value}");
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

}
