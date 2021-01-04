/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.init <br>
 * 文件名：InitializationByMysql.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-8-2-下午2:31:06<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.init;

import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.jaf.core.util.LoggerUtils;
import com.jaf.web.util.MD5;

/**
 *
 * 类名称：InitializationByMysql <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-8-2 下午2:31:06 <br>
 * 修改备注：TODO <br>
 *
 */
public class InitializationByMysql extends AbstractInitialization {

	/**
	 * 方法：createSysBaseUserTab <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysBaseUserTab()
	 */
	@Override
	protected void createSysBaseUserTab() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统基础用户表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer(
				"drop table if exists sys_base_user;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统基础用户表");
		sql = new StringBuffer("CREATE TABLE sys_base_user");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("userName varchar(32) COMMENT '用户名',");
		sql.append("password varchar(64) COMMENT '密码',");
		sql.append("status int(1) COMMENT '状态',");
		sql.append("createTime datetime COMMENT '创建时间',");
		sql.append("createUser int(10) COMMENT '创建者',");
		sql.append("primary key (id)");
		sql.append(")ENGINE=MYISAM;");
		// 执行SQL语句,新建表
		LoggerUtils.debug(getLogger(), "创建语句[" + sql + "]");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysUserTab <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysUserTab()
	 */
	@Override
	protected void createSysUserTab() throws Exception {
		LoggerUtils.debug(getLogger(), "删除系统用户表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer("drop table if exists sys_user;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统用户表");
		sql = new StringBuffer("CREATE TABLE sys_user");
		sql.append("(");
		sql.append("id INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("baseId INT(10) COMMENT '用户基础编号',");
		sql.append("number varchar(32) COMMENT '工号',");
		sql.append("email varchar(128) COMMENT '邮箱',");
		sql.append("mobilePhone varchar(32) COMMENT '手机',");
		sql.append("officePhone varchar(32) COMMENT '办公电话',");
		sql.append("realName varchar(32) COMMENT '用户昵称',");
		sql.append("primary key (id)");
		sql.append(")ENGINE=MYISAM;");
		// 执行SQL语句,新建表
		LoggerUtils.debug(getLogger(), "创建语句[" + sql + "]");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysTeamTab <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysTeamTab()
	 */
	@Override
	protected void createSysTeamTab() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统用户组表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer("drop table if exists sys_team;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统用户组表");
		sql = new StringBuffer("CREATE TABLE sys_team");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("teamName varchar(32) COMMENT '组名',");
		sql.append("description varchar(255) COMMENT '组描述',");
		sql.append("createTime datetime COMMENT '创建时间',");
		sql.append("createUser int(10) COMMENT '创建者',");
		sql.append("parentId int(10) COMMENT '父类编号',");
		sql.append("primary key (id)");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysRoleTab <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysRoleTab()
	 */
	@Override
	protected void createSysRoleTab() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统角色表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer("drop table if exists sys_role;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统角色表");
		sql = new StringBuffer("CREATE TABLE sys_role");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("roleName varchar(32) COMMENT '角色名',");
		sql.append("description varchar(255) COMMENT '角色描述',");
		sql.append("createTime datetime COMMENT '创建时间',");
		sql.append("createUser int(10) COMMENT '创建者',");
		sql.append("primary key (id)");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysPermission <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysPermission()
	 */
	@Override
	protected void createSysPermission() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统角色表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer(
				"drop table if exists sys_permission;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统角色表");
		sql = new StringBuffer("CREATE TABLE sys_permission");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("permissionName varchar(32) COMMENT '权限名称',");
		sql.append("description varchar(255) COMMENT '权限描述',");
		sql.append("url varchar(255) COMMENT '链接地址',");
		sql.append("parentId int(10) COMMENT '父级编号',");
		sql.append("weight int(5) COMMENT '权重',");
		sql.append("type int(1) COMMENT '类型 1菜单 2 按钮',");
		sql.append("createTime datetime COMMENT '创建时间',");
		sql.append("createUser int(10) COMMENT '创建者',");
		sql.append("icon varchar(255) COMMENT '图标',");
		sql.append("clazz varchar(255) COMMENT '样式',");
		sql.append("primary key (id)");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法: createSysDictionary <br>
	 * 描述: TODO
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createDictionary()
	 */
	@Override
	protected void createSysDictionary() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统字典表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer(
				"drop table if exists sys_dictionary;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统字典表");
		sql = new StringBuffer("CREATE TABLE sys_dictionary");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		// sql.append("groupid int(10) comment '字典分组编号',");
		sql.append("name varchar(100) comment '字典名称',");
		sql.append("code varchar(100) comment '字典编号',");
		sql.append("createTime datetime comment '创建时间',");
		sql.append("createUser int(10) comment '创建者',");
		sql.append("primary key (id)");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		// 新建表
		// LoggerUtils.debug(getLogger(), "删除系统字典分组表");
		// // 新建表的SQL语句
		// sql = new StringBuffer("drop table if exists sys_dictionary_group;");
		// st = connection.prepareStatement(sql.toString());
		// st.executeUpdate();

		// LoggerUtils.debug(getLogger(), "创建系统字典分组表");
		// sql = new StringBuffer("CREATE TABLE sys_dictionary_group");
		// sql.append("(");
		// sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		// sql.append("name varchar(100) comment '字典分组名称',");
		// sql.append("code varchar(100) comment '字典分组编号',");
		// sql.append("createTime datetime comment '创建时间',");
		// sql.append("createUser int(10) comment '创建者',");
		// sql.append("primary key (id)");
		// sql.append(");");
		// // 执行SQL语句,新建表
		// st = connection.prepareStatement(sql.toString());
		// st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysLog <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysLog()
	 */
	@Override
	protected void createSysLog() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统日志表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer("drop table if exists sys_log;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统日志表");
		sql = new StringBuffer("CREATE TABLE sys_log");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		// sql.append("groupid int(10) comment '字典分组编号',");
		sql.append("content blob comment '日志内容',");
		sql.append("remark varchar(100) comment '日志描述',");
		sql.append("level int(1) comment '日志级别 级别越高数据库敏感度越高 增删改为 1级 查为2级',");
		sql.append("operation int(1) comment '日志操作类型 1 添加/更改 、2 删除、3  查询'、4 其他,");
		sql.append("createTime datetime comment '创建时间',");
		sql.append("createUser int(10) comment '创建者',");
		sql.append("primary key (id)");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：createSysRelevance <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#createSysRelevance()
	 */
	@Override
	protected void createSysRelevance() throws Exception {
		// 新建表
		LoggerUtils.debug(getLogger(), "删除系统用户-用户组关联表");
		// 新建表的SQL语句
		StringBuffer sql = new StringBuffer(
				"drop table if exists sys_user_team;");
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统用户-用户组关联表");
		sql = new StringBuffer("CREATE TABLE sys_user_team");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("userId int(10) COMMENT '系统用户编号',");
		sql.append("teamId int(10) COMMENT '系统用户组编号',");
		sql.append("level int(3) COMMENT '系统用户组内级别',");
		sql.append("primary key (id)");
		sql.append(");");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		sql = new StringBuffer("alter table sys_user_team COMMENT '用户用户组中间表';");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "删除系统用户-角色关联表");
		sql = new StringBuffer("drop table if exists sys_user_role;");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统用户-角色关联表");
		sql = new StringBuffer("CREATE TABLE sys_user_role");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("userid int(10) COMMENT '系统用户编号',");
		sql.append("roleId int(10) COMMENT '系统角色编号',");
		sql.append("primary key (id)");
		sql.append(");");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		sql = new StringBuffer("alter table sys_user_role COMMENT '用户角色中间表';");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "删除系统角色-权限关联表");
		sql = new StringBuffer("drop table if exists sys_role_permission;");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		LoggerUtils.debug(getLogger(), "创建系统角色-权限关联表");
		sql = new StringBuffer("CREATE TABLE sys_role_permission");
		sql.append("(");
		sql.append("id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',");
		sql.append("roleId int(10) COMMENT '系统角色编号',");
		sql.append("permissionId int(10) COMMENT '系统权限编号',");
		sql.append("primary key (id)");
		sql.append(");");
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();

		sql = new StringBuffer(
				"alter table sys_role_permission COMMENT '角色权限中间表';");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialData <br>
	 * 描述：TODO <br>
	 *
	 * @throws Exception
	 * @see com.jaf.web.init.AbstractInitialization#insertInitialData()
	 */
	@Override
	protected void insertInitialData() throws Exception {

		LoggerUtils.debug(getLogger(), "插入初始化数据");

		// 插入基础用户初始化数据
		insertInitialDataToSysBaseUser();

		// 插入用户初始化数据
		insertInitialDataToSysUser();

		// 插入用户组初始化数据
		insertInitialDataToSysTeam();

		// 插入用户角色初始化数据
		insertInitialDataToSysRole();

		// 插入权限初始化数据
		insertInitialDataToSysPermission();

		// 插入用户与用户组初始化数据
		insertInitialDataToSysUserTeam();

		// 插入用户与用户角色初始化数据
		insertInitialDataToSysUserRole();

		// 初始化用户角色与权限之间的关系
		insertInitialDataToSysRolePermission();
	}

	/**
	 * 方法：insertInitialDataToSysBaseUser <br>
	 * 描述：插入基本用户初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午10:55:25 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysBaseUser() throws Exception {
		LoggerUtils.debug(getLogger(), "插入基础用户初始化数据");
		StringBuffer sql = new StringBuffer("INSERT INTO sys_base_user");
		sql.append("(");
		sql.append("userName,");
		sql.append("password,");
		sql.append("status,");
		sql.append("createTime,");
		sql.append("createUser");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'admin',");
		sql.append("'" + MD5.encryption("admin") + "',");
		sql.append("1,");
		sql.append("NOW(),");
		sql.append("'0'");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	private void insertInitialDataToSysUser() throws Exception {
		LoggerUtils.debug(getLogger(), "插入用户初始化数据");
		StringBuffer sql = new StringBuffer("INSERT INTO sys_user");
		sql.append("(");
		sql.append("baseId,");
		sql.append("number,");
		sql.append("email,");
		sql.append("mobilePhone,");
		sql.append("officePhone,");
		sql.append("realName");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("1,");
		sql.append("1,");
		sql.append("'zhaozengbin@gmail.com',");
		sql.append("18911656423,");
		sql.append("18911656423,");
		sql.append("'超级管理员'");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysTeam <br>
	 * 描述：插入用户组初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午10:58:33 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysTeam() throws Exception {
		LoggerUtils.debug(getLogger(), "插入组初始化数据");
		StringBuffer sql = new StringBuffer("INSERT INTO sys_team");
		sql.append("(");
		sql.append("teamName,");
		sql.append("description,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("parentId");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'网站管理组',");
		sql.append("'网站管理组',");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("0");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysRole <br>
	 * 描述：插入用户角色初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午10:59:45 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysRole() throws Exception {
		LoggerUtils.debug(getLogger(), "插入角色初始化数据");
		StringBuffer sql = new StringBuffer("INSERT INTO sys_role");
		sql.append("(");
		sql.append("roleName,");
		sql.append("description,");
		sql.append("createTime,");
		sql.append("createUser");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'超级管理员',");
		sql.append("'超级管理员',");
		sql.append("NOW(),");
		sql.append("1");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysPermission <br>
	 * 描述：插入权限初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午11:01:27 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysPermission() throws Exception {
		LoggerUtils.debug(getLogger(), "插入权限初始化数据");
		// 初始化权限的信息
		StringBuffer sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'系统管理',");
		sql.append("'系统管理',");
		sql.append("'#',");
		sql.append("0,");
		sql.append("1,");
		sql.append("1,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("'plugin/ui/accordion/images/group_add.png',");
		sql.append("'group_add'");
		sql.append(");");
		// 执行SQL语句
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'用户管理',");
		sql.append("'用户管理',");
		sql.append("'/sysUser/toList.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("1,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("'plugin/ui/accordion/images/pictures.png',");
		sql.append("'pictures'");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'进入添加修改用户页面',");
		sql.append("'进入添加修改用户页面',");
		sql.append("'/sysUser/toSave.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("2,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("NULL,");
		sql.append("NULL");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'批量删除用户',");
		sql.append("'批量删除用户',");
		sql.append("'/sysUser/delete.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("2,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("NULL,");
		sql.append("NULL");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'用户列表',");
		sql.append("'用户列表',");
		sql.append("'/sysUser/list.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("3,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("NULL,");
		sql.append("NULL");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'添加修改用户',");
		sql.append("'添加修改用户',");
		sql.append("'/sysUser/save.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("3,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("NULL,");
		sql.append("NULL");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'删除用户',");
		sql.append("'删除用户',");
		sql.append("'/sysUser/delete.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("3,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("NULL,");
		sql.append("NULL");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();

		// 查看日志 放在权限最后
		sql = new StringBuffer("INSERT INTO sys_permission");
		sql.append("(");
		sql.append("permissionName,");
		sql.append("description,");
		sql.append("url,");
		sql.append("parentId,");
		sql.append("weight,");
		sql.append("type,");
		sql.append("createTime,");
		sql.append("createUser,");
		sql.append("icon,");
		sql.append("clazz");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'操作日志',");
		sql.append("'操作日志',");
		sql.append("'/sysLog/toList.shtml',");
		sql.append("1,");
		sql.append("1,");
		sql.append("1,");
		sql.append("NOW(),");
		sql.append("1,");
		sql.append("'plugin/ui/accordion/images/pictures.png',");
		sql.append("'pictures'");
		sql.append(");");
		// 执行SQL语句,新建表
		st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysUserTeam <br>
	 * 描述：插入用户与用户组初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午11:02:56 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysUserTeam() throws Exception {
		LoggerUtils.debug(getLogger(), "插入用户与用户组初始化数据");
		// 初始化用户与用户组之间的关系
		StringBuffer sql = new StringBuffer("INSERT INTO sys_user_team");
		sql.append("(");
		sql.append("userId,");
		sql.append("teamId,");
		sql.append("level");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("1,");
		sql.append("1,");
		sql.append("1");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysUserRole <br>
	 * 描述：插入用户与用户角色初始化数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午11:03:43 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysUserRole() throws Exception {
		LoggerUtils.debug(getLogger(), "插入用户与用户角色初始化数据");
		// 初始化用户与用户角色之间的关系
		StringBuffer sql = new StringBuffer("INSERT INTO sys_user_role");
		sql.append("(");
		sql.append("userId,");
		sql.append("roleId");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("1,");
		sql.append("1");
		sql.append(");");
		// 执行SQL语句,新建表
		PreparedStatement st = connection.prepareStatement(sql.toString());
		st.executeUpdate();
		st.close();
	}

	/**
	 * 方法：insertInitialDataToSysRolePermission <br>
	 * 描述：初始化用户角色与权限之间的关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2014-4-11 上午11:05:41 <br>
	 *
	 * @throws Exception
	 */
	private void insertInitialDataToSysRolePermission() throws Exception {
		LoggerUtils.debug(getLogger(), "初始化用户角色与权限之间的关系");
		// 初始化用户角色与权限之间的关系
		for (int permissionId = 1; permissionId <= 8; permissionId++) {
			StringBuffer sql = new StringBuffer(
					"INSERT INTO sys_role_permission");
			sql.append("(");
			sql.append("roleId,");
			sql.append("permissionId");
			sql.append(") ");
			sql.append("VALUES");
			sql.append("(");
			sql.append("1,");
			sql.append(permissionId);
			sql.append(");");
			// 执行SQL语句,新建表
			PreparedStatement st = connection.prepareStatement(sql.toString());
			st.executeUpdate();
			st.close();
		}
	}

	/**
	 * 方法：getLogger <br>
	 * 描述：TODO <br>
	 *
	 * @return
	 * @see com.jaf.web.init.AbstractInitialization#getLogger()
	 */
	@Override
	protected Logger getLogger() {
		return LoggerUtils.getLogger(InitializationByMysql.class);
	}

}
