/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysLogService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-04-11 下午18:06:53 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaf.core.dto.BaseDto;
import com.jaf.core.service.BaseService;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.web.dao.ISysLogDao;
import com.jaf.web.dto.SysLogDto;
import com.jaf.web.pojo.SysLog;

/**
 *
 * 类名称：SysLogService <br>
 * 类描述：系统日志表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-11 下午18:06:53 <br>
 * 修改备注：TODO <br>
 *
 */
@Service("sysLogService")
public class SysLogService extends BaseService<SysLog, SysLogDto> {

	/**  */
	@Autowired
	private ISysLogDao sysLogDao;

	/**
	 * 方法：queryByDetailList <br>
	 * 描述：查询日志详细信息列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午3:28:49 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<SysLogDto> queryByDetailList(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]操作");

		List<SysLog> list = getDao().queryByDetailList(dto);
		List<SysLogDto> dtoList = new ArrayList<SysLogDto>();
		BeanUtils.copyBeanList(list, dtoList, getDtoName());
		return dtoList;
	}

	/**
	 * 方法：queryByDetailListCount <br>
	 * 描述：查询日志详细列表总数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午5:38:34 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public Integer queryByDetailListCount(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]总数操作");

		return getDao().queryByDetailListCount(dto);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.service.BaseService#getMapper()
	 */
	@Override
	public ISysLogDao getDao() {
		return sysLogDao;
	}

	/**
	 * 方法：getLogger <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getLogger()
	 */
	@Override
	protected Logger getLogger() {
		return LoggerUtils.getLogger(SysLogService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysLog> getPojoName() {
		return SysLog.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysLogDto> getDtoName() {
		return SysLogDto.class;
	}
}
