/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.util <br>
 * 文件名：SessionUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-10-18-上午11:15:26<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.web.vo.SysPermissionVo;
import com.jaf.web.web.vo.SysUserVo;

/**
 *
 * 类名称：SessionUtils <br>
 * 类描述：Session 工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-18 上午11:15:26 <br>
 * 修改备注：TODO <br>
 *
 */
public class SessionUtils {

	protected static final Logger logger = Logger.getLogger(SessionUtils.class);

	private static final String SESSION_USER = "session_user";

	/** 验证码 */
	private static final String SESSION_VALIDATECODE = "session_validatecode";

	/**
	 * 方法：setAttr <br>
	 * 描述：设置session的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:02 <br>
	 *
	 * @param key
	 * @param value
	 */
	public static void setAttr(String key, Object value) {
		SysContentUtils.getSession().setAttribute(key, value);
	}

	/**
	 * 方法：getAttr <br>
	 * 描述：获取session的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:08 <br>
	 *
	 * @param key
	 * @return
	 */
	public static Object getAttr(String key) {
		return SysContentUtils.getSession().getAttribute(key);
	}

	/**
	 * 方法：removeAttr <br>
	 * 描述：删除Session值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:16 <br>
	 *
	 * @param key
	 */
	public static void removeAttr(String key) {
		SysContentUtils.getSession().removeAttribute(key);
	}

	/**
	 * 方法：setUser <br>
	 * 描述：设置用户信息 到session <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:23 <br>
	 *
	 * @param user
	 */
	public static void setUser(SysUserVo sysUserVo) {
		SysContentUtils.getSession().setAttribute(SESSION_USER, sysUserVo);
	}

	/**
	 * 方法：getUser <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:32 <br>
	 *
	 * @return
	 */
	public static SysUserVo getUser() {
		return (SysUserVo) SysContentUtils.getSession().getAttribute(
				SESSION_USER);
	}

	/**
	 * 方法：getUserId <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:38 <br>
	 *
	 * @return
	 */
	public static Integer getUserId() {
		SysUserVo sysUserVo = getUser();
		if (sysUserVo != null) {
			return sysUserVo.getId();
		}
		return null;
	}

	/**
	 * 方法：removeUser <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:46 <br>
	 *
	 */
	public static void removeUser() {
		removeAttr(SESSION_USER);
	}

	/**
	 * 方法：setValidateCode <br>
	 * 描述：设置验证码 到session <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:55 <br>
	 *
	 * @param validateCode
	 */
	public static void setValidateCode(String validateCode) {
		SysContentUtils.getSession().setAttribute(SESSION_VALIDATECODE,
				validateCode);
	}

	/**
	 * 方法：getValidateCode <br>
	 * 描述：从session中获取验证码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:03 <br>
	 *
	 * @return
	 */
	public static String getValidateCode() {
		return (String) SysContentUtils.getSession().getAttribute(
				SESSION_VALIDATECODE);
	}

	/**
	 * 方法：removeValidateCode <br>
	 * 描述：从session中获删除验证码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:10 <br>
	 *
	 */
	public static void removeValidateCode() {
		removeAttr(SESSION_VALIDATECODE);
	}

	/**
	 * 方法：isAccessUrl <br>
	 * 描述：判断URL是否可访问 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:41 <br>
	 *
	 * @param url
	 * @return
	 */
	public static boolean isSecurityUrl(String url) {
		List<SysPermissionVo> sysPermissionVoList = getUser()
				.getSysPermissionVoList();
		if (ObjectUtils.isNotEmpty(sysPermissionVoList)) {
			for (SysPermissionVo sysPermissionVo : sysPermissionVoList) {
				if (url.contains(sysPermissionVo.getUrl())) {
					return true;
				}
			}
		}
		return false;
	}

}
