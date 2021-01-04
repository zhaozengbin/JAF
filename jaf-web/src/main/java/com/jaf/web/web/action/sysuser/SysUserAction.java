/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.action.sysuser <br>
 * 文件名：SysUserAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-04-03 下午13:45:08 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.action.sysuser;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaf.core.controller.BaseAction;
import com.jaf.core.entity.EStatus;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.annotaction.AuthAnnotaction;
import com.jaf.web.dto.SysBaseUserDto;
import com.jaf.web.dto.SysRoleDto;
import com.jaf.web.dto.SysTeamDto;
import com.jaf.web.dto.SysUserDto;
import com.jaf.web.dto.SysUserRoleDto;
import com.jaf.web.dto.SysUserTeamDto;
import com.jaf.web.dto.easyui.DataGrid;
import com.jaf.web.service.SysBaseUserService;
import com.jaf.web.service.SysRoleService;
import com.jaf.web.service.SysTeamService;
import com.jaf.web.service.SysUserRoleService;
import com.jaf.web.service.SysUserService;
import com.jaf.web.service.SysUserTeamService;
import com.jaf.web.tag.util.TagUtils;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.AjaxJsonVo;
import com.jaf.web.web.vo.SysBaseUserVo;
import com.jaf.web.web.vo.SysRoleVo;
import com.jaf.web.web.vo.SysTeamVo;
import com.jaf.web.web.vo.SysUserVo;
import com.jaf.web.web.vo.ValidForm;

/**
 *
 * 类名称：SysUserAction <br>
 * 类描述：系统用户表Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-03 下午13:45:08 <br>
 * 修改备注：TODO <br>
 *
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserAction extends BaseAction {

	/* 输出日志* */
	private final static Logger LOGGER = LoggerUtils
			.getLogger(SysUserAction.class);

	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 * */
	@Autowired(required = false)
	private SysUserService sysUserService;

	@Autowired(required = false)
	private SysBaseUserService sysBaseUserService;

	@Autowired(required = false)
	private SysUserTeamService sysUserTeamService;

	@Autowired(required = false)
	private SysTeamService sysTeamService;

	@Autowired(required = false)
	private SysUserRoleService sysUserRoleService;

	@Autowired(required = false)
	private SysRoleService sysRoleService;

	/**
	 * 方法：list <br>
	 * 描述：查询列表 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param vo
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@AuthAnnotaction()
	public void list(SysUserVo vo, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]查询列表操作");
		// 复制成分页属性
		SysUserDto dto = new SysUserDto();
		BeanUtils.copyBean(vo, dto);

		// 设置当前登录编号及创建者编号 当前用户只能管理自己及自己创建的用户
		SysUserVo sysUserVo = SessionUtils.getUser();
		dto.setBaseId(sysUserVo.getBaseId());
		dto.setCreateUser(sysUserVo.getBaseId());
		// 复制成展现对象
		List<SysUserDto> dtoList = sysUserService.queryByDetailList(dto);
		List<SysUserVo> voList = new ArrayList<SysUserVo>();
		BeanUtils.copyBeanList(dtoList, voList, SysUserVo.class);

		// 设置返回结果
		dataGrid.setReaults(voList);
		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：toSave <br>
	 * 描述：进入添加页面 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSave")
	@AuthAnnotaction()
	public ModelAndView toSave(SysUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]添加页面操作");

		Map<String, Object> context = new HashMap<String, Object>();
		if (ObjectUtils.isNotEmpty(vo) && ObjectUtils.isNotEmpty(vo.getId())) {
			SysUserDto dto = sysUserService.queryDetailById(vo.getId());
			BeanUtils.copyBean(dto, vo);

			// 获取当前要修改的用户
			List<SysUserTeamDto> currentModifyUserSysUserTeamDtoList = sysUserTeamService
					.queryByUserId(vo.getBaseId());

			// 根据用户组关系集合查询出多个用户组详细信息
			List<SysTeamDto> currentModifyUserSysTeamDtoList = sysTeamService
					.queryByIds(currentModifyUserSysUserTeamDtoList);

			List<SysTeamVo> currentModifyUserSysTeamVoList = new ArrayList<SysTeamVo>();
			BeanUtils.copyBeanList(currentModifyUserSysTeamDtoList,
					currentModifyUserSysTeamVoList, SysTeamVo.class);
			vo.setSysTeamVoList(currentModifyUserSysTeamVoList);
			context.put(DATA, vo);
		}
		return forword("sysUser/save", context);
	}

	/**
	 * 方法：toTeamList <br>
	 * 描述：用户选择管理组跳转 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午2:04:34 <br>
	 *
	 * @return
	 */
	@RequestMapping("/toTeamList")
	public String toTeamList() {
		return "sysUser/teamList";
	}

	@RequestMapping("/teamList")
	public void teamList(HttpServletRequest request, SysUserVo vo,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户组表]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		// 复制成分页属性
		SysTeamDto dto = new SysTeamDto();
		BeanUtils.copyBean(vo, dto);

		// 设置当前登录编号及创建者编号 当前用户只能管理自己及自己创建的用户
		SysUserVo sysUserVo = SessionUtils.getUser();
		// 获取当前要修改的用户
		List<SysUserTeamDto> currentModifyUserSysUserTeamDtoList = sysUserTeamService
				.queryByUserId(sysUserVo.getBaseId());
		// 根据用户组关系集合查询出多个用户组详细信息
		List<SysTeamDto> currentModifyUserSysTeamDtoList = sysTeamService
				.queryByIds(currentModifyUserSysUserTeamDtoList);

		List<SysTeamVo> currentModifyUserSysTeamVoList = new ArrayList<SysTeamVo>();
		if (ObjectUtils.isNotEmpty(currentModifyUserSysTeamDtoList)) {
			BeanUtils.copyBeanList(currentModifyUserSysTeamDtoList,
					currentModifyUserSysTeamVoList, SysTeamVo.class);
			context.put(DATA_List, currentModifyUserSysTeamVoList);
			context.put(SUCCESS, true);
			context.put(MSG, "查询成功!");
		} else {
			context.put(DATA_List, currentModifyUserSysTeamVoList);
			context.put(SUCCESS, false);
			context.put(MSG, "查询失败!");
		}
		dataGrid.setReaults(currentModifyUserSysTeamVoList);
		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：toTeamList <br>
	 * 描述：用户选择管理组跳转 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午2:04:34 <br>
	 *
	 * @return
	 */
	@RequestMapping("/toRoleList")
	public String toRoleList() {
		return "sysUser/roleList";
	}

	@RequestMapping("/roleList")
	public void roleList(HttpServletRequest request, SysUserVo vo,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统角色表]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		// 复制成分页属性
		SysRoleDto dto = new SysRoleDto();
		BeanUtils.copyBean(vo, dto);

		// 设置当前登录编号及创建者编号 当前用户只能管理自己及自己创建的用户
		SysUserVo sysUserVo = SessionUtils.getUser();
		// 获取当前要修改的用户
		List<SysUserRoleDto> currentModifyUserSysUserRoleDtoList = sysUserRoleService
				.queryByUserId(sysUserVo.getBaseId());
		// 根据用户组关系集合查询出多个用户组详细信息
		List<SysRoleDto> currentModifyUserSysRoleDtoList = sysRoleService
				.queryByIds(currentModifyUserSysUserRoleDtoList);

		List<SysRoleVo> currentModifyUserSysRoleVoList = new ArrayList<SysRoleVo>();
		if (ObjectUtils.isNotEmpty(currentModifyUserSysRoleDtoList)) {
			BeanUtils.copyBeanList(currentModifyUserSysRoleDtoList,
					currentModifyUserSysRoleVoList, SysRoleVo.class);
			context.put(DATA_List, currentModifyUserSysRoleVoList);
			context.put(SUCCESS, true);
			context.put(MSG, "查询成功!");
		} else {
			context.put(DATA_List, currentModifyUserSysRoleVoList);
			context.put(SUCCESS, false);
			context.put(MSG, "查询失败!");
		}
		dataGrid.setReaults(currentModifyUserSysRoleVoList);
		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或保存数据 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param bean
	 * @param response
	 * @pararm request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@AuthAnnotaction()
	public void save(SysUserVo vo, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]添加修改操作");

		SysUserDto dto = new SysUserDto();
		BeanUtils.copyBean(vo, dto);
		if (ObjectUtils.isEmpty(dto.getId())) {
			// 添加基本用户属性
			SysBaseUserDto sysBaseUserDto = new SysBaseUserDto();
			BeanUtils.copyBean(vo, sysBaseUserDto);
			// 设置当前创建时间
			sysBaseUserDto.setCreateTime(new Timestamp(System
					.currentTimeMillis()));
			sysBaseUserDto.setStatus(EStatus.AVAILABLE.getStatus());
			sysBaseUserService.add(sysBaseUserDto);

			SysUserVo currentSysUserVo = SessionUtils.getUser();
			dto.setCreateUser(currentSysUserVo.getId());
			dto.setBaseId(sysBaseUserDto.getId());
			sysUserService.add(dto);
		} else {
			sysUserService.update(dto);
		}
		// 保存用户与角色关系
		if (ObjectUtils.isNotEmpty(vo.getRoleId())) {
			saveSysUserRole(vo.getRoleId(), dto.getBaseId());
		}
		// 保存用户与用户组关系
		if (ObjectUtils.isNotEmpty(vo.getTeamId())) {
			saveSysUserTeam(vo.getTeamId(), dto.getBaseId());
		}
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：getId <br>
	 * 描述：根据ID查询 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	@AuthAnnotaction()
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]根据ID查询操作");

		SysUserDto dto = sysUserService.queryById(id);
		SysUserVo vo = new SysUserVo();
		BeanUtils.copyBean(vo, dto);

		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		if (ObjectUtils.isEmpty(vo)) {
			ajaxJsonVo.setSuccess(false);
			ajaxJsonVo.setMsg(AjaxJsonVo.MSG_NULL);
		} else {
			ajaxJsonVo.setSuccess(true);
			Map<String, Object> voMap = new HashMap<String, Object>();
			voMap.put(AjaxJsonVo.ATTRIBUTE_NAME_VO, vo);
			ajaxJsonVo.setAttributes(voMap);
		}
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：delete <br>
	 * 描述：删除 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@AuthAnnotaction()
	public void delete(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]根据删除操作");
		sysUserService.delete(id);
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：toList <br>
	 * 描述：进入列表页 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-03 下午13:45:08 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toList")
	@AuthAnnotaction()
	public ModelAndView toList(SysUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("sysUser/list", context);
	}

	/**
	 * 方法：checkUser <br>
	 * 描述：验证用户名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 下午1:47:24 <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkUser")
	public void checkUser(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]查询列表操作");
		SysBaseUserVo vo = new SysBaseUserVo();
		vo.setUserName(request.getParameter("param"));
		ValidForm validForm = new ValidForm();
		SysBaseUserDto dto = new SysBaseUserDto();
		BeanUtils.copyBean(vo, dto);

		// 根据用户名查询
		List<SysBaseUserDto> sysBaseUserDto = sysBaseUserService
				.queryByList(dto);
		if (ObjectUtils.isNotEmpty(sysBaseUserDto)) {
			validForm.setInfo(ValidForm.INFO_FAIL);
			validForm.setStatus(ValidForm.STATUS_FAIL);
		} else {
			validForm.setInfo(ValidForm.INFO_SUCCESS);
			validForm.setStatus(ValidForm.STATUS_SUCCESS);
		}
		HtmlUtils.writerJson(response, validForm);

	}

	/**
	 * 方法：saveSysUserRole <br>
	 * 描述：添加用户角色关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-8 下午4:03:38 <br>
	 *
	 * @param roles
	 * @param sysBaseUserId
	 */
	private void saveSysUserRole(String roles, Integer sysBaseUserId) {
		try {
			sysUserRoleService.deleteByUserId(sysBaseUserId);
			String[] roleIds = null;
			if (roles.contains(",")) {
				roleIds = roles.split(",");
			} else {
				roleIds = new String[] { roles };
			}

			for (String roleId : roleIds) {
				SysUserRoleDto sysUserRoleDto = new SysUserRoleDto();
				sysUserRoleDto.setRoleId(Integer.valueOf(roleId));
				sysUserRoleDto.setUserId(Integer.valueOf(sysBaseUserId));
				sysUserRoleService.add(sysUserRoleDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：saveSysUserRole <br>
	 * 描述：添加用户角色关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-8 下午4:03:38 <br>
	 *
	 * @param roles
	 * @param sysBaseUserId
	 */
	private void saveSysUserTeam(String teams, Integer sysBaseUserId) {
		try {
			sysUserTeamService.deleteByUserId(sysBaseUserId);
			String[] teamIds = null;
			if (teams.contains(",")) {
				teamIds = teams.split(",");
			} else {
				teamIds = new String[] { teams };
			}

			for (String teamId : teamIds) {
				SysUserTeamDto sysUserTeamDto = new SysUserTeamDto();
				sysUserTeamDto.setTeamId(Integer.valueOf(teamId));
				sysUserTeamDto.setUserId(Integer.valueOf(sysBaseUserId));
				sysUserTeamDto.setLevel(1);
				sysUserTeamService.add(sysUserTeamDto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
