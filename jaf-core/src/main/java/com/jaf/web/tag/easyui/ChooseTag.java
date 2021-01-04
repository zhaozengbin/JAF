/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.web.tag.easyui <br>
 * 文件名：ChooseTag.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.tag.easyui;

import com.jaf.core.util.ObjectUtils;
import com.jaf.core.util.UUIDGenerator;
import com.jaf.web.tag.AbstractTag;
import com.jaf.web.util.ContextHolderUtils;

/**
 *
 * 类名称：ChooseTag <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:28:21 <br>
 * 修改备注：TODO <br>
 *
 */
public class ChooseTag extends AbstractTag {

	/** 序列化 */
	private static final long serialVersionUID = 1L;

	/** 隐藏名称 */
	protected String hiddenName;

	/** 显示文本框字段 */
	protected String textname;

	/** icon */
	protected String icon;

	/** 显示文本 */
	protected String title;

	/** 地址 */
	protected String url;

	/** 顶 */
	protected String top;

	/** 左 */
	protected String left;

	/** 宽 */
	protected String width;

	/** 高 */
	protected String height;

	/** 名称 */
	protected String name;

	/** 隐藏框取值ID */
	protected String hiddenid;

	/** 是否清除 */
	protected Boolean isclear = false;

	/** 自定义函数 */
	protected String fun;

	/**  */
	protected String inputTextname;

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
		String methodname = UUIDGenerator.generate().replaceAll("-", "");
		StringBuffer sb = new StringBuffer();
		sb.append("<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" icon=\""
				+ icon + "\" onClick=\"choose_" + methodname + "()\">选择</a>");
		if (isclear && ObjectUtils.isNotEmpty(textname)) {
			sb.append("<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" icon=\"icon-redo\" onClick=\"clearAll_"
					+ methodname + "();\">清空</a>");
		}
		sb.append("<script type=\"text/javascript\">");
		sb.append("var windowapi = frameElement.api, W = windowapi.opener;");
		sb.append("function choose_" + methodname + "(){");
		sb.append("if(typeof(windowapi) == 'undefined'){");
		sb.append("$.dialog({");
		sb.append("content: \'url:"
				+ ContextHolderUtils.getRequest().getContextPath() + url
				+ "\',");
		sb.append("zIndex: 2100,");
		if (title != null) {
			sb.append("title: \'" + title + "\',");
		}
		sb.append("lock : true,");
		if (width != null) {
			sb.append("width :\'" + width + "\',");
		} else {
			sb.append("width :400,");
		}
		if (height != null) {
			sb.append("height :\'" + height + "\',");
		} else {
			sb.append("height :350,");
		}
		if (left != null) {
			sb.append("left :\'" + left + "\',");
		} else {
			sb.append("left :'85%',");
		}
		if (top != null) {
			sb.append("top :\'" + top + "\',");
		} else {
			sb.append("top :'65%',");
		}
		sb.append("opacity : 0.4,");
		sb.append("button : [ {");
		sb.append("name : \'确认\',");
		sb.append("callback : clickcallback_" + methodname + ",");
		sb.append("focus : true");
		sb.append("}, {");
		sb.append("name : \'取消\',");
		sb.append("callback : function() {");
		sb.append("}");
		sb.append("} ]");
		sb.append("});");
		sb.append("}else{");
		sb.append("$.dialog({");
		sb.append("content: \'url:"
				+ ContextHolderUtils.getRequest().getContextPath() + url
				+ "\',");
		sb.append("zIndex: 2100,");
		if (title != null) {
			sb.append("title: \'" + title + "\',");
		}
		sb.append("lock : true,");
		sb.append("parent:windowapi,");
		if (width != null) {
			sb.append("width :\'" + width + "\',");
		} else {
			sb.append("width :400,");
		}
		if (height != null) {
			sb.append("height :\'" + height + "\',");
		} else {
			sb.append("height :350,");
		}
		if (left != null) {
			sb.append("left :\'" + left + "\',");
		} else {
			sb.append("left :'85%',");
		}
		if (top != null) {
			sb.append("top :\'" + top + "\',");
		} else {
			sb.append("top :'65%',");
		}
		sb.append("opacity : 0.4,");
		sb.append("button : [ {");
		sb.append("name : \'确认\',");
		sb.append("callback : clickcallback_" + methodname + ",");
		sb.append("focus : true");
		sb.append("}, {");
		sb.append("name : \'取消\',");
		sb.append("callback : function() {");
		sb.append("}");
		sb.append("} ]");
		sb.append("});");
		sb.append("}");
		sb.append("}");
		clearAll(sb, methodname);
		callback(sb, methodname);
		sb.append("</script>");
		return sb.toString();
	}

	/**
	 * 方法：clearAll <br>
	 * 描述：清除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午4:26:32 <br>
	 *
	 * @param sb
	 * @param methodname
	 */
	private void clearAll(StringBuffer sb, String methodname) {
		String[] textnames = null;
		String[] inputTextnames = null;
		textnames = textname.split(",");
		if (ObjectUtils.isNotEmpty(inputTextname)) {
			inputTextnames = inputTextname.split(",");
		} else {
			inputTextnames = textnames;
		}
		if (isclear && ObjectUtils.isNotEmpty(textname)) {
			sb.append("function clearAll_" + methodname + "(){");
			for (int i = 0; i < textnames.length; i++) {
				inputTextnames[i] = inputTextnames[i]
						.replaceAll("\\[", "\\\\\\\\[")
						.replaceAll("\\]", "\\\\\\\\]")
						.replaceAll("\\.", "\\\\\\\\.");
				sb.append("if($(\'#" + inputTextnames[i] + "\').length>=1){");
				sb.append("$(\'#" + inputTextnames[i] + "\').val('');");
				sb.append("$(\'#" + inputTextnames[i] + "\').blur();");
				sb.append("}");
				sb.append("if($(\"input[name='" + inputTextnames[i]
						+ "']\").length>=1){");
				sb.append("$(\"input[name='" + inputTextnames[i]
						+ "']\").val('');");
				sb.append("$(\"input[name='" + inputTextnames[i]
						+ "']\").blur();");
				sb.append("}");
			}
			sb.append("$(\'#" + hiddenName + "\').val(\"\");");
			sb.append("}");
		}
	}

	/**
	 * 方法：callback <br>
	 * 描述：点击确定回填 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-4 下午4:26:19 <br>
	 *
	 * @param sb
	 * @param methodname
	 */
	private void callback(StringBuffer sb, String methodname) {
		sb.append("function clickcallback_" + methodname + "(){");
		sb.append("iframe = this.iframe.contentWindow;");
		String[] textnames = null;
		String[] inputTextnames = null;
		if (ObjectUtils.isNotEmpty(textname)) {
			textnames = textname.split(",");
			if (ObjectUtils.isNotEmpty(inputTextname)) {
				inputTextnames = inputTextname.split(",");
			} else {
				inputTextnames = textnames;
			}
			for (int i = 0; i < textnames.length; i++) {
				inputTextnames[i] = inputTextnames[i]
						.replaceAll("\\[", "\\\\\\\\[")
						.replaceAll("\\]", "\\\\\\\\]")
						.replaceAll("\\.", "\\\\\\\\.");
				sb.append("var " + textnames[i] + "=iframe.get" + name
						+ "Selections(\'" + textnames[i] + "\'); ");
				sb.append("if($(\'#" + inputTextnames[i] + "\').length>=1){");
				sb.append("$(\'#" + inputTextnames[i] + "\').val("
						+ textnames[i] + ");");
				sb.append("$(\'#" + inputTextnames[i] + "\').blur();");
				sb.append("}");
				sb.append("if($(\"input[name='" + inputTextnames[i]
						+ "']\").length>=1){");
				sb.append("$(\"input[name='" + inputTextnames[i] + "']\").val("
						+ textnames[i] + ");");
				sb.append("$(\"input[name='" + inputTextnames[i]
						+ "']\").blur();");
				sb.append("}");
			}
		}
		if (ObjectUtils.isNotEmpty(hiddenName)) {
			sb.append("var id =iframe.get" + name + "Selections(\'" + hiddenid
					+ "\');");
			sb.append("if (id!== undefined &&id!=\"\"){");
			sb.append("$(\'#" + hiddenName + "\').val(id);");
			sb.append("}");
		}
		if (ObjectUtils.isNotEmpty(fun)) {
			sb.append("" + fun + "();");// 执行自定义函数
		}
		sb.append("}");
	}

	/**
	 * 返回: the hiddenName <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getHiddenName() {
		return hiddenName;
	}

	/**
	 * 参数: hiddenName the hiddenName to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}

	/**
	 * 返回: the textname <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getTextname() {
		return textname;
	}

	/**
	 * 参数: textname the textname to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setTextname(String textname) {
		this.textname = textname;
	}

	/**
	 * 返回: the icon <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 参数: icon the icon to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 返回: the title <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 参数: title the title to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 返回: the url <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 参数: url the url to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回: the top <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getTop() {
		return top;
	}

	/**
	 * 参数: top the top to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setTop(String top) {
		this.top = top;
	}

	/**
	 * 返回: the left <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getLeft() {
		return left;
	}

	/**
	 * 参数: left the left to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setLeft(String left) {
		this.left = left;
	}

	/**
	 * 返回: the width <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 参数: width the width to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 返回: the height <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 参数: height the height to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * 返回: the name <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getName() {
		return name;
	}

	/**
	 * 参数: name the name to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 返回: the hiddenid <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getHiddenid() {
		return hiddenid;
	}

	/**
	 * 参数: hiddenid the hiddenid to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setHiddenid(String hiddenid) {
		this.hiddenid = hiddenid;
	}

	/**
	 * 返回: the isclear <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public Boolean getIsclear() {
		return isclear;
	}

	/**
	 * 参数: isclear the isclear to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setIsclear(Boolean isclear) {
		this.isclear = isclear;
	}

	/**
	 * 返回: the fun <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public String getFun() {
		return fun;
	}

	/**
	 * 参数: fun the fun to set <br>
	 *
	 * 时间: 2013-7-25 下午2:12:39
	 */
	public void setFun(String fun) {
		this.fun = fun;
	}

	/**
	 * @retrun the inputTextname <br>
	 *
	 *         时间: 2014-4-4 下午4:27:21 <br>
	 */

	public String getInputTextname() {
		return inputTextname;
	}

	/**
	 * @param inputTextname
	 *            the inputTextname to set <br>
	 *
	 *            时间: 2014-4-4 下午4:27:21
	 */
	public void setInputTextname(String inputTextname) {
		this.inputTextname = inputTextname;
	}

}
