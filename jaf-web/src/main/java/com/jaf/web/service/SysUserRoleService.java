/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysUserRoleService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 上午11:49:16 <br>
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
import com.jaf.web.dao.ISysUserRoleDao;
import com.jaf.web.dto.SysUserRoleDto;
import com.jaf.web.pojo.SysUserRole;

/**
 *
 * 类名称：SysUserRoleService <br>
 * 类描述：系统用户角色关系表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 *
 */
@Service("sysUserRoleService")
public class SysUserRoleService extends
		BaseService<SysUserRole, SysUserRoleDto> {

	/**  */
	@Autowired
	private ISysUserRoleDao sysUserRoleDao;

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
	public List<SysUserRoleDto> queryByUserId(Integer userId) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询操作");
		SysUserRoleDto dto = new SysUserRoleDto();
		dto.setUserId(userId);
		List<SysUserRole> pojoList = getDao().queryByList(dto);
		if (ObjectUtils.isNotEmpty(pojoList)) {
			List<SysUserRoleDto> dtoList = new ArrayList<SysUserRoleDto>();
			BeanUtils.copyBeanList(pojoList, dtoList, SysUserRoleDto.class);
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
	public void deleteByRoleId(Integer roleId) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行删除操作");
		getDao().deleteByRoleId(roleId);
	}

	/**
	 * 方法：queryByUserIds <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午11:39:20 <br>
	 *
	 * @param sysUserRoleDtoList
	 * @return
	 * @throws Exception
	 */
	public List<SysUserRoleDto> queryByUserIds(
			List<SysUserRoleDto> sysUserRoleDtoList) throws Exception {
		if (ObjectUtils.isNotEmpty(sysUserRoleDtoList)) {
			List<Integer> userIds = new ArrayList<Integer>();
			for (SysUserRoleDto dto : sysUserRoleDtoList) {
				userIds.add(dto.getUserId());
			}
			List<SysUserRole> pojoList = getDao().queryByUserIds(userIds);
			if (ObjectUtils.isNotEmpty(pojoList)) {
				List<SysUserRoleDto> dtoList = new ArrayList<SysUserRoleDto>();
				BeanUtils.copyBeanList(pojoList, dtoList, SysUserRoleDto.class);
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
	public ISysUserRoleDao getDao() {
		return sysUserRoleDao;
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
		return LoggerUtils.getLogger(SysUserRoleService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysUserRole> getPojoName() {
		return SysUserRole.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysUserRoleDto> getDtoName() {
		return SysUserRoleDto.class;
	}
}
