/**
 * 项目名：jaf-web  <br>
 * 包名：com.jaf.web.listener <br>
 * 文件名：InitListener.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-08-14 下午14:49:41 <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */

package com.jaf.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaf.core.cache.adapter.CacheAdapter;
import com.jaf.core.util.ObjectUtils;
import com.jaf.web.dto.SysDictionaryDto;
import com.jaf.web.service.SysDictionaryService;

/**
 *
 * 类名称：InitListener <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-10-9 下午6:48:45 <br>
 * 修改备注：TODO <br>
 *
 */
public class InitListener implements ServletContextListener {

	@Autowired(required = false)
	private SysDictionaryService sysDictionaryService;

	/**
	 * 方法: contextDestroyed <br>
	 * 描述: TODO
	 *
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * 方法: contextInitialized <br>
	 * 描述: TODO
	 *
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 对数据字典进行缓存
		if (ObjectUtils.isNotEmpty(sysDictionaryService)) {
			try {
				List<SysDictionaryDto> dictionaryDtoList = sysDictionaryService
						.queryByList(new SysDictionaryDto());
				if (ObjectUtils.isNotEmpty(dictionaryDtoList)) {
					CacheAdapter.adapter().put(
							CacheAdapter.CACHE_KEY_SYS_DICTIONARY,
							dictionaryDtoList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
