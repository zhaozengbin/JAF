<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<html>
<head>
<!-- Link JScript-->
<script type="text/javascript"
	src="/theme/common/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/theme/common/js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery-jrumble.js"></script>
<script type="text/javascript" src="js/jquery.tipsy.js"></script>
<script type="text/javascript" src="js/iphone.check.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
	//判断如果当前页面不为主框架，则将主框架进行跳转
	var tagert_URL = path + "/loginController.do?login";
	if (self == top) {
		window.location.href = tagert_URL;
	} else {
		top.location.href = tagert_URL;
	}
</script>
</head>
<body>
</body>
</html>