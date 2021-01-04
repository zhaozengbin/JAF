<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<t:datagrid name="sysLogList" title="操作日志"
	actionUrl="/sysLog/list.shtml" fit="true" fitColumns="true"
	idField="id" queryMode="group" checkbox="true">
	<t:dgCol title="编号" field="id" query="true" hidden="false"></t:dgCol>
	<t:dgCol title="操作者" sortable="false" field="createUserName"
		query="true" width="20"></t:dgCol>
	<t:dgCol title="操作时间" sortable="false" field="createTime" query="false"
		width="20"></t:dgCol>
	<t:dgCol title="操作描述" sortable="false" field="remark" query="true"
		width="20"></t:dgCol>
	<t:dgCol title="操作类型" sortable="false" field="operation" query="false"
		width="20" replace="${logOperation}" queryMode="single"></t:dgCol>
	<t:dgCol title="操作级别" sortable="false" field="level" query="false"
		width="20" replace="${logLevel}" queryMode="single"></t:dgCol>
</t:datagrid>
<script>
	
</script>