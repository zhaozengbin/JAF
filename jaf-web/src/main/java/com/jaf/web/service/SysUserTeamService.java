/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysUserTeamService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 下午17:18:00 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaf.core.service.BaseService;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dao.ISysUserTeamDao;
import com.jaf.web.dto.SysUserTeamDto;
import com.jaf.web.pojo.SysUserTeam;

/**
 *
 * 类名称：SysUserTeamService <br>
 * 类描述：系统用户组关系表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 *
 */
@Service("sysUserTeamService")
public class SysUserTeamService extends
		BaseService<SysUserTeam, SysUserTeamDto> {

	/**  */
	@Autowired
	private ISysUserTeamDao sysUserTeamDao;

	/**
	 * 方法：queryByUserId <br>
	 * 描述：根据用户ID查询系统用户组关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午5:48:47 <br>
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<SysUserTeamDto> queryByUserId(Integer userId) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询操作");
		SysUserTeamDto dto = new SysUserTeamDto();
		dto.setUserId(userId);
		List<SysUserTeam> pojoList = getDao().queryByList(dto);
		if (ObjectUtils.isNotEmpty(pojoList)) {
			List<SysUserTeamDto> dtoList = new ArrayList<SysUserTeamDto>();
			BeanUtils.copyBeanList(pojoList, dtoList, SysUserTeamDto.class);
			return dtoList;
		}
		return null;
	}

	/**
	 * 方法：queryByTeamId <br>
	 * 描述：根据组ID查询系统用户组关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午6:05:28 <br>
	 *
	 * @param teamId
	 * @return
	 * @throws Exception
	 */
	public List<SysUserTeamDto> queryByTeamId(Integer teamId) throws Exception {
		SysUserTeamDto dto = new SysUserTeamDto();
		dto.setTeamId(teamId);
		List<SysUserTeam> pojoList = getDao().queryByList(dto);
		if (ObjectUtils.isNotEmpty(pojoList)) {
			List<SysUserTeamDto> dtoList = new ArrayList<SysUserTeamDto>();
			BeanUtils.copyBeanList(pojoList, dtoList, SysUserTeamDto.class);
			return dtoList;
		}
		return null;
	}

	/**
	 * 方法：deleteByUserId <br>
	 * 描述：根据用户编号删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-8 下午4:12:22 <br>
	 *
	 * @param userId
	 * @throws Exception
	 */
	public void deleteByUserId(Integer userId) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行删除操作");
		getDao().deleteByUserId(userId);
	}

	/**
	 * 方法：deleteByRoleId <br>
	 * 描述：根据用户编号删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-8 下午4:12:22 <br>
	 *
	 * @param userId
	 * @throws Exception
	 */
	public void deleteByTeamId(Integer teamId) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行删除操作");
		getDao().deleteByTeamId(teamId);
	}

	/**
	 * 方法：queryByTeamIds <br>
	 * 描述：根据组ID查询系统用户组关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-24 下午6:05:28 <br>
	 *
	 * @param sysUserTeamDtoList
	 * @return
	 * @throws Exception
	 */
	public List<SysUserTeamDto> queryByTeamIds(
			List<SysUserTeamDto> sysUserTeamDtoList) throws Exception {
		if (ObjectUtils.isNotEmpty(sysUserTeamDtoList)) {
			List<Integer> teamIds = new ArrayList<Integer>();
			for (SysUserTeamDto dto : sysUserTeamDtoList) {
				teamIds.add(dto.getTeamId());
			}
			List<SysUserTeam> pojoList = getDao().queryByTeamIds(teamIds);
			if (ObjectUtils.isNotEmpty(pojoList)) {
				List<SysUserTeamDto> dtoList = new ArrayList<SysUserTeamDto>();
				BeanUtils.copyBeanList(pojoList, dtoList, SysUserTeamDto.class);
				return dtoList;
			}
		}
		return null;
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.service.BaseService#getMapper()
	 */
	@Override
	public ISysUserTeamDao getDao() {
		return sysUserTeamDao;
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
		return LoggerUtils.getLogger(SysUserTeamService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysUserTeam> getPojoName() {
		return SysUserTeam.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysUserTeamDto> getDtoName() {
		return SysUserTeamDto.class;
	}
}
