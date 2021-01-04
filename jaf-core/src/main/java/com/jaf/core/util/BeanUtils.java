/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.util <br>
 * 文件名：BeanUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-1-下午2:54:59<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * 类名称：BeanUtils <br>
 * 类描述：bean工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-1 下午2:54:59 <br>
 * 修改备注：TODO <br>
 * 
 */
public class BeanUtils {

	/**
	 * 方法：copyBean <br>
	 * 描述：复制bean属性 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-1 下午2:55:59 <br>
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyBean(Object source, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(source, target);
	}

	/**
	 * 方法：copyBeanList <br>
	 * 描述：复制结合bean属性 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-1 下午3:05:53 <br>
	 * 
	 * @param source
	 * @param target
	 */
	public static <T, K> void copyBeanList(Collection<T> source,
			Collection<K> target, Class<K> targetClassType) {
		if (ObjectUtils.isNotEmpty(source)) {
			Iterator<T> iterator = source.iterator();
			while (iterator.hasNext()) {
				T t = iterator.next();
				K k;
				try {
					k = targetClassType.newInstance();
					copyBean(t, k);
					target.add(k);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
