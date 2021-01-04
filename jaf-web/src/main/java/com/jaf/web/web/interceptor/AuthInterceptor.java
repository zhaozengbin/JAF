/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.web.interceptor <br>
 * 文件名：AuthInterceptor.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jaf.core.controller.BaseAction;
import com.jaf.core.util.HtmlUtils;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.annotaction.AuthAnnotaction;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.SysUserVo;

/**
 * 类: AuthInterceptor <br>
 * 描述: 安全拦截器 <br>
 * 作者: 赵增斌 zhaozengbin@adwo.com <br>
 * 时间: 2013-10-18 上午11:04:48
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	/**  */
	private final static Logger LOGGER = Logger
			.getLogger(AuthInterceptor.class);

	/**
	 * 方法：preHandle <br>
	 * 描述：TODO <br>
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			AuthAnnotaction authAnnotaction = method.getMethod().getAnnotation(
					AuthAnnotaction.class);
			// //验证登陆超时问题 authAnnotaction = null，默认验证
			if (authAnnotaction == null || authAnnotaction.verifyLogin()) {
				String baseUri = request.getContextPath();
				String path = request.getServletPath();
				SysUserVo sysUserVo = SessionUtils.getUser();

				if (ObjectUtils.isEmpty(sysUserVo)
						&& !path.contains("security")) {
					if (path.endsWith(".shtml")) {
						response.setStatus(response.SC_GATEWAY_TIMEOUT);
						response.sendRedirect(baseUri
								+ "/theme/easyui/main/forward.jsp");
						return false;
					} else {
						response.setStatus(response.SC_GATEWAY_TIMEOUT);
						Map<String, Object> result = new HashMap<String, Object>();
						result.put(BaseAction.SUCCESS, false);
						result.put(BaseAction.LOGOUT_FLAG, true);// 登录标记 true 退出
						result.put(BaseAction.MSG, "登录超时.");
						HtmlUtils.writerJson(response, result);
						return false;
					}
				}
			}
			// 验证URL权限
			if (ObjectUtils.isNotEmpty(authAnnotaction)
					&& authAnnotaction.verifyURL()) {
				// 判断是否超级管理员
				String menuUrl = StringUtils.remove(request.getRequestURI(),
						request.getContextPath());
				if (!SessionUtils.isSecurityUrl(StringUtils.trim(menuUrl))) {
					// 日志记录
					String userMail = SessionUtils.getUser().getEmail();
					String msg = "URL权限验证不通过:[url=" + menuUrl + "][email ="
							+ userMail + "]";
					LOGGER.error(msg);

					response.setStatus(response.SC_FORBIDDEN);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.MSG, "没有权限访问,请联系管理员.");
					HtmlUtils.writerJson(response, result);
					return false;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

}
