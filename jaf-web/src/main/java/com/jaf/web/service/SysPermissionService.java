/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysPermissionService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-24 上午11:49:15 <br>
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
import com.jaf.web.dao.ISysPermissionDao;
import com.jaf.web.dto.SysPermissionDto;
import com.jaf.web.dto.SysRolePermissionDto;
import com.jaf.web.pojo.SysPermission;

/**
 * 
 * 类名称：SysPermissionService <br>
 * 类描述：系统权限表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 上午11:49:15 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysPermissionService")
public class SysPermissionService extends
		BaseService<SysPermission, SysPermissionDto> {

	/**  */
	@Autowired
	private ISysPermissionDao sysPermissionDao;

	/**
	 * 方法：queryByIds <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午11:49:15 <br>
	 * 
	 * @param sysRolePermissionDtoList
	 * @return
	 * @throws Exception
	 */
	public List<SysPermissionDto> queryByIds(
			List<SysRolePermissionDto> sysRolePermissionDtoList)
			throws Exception {
		if (ObjectUtils.isNotEmpty(sysRolePermissionDtoList)) {
			// 判断如果集合不为空则转换为ID组合
			List<Integer> ids = new ArrayList<Integer>();
			for (SysRolePermissionDto sysRolePermissionDto : sysRolePermissionDtoList) {
				ids.add(sysRolePermissionDto.getPermissionId());
			}
			List<SysPermission> pojoList = getDao().queryByIds(ids);
			if (ObjectUtils.isNotEmpty(pojoList)) {
				List<SysPermissionDto> dtoList = new ArrayList<SysPermissionDto>();
				BeanUtils.copyBeanList(pojoList, dtoList,
						SysPermissionDto.class);
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
	public ISysPermissionDao getDao() {
		return sysPermissionDao;
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
		return LoggerUtils.getLogger(SysPermissionService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysPermission> getPojoName() {
		return SysPermission.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysPermissionDto> getDtoName() {
		return SysPermissionDto.class;
	}
}
