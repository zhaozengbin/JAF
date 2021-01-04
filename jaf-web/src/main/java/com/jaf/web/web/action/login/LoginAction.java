/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.action.login <br>
 * 文件名：LoginAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.action.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaf.core.controller.BaseAction;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.annotaction.AuthAnnotaction;
import com.jaf.web.dto.SysBaseUserDto;
import com.jaf.web.dto.SysPermissionDto;
import com.jaf.web.dto.SysRoleDto;
import com.jaf.web.dto.SysRolePermissionDto;
import com.jaf.web.dto.SysTeamDto;
import com.jaf.web.dto.SysUserDto;
import com.jaf.web.dto.SysUserRoleDto;
import com.jaf.web.dto.SysUserTeamDto;
import com.jaf.web.dto.system.SysIcon;
import com.jaf.web.dto.system.SysMenu;
import com.jaf.web.service.SysBaseUserService;
import com.jaf.web.service.SysPermissionService;
import com.jaf.web.service.SysRolePermissionService;
import com.jaf.web.service.SysRoleService;
import com.jaf.web.service.SysTeamService;
import com.jaf.web.service.SysUserRoleService;
import com.jaf.web.service.SysUserService;
import com.jaf.web.service.SysUserTeamService;
import com.jaf.web.tag.util.ListtoMenu;
import com.jaf.web.util.MD5;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.AjaxJsonVo;
import com.jaf.web.web.vo.SysBaseUserVo;
import com.jaf.web.web.vo.SysPermissionVo;
import com.jaf.web.web.vo.SysUserVo;

/**
 *
 * 类名称：LoginAction <br>
 * 类描述：登陆初始化控制器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:49:53 <br>
 * 修改备注：TODO <br>
 *
 */
@Controller
@RequestMapping("/security")
public class LoginAction extends BaseAction {

	/* 输出日志* */
	private final static Logger LOGGER = LoggerUtils
			.getLogger(LoginAction.class);

	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 * */
	@Autowired(required = false)
	private SysBaseUserService sysBaseUserService;

	@Autowired(required = false)
	private SysUserService sysUserService;

	@Autowired(required = false)
	private SysUserTeamService sysUserTeamService;

	@Autowired(required = false)
	private SysTeamService sysTeamService;

	@Autowired(required = false)
	private SysUserRoleService sysUserRoleService;

	@Autowired(required = false)
	private SysRoleService sysRoleService;

	@Autowired(required = false)
	private SysRolePermissionService sysRolePermissionService;

	@Autowired(required = false)
	private SysPermissionService sysPermissionService;

	/**
	 * 方法：toLogin <br>
	 * 描述：进入登录页面 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2013-08-14 下午14:49:41 <br>
	 *
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(SysBaseUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入用户登录操作");
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("../login/login", context);
	}

	/**
	 * 方法：login <br>
	 * 描述：用户登录 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2013-08-14 下午14:49:41 <br>
	 *
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login(SysBaseUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]登录操作");
		Map<String, Object> context = new HashMap<String, Object>();
		SysUserVo sysUserVo = SessionUtils.getUser();
		if (ObjectUtils.isNotEmpty(sysUserVo)) {
			LoggerUtils.debug(LOGGER, "开始分配权限");
			// 查询用户所属用户组
			List<SysUserTeamDto> sysUserTeamDtoList = sysUserTeamService
					.queryByUserId(sysUserVo.getBaseId());

			// 根据用户组关系集合查询出多个用户组详细信息
			List<SysTeamDto> sysTeamDtoList = sysTeamService
					.queryByIds(sysUserTeamDtoList);

			// 查询出所有与当前登录有组关系的用户
			List<SysUserTeamDto> allRelationSysUserTeamDtoList = sysUserTeamService
					.queryByTeamIds(sysUserTeamDtoList);

			List<SysUserRoleDto> sysUserRoleDtoList = chooseManagered(
					sysUserTeamDtoList, allRelationSysUserTeamDtoList);
			sysUserRoleDtoList.add(new SysUserRoleDto(sysUserVo.getBaseId(),
					null));
			// 重置用户角色关系集合，查询出角色关系的ID
			sysUserRoleDtoList = sysUserRoleService
					.queryByUserIds(sysUserRoleDtoList);

			// 根据用户组关系集合查询出多个用户角色详细信息
			List<SysRoleDto> sysRoleDtoList = sysRoleService
					.queryByIds(sysUserRoleDtoList);

			List<SysRolePermissionDto> sysRolePermissionDtoList = sysRolePermissionService
					.queryByRoleIds(sysUserRoleDtoList);

			List<SysPermissionDto> sysPermissionDtoList = sysPermissionService
					.queryByIds(sysRolePermissionDtoList);
			if (ObjectUtils.isNotEmpty(sysTeamDtoList)) {
				StringBuffer teamIdStringBuffer = new StringBuffer();
				StringBuffer teamNameStringBuffer = new StringBuffer();
				for (SysTeamDto sysTeamDto : sysTeamDtoList) {
					teamIdStringBuffer.append(sysTeamDto.getId());
					teamIdStringBuffer.append(",");
					teamNameStringBuffer.append(sysTeamDto.getTeamName());
					teamNameStringBuffer.append(",");
				}
				sysUserVo.setTeamId(String.valueOf(teamIdStringBuffer
						.substring(0, teamIdStringBuffer.lastIndexOf(","))));
				sysUserVo.setTeamName(String.valueOf(teamNameStringBuffer
						.substring(0, teamNameStringBuffer.lastIndexOf(","))));
			}
			StringBuffer roleIdStringBuffer = new StringBuffer();
			StringBuffer roleNameStringBuffer = new StringBuffer();
			if (ObjectUtils.isNotEmpty(sysRoleDtoList)) {
				for (SysRoleDto sysRoleDto : sysRoleDtoList) {
					roleIdStringBuffer.append(sysRoleDto.getId());
					roleIdStringBuffer.append(",");
					roleNameStringBuffer.append(sysRoleDto.getRoleName());
					roleNameStringBuffer.append(",");
				}
				sysUserVo.setRoleId(String.valueOf(roleIdStringBuffer
						.substring(0, roleIdStringBuffer.lastIndexOf(","))));
				sysUserVo.setRoleName(String.valueOf(roleNameStringBuffer
						.substring(0, roleNameStringBuffer.lastIndexOf(","))));

				List<SysPermissionVo> sysPermissionVoList = new ArrayList<SysPermissionVo>();
				BeanUtils.copyBeanList(sysPermissionDtoList,
						sysPermissionVoList, SysPermissionVo.class);
				sysUserVo.setSysPermissionVoList(sysPermissionVoList);

				// 查询相应主用户的信息
				SysBaseUserDto sysBaseUserDto = sysBaseUserService
						.queryById(sysUserVo.getBaseId());
				sysUserVo.setBaseId(sysBaseUserDto.getId());
				SessionUtils.setUser(sysUserVo);
			}
			return forword("../main/main", context);
		} else {
			return forword("../login/login", context);
		}
	}

	/**
	 * 方法：checkuser <br>
	 * 描述：检测用户 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-18 下午2:05:41 <br>
	 *
	 * @param userName
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkUser")
	public void checkUser(SysBaseUserVo vo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]检测操作");
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		SysBaseUserDto dto = new SysBaseUserDto();
		BeanUtils.copyBean(vo, dto);
		dto.setPassword(MD5.encryption(dto.getPassword()));
		List<SysBaseUserDto> dtoList = sysBaseUserService.queryByList(dto);
		List<SysBaseUserVo> voList = new ArrayList<SysBaseUserVo>();
		if (ObjectUtils.isNotEmpty(dtoList)) {
			BeanUtils.copyBeanList(dtoList, voList, SysBaseUserVo.class);
			vo = voList.get(0);

			// 查询用户信息
			SysUserDto sysUserDto = new SysUserDto();
			sysUserDto.setBaseId(vo.getId());
			List<SysUserDto> sysUserDtoList = sysUserService
					.queryByDetailList(sysUserDto);

			if (ObjectUtils.isNotEmpty(sysUserDtoList)) {
				sysUserDto = sysUserDtoList.get(0);
				SysUserVo sysUserVo = new SysUserVo();
				// 将当前用户存入缓存
				BeanUtils.copyBean(sysUserDto, sysUserVo);
				BeanUtils.copyBean(vo, sysUserVo);
				SessionUtils.setUser(sysUserVo);
				ajaxJsonVo.setSuccess(true);
				HtmlUtils.writerJson(response, ajaxJsonVo);
				return;
			}
		}
		ajaxJsonVo.setMsg("用户名或密码错误!");
		ajaxJsonVo.setSuccess(false);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：home <br>
	 * 描述：首页内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-30 下午3:20:05 <br>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		return new ModelAndView("../main/home");
	}

	/**
	 * 方法：chooseManagered <br>
	 * 描述：查询出在各组中级别低于当前用户的用户ID <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-25 上午10:56:36 <br>
	 *
	 * @param sysUserTeamDtoList
	 * @param allRelationSysUserTeamDtoList
	 * @return
	 */
	private List<SysUserRoleDto> chooseManagered(
			List<SysUserTeamDto> sysUserTeamDtoList,
			List<SysUserTeamDto> allRelationSysUserTeamDtoList) {
		List<SysUserRoleDto> sysUserRoleDtoList = null;
		if (ObjectUtils.isNotEmpty(allRelationSysUserTeamDtoList)) {
			sysUserRoleDtoList = new ArrayList<SysUserRoleDto>();
			for (SysUserTeamDto sysUserTeamDto : sysUserTeamDtoList) {
				for (SysUserTeamDto relationSysUserTeamDto : allRelationSysUserTeamDtoList) {
					if (sysUserTeamDto.getUserId() != relationSysUserTeamDto
							.getUserId()
							&& sysUserTeamDto.getTeamId() == relationSysUserTeamDto
									.getTeamId()
							&& sysUserTeamDto.getLevel() > relationSysUserTeamDto
									.getLevel()) {
						SysUserRoleDto sysUserRoleDto = new SysUserRoleDto();
						sysUserRoleDto.setUserId(relationSysUserTeamDto
								.getUserId());
						sysUserRoleDtoList.add(sysUserRoleDto);
					}
				}
			}
		}
		return sysUserRoleDtoList;
	}

	/**
	 * 方法：left <br>
	 * 描述：菜单跳转 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-31 上午11:36:47 <br>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("left")
	@AuthAnnotaction(verifyLogin = true, verifyURL = false)
	public ModelAndView left(HttpServletRequest request) {
		SysUserVo sysUserVo = SessionUtils.getUser();
		// 登陆者的权限
		if (ObjectUtils.isEmpty(sysUserVo)) {
			SessionUtils.removeUser();
			forword("../login/login", null);
		}
		Set<SysPermissionVo> loginActionlist = new HashSet<SysPermissionVo>();// 已有权限菜单
		loginActionlist.addAll(sysUserVo.getSysPermissionVoList());

		List<SysMenu> bigActionlist = new ArrayList<SysMenu>();// 一级权限菜单
		List<SysMenu> smailActionlist = null;// 二级权限菜单
		Map<Integer, List<SysMenu>> permissionMap = new HashMap<Integer, List<SysMenu>>();
		if (loginActionlist.size() > 0) {
			for (SysPermissionVo sysPermissionVo : loginActionlist) {
				if (sysPermissionVo.getType() == 1) {
					SysMenu sysMenu = new SysMenu();
					sysMenu.setId(sysPermissionVo.getId());
					sysMenu.setName(sysPermissionVo.getPermissionName());
					sysMenu.setSysIcon(new SysIcon(sysPermissionVo.getIcon(),
							sysPermissionVo.getClazz()));
					sysMenu.setUrl(sysPermissionVo.getUrl());
					if (sysPermissionVo.getParentId() == 0) {
						sysMenu.setLevel(Short.valueOf(new String("0")));
						bigActionlist.add(sysMenu);
					} else {
						sysMenu.setLevel(Short.valueOf(new String("1")));

						sysMenu.setSysMenu(new SysMenu(sysPermissionVo
								.getParentId()));
						smailActionlist = permissionMap.get(sysPermissionVo
								.getParentId());
						if (ObjectUtils.isEmpty(smailActionlist)) {
							smailActionlist = new ArrayList<SysMenu>();
						}
						smailActionlist.add(sysMenu);
						permissionMap.put(sysPermissionVo.getParentId(),
								smailActionlist);
					}
				}
			}
			for (SysMenu sysMenu : bigActionlist) {
				sysMenu.setSysMenus(permissionMap.get(sysMenu.getId()));
			}
		}
		// 菜单栏排序
		String logString = ListtoMenu.getEasyuiMenu(bigActionlist,
				smailActionlist);
		request.setAttribute("loginMenu", logString);
		request.setAttribute("parentSysMenu", bigActionlist);
		request.setAttribute("childSysMenu", smailActionlist);
		return new ModelAndView("../main/left");
	}

	/**
	 * 方法：logout <br>
	 * 描述：退出登录 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-31 上午11:32:10 <br>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		Map<String, Object> context = new HashMap<String, Object>();
		SessionUtils.removeUser();
		return forword("../login/login", context);
	}
}
