<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<t:datagrid name="userList" title="用户管理"
	actionUrl="/sysBaseUser/list.shtml" fit="true" fitColumns="true"
	idField="id" queryMode="group" checkbox="true">
	<t:dgCol title="编号" field="id" query="true" hidden="false"></t:dgCol>
	<t:dgCol title="用户名" sortable="false" field="userName" query="true"
		width="20"></t:dgCol>
	<t:dgCol title="所属组" sortable="false" field="teamName" query="true"
		width="20"></t:dgCol>
	<t:dgCol title="所属角色" sortable="false" field="roleName" query="true"
		width="20"></t:dgCol>
	<t:dgCol title="状态" sortable="true" field="status"
		replace="正常_1,禁用_0,超级管理员_-1"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除"
		url="/sysBaseUser/delete.shtml" />
	<t:dgToolBar title="用户录入" icon="icon-add"
		url="/sysBaseUser/toSave.shtml" funname="add"></t:dgToolBar>
	<t:dgToolBar title="用户编辑" icon="icon-edit"
		url="/sysBaseUser/toSave.shtml" funname="update"></t:dgToolBar>
	<t:dgToolBar title="用户删除" icon="icon-remove"
		url="/sysBaseUser/delete.shtml" funname="delAll"></t:dgToolBar>
</t:datagrid>