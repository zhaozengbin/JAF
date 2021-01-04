/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.main <br>
 * 文件名：Build.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-11-下午1:49:21<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.main;

import java.util.List;
import java.util.Map;

import com.jaf.common.Globals;
import com.jaf.core.dto.ColumnData;
import com.jaf.core.entity.EControllerFrame;
import com.jaf.core.entity.EDBType;
import com.jaf.core.entity.EModelFrame;
import com.jaf.core.entity.EViewFrame;
import com.jaf.core.init.Initialization;
import com.jaf.core.sql.adapter.ModelFrameAdaper;
import com.jaf.core.sql.generate.AbstractGenerateModelFrame;
import com.jaf.core.velocity.AbstractVelocity;
import com.jaf.core.velocity.adapter.VelocityAdapter;

/**
 *
 * 类名称：Build <br>
 * 类描述：建造抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-11 下午1:49:21 <br>
 * 修改备注：TODO <br>
 *
 */
public class Build {

	/** 生成类 */
	private static AbstractGenerateModelFrame generateModelFrame;

	/** 模版操作实现类 */
	private static AbstractVelocity velocity;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-16 上午9:43:40 <br>
	 */
	public Build() {

		Initialization.init();

		// 选择数据库及模型层框架
		generateModelFrame = ModelFrameAdaper.adaper(
				EModelFrame.valueOf(Globals.SYSTEM_CONFIG_MODEL_FRAME_TYPE),
				EDBType.valueOf(Globals.SYSTEM_CONFIG_SQL_TYPE));

		// 选择生成规则
		velocity = VelocityAdapter.adapter(EViewFrame
				.valueOf(Globals.SYSTEM_CONFIG_VIEW_FRAME_TYPE),
				EControllerFrame
						.valueOf(Globals.SYSTEM_CONFIG_CONTROLLER_FRAME_TYPE),
				EModelFrame.valueOf(Globals.SYSTEM_CONFIG_MODEL_FRAME_TYPE));
	}

	/**
	 * 方法：execute <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午2:45:21 <br>
	 *
	 * @param projectName
	 *            项目名
	 * @param buildPath
	 *            创建文件夹 src之后的路径 例:/main/java/com/jaf
	 * @param packagePath
	 *            包名 classes对应的项目路径之后路径 例:com.jaf
	 * @param tableName
	 *            表名
	 * @param remark
	 *            表描述 注释相关
	 */
	public void execute(String projectName, String buildPath,
			String packagePath, String tableName, String remark) {
		try {
			String className = generateModelFrame.getTablesNameToClassName(
					tableName, null);
			String lowerName = className.substring(0, 1).toLowerCase()
					+ className.substring(1, className.length());
			Map<String, Object> sqlMap = generateModelFrame
					.getAutoCreateSql(tableName);
			List<ColumnData> columnDatas = generateModelFrame
					.getColumnDatas(tableName);

			String feilds = generateModelFrame.getBeanFeilds(columnDatas);

			velocity.execute(projectName, buildPath, packagePath, className,
					lowerName, tableName, remark, sqlMap, columnDatas, feilds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Initialization.init();
		Build build = new Build();
		// String[] tables = new String[] { "sys_base_user", "sys_permission",
		// "sys_role", "sys_role_permission", "sys_team", "sys_user_role",
		// "sys_user_team", "sys_dictionary" };
		// String[] comments = new String[] { "系统基础用户表", "系统权限表", "系统角色表",
		// "系统角色权限关系表", "系统用户组表", "系统用户角色关系表", "系统用户组关系表", "系统词典" };
		String[] tables = new String[] { "sys_log" };
		String[] comments = new String[] { "系统日志表" };
		for (int i = 0; i < tables.length; i++) {
			String table = tables[i];
			String comment = comments[i];
			build.execute("jaf-web", "/main/java/com/jaf/web", "com.jaf.web",
					table, comment);
		}
	}
}
