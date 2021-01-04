/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.sql.generate <br>
 * 文件名：GenerateByMyBatisAndMysql.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-10-下午1:59:10<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.sql.generate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jaf.core.dto.ColumnData;
import com.jaf.core.entity.ESpecialCharacters;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.core.velocity.AbstractVelocity;

/**
 * 
 * 类名称：GenerateByMyBatisAndMysql <br>
 * 类描述：生成MyBatis方法 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-10 下午1:59:10 <br>
 * 修改备注：TODO <br>
 * 
 */
public class GenerateByMyBatisAndMysql extends AbstractGenerateModelFrame {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils
			.getLogger(GenerateByMyBatisAndMysql.class);

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:03:32 <br>
	 */
	public GenerateByMyBatisAndMysql() {
		super();
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午2:00:59 <br>
	 */
	public GenerateByMyBatisAndMysql(AbstractGetData getDate) {
		super(getDate);
	}

	/**
	 * 方法：getAutoCreateSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getAutoCreateSql(java.lang.String)
	 */
	@Override
	public Map<String, Object> getAutoCreateSql(String TABleName)
			throws Exception {
		Map<String, Object> sqlMap = new HashMap<String, Object>();
		List<ColumnData> columnDatas = getDate.getColumnDatas(TABleName);
		LoggerUtils.debug(LOGGER, "开始根据表:[" + TABleName + "]生成Sql");
		String columns = this.getColumnSplit(columnDatas);
		// 表所有字段
		String[] columnList = getColumnList(columns);
		// 表所有字段 按","隔开
		String columnFields = getColumnFields(columns);
		// 组装插入语句
		String insert = getInsertSql(TABleName, columns);
		// 组装修改语句
		String update = getUpdateSql(TABleName, columnList);
		// 组装修改语句
		String updateSelective = getUpdateSelectiveSql(TABleName, columnDatas);
		// 组装查询语句
		String selectById = getSelectByIdSql(TABleName, columnList);
		// 组装删除语句
		String delete = getDeleteSql(TABleName, columnList);
		sqlMap.put("columnDatas", columnDatas);
		sqlMap.put("columnList", columnList);
		sqlMap.put("columnFields", columnFields);
		sqlMap.put(
				"insert",
				insert.replace("#{createTime}", "now()").replace(
						"#{updateTime}", "now()"));
		sqlMap.put(
				"update",
				update.replace("#{createTime}", "now()").replace(
						"#{updateTime}", "now()"));
		sqlMap.put("delete", delete);
		sqlMap.put("updateSelective", updateSelective);
		sqlMap.put("selectById", selectById);
		return sqlMap;
	}

	/**
	 * 方法：getDeleteSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getDeleteSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getDeleteSql(String TABleName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("delete ");
		sb.append(ESpecialCharacters.TAB.getEscape());
		sb.append(" from ");
		sb.append(TABleName);
		sb.append(" where ");
		sb.append(columnsList[0]);
		sb.append(" = #{");
		sb.append(columnsList[0]);
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 方法：getInsertSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @param columns
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getInsertSql(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String getInsertSql(String TABleName, String columns)
			throws Exception {
		return "insert into " + TABleName + "("
				+ columns.replaceAll("\\|", ",") + ")\n values(#{"
				+ columns.replaceAll("\\|", "},#{") + "})";
	}

	/**
	 * 方法：getSelectByIdSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getSelectByIdSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getSelectByIdSql(String TABleName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select <include refid=\"Base_Column_List\" /> "
				+ ESpecialCharacters.WRAP.getEscape());
		sb.append(ESpecialCharacters.TAB.getEscape());
		sb.append(" from ");
		sb.append(TABleName);
		sb.append(" where ");
		sb.append(columnsList[0]);
		sb.append(" = #{");
		sb.append(columnsList[0]);
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 方法：getColumnFields <br>
	 * 描述：TODO <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnFields(java.lang.String)
	 */
	@Override
	public String getColumnFields(String columns) throws Exception {
		String fields = columns;
		if (ObjectUtils.isNotEmpty(fields)) {
			fields = fields.replaceAll("[|]", ",");
		}
		return fields;
	}

	/**
	 * 方法：getColumnList <br>
	 * 描述：TODO <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnList(java.lang.String)
	 */
	@Override
	public String[] getColumnList(String columns) throws Exception {
		String[] columnList = columns.split("[|]");
		return columnList;
	}

	/**
	 * 方法：getUpdateSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getUpdateSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getUpdateSql(String TABleName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < columnsList.length; i++) {
			String column = columnsList[i];
			if ("CREATETIME".equals(column.toUpperCase())) {
				continue;
			}
			if ("UPDATETIME".equals(column.toUpperCase())) {
				sb.append(column + "=now()");
			} else {
				sb.append(column + "=#{" + column + "}");
			}
			// 最后一个字段不需要","
			if ((i + 1) < columnsList.length) {
				sb.append(",");
			}
		}
		String update = "update " + TABleName + " set " + sb.toString()
				+ " where " + columnsList[0] + "=#{" + columnsList[0] + "}";
		return update;
	}

	/**
	 * 方法：getUpdateSelectiveSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @param columnList
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getUpdateSelectiveSql(java.lang.String,
	 *      java.util.List)
	 */
	@Override
	public String getUpdateSelectiveSql(String TABleName,
			List<ColumnData> columnList) throws Exception {
		StringBuffer sb = new StringBuffer();
		ColumnData cd = columnList.get(0); // 获取第一条记录，主键
		sb.append(ESpecialCharacters.TAB.getEscape());
		sb.append("<trim  suffixOverrides=\",\" >");
		sb.append(ESpecialCharacters.WRAP.getEscape());
		for (int i = 1; i < columnList.size(); i++) {
			ColumnData data = columnList.get(i);
			String columnName = data.getColumnName();
			System.out.println(columnName);
			sb.append(ESpecialCharacters.TAB.getEscape());
			sb.append("<if test=\"" + columnName + " != null ");
			// String 还要判断是否为空
			if ("String" == data.getDataType()) {
				sb.append(" and " + columnName + " != ''");
			}
			sb.append(" \">");
			sb.append(ESpecialCharacters.WRAP.getEscape());
			sb.append(ESpecialCharacters.TAB.getEscape());
			sb.append(ESpecialCharacters.TAB.getEscape());
			sb.append(columnName + "=#{" + columnName + "},"
					+ ESpecialCharacters.WRAP.getEscape());
			sb.append(ESpecialCharacters.TAB.getEscape() + "</if>"
					+ ESpecialCharacters.WRAP.getEscape());
		}
		sb.append(ESpecialCharacters.TAB.getEscape() + "</trim>");
		String update = "update " + TABleName + " set "
				+ ESpecialCharacters.WRAP.getEscape() + sb.toString()
				+ " where " + cd.getColumnName() + "=#{" + cd.getColumnName()
				+ "}";
		return update;
	}

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：TODO <br>
	 * 
	 * @param TABleName
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnDatas(java.lang.String)
	 */
	@Override
	public List<ColumnData> getColumnDatas(String TABleName) throws Exception {
		return getDate.getColumnDatas(TABleName);
	}

	/**
	 * 方法：getColumnSplit <br>
	 * 描述：TODO <br>
	 * 
	 * @param columnList
	 * @return
	 * @throws Exception
	 * @see com.jaf.core.sql.generate.AbstractGenerateModelFrame#getColumnSplit(java.util.List)
	 */
	@Override
	public String getColumnSplit(List<ColumnData> columnList) throws Exception {
		StringBuffer commonColumns = new StringBuffer();
		for (ColumnData data : columnList) {
			commonColumns.append(data.getColumnName() + "|");
		}
		return commonColumns.delete(commonColumns.length() - 1,
				commonColumns.length()).toString();
	}

}
