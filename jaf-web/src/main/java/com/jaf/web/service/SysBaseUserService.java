/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysBaseUserService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-11-06 下午16:19:59 <br>
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
import com.jaf.web.dao.ISysBaseUserDao;
import com.jaf.web.dto.SysBaseUserDto;
import com.jaf.web.pojo.SysBaseUser;

/**
 * 
 * 类名称：SysBaseUserService <br>
 * 类描述：系统基础用户表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-06 下午16:19:59 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysBaseUserService")
public class SysBaseUserService extends
		BaseService<SysBaseUser, SysBaseUserDto> {

	/**  */
	@Autowired
	private ISysBaseUserDao sysBaseUserDao;

	/**
	 * 方法：queryByDetailList <br>
	 * 描述：查询用户详细信息列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午3:28:49 <br>
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<SysBaseUserDto> queryByDetailList(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]操作");
		List<SysBaseUser> list = getDao().queryByDetailList(dto);
		List<SysBaseUserDto> dtoList = new ArrayList<SysBaseUserDto>();
		BeanUtils.copyBeanList(list, dtoList, getDtoName());
		dto.getPager().setRowCount(dtoList.size());
		return dtoList;
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.web.service.BaseService#getMapper()
	 */
	@Override
	public ISysBaseUserDao getDao() {
		return sysBaseUserDao;
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
		return LoggerUtils.getLogger(SysBaseUserService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysBaseUser> getPojoName() {
		return SysBaseUser.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysBaseUserDto> getDtoName() {
		return SysBaseUserDto.class;
	}
}
