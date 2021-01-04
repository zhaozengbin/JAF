/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysUserService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-04-03 下午13:45:08 <br>
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
import com.jaf.web.dao.ISysUserDao;
import com.jaf.web.dto.SysUserDto;
import com.jaf.web.pojo.SysUser;

/**
 *
 * 类名称：SysUserService <br>
 * 类描述：系统用户表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-03 下午13:45:08 <br>
 * 修改备注：TODO <br>
 *
 */
@Service("sysUserService")
public class SysUserService extends BaseService<SysUser, SysUserDto> {

	/**  */
	@Autowired
	private ISysUserDao sysUserDao;

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
	public List<SysUserDto> queryByDetailList(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]操作");
		List<SysUser> list = getDao().queryByDetailList(dto);
		List<SysUserDto> dtoList = new ArrayList<SysUserDto>();
		BeanUtils.copyBeanList(list, dtoList, getDtoName());
		dto.getPager().setRowCount(dtoList.size());
		return dtoList;
	}

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
	public SysUserDto queryDetailById(Integer id) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]操作");
		SysUser sysUser = getDao().queryDetailById(id);
		SysUserDto dto = new SysUserDto();
		BeanUtils.copyBean(sysUser, dto);
		return dto;
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.service.BaseService#getMapper()
	 */
	@Override
	public ISysUserDao getDao() {
		return sysUserDao;
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
		return LoggerUtils.getLogger(SysUserService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysUser> getPojoName() {
		return SysUser.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysUserDto> getDtoName() {
		return SysUserDto.class;
	}
}
