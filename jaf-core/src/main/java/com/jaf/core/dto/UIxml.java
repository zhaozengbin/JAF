/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.dto <br>
 * 文件名：UIxml.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-18-下午7:02:30<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.dto;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 * 类名称：UIxml <br>
 * 类描述：uixml主类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-18 下午7:02:30 <br>
 * 修改备注：TODO <br>
 * 
 */
@XStreamAlias("project")
public class UIxml implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 1L;

	/** js标签 */
	private List<UIxmlJs> js;

	/** css标签 */
	private List<UIxmlCss> css;

	@XStreamAlias("jsNode")
	public class UIxmlJs implements Serializable {

		/** 序列号 */
		private static final long serialVersionUID = 1L;

		@XStreamAsAttribute
		/** CSS 引入标签 name参数 */
		private String name;

		/** 引入标签组名称 */
		private String groupId;

		/** 引入标签类型 */
		private String type;

		/** 引入标签地址 */
		private String src;

		/** 引入标签版本 */
		private String version;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-7-18 下午7:09:15 <br>
		 */
		public UIxmlJs() {
		}

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-7-18 下午7:09:28 <br>
		 * 
		 * @param name
		 * @param groupId
		 * @param type
		 * @param src
		 * @param version
		 */
		public UIxmlJs(String name, String groupId, String type, String src,
				String version) {
			super();
			this.name = name;
			this.groupId = groupId;
			this.type = type;
			this.src = src;
			this.version = version;
		}

		/**
		 * 方法: hashCode <br>
		 * 描述: TODO
		 * 
		 * @return
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return super.hashCode();
		}

		/**
		 * 方法: equals <br>
		 * 描述: TODO
		 * 
		 * @param obj
		 * @return
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof UIxmlJs) {
				UIxmlJs uIxmlJs = (UIxmlJs) obj;
				return this.getSrc().equals(uIxmlJs.getSrc());
			}
			return false;
		}

		/**
		 * @retrun the name <br>
		 * 
		 *         时间: 2013-7-18 下午7:09:33 <br>
		 */

		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:09:33
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @retrun the groupId <br>
		 * 
		 *         时间: 2013-7-18 下午7:09:33 <br>
		 */

		public String getGroupId() {
			return groupId;
		}

		/**
		 * @param groupId
		 *            the groupId to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:09:33
		 */
		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}

		/**
		 * @retrun the type <br>
		 * 
		 *         时间: 2013-7-18 下午7:09:33 <br>
		 */

		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:09:33
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @retrun the src <br>
		 * 
		 *         时间: 2013-7-18 下午7:09:33 <br>
		 */

		public String getSrc() {
			return src;
		}

		/**
		 * @param src
		 *            the src to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:09:33
		 */
		public void setSrc(String src) {
			this.src = src;
		}

		/**
		 * @retrun the version <br>
		 * 
		 *         时间: 2013-7-18 下午7:09:33 <br>
		 */

		public String getVersion() {
			return version;
		}

		/**
		 * @param version
		 *            the version to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:09:33
		 */
		public void setVersion(String version) {
			this.version = version;
		}

	}

	@XStreamAlias("cssNode")
	public class UIxmlCss implements Serializable {

		/** 序列号 */
		private static final long serialVersionUID = 1L;

		@XStreamAsAttribute
		/** CSS 引入标签 id参数 */
		private String id;

		/** 引入标签名称 */
		private String name;

		/** 引入标签组名称 */
		private String groupId;

		/** 引入标签类型 */
		private String type;

		/** 引入标签地址 */
		private String href;

		/** CSS 引入标签 rel参数 */
		private String rel;

		/** 引入标签版本 */
		private String version;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-7-18 下午7:15:09 <br>
		 */
		public UIxmlCss() {
		}

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-7-18 下午7:15:16 <br>
		 * 
		 * @param id
		 * @param name
		 * @param groupId
		 * @param type
		 * @param href
		 * @param rel
		 * @param version
		 */
		public UIxmlCss(String id, String name, String groupId, String type,
				String href, String rel, String version) {
			super();
			this.id = id;
			this.name = name;
			this.groupId = groupId;
			this.type = type;
			this.href = href;
			this.rel = rel;
			this.version = version;
		}

		/**
		 * 方法: hashCode <br>
		 * 描述: TODO
		 * 
		 * @return
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return super.hashCode();
		}

		/**
		 * 方法: equals <br>
		 * 描述: TODO
		 * 
		 * @param obj
		 * @return
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof UIxmlCss) {
				UIxmlCss uIxmlCss = (UIxmlCss) obj;
				System.out.println("this:[" + this.getHref() + "],obj:["
						+ uIxmlCss.getHref() + "]");
				return this.getHref().equals(uIxmlCss.getHref());
			}
			return false;
		}

		/**
		 * @retrun the id <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @retrun the name <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @retrun the groupId <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getGroupId() {
			return groupId;
		}

		/**
		 * @param groupId
		 *            the groupId to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}

		/**
		 * @retrun the type <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @retrun the href <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getHref() {
			return href;
		}

		/**
		 * @param href
		 *            the href to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setHref(String href) {
			this.href = href;
		}

		/**
		 * @retrun the rel <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getRel() {
			return rel;
		}

		/**
		 * @param rel
		 *            the rel to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setRel(String rel) {
			this.rel = rel;
		}

		/**
		 * @retrun the version <br>
		 * 
		 *         时间: 2013-7-18 下午7:15:27 <br>
		 */

		public String getVersion() {
			return version;
		}

		/**
		 * @param version
		 *            the version to set <br>
		 * 
		 *            时间: 2013-7-18 下午7:15:27
		 */
		public void setVersion(String version) {
			this.version = version;
		}
	}

	/**
	 * @retrun the js <br>
	 * 
	 *         时间: 2013-7-18 下午7:32:27 <br>
	 */

	public List<UIxmlJs> getJs() {
		return js;
	}

	/**
	 * @param js
	 *            the js to set <br>
	 * 
	 *            时间: 2013-7-18 下午7:32:27
	 */
	public void setJs(List<UIxmlJs> js) {
		this.js = js;
	}

	/**
	 * @retrun the css <br>
	 * 
	 *         时间: 2013-7-18 下午7:32:27 <br>
	 */

	public List<UIxmlCss> getCss() {
		return css;
	}

	/**
	 * @param css
	 *            the css to set <br>
	 * 
	 *            时间: 2013-7-18 下午7:32:27
	 */
	public void setCss(List<UIxmlCss> css) {
		this.css = css;
	}

}
