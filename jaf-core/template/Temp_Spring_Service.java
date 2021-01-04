/**
 * 项目名：${projectName}  <br>
 * 包名：${packagePath}.service <br>
 * 文件名：${className}Service.java <br>
 * 版本信息：TODO <br>
 * 作者：${author}<br>
 * 日期：${time} <br>
 * Copyright (c) 2013 ${copyright}-版权所有<br>
 *
 */
package ${packagePath}.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.service.BaseService;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.LoggerUtils;
import ${packagePath}.dao.I${className}Dao;
import ${packagePath}.dto.${className}Dto;
import ${packagePath}.pojo.${className};


/**
 * 
 * 类名称：${className}Service <br>
 * 类描述：${remark}服务 <br>
 * 创建人：${createUser} <br>
 * 修改人：${modifyUser} <br>
 * 修改时间：${time} <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("$!{lowerName}Service")
public class ${className}Service extends BaseService<${className},${className}Dto> {
	
	/**  */
	@Autowired
    private I${className}Dao ${lowerName}Dao;
    
    /**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see ${packagePath}.service.BaseService#getMapper()
	 */
	@Override
	public I${className}Dao getDao() {
		return ${lowerName}Dao;
	}
	
	/**
	 *  方法：getLogger <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getLogger()
	 */
	@Override
	protected Logger getLogger() {
		return LoggerUtils.getLogger(${className}Service.class);
	}
	
	/**
	 *  方法：getPojoName <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<${className}> getPojoName() {
		return ${className}.class;
	}
	
	/**
	 *  方法：getDtoName <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<${className}Dto> getDtoName() {
		return ${className}Dto.class;
	}
}
