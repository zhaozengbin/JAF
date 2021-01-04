<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
<t:base type="JQuery,Tool,Accordion,EasyUI,Validform"></t:base>

</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="userController.do?saveUser">
		<input id="id" name="id" type="hidden" value="${data.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" width="15%" nowrap>
					<label class="Validform_label"> 用户名: </label>
				</td>
				<td class="value" width="85%">
					<c:if test="${data.id!=null }">
     					${data.userName }
     						</c:if> 
     				<c:if test="${data.id==null }">
						<input id="userName" class="inputxt" name="userName"
							ajaxurl="userController.do?checkUser&code=${data.userName }"
							value="${data.userName }" datatype="s2-10" />
						<span class="Validform_checktip">用户名范围在2~10位字符</span>
					</c:if></td>
			</tr>
			<c:if test="${data.id==null }">
				<tr>
					<td align="right"><label class="Validform_label"> 密码:
					</label></td>
					<td class="value"><input type="password" class="inputxt"
						value="" name="password" plugin="passwordStrength"
						datatype="*6-18" errormsg="" /> <span class="passwordStrength"
						style="display: none;"><span>弱</span><span>中</span><span
							class="last">强</span> </span> <span class="Validform_checktip">密码至少6个字符,最多18个字符</span>
					</td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label">
							重复密码: </label></td>
					<td class="value"><input id="repassword" class="inputxt"
						type="password" value="${data.password}" recheck="password"
						datatype="*6-18" errormsg="两次输入的密码不一致！"> <span
						class="Validform_checktip">重复个人密码</span></td>
				</tr>
			</c:if>
			<tr>
				<td align="right"><label class="Validform_label">用户组: </label>
				</td>
				<td class="value"><select id="teamId" name="teamId"
					datatype="*">
						<c:forEach items="${data.sysTeamVoList}" var="team">
							<option value="${team.id }"
								<c:if test="${team.selected==true}">selected="selected"</c:if>>
								${team.name}</option>
						</c:forEach>
				</select> <span class="Validform_checktip">请选择用户组</span></td>
			</tr>
			<tr>
				<td align="right" nowrap><label class="Validform_label">
						手机号码: </label></td>
				<td class="value">
					<!-- update-begin--Author:chenxu  Date:20130318 for：手机号无法保存和修改  -->
					<input class="inputxt" name="mobilePhone"
					value="${data.mobilePhone}" datatype="m" errormsg="手机号码不正确!"
					ignore="ignore"> <!-- update-end--Author:chenxu  Date:20130318 for：手机号无法保存和修改  -->
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 办公电话:
				</label></td>
				<td class="value"><input class="inputxt" name="officePhone"
					value="${data.officePhone}" datatype="n" errormsg="办公室电话不正确!"
					ignore="ignore"> <span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 常用邮箱:
				</label></td>
				<td class="value"><input class="inputxt" name="email"
					value="${data.email}" datatype="e" errormsg="邮箱格式不正确!"
					ignore="ignore"> <span class="Validform_checktip"></span></td>
			</tr>
		</table>
	</t:formvalid>
</body>