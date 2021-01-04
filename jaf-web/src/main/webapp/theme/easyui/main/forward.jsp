<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/taglib.jsp"%>
<html>
    <!-- Link JScript-->
	  <script type="text/javascript">
	  //判断如果当前页面不为主框架，则将主框架进行跳转
	  	var tagert_URL = "<%=path%>/security/toLogin.shtml";
	    if(self==top){
	    	window.location.href = tagert_URL;
	    }else{
	    	top.location.href = tagert_URL;
	    }
	  </script>
</html>