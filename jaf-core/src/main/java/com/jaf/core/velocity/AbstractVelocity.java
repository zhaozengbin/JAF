/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.velocity <br>
 * 文件名：AbstractVelocity.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-11-下午12:01:59<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.velocity;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;

import com.jaf.common.Globals;
import com.jaf.core.dto.ColumnData;
import com.jaf.core.util.CommonPageParser;
import com.jaf.core.util.DateUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.core.util.SystemUtils;

/**
 * 
 * 类名称：AbstractVelocity <br>
 * 类描述：Velocity抽象模版类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-11 下午12:01:59 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractVelocity {

	/** 输出日志 */
	private static final Logger LOGGER = LoggerUtils
			.getLogger(AbstractVelocity.class);

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午5:09:52 <br>
	 */
	public AbstractVelocity() {
	}

	/**
	 * 方法：getSrcPath <br>
	 * 描述：获取SRC路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:34:20 <br>
	 * 
	 * @return
	 */
	public String getSrcPath() {
		return SystemUtils.getRealPath() + "src" + File.separator;
	}

	/**
	 * 方法：getPckPath <br>
	 * 描述：获取包路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:35:08 <br>
	 * 
	 * @param buildPath
	 *            创建文件夹 src之后的路径 例:/main/java/com/jaf
	 * 
	 * 
	 * @return
	 */
	public String getPckPath(String buildPath) {
		String[] paths = null;
		if (buildPath.contains(".")) {
			paths = buildPath.split("\\.");

		} else if (buildPath.contains("/")) {
			paths = buildPath.split("/");
		} else if (buildPath.contains("\\")) {
			paths = buildPath.split("\\");
		}
		if (ObjectUtils.isNotEmpty(paths)) {
			buildPath = "";
			for (String path : paths) {
				buildPath += path + File.separator;
			}
		}
		String pckPath = SystemUtils.getProjectRootPath() + "src"
				+ File.separator + buildPath;
		return pckPath;
	}

	/**
	 * 方法：getWebPath <br>
	 * 描述：获取WEB路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午6:35:56 <br>
	 * 
	 * @return
	 */
	public String getWebPath() {
		return SystemUtils.getRealPath() + File.separator + "WebContent"
				+ File.separator + "jsp" + File.separator;
	}

	/**
	 * 方法：getVoPath <br>
	 * 描述：获取展现对象相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:05:21 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getVoPath(String className) {
		return "web" + File.separator + "vo" + File.separator + className
				+ "Vo.java";
	}

	/**
	 * 方法：getDtoPath <br>
	 * 描述：获取传输对象相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:05:21 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getDtoPath(String className) {
		return "dto" + File.separator + className + "Dto.java";
	}

	/**
	 * 方法：getPojoPath <br>
	 * 描述：获取bean相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:08:15 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getPojoPath(String className) {
		return "pojo" + File.separator + className + ".java";
	}

	/**
	 * 方法：getDaoInterfacePath <br>
	 * 描述：获取Dao实体相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:37:11 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getDaoInterfacePath(String className) {
		return "dao" + File.separator + "I" + className + "Dao.java";
	}

	/**
	 * 方法：getDaoImplPath <br>
	 * 描述：获取Dao实体相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:37:11 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getDaoImplPath(String className) {
		return "dao" + File.separator + "impl" + File.separator + className
				+ "DaoImpl.java";
	}

	/**
	 * 方法：getServiceInterfacePath <br>
	 * 描述：获取service相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:37:59 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getServiceInterfacePath(String className) {
		return "service" + File.separator + className + "Service.java";
	}

	/**
	 * 方法：getServiceImplPath <br>
	 * 描述：获取service相对地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:37:59 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getServiceImplPath(String className) {
		return "service" + File.separator + "impl" + File.separator + className
				+ "Service.java";
	}

	/**
	 * 方法：getController <br>
	 * 描述：获取控制层实体相对路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:38:57 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getController(String className) {
		return "web" + File.separator + "action" + File.separator
				+ className.toLowerCase() + File.separator + className
				+ "Action.java";
	}

	/**
	 * 方法：getSqlMapperPath <br>
	 * 描述：获取sqlMapper相对路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-10 下午4:39:58 <br>
	 * 
	 * @param className
	 * @return
	 */
	public String getSqlMapperPath(String className) {
		return "pojo" + File.separator + "xml" + File.separator + className
				+ "Mapper.xml";
	}

	/**
	 * 方法：put <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午2:38:53 <br>
	 * 
	 * @param projectName
	 *            项目名
	 * @param packagePath
	 *            包路径
	 * @param className
	 *            类名
	 * @param lowerName
	 *            小写名称
	 * @param tableName
	 *            表名
	 * @param remark
	 *            注释 类中文名
	 * @param sqlMap
	 *            sql语句
	 * 
	 * @param columnDatas
	 *            属性列表
	 * 
	 * @param feilds
	 *            字段列表
	 * @return
	 */
	public VelocityContext put(String projectName, String packagePath,
			String className, String lowerName, String tableName,
			String remark, Map<String, Object> sqlMap,
			List<ColumnData> columnDatas, String feilds) {
		VelocityContext context = new VelocityContext();
		context.put("projectName", projectName); //
		context.put("packagePath", packagePath);
		context.put("className", className); //
		context.put("lowerName", lowerName);
		context.put("tableName", tableName);

		// 设置注释相关信息
		context.put("time", DateUtils.currentDateFor12Hour(
				DateUtils.YYYY_MM_DD, DateUtils.HH_MM_SS));
		context.put("author", Globals.NOTE_CONFIG_AUTHOR);
		context.put("createUser", Globals.NOTE_CONFIG_CREATE_USER);
		context.put("modifyUser", Globals.NOTE_CONFIG_MODIFY_USER);
		context.put("remark", remark);
		context.put("copyright", Globals.NOTE_CONFIG_COPYRIGHT);
		context.put("classNameLower", className.toLowerCase());
		// 生成sql语句
		context.put("SQL", sqlMap);
		context.put("columnDatas", columnDatas);
		context.put("feilds", feilds);
		return context;
	}

	/**
	 * 方法：writeBean <br>
	 * 描述：根据模版写bean文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writePojo(VelocityContext context, String buildPath,
			String className);

	/**
	 * 方法：writeVo <br>
	 * 描述：根据模版写vo文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeVo(VelocityContext context, String buildPath,
			String className);

	/**
	 * 方法：writeDto <br>
	 * 描述：根据模版写Dto文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeDto(VelocityContext context, String buildPath,
			String className);

	/**
	 * 方法：writeDao <br>
	 * 描述：根据模版写DAO文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeDao(VelocityContext context, String buildPath,
			String className);

	/**
	 * 方法：writeMapper <br>
	 * 描述：根据模版写POJO配置文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeMapper(VelocityContext context, String buildPath,
			String className);

	/**
	 * 方法：writeService <br>
	 * 描述：根据模版写service文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeService(VelocityContext context,
			String buildPath, String className);

	/**
	 * 方法：writeController <br>
	 * 描述：根据模版写controller文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:12:31 <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 */
	public abstract void writeController(VelocityContext context,
			String buildPath, String className);

	/**
	 * 方法：writePage <br>
	 * 描述：公用生成文件方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午1:20:11 <br>
	 * 
	 * @param context
	 *            生成文件内容
	 * @param className
	 *            生成文件类名
	 * @param templateName
	 *            生成文件模版
	 * @param pckPath
	 *            包路径
	 * @param path
	 *            文件路径
	 */
	public void writePage(VelocityContext context, String className,
			String templateName, String pckPath, String path) {
		LoggerUtils.debug(LOGGER, "生成文件信息,文件内容:[" + context + "],模版名称:["
				+ templateName + "],包路径:[" + pckPath + "],路径:[" + path + "]");
		CommonPageParser.WriterPage(context, templateName, pckPath, path);
	}

	/**
	 * 方法：execute <br>
	 * 描述：执行根据模版生成文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午1:46:04 <br>
	 * 
	 * @param projectName
	 *            项目名
	 * @param buildPath
	 *            创建文件夹 src之后的路径 例:/main/java/com/jaf
	 * @param packagePath
	 *            包名 classes对应的项目路径之后路径 例:com.jaf
	 * @param className
	 *            类名
	 * @param lowerName
	 *            小写名称
	 * @param tableName
	 *            表名
	 * @param remark
	 *            注释 类中文名
	 * @param sqlMap
	 *            sql语句
	 * 
	 * @param columnDatas
	 *            属性列表
	 * 
	 * @param feilds
	 *            字段列表
	 */
	public abstract void execute(String projectName, String buildPath,
			String packagePath, String className, String lowerName,
			String tableName, String remark, Map<String, Object> sqlMap,
			List<ColumnData> columnDatas, String feilds);
}
