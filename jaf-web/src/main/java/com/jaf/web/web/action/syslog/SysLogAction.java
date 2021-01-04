/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.action.syslog <br>
 * 文件名：SysLogAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-04-11 下午18:06:53 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.action.syslog;

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
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.LoggerUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.SysUserVo;

import com.jaf.web.dto.SysLogDto;
import com.jaf.web.dto.easyui.DataGrid;
import com.jaf.web.entity.ELogLevel;
import com.jaf.web.entity.ELogOperation;
import com.jaf.web.service.SysLogService;
import com.jaf.web.tag.util.TagUtils;
import com.jaf.web.web.vo.AjaxJsonVo;
import com.jaf.web.web.vo.SysLogVo;

/**
 *
 * 类名称：SysLogAction <br>
 * 类描述：系统日志表Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-04-11 下午18:06:53 <br>
 * 修改备注：TODO <br>
 *
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogAction extends BaseAction {

	/* 输出日志* */
	private final static Logger LOGGER = LoggerUtils
			.getLogger(SysLogAction.class);

	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 * */
	@Autowired(required = false)
	private SysLogService sysLogService;

	/**
	 * 方法：list <br>
	 * 描述：查询列表 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param vo
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(SysLogVo vo, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]查询列表操作");
		// 复制成分页属性
		SysLogDto dto = new SysLogDto();
		BeanUtils.copyBean(vo, dto);

		// 复制成展现对象
		List<SysLogDto> dtoList = sysLogService.queryByDetailList(dto);
		List<SysLogVo> voList = new ArrayList<SysLogVo>();
		BeanUtils.copyBeanList(dtoList, voList, SysLogVo.class);

		// 设置返回结果
		dataGrid.setReaults(voList);
		dataGrid.setTotal(sysLogService.queryByDetailListCount(dto));

		// 设置日志类型
		StringBuffer logOperationSbf = new StringBuffer();
		for (ELogOperation eLogOperation : ELogOperation.values()) {
			logOperationSbf.append(eLogOperation.getOperation());
			logOperationSbf.append("_");
			logOperationSbf.append(eLogOperation.getContent());
		}
		// 设置属性
		request.setAttribute("logOperation", logOperationSbf);

		// 设置日志级别
		StringBuffer logLevelSbf = new StringBuffer();
		for (ELogLevel eLogLevel : ELogLevel.values()) {
			logLevelSbf.append(eLogLevel.getLevel());
			logLevelSbf.append("_");
			logLevelSbf.append(eLogLevel.getContent());
		}
		request.setAttribute("logLevel", logLevelSbf);

		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：toSave <br>
	 * 描述：进入添加页面 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSave")
	public ModelAndView toSave(SysLogVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]添加页面操作");

		Map<String, Object> context = new HashMap<String, Object>();
		if (ObjectUtils.isNotEmpty(vo) && ObjectUtils.isNotEmpty(vo.getId())) {
			SysLogDto dto = sysLogService.queryById(vo.getId());
			BeanUtils.copyBean(dto, vo);
			context.put(DATA, vo);
		}
		return forword("sysLog/save", context);
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或保存数据 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param bean
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysLogVo vo, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]添加修改操作");

		SysLogDto dto = new SysLogDto();
		BeanUtils.copyBean(vo, dto);
		if (dto.getId() == null) {
			SysUserVo currentSysUserVo = SessionUtils.getUser();
			dto.setCreateUser(currentSysUserVo.getCreateUser());
			sysLogService.add(dto);
		} else {
			sysLogService.update(dto);
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
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]根据ID查询操作");

		SysLogDto dto = sysLogService.queryById(id);
		SysLogVo vo = new SysLogVo();
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
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer id, HttpServletResponse response)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]根据删除操作");
		sysLogService.delete(id);
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：toList <br>
	 * 描述：进入列表页 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期：2014-04-11 下午18:06:53 <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toList")
	public ModelAndView toList(SysLogVo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[系统日志表]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("sysLog/list", context);
	}
}
