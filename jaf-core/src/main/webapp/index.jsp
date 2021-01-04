<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tags.jsp"%>
<head>
<eu:base type="JQuery,EasyUI,Tool,lhgDialog,WdatePicker"></eu:base>
</head>
<eu:datagrid name="userList" title="用户管理" actionUrl="TestServlet?datagrid"
	fit="true" fitColumns="true" idField="id" queryMode="group"
	checkbox="true">
	<eu:dgCol title="编号" field="id" query="true" hidden="false"></eu:dgCol>
	<eu:dgCol title="用户名" sortable="false" field="userName" query="true"
		width="20"></eu:dgCol>
	<eu:dgCol title="部门" field="TSDepart_departname" query="true"
		queryMode="single" replace="${departsReplace}"></eu:dgCol>
	<eu:dgCol title="真实姓名" field="realName" query="true"></eu:dgCol>
	<eu:dgCol title="状态" sortable="true" field="status"
		replace="正常_1,禁用_0,超级管理员_-1"></eu:dgCol>
	<eu:dgCol title="操作" field="opt" width="100"></eu:dgCol>
	<eu:dgButtonOpt type="Del" title="删除"
		url="userController.do?del&id={id}&userName={userName}" message="" />
	<eu:dgToolBar title="用户录入" icon="icon-add"
		url="userController.do?addorupdate" funname="add"></eu:dgToolBar>
	<eu:dgToolBar title="用户编辑" icon="icon-edit"
		url="userController.do?addorupdate" funname="update"></eu:dgToolBar>
	<eu:dgToolBar title="用户删除" icon="icon-remove"
		url="userController.do?delAll" funname="delAll"></eu:dgToolBar>
</eu:datagrid>
