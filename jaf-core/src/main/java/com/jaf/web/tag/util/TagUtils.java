/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.util <br>
 * 文件名：TagUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.easyui.Autocomplete;
import com.jaf.web.dto.easyui.ComboBox;
import com.jaf.web.dto.easyui.DataGrid;
import com.jaf.web.dto.easyui.DataTableReturn;

/**
 * 
 * 类名称：TagUtils <br>
 * 类描述：标签工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:37:18 <br>
 * 修改备注：TODO <br>
 * 
 */
public class TagUtils {
	/**
	 * 方法：getFiled <br>
	 * 描述：获得实体Bean中所有属性 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:37:27 <br>
	 * 
	 * @param objClass
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Field[] getFiled(Class<?> objClass)
			throws ClassNotFoundException {
		Field[] field = null;
		if (objClass != null) {
			Class<?> class1 = Class.forName(objClass.getName());
			field = class1.getDeclaredFields();// 这里便是获得实体Bean中所有属性的方法
			return field;
		} else {
			return field;
		}
	}

	/**
	 * 方法：fieldNametoValues <br>
	 * 描述： 获取对象内对应字段的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:37:51 <br>
	 * 
	 * @param FiledName
	 * @param o
	 * @return
	 */
	public static Object fieldNametoValues(String FiledName, Object o) {
		Object value = "";
		String fieldName = "";
		String childFieldName = null;
		ReflectHelper reflectHelper = new ReflectHelper(o);
		if (FiledName.indexOf("_") == -1) {
			fieldName = FiledName;
		} else {
			fieldName = FiledName.substring(0, FiledName.indexOf("_"));// 外键字段引用名
			childFieldName = FiledName.substring(FiledName.indexOf("_") + 1);// 外键字段名
		}
		value = reflectHelper.getMethodValue(fieldName) == null ? ""
				: reflectHelper.getMethodValue(fieldName);
		if (value != "" && value != null && FiledName.indexOf("_") != -1) {
			value = fieldNametoValues(childFieldName, value);
		}
		return value;
	}

	/**
	 * 方法：field2Values <br>
	 * 描述：对象转数组 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:00 <br>
	 * 
	 * @param fields
	 * @param o
	 * @return
	 * @throws Exception
	 */
	protected static Object[] field2Values(String[] fields, Object o)
			throws Exception {
		Object[] values = new Object[fields.length];
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].toString();
			values[i] = fieldNametoValues(fieldName, o);
		}
		return values;
	}

	/**
	 * 方法：listtojson <br>
	 * 描述：循环LIST对象拼接EASYUI格式的JSON数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:13 <br>
	 * 
	 * @param fields
	 * @param total
	 * @param list
	 * @param footers
	 * @return
	 * @throws Exception
	 */
	private static String listtojson(String[] fields, int total, List<?> list,
			String[] footers) throws Exception {
		Object[] values = new Object[fields.length];
		String jsonTemp = "{\'total\':" + total + ",\'rows\':[";
		for (int j = 0; j < list.size(); j++) {
			jsonTemp = jsonTemp + "{\'state\':\'closed\',";
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].toString();
				values[i] = fieldNametoValues(fieldName, list.get(j));
				jsonTemp = jsonTemp + "\'" + fieldName + "\'" + ":\'"
						+ values[i] + "\'";
				if (i != fields.length - 1) {
					jsonTemp = jsonTemp + ",";
				}
			}
			if (j != list.size() - 1) {
				jsonTemp = jsonTemp + "},";
			} else {
				jsonTemp = jsonTemp + "}";
			}
		}
		jsonTemp = jsonTemp + "]";
		// datagrid标签没有封装合计功能
		if (footers != null) {
			jsonTemp = jsonTemp + ",";
			jsonTemp = jsonTemp + "\'footer\':[";
			jsonTemp = jsonTemp + "{";
			jsonTemp = jsonTemp + "\'name\':\'合计\',";
			for (String footer : footers) {
				String footerFiled = footer.split(":")[0];
				Object value = null;
				if (footer.split(":").length == 2) {
					value = footer.split(":")[1];
				} else {
					value = getTotalValue(footerFiled, list);
				}
				jsonTemp = jsonTemp + "\'" + footerFiled + "\':\'" + value
						+ "\',";
			}
			if (jsonTemp.endsWith(",")) {
				jsonTemp = jsonTemp.substring(0, jsonTemp.length() - 1);
			}
			jsonTemp = jsonTemp + "}";
			jsonTemp = jsonTemp + "]";
		}
		// datagrid标签没有封装合计功能
		jsonTemp = jsonTemp + "}";
		return jsonTemp;
	}

	/**
	 * 方法：getTotalValue <br>
	 * 描述：计算指定列的合计 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:23 <br>
	 * 
	 * @param fieldName
	 * @param list
	 * @return
	 */
	private static Object getTotalValue(String fieldName, List<?> list) {
		Double sum = 0D;
		try {
			for (int j = 0; j < list.size(); j++) {
				Double v = 0d;
				String vstr = String.valueOf(fieldNametoValues(fieldName,
						list.get(j)));
				if (!ObjectUtils.isEmpty(vstr)) {
					v = Double.valueOf(vstr);
				} else {

				}
				sum += v;
			}
		} catch (Exception e) {
			return "";
		}
		return sum;
	}

	/**
	 * 方法：getAutoList <br>
	 * 描述：循环LIST对象拼接自动完成控件数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:33 <br>
	 * 
	 * @param autocomplete
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String getAutoList(Autocomplete autocomplete, List<?> list)
			throws Exception {
		String field = autocomplete.getLabelField() + ","
				+ autocomplete.getValueField();
		String[] fields = field.split(",");
		Object[] values = new Object[fields.length];
		String jsonTemp = "{\'totalResultsCount\':1,\'geonames\':[";
		if (list.size() > 0) {
			for (int j = 0; j < list.size(); j++) {
				jsonTemp = jsonTemp + "{'nodate':'yes',";
				for (int i = 0; i < fields.length; i++) {
					String fieldName = fields[i].toString();
					values[i] = fieldNametoValues(fieldName, list.get(j));
					jsonTemp = jsonTemp + "\'" + fieldName + "\'" + ":\'"
							+ values[i] + "\'";
					if (i != fields.length - 1) {
						jsonTemp = jsonTemp + ",";
					}
				}
				if (j != list.size() - 1) {
					jsonTemp = jsonTemp + "},";
				} else {
					jsonTemp = jsonTemp + "}";
				}
			}
		} else {
			jsonTemp += "{'nodate':'数据不存在'}";
		}
		jsonTemp = jsonTemp + "]}";
		return JSONObject.fromObject(jsonTemp).toString();
	}

	/**
	 * 方法：datatable <br>
	 * 描述：循环LIST对象拼接DATATABLE格式的JSON数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:43 <br>
	 * 
	 * @param field
	 * @param total
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private static String datatable(String field, int total, List<?> list)
			throws Exception {
		String[] fields = field.split(",");
		Object[] values = new Object[fields.length];
		String jsonTemp = "{\'iTotalDisplayRecords\':" + total
				+ ",\'iTotalRecords\':" + total + ",\'aaData\':[";
		for (int j = 0; j < list.size(); j++) {
			jsonTemp = jsonTemp + "{";
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].toString();
				values[i] = fieldNametoValues(fieldName, list.get(j));
				jsonTemp = jsonTemp + "\'" + fieldName + "\'" + ":\'"
						+ values[i] + "\'";
				if (i != fields.length - 1) {
					jsonTemp = jsonTemp + ",";
				}
			}
			if (j != list.size() - 1) {
				jsonTemp = jsonTemp + "},";
			} else {
				jsonTemp = jsonTemp + "}";
			}
		}
		jsonTemp = jsonTemp + "]}";
		return jsonTemp;
	}

	/**
	 * 方法：getJson <br>
	 * 描述：返回列表JSONObject对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:38:56 <br>
	 * 
	 * @param dg
	 * @return
	 */
	private static JSONObject getJson(DataGrid dg) {
		JSONObject jObject = null;
		try {
			// update-begin--Author:zhaojunfu Date:20130520 for：TASK #109
			// datagrid标签没有封装合计功能
			if (!ObjectUtils.isEmpty(dg.getFooter())) {
				jObject = JSONObject.fromObject(listtojson(
						dg.getField().split(","), dg.getTotal(),
						dg.getReaults(), dg.getFooter().split(",")));
			} else {
				jObject = JSONObject.fromObject(listtojson(
						dg.getField().split(","), dg.getTotal(),
						dg.getReaults(), null));
			}
			// update-end--Author:zhaojunfu Date:20130520 for：TASK #109
			// datagrid标签没有封装合计功能
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jObject;

	}

	/**
	 * 方法：getJson <br>
	 * 描述：返回列表JSONObject对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:39:10 <br>
	 * 
	 * @param dataTable
	 * @param field
	 * @return
	 */
	private static JSONObject getJson(DataTableReturn dataTable, String field) {
		JSONObject jObject = null;
		try {
			jObject = JSONObject
					.fromObject(datatable(field,
							dataTable.getiTotalDisplayRecords(),
							dataTable.getAaData()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jObject;

	}

	/**
	 * 方法：getColumnType <br>
	 * 描述：获取指定字段类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:39:21 <br>
	 * 
	 * @param fileName
	 * @param fields
	 * @return
	 */
	public static String getColumnType(String fileName, Field[] fields) {
		String type = "";
		if (fields.length > 0) {
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName(); // 获取属性的名字
				String filedType = fields[i].getGenericType().toString(); // 获取属性的类型
				if (fileName.equals(name)) {
					if (filedType.equals("class java.lang.Integer")) {
						filedType = "int";
						type = filedType;
					} else if (filedType.equals("class java.lang.Short")) {
						filedType = "short";
						type = filedType;
					} else if (filedType.equals("class java.lang.Double")) {
						filedType = "double";
						type = filedType;
					} else if (filedType.equals("class java.util.Date")) {
						filedType = "date";
						type = filedType;
					} else if (filedType.equals("class java.lang.String")) {
						filedType = "string";
						type = filedType;
					} else if (filedType.equals("class java.sql.Timestamp")) {
						filedType = "Timestamp";
						type = filedType;
					} else if (filedType.equals("class java.lang.Character")) {
						filedType = "character";
						type = filedType;
					} else if (filedType.equals("class java.lang.Boolean")) {
						filedType = "boolean";
						type = filedType;
					} else if (filedType.equals("class java.lang.Long")) {
						filedType = "long";
						type = filedType;
					}

				}
			}
		}
		return type;
	}

	/**
	 * 方法：getSortColumnIndex <br>
	 * 描述：获取指定字段索引 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:39:31 <br>
	 * 
	 * @param fileName
	 * @param fieldString
	 * @return
	 */
	protected static String getSortColumnIndex(String fileName,
			String[] fieldString) {
		String index = "";
		if (fieldString.length > 0) {
			for (int i = 0; i < fieldString.length; i++) {
				if (fileName.equals(fieldString[i])) {
					int j = i + 1;
					index = String.valueOf(j);
				}
			}
		}
		return index;

	}

	/**
	 * 方法：datagrid <br>
	 * 描述：控件类型：easyui <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:40:08 <br>
	 * 
	 * @param response
	 * @param dg
	 */
	public static void datagrid(HttpServletResponse response, DataGrid dg) {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");

		JSONObject object = TagUtils.getJson(dg);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(object.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：datatable <br>
	 * 描述：控件类型：datatable <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:39:44 <br>
	 * 
	 * @param response
	 * @param dataTableReturn
	 * @param field
	 */
	public static void datatable(HttpServletResponse response,
			DataTableReturn dataTableReturn, String field) {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		JSONObject object = TagUtils.getJson(dataTableReturn, field);
		try {
			response.getWriter().write(object.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：getComboBox <br>
	 * 描述：根据模型生成JSON <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:39:56 <br>
	 * 
	 * @param all
	 * @param in
	 * @param comboBox
	 * @return
	 */
	public static List<ComboBox> getComboBox(List<?> all, List<?> in,
			ComboBox comboBox) {
		List<ComboBox> comboxBoxs = new ArrayList<ComboBox>();
		String[] fields = new String[] { comboBox.getId(), comboBox.getText() };
		Object[] values = new Object[fields.length];
		for (Object node : all) {
			ComboBox box = new ComboBox();
			ReflectHelper reflectHelper = new ReflectHelper(node);
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].toString();
				values[i] = reflectHelper.getMethodValue(fieldName);
			}
			box.setId(values[0].toString());
			box.setText(values[1].toString());
			if (in != null) {
				for (Object node1 : in) {
					ReflectHelper reflectHelper2 = new ReflectHelper(node);
					if (node1 != null) {
						String fieldName = fields[0].toString();
						String test = reflectHelper2.getMethodValue(fieldName)
								.toString();
						if (values[0].toString().equals(test)) {
							box.setSelected(true);
						}
					}
				}
			}
			comboxBoxs.add(box);
		}
		return comboxBoxs;

	}

	/**
	 * 方法：getFunction <br>
	 * 描述：获取自定义函数名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:40:19 <br>
	 * 
	 * @param functionname
	 * @return
	 */
	public static String getFunction(String functionname) {
		int index = functionname.indexOf("(");
		if (index == -1) {
			return functionname;
		} else {
			return functionname.substring(0, functionname.indexOf("("));
		}
	}

	/**
	 * 方法：getFunParams <br>
	 * 描述：获取自定义函数的参数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-9 下午6:40:30 <br>
	 * 
	 * @param functionname
	 * @return
	 */
	public static String getFunParams(String functionname) {
		int index = functionname.indexOf("(");
		String param = "";
		if (index != -1) {
			String testparam = functionname.substring(
					functionname.indexOf("(") + 1, functionname.length() - 1);
			if (ObjectUtils.isNotEmpty(testparam)) {
				String[] params = testparam.split(",");
				for (String string : params) {
					param += "'\"+rec." + string + "+\"',";
				}
			}
		}
		param += "'\"+index+\"'";// 传出行索引号参数
		return param;
	}

}
