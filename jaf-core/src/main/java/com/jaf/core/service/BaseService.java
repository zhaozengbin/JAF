/**
 * 项目名：jaf-core <br>
 * 包名：com.jaf.core.service <br>
 * 文件名：BaseService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-7-31-下午2:36:54<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.core.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jaf.core.dao.IBaseDao;
import com.jaf.core.dto.BaseDto;
import com.jaf.core.util.BeanUtils;
import com.jaf.core.util.LoggerUtils;

/**
 *
 * 类名称：BaseService <br>
 * 类描述：基础服务层 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-7-31 下午2:36:54 <br>
 * 修改备注：TODO <br>
 *
 */
public abstract class BaseService<T, Tdto> {

	/**
	 * 方法：getDao <br>
	 * 描述：BaserDao抽象get方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:53:28 <br>
	 *
	 * @return
	 */
	public abstract IBaseDao<T> getDao();

	/**
	 * 方法：insert <br>
	 * 描述：添加对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:11 <br>
	 *
	 * @param tdto
	 * @throws Exception
	 */
	public void add(Tdto tdto) throws Exception {
		T t = getPojoName().newInstance();
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行添加[" + t.getClass() + "]操作");
		BeanUtils.copyBean(tdto, t);
		getDao().insert(t);
		BeanUtils.copyBean(t, tdto);
	}

	/**
	 * 方法：update <br>
	 * 描述：更新实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:21 <br>
	 *
	 * @param tdto
	 * @throws Exception
	 */
	public void update(Tdto tdto) throws Exception {
		T t = getPojoName().newInstance();
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行修改[" + t.getClass() + "]操作");
		BeanUtils.copyBean(tdto, t);
		getDao().update(t);
	}

	/**
	 * 方法：updateBySelective <br>
	 * 描述：选择性更新 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:37 <br>
	 *
	 * @param tdto
	 * @throws Exception
	 */
	public void updateBySelective(Tdto tdto) throws Exception {
		T t = getPojoName().newInstance();
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行修改[" + t.getClass() + "]操作");
		BeanUtils.copyBean(tdto, t);
		getDao().updateBySelective(t);
	}

	/**
	 * 方法：delete <br>
	 * 描述：根据ID集合删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:55:07 <br>
	 *
	 * @param ids
	 * @throws Exception
	 */
	public void delete(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行删除操作");
		for (Object id : ids) {
			getDao().delete(id);
		}
	}

	/**
	 * 方法：queryByList <br>
	 * 描述：查询集合 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:57:12 <br>
	 *
	 * @param dto
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<Tdto> queryByList(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]操作");
		List<T> list = getDao().queryByList(dto);
		List<Tdto> dtoList = new ArrayList<Tdto>();
		BeanUtils.copyBeanList(list, dtoList, getDtoName());
		return dtoList;
	}

	/**
	 * 方法：queryByCount <br>
	 * 描述：查询集合数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-14 下午5:40:01 <br>
	 *
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public Integer queryByCount(BaseDto dto) throws Exception {
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询[" + getPojoName().getName() + "]列表数操作");
		return getDao().queryByCount(dto);
	}

	/**
	 * 方法：queryById <br>
	 * 描述：根据ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:57:22 <br>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Tdto queryById(Object id) throws Exception {
		T t = getPojoName().newInstance();
		Tdto tdto = getDtoName().newInstance();
		LoggerUtils.debug(getLogger(), "通过[" + getDao().getClass()
				+ "]DAO执行查询操作");
		t = (T) getDao().queryById(id);
		BeanUtils.copyBean(t, tdto);
		return tdto;
	}

	/**
	 * 方法：getLogger <br>
	 * 描述：获取日志对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-8-1 下午12:31:35 <br>
	 *
	 * @return
	 */
	protected abstract Logger getLogger();

	/**
	 * 方法：getPojoName <br>
	 * 描述：获取当前操作业务对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-23 下午12:09:12 <br>
	 *
	 * @return
	 */
	protected abstract Class<T> getPojoName();

	/**
	 * 方法：getDtoName <br>
	 * 描述：获取当前操作业务对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-10-23 下午12:09:12 <br>
	 *
	 * @return
	 */
	protected abstract Class<Tdto> getDtoName();

}
