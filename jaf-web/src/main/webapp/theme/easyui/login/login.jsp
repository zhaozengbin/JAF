<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/theme/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>JAF 演示系统</title>
<link rel="shortcut icon" href="favicon.ico">
<!--[if lt IE 9]>
   <script src="js/html5.js"></script>
  <![endif]-->
<!--[if lt IE 7]>
  <script src="js/iepng.js" type="text/javascript"></script>
  <script type="text/javascript">
	EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
</script>
  <![endif]-->
<link href="<%=path%>/theme/easyui/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/theme/easyui/css/buttons.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/theme/easyui/css/icon.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/theme/easyui/css/tipsy.css" rel="stylesheet"
	type="text/css" media="all" />
<style type="text/css">
html {
	background-image: none;
}

label.iPhoneCheckLabelOn span {
	padding-left: 0px
}

#versionBar {
	background-color: #212121;
	position: fixed;
	width: 100%;
	height: 35px;
	bottom: 0;
	left: 0;
	text-align: center;
	line-height: 35px;
	z-index: 11;
	-webkit-box-shadow: black 0px 10px 10px -10px inset;
	-moz-box-shadow: black 0px 10px 10px -10px inset;
	box-shadow: black 0px 10px 10px -10px inset;
}

.copyright {
	text-align: center;
	font-size: 10px;
	color: #CCC;
}

.copyright a {
	color: #A31F1A;
	text-decoration: none
}

/*update-begin--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
.on_off_checkbox {
	width: 0px;
}
/*update-end--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
#login .logo {
	width: 500px;
	height: 51px;
}
</style>
</head>
<body>
	<div id="alertMessage"></div>
	<div id="successLogin"></div>
	<div class="text_success">
		<img src="<%=path%>/theme/easyui/images/loader_green.gif"
			alt="Please wait" /> <span>登陆成功!请稍后....</span>
	</div>
	<div id="login">
		<div class="ribbon"
			style="background-image: url(<%=path%>/theme/easyui/images/typelogin.png);"></div>
		<div class="inner">
			<div class="logo">
				<img src="<%=path%>/theme/easyui/images/toplogo-jeecg.png" />
			</div>
			<div class="formLogin">
				<form name="formLogin" id="formLogin"
					action="<%=path%>/security/login.shtml"
					check="<%=path%>/security/checkUser.shtml" method="post">
					<div class="tip">
						<input class="userName" name="userName" type="text"
							id="userName" title="用户名" iscookie="true" value="admin"
							nullmsg="请输入用户名!" />
					</div>
					<div class="tip">
						<input class="password" name="password" type="password"
							id="password" title="密码" value="admin" nullmsg="请输入密码!" />
					</div>
					<div class="loginButton">
						<div style="float: left; margin-left: -9px;">
							<input type="checkbox" id="on_off" name="remember" checked="ture"
								class="on_off_checkbox" value="0" /> <span class="f_help">是否记住用户名
								?</span>
						</div>
						<!--  <div style="float: left; margin-left: 25px;" class="QapTcha"></div> -->
						<div style="float: right; padding: 3px 0; margin-right: -12px;">
							<div>
								<ul class="uibutton-group">
									<li><a class="uibutton normal" href="#" id="but_login"
										name="submit">登陆</a></li>
									<li><a class="uibutton normal" href="#" id="forgetpass">重置</a>
									</li>
								</ul>
								<!--  <img src="<%=path%>/jcaptcha" width="100px" height="30px">
								<input type='text' name='j_captcha_response' value='' size="10">-->
							</div>
							<div style="float: left; margin-left: 30px;">
								<a href="loginController.do?goPwdInit"><span class="f_help">是否初始化admin的密码</span></a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
		<div class="shadow"></div>
	</div>
	<!--Login div-->
	<div class="clear"></div>
	<div id="versionBar">
		<div class="copyright">
			&copy; 版权所有 <span class="tip"><a href="#" title="JAF 新版演示系统">jeecg</a>
				(推荐使用IE8+,谷歌浏览器可以获得更快,更安全的页面响应速度)技术支持:<a href="#" title="JAF 新版演示系统">JAF</a></span>
		</div>
	</div>
	<!-- Link JScript-->
	<t:base type="JQuery,JQueryUI,QapTcha"></t:base>
	<script type="text/javascript"
		src="<%=path%>/theme/easyui/js/iphone.check.js"></script>
	<script type="text/javascript" src="<%=path%>/theme/easyui/js/login.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.QapTcha').QapTcha({
				disabledSubmit : false,
				autoRevert : true,
				autoSubmit : false
			});
		});
	</script>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-9271946-9' ]);
		_gaq.push([ '_setDomainName', 'myjqueryplugins.com' ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>