/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.velocity <br>
 * 文件名：Velocity4SpringMVCAndMyBatis.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-11-下午12:19:53<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.velocity;

import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.jaf.core.dto.ColumnData;
import com.jaf.core.entity.EVelocityTemplate;

/**
 * 
 * 类名称：Velocity4SpringMVCAndMyBatis <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-11 下午12:19:53 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Velocity4SpringMVCAndMyBatis extends AbstractVelocity {

	/**
	 * 方法：execute <br>
	 * 描述：TODO <br>
	 * 
	 * @param projectName
	 * @param buildPath
	 * @param packagePath
	 * @param className
	 * @param lowerName
	 * @param tableName
	 * @param remark
	 * @param sqlMap
	 * @param columnDatas
	 * @param feilds
	 * @see com.jaf.core.velocity.AbstractVelocity#execute(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, java.util.Map,
	 *      java.util.List, java.lang.String)
	 */
	@Override
	public void execute(String projectName, String buildPath,
			String packagePath, String className, String lowerName,
			String tableName, String remark, Map<String, Object> sqlMap,
			List<ColumnData> columnDatas, String feilds) {
		VelocityContext velocityContext = put(projectName, packagePath,
				className, lowerName, tableName, remark, sqlMap, columnDatas,
				feilds);
		writeVo(velocityContext, buildPath, className);
		writeController(velocityContext, buildPath, className);
		writeService(velocityContext, buildPath, className);
		writeDao(velocityContext, buildPath, className);
		writeMapper(velocityContext, buildPath, className);
		writePojo(velocityContext, buildPath, className);
		writeDto(velocityContext, buildPath, className);
	}

	/**
	 * 方法：writePojo <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writePojo(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writePojo(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className, EVelocityTemplate.POJO_SPRING.getName(),
				getPckPath(buildPath), getPojoPath(className));
	}

	/**
	 * 方法：writeVo <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeVo(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeVo(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className, EVelocityTemplate.VO_SPRING.getName(),
				getPckPath(buildPath), getVoPath(className));
	}

	/**
	 * 方法：writeDto <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeDto(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeDto(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className, EVelocityTemplate.DTO_SPRING.getName(),
				getPckPath(buildPath), getDtoPath(className));
	}

	/**
	 * 方法：writeDao <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeDao(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeDao(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className,
				EVelocityTemplate.DAO_INTERFACE_MYBAITS.getName(),
				getPckPath(buildPath), getDaoInterfacePath(className));
		// writePage(context, className,
		// EVelocityTemplate.DAO_IMPL_MYBAITS.getName(),
		// getPckPath(buildPath), getDaoImplPath(className));
	}

	/**
	 * 方法：writeMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeMapper(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeMapper(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className,
				EVelocityTemplate.MAPPERXML_MYBAITS.getName(),
				getPckPath(buildPath), getSqlMapperPath(className));
	}

	/**
	 * 方法：writeService <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeService(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeService(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className,
				EVelocityTemplate.SERVICE_SPRING.getName(),
				getPckPath(buildPath), getServiceInterfacePath((className)));
	}

	/**
	 * 方法：writeController <br>
	 * 描述：TODO <br>
	 * 
	 * @param context
	 * @param buildPath
	 * @param className
	 * @see com.jaf.core.velocity.AbstractVelocity#writeController(org.apache.velocity.VelocityContext,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void writeController(VelocityContext context, String buildPath,
			String className) {
		writePage(context, className,
				EVelocityTemplate.CONTROLLER_SPRING.getName(),
				getPckPath(buildPath), getController(className));

	}

}
