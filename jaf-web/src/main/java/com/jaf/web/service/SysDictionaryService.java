/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysDictionaryService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 上午11:49:16 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.service.BaseService;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.web.dao.ISysDictionaryDao;
import com.jaf.web.dto.SysDictionaryDto;
import com.jaf.web.pojo.SysDictionary;


/**
 * 
 * 类名称：SysDictionaryService <br>
 * 类描述：系统词典服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysDictionaryService")
public class SysDictionaryService extends BaseService<SysDictionary,SysDictionaryDto> {
	
	/**  */
	@Autowired
    private ISysDictionaryDao sysDictionaryDao;
    
    /**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.web.service.BaseService#getMapper()
	 */
	@Override
	public ISysDictionaryDao getDao() {
		return sysDictionaryDao;
	}
	
	/**
	 *  方法：getLogger <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getLogger()
	 */
	@Override
	protected Logger getLogger() {
		return LoggerUtils.getLogger(SysDictionaryService.class);
	}
	
	/**
	 *  方法：getPojoName <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysDictionary> getPojoName() {
		return SysDictionary.class;
	}
	
	/**
	 *  方法：getDtoName <br>
	 *  描述：TODO <br>
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysDictionaryDto> getDtoName() {
		return SysDictionaryDto.class;
	}
}
