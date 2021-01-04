/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：FormValidationTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-22-下午5:03:21<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.tag.easyui;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.tag.AbstractTag;
import com.jaf.web.util.ContextHolderUtils;

/**
 *
 * 类名称：FormValidationTag <br>
 * 类描述：表单 验证标签<br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-22 下午5:03:21 <br>
 * 修改备注：TODO <br>
 *
 */
public class FormValidationTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 表单FORM ID */
	protected String formid = "formid";

	/**  */
	protected Boolean refresh = true;

	/** 回调函数 */
	protected String callback;

	/** 提交前处理函数 */
	protected String beforeSubmit;

	/** 以ID为标记触发提交事件 */
	protected String btnsub = "btn_sub";

	/** 以ID为标记触发提交事件 */
	protected String btnreset = "btn_reset";

	/** 表单布局 */
	protected String layout = "div";

	/** 外调插件 */
	protected String usePlugin;

	/** 是否是弹出窗口模式 */
	protected boolean dialog = true;

	/** 表单提交路径 */
	protected String action;

	/** 表单选项卡 */
	protected String tabtitle;

	/** 校验方式 */
	protected String tiptype = "4";

	/**
	 * 方法: assembleStart <br>
	 * 描述: TODO
	 *
	 * @return
	 * @see com.jaf.web.tag.AbstractTag#assembleStart()
	 */
	@Override
	protected String assembleStart() {
		StringBuffer sb = new StringBuffer();
		if ("div".equals(layout)) {
			sb.append("<div id=\"content\">");
			sb.append("<div id=\"wrapper\">");
			sb.append("<div id=\"steps\">");
		}
		sb.append("<form id=\"" + formid + "\" action=\""
				+ ContextHolderUtils.getRequest().getContextPath() + action
				+ "\" name=\"" + formid + "\" method=\"post\">");
		if ("btn_sub".equals(btnsub) && dialog)
			sb.append("<input type=\"hidden\" id=\"" + btnsub + "\" class=\""
					+ btnsub + "\"/>");
		return sb.toString();
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
		sb.append("<script type=\"text/javascript\">");
		sb.append("$(function(){");
		sb.append("$(\"#" + formid + "\").Validform({");
		if (this.getTiptype() != null && !"".equals(this.getTiptype())) {
			sb.append("tiptype:" + this.getTiptype() + ",");
		} else {
			sb.append("tiptype:1,");
		}
		sb.append("btnSubmit:\"#" + btnsub + "\",");
		sb.append("btnReset:\"#" + btnreset + "\",");
		sb.append("ajaxPost:true,");
		if (beforeSubmit != null) {
			sb.append("beforeSubmit:function(curform){var tag=false;");
			sb.append("return " + beforeSubmit + "(curform);");

			sb.append("},");
		}
		if (usePlugin != null) {
			StringBuffer passsb = new StringBuffer();
			if (usePlugin.indexOf("password") >= 0) {
				passsb.append("passwordstrength:{");
				passsb.append("minLen:6,");
				passsb.append("maxLen:18,");
				passsb.append("trigger:function(obj,error)");
				passsb.append("{");
				passsb.append("if(error)");
				passsb.append("{");
				passsb.append("obj.parent().next().find(\".Validform_checktip\").show();");
				passsb.append("obj.find(\".passwordStrength\").hide();");
				passsb.append("}");
				passsb.append("else");
				passsb.append("{");
				passsb.append("$(\".passwordStrength\").show();");
				passsb.append("obj.parent().next().find(\".Validform_checktip\").hide();");
				passsb.append("}");
				passsb.append("}");// trigger结尾
				passsb.append("}");// passwordstrength结尾
			}
			StringBuffer jqsb = new StringBuffer();
			if (usePlugin.indexOf("jqtransform") >= 0) {
				if (usePlugin.indexOf("password") >= 0) {
					sb.append(",");
				}
				jqsb.append("jqtransform :{selector:\"select\"}");
			}
			sb.append("usePlugin:{");
			if (usePlugin.indexOf("password") >= 0) {
				sb.append(passsb);
			}
			if (usePlugin.indexOf("jqtransform") >= 0) {
				sb.append(jqsb);
			}
			sb.append("},");
		}
		sb.append("callback:function(data){");
		if (dialog) {
			sb.append("var win = frameElement.api.opener;");
			// 先判断是否成功，成功再刷新父页面，否则return false

			sb.append("if(data.success==true){frameElement.api.close();win.tip(data.msg);}else{if(data.responseText==''||data.responseText==undefined)$(\"#"
					+ formid
					+ "\").html(data.msg);else $(\"#"
					+ formid
					+ "\").html(data.responseText); return false;}");
			if (refresh) {
				sb.append("win.reloadTable();");
			}
			if (ObjectUtils.isNotEmpty(callback)) {
				sb.append("win." + callback + "(data);");
			}
		} else {
			sb.append("" + callback + "(data);");
		}
		sb.append("}" + "});" + "});" + "</script>");
		sb.append("");
		sb.append("</form>");
		if ("div".equals(layout)) {
			sb.append("</div>");
			if (tabtitle != null) {
				String[] tabtitles = tabtitle.split(",");
				sb.append("<div id=\"navigation\" style=\"display: none;\">");
				sb.append("<ul>");
				for (String string : tabtitles) {
					sb.append("<li>");
					sb.append("<a href=\"#\">" + string + "</a>");
					sb.append("</li>");
				}
				sb.append("</ul>");
				sb.append("</div>");
			}
			sb.append("</div></div>");
		}
		return sb.toString();
	}

	/**
	 * @retrun the formid <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getFormid() {
		return formid;
	}

	/**
	 * @param formid
	 *            the formid to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setFormid(String formid) {
		this.formid = formid;
	}

	/**
	 * @retrun the refresh <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public Boolean getRefresh() {
		return refresh;
	}

	/**
	 * @param refresh
	 *            the refresh to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setRefresh(Boolean refresh) {
		this.refresh = refresh;
	}

	/**
	 * @retrun the callback <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getCallback() {
		return callback;
	}

	/**
	 * @param callback
	 *            the callback to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setCallback(String callback) {
		this.callback = callback;
	}

	/**
	 * @retrun the beforeSubmit <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getBeforeSubmit() {
		return beforeSubmit;
	}

	/**
	 * @param beforeSubmit
	 *            the beforeSubmit to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setBeforeSubmit(String beforeSubmit) {
		this.beforeSubmit = beforeSubmit;
	}

	/**
	 * @retrun the btnsub <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getBtnsub() {
		return btnsub;
	}

	/**
	 * @param btnsub
	 *            the btnsub to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setBtnsub(String btnsub) {
		this.btnsub = btnsub;
	}

	/**
	 * @retrun the btnreset <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getBtnreset() {
		return btnreset;
	}

	/**
	 * @param btnreset
	 *            the btnreset to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setBtnreset(String btnreset) {
		this.btnreset = btnreset;
	}

	/**
	 * @retrun the layout <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getLayout() {
		return layout;
	}

	/**
	 * @param layout
	 *            the layout to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setLayout(String layout) {
		this.layout = layout;
	}

	/**
	 * @retrun the usePlugin <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getUsePlugin() {
		return usePlugin;
	}

	/**
	 * @param usePlugin
	 *            the usePlugin to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setUsePlugin(String usePlugin) {
		this.usePlugin = usePlugin;
	}

	/**
	 * @retrun the dialog <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public boolean isDialog() {
		return dialog;
	}

	/**
	 * @param dialog
	 *            the dialog to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setDialog(boolean dialog) {
		this.dialog = dialog;
	}

	/**
	 * @retrun the action <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @retrun the tabtitle <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getTabtitle() {
		return tabtitle;
	}

	/**
	 * @param tabtitle
	 *            the tabtitle to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setTabtitle(String tabtitle) {
		this.tabtitle = tabtitle;
	}

	/**
	 * @retrun the tiptype <br>
	 *
	 *         时间: 2013-7-22 下午5:06:39 <br>
	 */

	public String getTiptype() {
		return tiptype;
	}

	/**
	 * @param tiptype
	 *            the tiptype to set <br>
	 *
	 *            时间: 2013-7-22 下午5:06:39
	 */
	public void setTiptype(String tiptype) {
		this.tiptype = tiptype;
	}

}
