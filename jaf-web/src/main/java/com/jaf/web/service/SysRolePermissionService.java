/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysRolePermissionService.java <br>
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
import com.jaf.web.dao.ISysRolePermissionDao;
import com.jaf.web.dto.SysRolePermissionDto;
import com.jaf.web.dto.SysUserRoleDto;
import com.jaf.web.pojo.SysRolePermission;

/**
 * 
 * 类名称：SysRolePermissionService <br>
 * 类描述：系统角色权限关系表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:16 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysRolePermissionService")
public class SysRolePermissionService extends
		BaseService<SysRolePermission, SysRolePermissionDto> {

	/**  */
	@Autowired
	private ISysRolePermissionDao sysRolePermissionDao;

	/**
	 * 方法：queryByRoleIds <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午11:43:42 <br>
	 * 
	 * @param sysUserRoleDtoList
	 * @return
	 * @throws Exception
	 */
	public List<SysRolePermissionDto> queryByRoleIds(
			List<SysUserRoleDto> sysUserRoleDtoList) throws Exception {
		if (ObjectUtils.isNotEmpty(sysUserRoleDtoList)) {
			List<Integer> roleIds = new ArrayList<Integer>();
			for (SysUserRoleDto dto : sysUserRoleDtoList) {
				roleIds.add(dto.getUserId());
			}
			List<SysRolePermission> pojoList = getDao().queryByRoleIds(roleIds);
			if (ObjectUtils.isNotEmpty(pojoList)) {
				List<SysRolePermissionDto> dtoList = new ArrayList<SysRolePermissionDto>();
				BeanUtils.copyBeanList(pojoList, dtoList,
						SysRolePermissionDto.class);
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
	public ISysRolePermissionDao getDao() {
		return sysRolePermissionDao;
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
		return LoggerUtils.getLogger(SysRolePermissionService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysRolePermission> getPojoName() {
		return SysRolePermission.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysRolePermissionDto> getDtoName() {
		return SysRolePermissionDto.class;
	}
}
