/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.action.sysbaseuser <br>
 * 文件名：SysBaseUserAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-11-06 下午16:19:59 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.action.sysbaseuser;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaf.core.controller.BaseAction;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.SysBaseUserDto;
import com.jaf.web.dto.easyui.DataGrid;
import com.jaf.web.service.SysBaseUserService;
import com.jaf.web.tag.util.TagUtils;
import com.jaf.web.util.MD5;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.AjaxJsonVo;
import com.jaf.web.web.vo.SysBaseUserVo;
import com.jaf.web.web.vo.SysUserVo;

/**
 *
 * 类名称：SysBaseUserAction <br>
 * 类描述：系统基础用户表Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-06 下午16:19:59 <br>
 * 修改备注：TODO <br>
 *
 */
@Controller
@RequestMapping("/sysBaseUser")
public class SysBaseUserAction extends BaseAction {

	/* 输出日志* */
	private final static Logger LOGGER = LoggerUtils
			.getLogger(SysBaseUserAction.class);

	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 * */
	@Autowired(required = false)
	private SysBaseUserService sysBaseUserService;

	/**
	 * 方法：toList <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午5:12:34 <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toList")
	public ModelAndView toList(SysBaseUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("sysBaseUser/list", context);
	}

	/**
	 * 方法：list <br>
	 * 描述：查询列表 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2013-11-06 下午16:19:59 <br>
	 *
	 * @param vo
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(SysBaseUserVo vo, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]查询列表操作");
		// 复制成分页属性
		SysBaseUserDto dto = new SysBaseUserDto();
		BeanUtils.copyBean(vo, dto);

		// 设置当前登录编号及创建者编号 当前用户只能管理自己及自己创建的用户
		SysUserVo sysUserVo = SessionUtils.getUser();
		dto.setId(sysUserVo.getId());
		dto.setCreateUser(sysUserVo.getId());
		// 复制成展现对象
		List<SysBaseUserDto> dtoList = sysBaseUserService
				.queryByDetailList(dto);
		List<SysBaseUserVo> voList = new ArrayList<SysBaseUserVo>();
		BeanUtils.copyBeanList(dtoList, voList, SysBaseUserVo.class);

		// 设置返回结果
		dataGrid.setReaults(voList);
		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：toSave <br>
	 * 描述：进入添加页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午5:04:13 <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSave")
	public ModelAndView toSave(SysBaseUserVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统用户表]添加页面操作");

		Map<String, Object> context = new HashMap<String, Object>();
		if (ObjectUtils.isNotEmpty(vo) && ObjectUtils.isNotEmpty(vo.getId())) {
			SysBaseUserDto dto = sysBaseUserService.queryById(vo.getId());
			BeanUtils.copyBean(dto, vo);
			context.put(DATA, vo);
		}
		return forword("sysBaseUser/save", context);
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或保存数据 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2013-11-06 下午16:19:59 <br>
	 *
	 * @param bean
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysBaseUserVo vo, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]添加修改操作");

		SysBaseUserDto dto = new SysBaseUserDto();
		BeanUtils.copyBean(vo, dto);
		if (dto.getId() == null) {
			sysBaseUserService.add(dto);
		} else {
			sysBaseUserService.update(dto);
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
	 * 日期：2013-11-06 下午16:19:59 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]根据ID查询操作");

		SysBaseUserDto dto = sysBaseUserService.queryById(id);
		SysBaseUserVo vo = new SysBaseUserVo();
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
	 * 日期：2013-11-06 下午16:19:59 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统基础用户表]根据删除操作");
		sysBaseUserService.delete(id);
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：changepassword <br>
	 * 描述：进入修改密码页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-11-1 下午3:41:02 <br>
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("changePassword")
	public String changePassword(HttpServletRequest request) {
		return "sysBaseUser/changePassword";
	}

	/**
	 * 方法：savePassword <br>
	 * 描述：修改密码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-11-6 下午4:22:08 <br>
	 *
	 * @param request
	 * @param password
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("savePassword")
	@ResponseBody
	public AjaxJsonVo savePassword(HttpServletRequest request, String password,
			String newPassword) {
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		SysUserVo sysUserVo = SessionUtils.getUser();
		String passwordMd5 = MD5.encryption(password);
		if (!passwordMd5.equals(sysUserVo.getPassword())) {
			ajaxJsonVo.setMsg("原密码不正确");
			ajaxJsonVo.setSuccess(false);
		} else {
			try {
				SysBaseUserVo vo = new SysBaseUserVo();
				vo.setPassword(MD5.encryption(newPassword));
				SysBaseUserDto dto = new SysBaseUserDto();
				BeanUtils.copyBean(vo, dto);
				sysBaseUserService.update(dto);
				ajaxJsonVo.setMsg("修改成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ajaxJsonVo;
	}

	/**
	 * 方法：roles <br>
	 * 描述：进入权限列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-12-24 下午6:07:14 <br>
	 *
	 * @return
	 */
	@RequestMapping(params = "roles")
	public String roles() {
		return "sysBaseUser/roles";
	}
}
