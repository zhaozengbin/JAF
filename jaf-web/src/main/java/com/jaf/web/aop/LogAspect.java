/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.aop <br>
 * 文件名：LogAspect.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2014-4-14-上午11:01:08<br>
 * Copyright (c) 2014 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.aop;

import java.lang.reflect.Method;
import java.sql.Timestamp;

import net.sf.json.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaf.core.util.ObjectUtils;
import com.jaf.web.annotaction.LogAnnotaction;
import com.jaf.web.dto.SysLogDto;
import com.jaf.web.service.SysLogService;
import com.jaf.web.util.SessionUtils;
import com.jaf.web.web.vo.SysUserVo;

/**
 *
 * 类名称：LogAspect <br>
 * 类描述：日志面向切面编程 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2014-4-14 上午11:01:08 <br>
 * 修改备注：TODO <br>
 *
 */
@Aspect
@Component
public class LogAspect {
	@Autowired
	private SysLogService sysLogService;// 日志记录Service

	/**
	 * 添加业务逻辑方法切入点
	 */
	private final static String el = "@annotation(com.jaf.web.annotaction.LogAnnotaction)";

	/**
	 * 方法：before <br>
	 * 描述：执行之前 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午1:53:16 <br>
	 */
	@Before(el)
	public void before() {
	}

	/**
	 * 方法：after <br>
	 * 描述：执行之后 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午1:53:26 <br>
	 */
	@After(el)
	public void after() {
	}

	/**
	 * 方法：afterReturning <br>
	 * 描述：管理员添加操作日志(后置通知) <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午1:53:35 <br>
	 *
	 * @param joinPoint
	 * @throws Throwable
	 */
	@AfterReturning(value = el, argNames = "rtv", returning = "rtv")
	public void afterReturning(JoinPoint joinPoint) throws Throwable {
		// 获取登录管理员id
		SysUserVo sysUserVo = SessionUtils.getUser();

		if (ObjectUtils.isEmpty(sysUserVo)
				&& ObjectUtils.isEmpty(sysUserVo.getId())) {// 没有管理员登录
			return;
		}
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();

		// 方法名
		Method method = ((MethodSignature) joinPoint.getSignature())
				.getMethod();

		LogAnnotaction annotation = method.getAnnotation(LogAnnotaction.class);

		// 获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(), methodName);

		// 创建日志对象
		SysLogDto sysLogDto = new SysLogDto();
		sysLogDto.setCreateUser(sysUserVo.getId());// 设置管理员id
		sysLogDto.setCreateTime(new Timestamp(System.currentTimeMillis()));// 操作时间
		sysLogDto.setContent(opContent);// 操作内容
		sysLogDto.setOperation(annotation.operation().getOperation());// 操作
		sysLogDto.setLevel(annotation.level().getLevel());// 操作
		sysLogDto.setRemark(annotation.remark());
		sysLogService.add(sysLogDto);// 添加日志
	}

	/**
	 * 方法：adminOptionContent <br>
	 * 描述： 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午12:59:58 <br>
	 *
	 * @param args
	 * @param mName
	 * @return
	 * @throws Exception
	 */
	public String adminOptionContent(Object[] args, String mName)
			throws Exception {
		if (args == null) {
			return null;
		}

		StringBuffer rs = new StringBuffer();
		rs.append(mName);
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {

			// 获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数" + index + "，类型：" + className + "，值：");

			// 获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();

			// 遍历方法，判断get方法
			for (Method method : methods) {

				String methodName = method.getName();
				// 判断是不是get方法
				if (methodName.indexOf("get") == -1) {// 不是get方法
					continue;// 不处理
				}

				Object rsValue = null;
				try {

					// 调用get方法，获取返回值
					rsValue = method.invoke(info);

					if (rsValue == null) {// 没有返回值
						continue;
					}

				} catch (Exception e) {
					continue;
				}
				rs.append("(" + methodName + " : " + rsValue + ")");
			}
			rs.append("]");
			index++;
		}
		return rs.toString();
	}
}
