/**
 * 项目名：${projectName} <br>
 * 包名：${packagePath}.dao.impl <br>
 * 文件名：${className}DaoImpl.java <br>
 * 版本信息：TODO <br>
 * 作者：${author} <br>
 * 日期：${time} <br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package ${packagePath}.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jaf.core.dto.Query;
import ${packagePath}.dao.I${className}Dao;
import ${packagePath}.pojo.${className};

/**
 * 
 * 类名称：${className}DaoImpl <br>
 * 类描述：${remark} 数据连接对象实现 <br>
 * 创建人：${createUser} <br>
 * 修改人：${modifyUser} <br>
 * 修改时间：${time} <br>
 * 修改备注：TODO <br>
 * 
 */
@SuppressWarnings("deprecation")
public class ${className}DaoImpl extends SqlMapClientDaoSupport implements I${className}Dao {
	#set ($well="#")
	
	/**
	 *  方法：insert <br>
	 *  描述：TODO <br>
	 *  
	 * @param t
	 * @see com.jaf.core.dao.IBaseDao${well}insert(java.lang.Object)
	 */
	public void insert(${className} t) {
		getSqlMapClientTemplate().insert("${tableName}.jaf_insert",t);
	}

	/**
	 *  方法：update <br>
	 *  描述：TODO <br>
	 *  
	 * @param t
	 * @see com.jaf.core.dao.IBaseDao${well}update(java.lang.Object)
	 */
	public void update(${className} t) {
		getSqlMapClientTemplate().update("${tableName}.jaf_update",t);
	}

	/**
	 *  方法：updateBySelective <br>
	 *  描述：TODO <br>
	 *  
	 * @param t
	 * @see com.jaf.core.dao.IBaseDao${well}updateBySelective(java.lang.Object)
	 */
	
	public void updateBySelective(${className} t) {
		getSqlMapClientTemplate().update("${tableName}.jaf_updateBySelective",t);
	}
	/**
	 *  方法：delete <br>
	 *  描述：TODO <br>
	 *  
	 * @param id
	 * @see com.jaf.core.dao.IBaseDao${well}delete(java.lang.Object)
	 */
	public void delete(Object id) {
		getSqlMapClientTemplate().delete("${tableName}.jaf_delete", id);
	}


	/**
	 *  方法：queryByList <br>
	 *  描述：TODO <br>
	 *  
	 * @param query
	 * @param t
	 * @return
	 * @see com.jaf.core.dao.IBaseDao${well}queryByList(com.jaf.core.dto.Query,java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<${className}> queryByList(Query query, ${className} t) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("query", query);
		map.put("entity", t);
		return	(List<${className}>) getSqlMapClientTemplate().queryForList("${tableName}.queryByList", map);
	}
	
	/**
	 *  方法：queryByList <br>
	 *  描述：TODO <br>
	 *  
	 * @return
	 * @see com.jaf.core.dao.IBaseDao${well}queryByList()
	 */
	@SuppressWarnings("unchecked")
	public List<${className}> queryByList() {
		Map<String,Object> map = new HashMap<String,Object>();
		return	(List<${className}>) getSqlMapClientTemplate().queryForList("${tableName}.queryByList", map);
	}
	/**
	 *  方法：queryById <br>
	 *  描述：TODO <br>
	 *  
	 * @param id
	 * @return
	 * @see com.jaf.core.dao.IBaseDao${well}queryById(java.lang.Object)
	 */
	public ${className} queryById(Object id) {
		 return (${className})getSqlMapClientTemplate().queryForObject("${tableName}.jaf_queryById",id);
	}

}
