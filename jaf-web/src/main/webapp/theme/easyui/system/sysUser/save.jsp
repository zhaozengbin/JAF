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
		layout="table" action="/sysUser/save.shtml">
		<input id="id" name="id" type="hidden" value="${data.id }">
		<input id="baseId" name="baseId" type="hidden" value="${data.baseId }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" width="15%" nowrap><label
					class="Validform_label"> 用户名: </label></td>
				<td class="value" width="85%"><c:if test="${data.id!=null }">
     					${data.userName }
     						</c:if> <c:if test="${data.id==null }">
						<input id="userName" class="inputxt" name="userName"
							ajaxurl="<%=basePath %>sysUser/checkUser.shtml"
							value="${data.userName }" datatype="s2-10" />
						<span class="Validform_checktip">用户名范围在2~10位字符</span>
					</c:if></td>
			</tr>
			<tr>
				<td align="right" width="15%" nowrap><label
					class="Validform_label"> 用户昵称: </label></td>
				<td class="value" width="85%"><input id="realName"
					class="inputxt" name="realName" value="${data.realName }"
					datatype="s4-10" /> <span class="Validform_checktip">用户昵称范围在4~10位字符</span></td>
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
				<td class="value"><input name="teamId" type="hidden"
					value="${data.teamId}" id="teamId"> <input name="teamName"
					class="inputxt" value="${data.teamName}" id="teamName"
					readonly="readonly" datatype="*" /> <t:choose hiddenName="teamId"
						hiddenid="id" url="/sysUser/toTeamList.shtml" name="teamList"
						icon="icon-choose" title="用户组列表" textname="teamName"
						isclear="true"></t:choose> <span class="Validform_checktip">可多选</span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">角色: </label></td>
				<td class="value"><input name="roleId" type="hidden"
					value="${data.roleId}" id="roleId"> <input name="roleName"
					class="inputxt" value="${data.roleName}" id="roleName"
					readonly="readonly" datatype="*" /> <t:choose hiddenName="roleId"
						hiddenid="id" url="/sysUser/toRoleList.shtml" name="roleList"
						icon="icon-choose" title="角色列表" textname="roleName" isclear="true"></t:choose>
					<span class="Validform_checktip">可多选</span></td>
			</tr>
			<tr>
				<td align="right" nowrap><label class="Validform_label">
						手机号码: </label></td>
				<td class="value"><input class="inputxt" name="mobilePhone"
					value="${data.mobilePhone}" datatype="m" errormsg="手机号码不正确!"
					ignore="ignore"> <span class="Validform_checktip"></span></td>
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