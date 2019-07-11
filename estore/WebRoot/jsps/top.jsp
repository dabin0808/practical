<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>

<base target="body"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background: #4682B4;
}

a {
	text-transform: none;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<h1 style="text-align: center; font-size: 30pt;">知识书店</h1>
	<div style="font-size: 10pt;" align="center">
		<!-- 判断是否登录，即exisUser里面是否存 -->
		<c:if test="${not empty exisUser }"> 
		
				你好，${exisUser.username}&nbsp;&nbsp;&nbsp;	
				<a href="<c:url value='/jsps/cart/list.jsp' />" targer="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				
				<!-- 查询当前用户的订单 -->
				<a href="${pageContext.request.contextPath }/OrderServlet?method=findUid" targer="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				
				 <a href="${pageContext.request.contextPath }/UserServlet?method=exit" target="_parent">退出</a> 

		 </c:if>

		<c:if test="${empty  exisUser}">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a>
			<a href="<c:url value = '/jsps/user/regist.jsp'/>" target="_parent">注册</a>
		</c:if>
			</br>
		
	</div>
	<form action="${ pageContext.request.contextPath }/BookServlet?method=search" method="post" >
	<input type="text" id="sInput" name="sInput" placeholder="请输入内容...">  
	<button type="submit" value="提交" >搜索</button>
	</form>
</body>
</html>
