/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：UploadTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import com.jaf.web.tag.AbstractTag;

/**
 * 
 * 类名称：UploadTag <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:33:27 <br>
 * 修改备注：TODO <br>
 * 
 */
public class UploadTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** ID */
	protected String id;

	/** url */
	protected String uploader;

	/** 控件名称 */
	protected String name;

	/** 参数名称 */
	protected String formData;

	/** 上传文件的扩展名 */
	protected String extend = "";

	/** 按钮文本 */
	protected String buttonText = "浏览";

	/** 是否多文件 */
	protected boolean multi = true;

	/** 文件容器ID */
	protected String queueID = "filediv";

	/** 是否是弹出窗口模式 */
	protected boolean dialog = true;

	/** 回调 */
	protected String callback;

	/** 是否自动上传 */
	protected boolean auto = false;

	/** 上传成功处理函数 */
	protected String onUploadSuccess;

	/** 生成查看删除链接 */
	protected boolean view = false;

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
		if ("pic".equals(extend)) {
			extend = "*.jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif";
		}
		if (extend.equals("office")) {
			extend = "*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm";
		}
		sb.append("<script type=\"text/javascript\">" + "var flag = false;"
				+ "var fileitem=\"\";" + "var fileKey=\"\";"
				+ "var m = new Map();" + "$(function(){" + "$(\'#"
				+ id
				+ "\').uploadify({"
				+ "buttonText:\'"
				+ buttonText
				+ "\',"
				+ "auto:"
				+ auto
				+ ","
				+ "progressData:\'speed\',"
				+ "multi:"
				+ multi
				+ ","
				+ "height:25,"
				+ "overrideEvents:[\'onDialogClose\'],"
				+ "fileTypeDesc:\'文件格式:\',"
				+ "queueID:\'"
				+ queueID
				+ "\',"
				+ "fileTypeExts:\'"
				+ extend
				+ "\',"
				+ "fileSizeLimit:\'3MB\',"
				+ "swf:\'plugin/ui/uploadify/uploadify.swf\',	"
				+ "uploader:\'"
				+ uploader
				+ "&jsessionid='+$(\"#sessionUID\").val()+'\',"
				+ "onUploadStart : function(file) { ");
		if (formData != null) {
			String[] paramnames = formData.split(",");
			for (int i = 0; i < paramnames.length; i++) {
				String paramname = paramnames[i];
				sb.append("var " + paramname + "=$(\'#" + paramname
						+ "\').val();");
			}
			sb.append("$(\'#" + id
					+ "\').uploadify(\"settings\", \"formData\", {");
			for (int i = 0; i < paramnames.length; i++) {
				String paramname = paramnames[i];
				if (i == paramnames.length - 1) {
					sb.append("'" + paramname + "':" + paramname + "");
				} else {
					sb.append("'" + paramname + "':" + paramname + ",");
				}
			}
			sb.append("});");
		}
		;
		sb.append("} ," + "onQueueComplete : function(queueData) { ");
		if (dialog) {
			sb.append("var win = frameElement.api.opener;"
					+ "win.reloadTable();" + "win.tip(\'上传完成\');"
					+ "frameElement.api.close();");
		} else {
			if (callback != null)
				sb.append("" + callback + "();");
		}
		if (view) {
			sb.append("$(\"#viewmsg\").html(m.toString());");
			sb.append("$(\"#fileKey\").val(fileKey);");
		}
		sb.append("},");
		// 上传成功处理函数
		sb.append("onUploadSuccess : function(file, data, response) {");
		sb.append("var d=$.parseJSON(data);");
		if (view) {
			sb.append("var fileitem=\"<span id=\'\"+d.attributes.id+\"\'><a href=\'#\' onclick=openwindow(\'文件查看\',\'\"+d.attributes.viewhref+\"\',\'70%\',\'80%\') title=\'查看\'>\"+d.attributes.name+\"</a><img border=\'0\' onclick=confuploadify(\'\"+d.attributes.delurl+\"\',\'\"+d.attributes.id+\"\') title=\'删除\' src=\'plugin/ui/uploadify/img/uploadify-cancel.png\' widht=\'15\' height=\'15\'>&nbsp;&nbsp;</span>\";");
			sb.append("m.put(d.attributes.id,fileitem);");
			sb.append("fileKey=d.attributes.fileKey;");
		}
		if (onUploadSuccess != null) {
			sb.append(onUploadSuccess + "(d,file,response);");
		}
		sb.append("if(d.success){");
		sb.append("var win = frameElement.api.opener");
		sb.append("win.tip(d.msg);");
		sb.append("}");
		sb.append("},");
		sb.append("onFallback : function(){tip(\"您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试\")},");
		sb.append("onSelectError : function(file, errorCode, errorMsg){");
		sb.append("switch(errorCode) {");
		sb.append("case -100:");
		sb.append("tip(\"上传的文件数量已经超出系统限制的\"+$(\'#" + id
				+ "\').uploadify(\'settings\',\'queueSizeLimit\')+\"个文件！\");");
		sb.append("break;");
		sb.append("case -110:" + "tip(\"文件 [\"+file.name+\"] 大小超出系统限制的\"+$(\'#"
				+ id
				+ "\').uploadify(\'settings\',\'fileSizeLimit\')+\"大小！\");"
				+ "break;" + "case -120:"
				+ "tip(\"文件 [\"+file.name+\"] 大小异常！\");" + "break;"
				+ "case -130:" + "tip(\"文件 [\"+file.name+\"] 类型不正确！\");"
				+ "break;" + "}");
		sb.append("},"
				+ "onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) { "
				// +"tip('<span>文件上传成功:'+totalBytesUploaded/1024 + ' KB 已上传 ,总数' + totalBytesTotal/1024 + ' KB.</span>');"
				+ "}" + "});" + "});" + "function upload() {" + "	$(\'#" + id
				+ "\').uploadify('upload', '*');" + "		return flag;" + "}"
				+ "function cancel() {" + "$(\'#" + id
				+ "\').uploadify('cancel', '*');" + "}" + "</script>");
		sb.append("<span id=\"" + id + "span\"><input type=\"file\" name=\""
				+ name + "\" id=\"" + id + "\" /></span>");
		if (view) {
			sb.append("<span id=\"viewmsg\"></span>");
			sb.append("<input type=\"hidden\" name=\"fileKey\" id=\"fileKey\" />");
		}

		return sb.toString();
	}

}
