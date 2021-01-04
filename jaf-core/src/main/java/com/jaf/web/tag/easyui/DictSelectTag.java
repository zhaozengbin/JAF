/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：DictSelectTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jaf.web.dto.system.SysDictionary;
import com.jaf.web.dto.system.SysDictionaryGroup;
import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：DictSelectTag <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:31:41 <br>
 * 修改备注：TODO <br>
 * 
 */
public class DictSelectTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 数据字典类型 */
	private String typeGroupCode;

	/** 选择表单的Name EAMPLE:<select name="selectName" id = ""/> */
	private String field;

	/** 选择表单ID EAMPLE:<select name="selectName" id = "" /> */
	private String id;

	/** 默认值 */
	private String defaultVal;

	/** DIV样式 */
	private String divClass;

	/** Label样式 */
	private String labelClass;

	/** label显示值 */
	private String title;

	/** 是否显示label */
	private boolean hasLabel = true;

	/**
	 * 方法: assembleStart <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		return null;
	}

	/**
	 * 方法: assembleEnd <br>
	 * 描述: TODO
	 * 
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleEnd()
	 */
	@Override
	protected String assembleEnd() {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(divClass)) {
			divClass = "form"; // 默认form样式
		}
		if (StringUtils.isNotEmpty(labelClass)) {
			labelClass = "Validform_label"; // 默认label样式
		}
		SysDictionaryGroup sysDictionaryGroup = SysDictionaryGroup.allSysDictionaryGroups
				.get(this.typeGroupCode.toLowerCase());
		List<SysDictionary> sysDictionarys = SysDictionaryGroup.allSysDictionarys
				.get(this.typeGroupCode.toLowerCase());
		if (hasLabel) {
			sb.append("<div class=\"" + divClass + "\">");
			sb.append("<label class=\"" + labelClass + "\" >");
		}
		if (sysDictionaryGroup == null) {
		} else {
			if (hasLabel) {
				if (StringUtils.isNotEmpty(this.title)) {
					this.title = sysDictionaryGroup.getName();
				}
				sb.append(this.title + ":");
				sb.append("</label>");
			}
			sb.append("<select name=\"" + field + "\"");
			if (!StringUtils.isNotEmpty(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(">");
			for (SysDictionary sysDictionary : sysDictionarys) {
				if (sysDictionary.getTypecode().equals(this.defaultVal)) {
					sb.append(" <option value=\"" + sysDictionary.getTypecode()
							+ "\" selected=\"selected\">");
				} else {
					sb.append(" <option value=\"" + sysDictionary.getTypecode()
							+ "\">");
				}
				sb.append(sysDictionary.getTypename());
				sb.append(" </option>");
			}

			sb.append("</select>");
			if (hasLabel) {
				sb.append("</div>");
			}
		}
		return sb.toString();
	}

	/**
	 * 返回: the typeGroupCode <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getTypeGroupCode() {
		return typeGroupCode;
	}

	/**
	 * 参数: typeGroupCode the typeGroupCode to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setTypeGroupCode(String typeGroupCode) {
		this.typeGroupCode = typeGroupCode;
	}

	/**
	 * 返回: the field <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getField() {
		return field;
	}

	/**
	 * 参数: field the field to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * 返回: the id <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getId() {
		return id;
	}

	/**
	 * 参数: id the id to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回: the defaultVal <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getDefaultVal() {
		return defaultVal;
	}

	/**
	 * 参数: defaultVal the defaultVal to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	/**
	 * 返回: the divClass <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getDivClass() {
		return divClass;
	}

	/**
	 * 参数: divClass the divClass to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setDivClass(String divClass) {
		this.divClass = divClass;
	}

	/**
	 * 返回: the labelClass <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getLabelClass() {
		return labelClass;
	}

	/**
	 * 参数: labelClass the labelClass to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	/**
	 * 返回: the title <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the hasLabel <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public boolean isHasLabel() {
		return hasLabel;
	}

	/**
	 * 参数: hasLabel the hasLabel to set <br>
	 * 
	 * 时间: 2013-7-25 下午2:43:34
	 */
	public void setHasLabel(boolean hasLabel) {
		this.hasLabel = hasLabel;
	}

}
