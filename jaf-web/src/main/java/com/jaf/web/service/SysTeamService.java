/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.service <br>
 * 文件名：SysTeamService.java <br>
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
import com.jaf.web.dao.ISysTeamDao;
import com.jaf.web.dto.SysTeamDto;
import com.jaf.web.dto.SysUserTeamDto;
import com.jaf.web.pojo.SysTeam;

/**
 *
 * 类名称：SysTeamService <br>
 * 类描述：系统用户组表服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-24 下午17:18:00 <br>
 * 修改备注：TODO <br>
 *
 */
@Service("sysTeamService")
public class SysTeamService extends BaseService<SysTeam, SysTeamDto> {

	/**  */
	@Autowired
	private ISysTeamDao sysTeamDao;

	/**
	 * 方法：queryByIds <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午9:35:51 <br>
	 *
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public List<SysTeamDto> queryByIds(List<SysUserTeamDto> sysUserTeamDtoList)
			throws Exception {
		if (ObjectUtils.isNotEmpty(sysUserTeamDtoList)) {
			// 判断如果集合不为空则转换为ID组合
			List<Integer> ids = new ArrayList<Integer>();
			for (SysUserTeamDto sysUserTeamDto : sysUserTeamDtoList) {
				ids.add(sysUserTeamDto.getTeamId());
			}
			List<SysTeam> pojoList = getDao().queryByIds(ids);
			if (ObjectUtils.isNotEmpty(pojoList)) {
				List<SysTeamDto> dtoList = new ArrayList<SysTeamDto>();
				BeanUtils.copyBeanList(pojoList, dtoList, SysTeamDto.class);
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
	public ISysTeamDao getDao() {
		return sysTeamDao;
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
		return LoggerUtils.getLogger(SysTeamService.class);
	}

	/**
	 * 方法：getPojoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getPojoName()
	 */
	@Override
	protected Class<SysTeam> getPojoName() {
		return SysTeam.class;
	}

	/**
	 * 方法：getDtoName <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.core.service.BaseService#getDtoName()
	 */
	@Override
	protected Class<SysTeamDto> getDtoName() {
		return SysTeamDto.class;
	}
}
