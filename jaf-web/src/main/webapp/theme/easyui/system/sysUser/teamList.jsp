<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>管理组集合</title>
<t:base type="JQuery,Tool,Accordion,EasyUI,Validform"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:datagrid name="teamList" title="按用户组选择"
		actionUrl="/sysUser/teamList.shtml" idField="id" checkbox="true"
		showRefresh="false">
		<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
		<t:dgCol title="管理组名称" field="teamName" width="50"></t:dgCol>
	</t:datagrid>
</body>
</html>