/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.entity <br>
 * 文件名：EVelocityTemplate.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-11-下午12:21:42<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.entity;

/**
 * 
 * 类名称：EVelocityTemplate <br>
 * 类描述：velocity模版类型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-11 下午12:21:42 <br>
 * 修改备注：TODO <br>
 * 
 */
public enum EVelocityTemplate {
	CONTROLLER_SPRING("controller", "spring", "Temp_Spring_Controller.java",
			"java"), SERVICE_SPRING("service", "spring",
			"Temp_Spring_Service.java", "java"), VO_SPRING("vo", "spring",
			"Temp_Spring_Vo.java", "java"), DTO_SPRING("dto", "spring",
			"Temp_Spring_Dto.java", "java"), POJO_SPRING("model", "java",
			"Temp_Spring_Pojo.java", "java"), DAO_INTERFACE_MYBAITS("model",
			"mybatis", "Temp_MyBaits_Dao.java", "java"), DAO_IMPL_MYBAITS(
			"model", "mybatis", "Temp_MyBaits_Dao_Impl.java", "java"), MAPPERXML_MYBAITS(
			"model", "mybatis", "Temp_MyBaits_Mapper.xml", "xml");

	/** 模版类型 model - view - controller */
	private String type;

	/** 模版框架类型 spring - struts - mybatis - hibernate - java */
	private String frame;

	/** 模版文件名 TEMP_frame_type */
	private String name;

	/** 模版文件扩展名 java - xml */
	private String extension;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:29:15 <br>
	 */
	EVelocityTemplate() {
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-7-11 下午12:29:40 <br>
	 * 
	 * @param type
	 *            模版类型 model - view - controller - bean - service
	 * @param frame
	 *            模版框架类型 spring - struts - mybatis - hibernate
	 * @param name
	 *            模版文件名 TEMP_frame_type
	 * @param extension
	 *            模版文件扩展名 java - xml
	 */
	EVelocityTemplate(String type, String frame, String name, String extension) {
		this.type = type;
		this.frame = frame;
		this.name = name;
		this.extension = extension;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
