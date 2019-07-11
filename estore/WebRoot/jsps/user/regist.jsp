
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript" src="/estore/jsps/user/js/jquery.min.js"></script>
</head>

<body>

	<div class="container">

		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<!-- Start Sign In Form -->
				<form action="${ pageContext.request.contextPath }/UserServlet"
					method="post" onsubmit="return cheackForm()"
					class="fh5co-form animate-box" data-animate-effect="fadeIn">
					<h2>注 册</h2>
					<!-- 隐藏域 返回regist -->
					<input type="hidden" name="method" value="registUser" />

					<div class="form-group">
						<div class="alert alert-success" role="alert">输入你的注册信息</div>
					</div>

					<div class="form-group">
						<label for="name" class="sr-only">Name</label> <input type="text"
							class="form-control" id="username" name="username"
							onblur="checkName(this.value)" placeholder="Input Name"
							autocomplete="off"> <span id="msg"></span>
					</div>

					<div class="form-group">
						<label for="email" class="sr-only">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Email" autocomplete="off">
					</div>

					<div class="form-group">
						<label for="password" class="sr-only">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="Password" autocomplete="off">
					</div>



					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember">
							Remember Me</label>
					</div>

					<div class="form-group">
						<p>
							Already registered? <a href="login.jsp">登 录</a>
						</p>
					</div>
					<div class="form-group">
						<input type="submit" value="注  册" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center">
				<p>
					<small>&copy;Jump to the homepage of the website <a
						href="<c:url value='/jsps/main.jsp'/>" target="_top" title="网站首页">网站首页</a>
						- Collect from <a href="<c:url value='/jsps/main.jsp'/>"
						target="_top">知识书店</a></small>
				</p>
			</div>
		</div>
	</div>


	<script src="js/regist.js" type="application/javascript"></script>

</body>
</html>
