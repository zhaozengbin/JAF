/**
 * 项目名：${projectName} <br>
 * 包名：${packagePath}.web.action.${classNameLower} <br>
 * 文件名：${className}Action.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：${time} <br>
 * Copyright (c) 2013 ${copyright}-版权所有<br>
 *
 */
package ${packagePath}.web.action.${classNameLower};

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
import com.jaf.web.annotaction.AuthAnnotaction;
import com.jaf.web.annotaction.LogAnnotaction;
import com.jaf.web.entity.ELogLevel;
import com.jaf.web.entity.ELogOperation;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.SysUserVo;

import ${packagePath}.dto.${className}Dto;
import ${packagePath}.dto.easyui.DataGrid;
import ${packagePath}.service.${className}Service;
import ${packagePath}.tag.util.TagUtils;
import ${packagePath}.web.vo.AjaxJsonVo;
import ${packagePath}.web.vo.${className}Vo;

/**
 *
 * 类名称：${className}Action <br>
 * 类描述：${remark}Action <br>
 * 创建人：${createUser} <br>
 * 修改人：${modifyUser} <br>
 * 修改时间：${time} <br>
 * 修改备注：TODO <br>
 *
 */
@Controller
@RequestMapping("/${lowerName}")
public class ${className}Action extends BaseAction{

	/* 输出日志**/
	private final static Logger LOGGER= LoggerUtils.getLogger(${className}Action.class);

	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 **/
	@Autowired(required=false)
	private ${className}Service ${lowerName}Service;

	/**
	 * 方法：list <br>
	 * 描述：查询列表 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
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
	@LogAnnotaction(level = ELogLevel.QUERY, operation = ELogOperation.QUERY, remark = "[${remark}]查询列表操作")
	public void list(${className}Vo vo,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid) throws Exception{
		LoggerUtils.debug(LOGGER, "进入[${remark}]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		//复制成分页属性
		${className}Dto dto = new ${className}Dto();
		BeanUtils.copyBean(vo, dto);

		//复制成展现对象
		List<${className}Dto> dtoList = ${lowerName}Service.queryByList(
						dto);
		List<${className}Vo> voList = new ArrayList<${className}Vo>();
		BeanUtils.copyBeanList(dtoList, voList, ${className}Vo.class);

		//设置返回数据
		dataGrid.setReaults(voList);
		dataGrid.setTotal(${lowerName}Service.queryByCount(dto));
		TagUtils.datagrid(response, dataGrid);
	}

	/**
	 * 方法：toSave <br>
	 * 描述：进入添加页面 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 *
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSave")
	@AuthAnnotaction()
	public ModelAndView toSave(${className}Vo vo, HttpServletRequest request)
			throws Exception {
		LoggerUtils.debug(LOGGER, "进入[${remark}]添加页面操作");

		Map<String, Object> context = new HashMap<String, Object>();
		if (ObjectUtils.isNotEmpty(vo) && ObjectUtils.isNotEmpty(vo.getId())) {
			${className}Dto dto = ${lowerName}Service.queryById(vo.getId());
			BeanUtils.copyBean(dto, vo);
			context.put(DATA, vo);
		}
		return forword("${lowerName}/save", context);
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或保存数据 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 *
	 * @param bean
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@AuthAnnotaction()
	@LogAnnotaction(level = ELogLevel.EDITOR, operation = ELogOperation.EDITOR, remark = "[${remark}]添加修改操作")
	public void save(${className}Vo vo,HttpServletResponse response,HttpServletRequest request) throws Exception{
		LoggerUtils.debug(LOGGER, "进入[${remark}]添加修改操作");

		${className}Dto dto = new ${className}Dto();
		BeanUtils.copyBean(vo, dto);
		if (dto.getId() == null) {
			SysUserVo currentSysUserVo = SessionUtils.getUser(request);
			dto.setCreateUser(currentSysUserVo.getCreateUser());
			${lowerName}Service.add(dto);
		} else {
			${lowerName}Service.update(dto);
		}
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：getId <br>
	 * 描述：根据ID查询 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	@AuthAnnotaction()
	@LogAnnotaction(level = ELogLevel.QUERY, operation = ELogOperation.QUERY, remark = "[${remark}]根据ID查询操作")
	public void getId(Integer id,HttpServletResponse response) throws Exception{
		LoggerUtils.debug(LOGGER, "进入[${remark}]根据ID查询操作");

		${className}Dto dto =  ${lowerName}Service.queryById(id);
		${className}Vo vo = new ${className}Vo();
		BeanUtils.copyBean(vo, dto);

		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		if (ObjectUtils.isEmpty(vo)) {
			ajaxJsonVo.setSuccess(false);
			ajaxJsonVo.setMsg(AjaxJsonVo.MSG_NULL);
		}else{
			ajaxJsonVo.setSuccess(true);
			Map<String,Object> voMap = new HashMap<String, Object>();
			voMap.put(AjaxJsonVo.ATTRIBUTE_NAME_VO, vo);
			ajaxJsonVo.setAttributes(voMap);
		}
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：delete <br>
	 * 描述：删除 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@AuthAnnotaction()
	@LogAnnotaction(level = ELogLevel.EDITOR, operation = ELogOperation.DELETE, remark = "[${remark}]根据删除操作")
	public void delete(Integer id,HttpServletResponse response) throws Exception{
		LoggerUtils.debug(LOGGER, "进入[${remark}]根据删除操作");
		${lowerName}Service.delete(id);
		AjaxJsonVo ajaxJsonVo = new AjaxJsonVo();
		ajaxJsonVo.setSuccess(true);
		HtmlUtils.writerJson(response, ajaxJsonVo);
	}

	/**
	 * 方法：toList <br>
	 * 描述：进入列表页 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toList")
	public ModelAndView toList(${className}Vo vo,HttpServletRequest request) throws Exception{
		LoggerUtils.debug(LOGGER, "进入[${remark}]查询列表操作");
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("${lowerName}/list",context);
	}
}
