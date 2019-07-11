<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书详细</title>
    
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
		font-size: 10pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	a {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -70px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	a:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -106px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
 			 <!-- 单个图书详情  -->
  <body>
  <div>
    <img src="${pageContext.request.contextPath }/${book.image }"  width="130" height="150" border="0"/>
  </div>
  <ul>
    <li>书名：${book.bname }</li>
    <li>作者：${book.author }</li>
    <li>单价：${book.price }</li>
    
  </ul>
  
  	<!-- 添加购物车，通过隐藏域传递方法和 -->
  <form id="form" action="${pageContext.request.contextPath }/CartServlet" method="post">
	  		<!-- method的隐藏域 -->
	  	<input type ="hidden" name="method" value="addCart"> 
	  		<!-- 图书主键的隐藏域 -->
	  	<input type ="hidden" name="bookId" value="${book.bid }"> 
	  		<!-- 图书count -->
  	<input type="text" size="3" name="count" value="1"/>
  </form>
  
  <!-- 点击，提交form表单 -->
  <a href="javascript:document.getElementById('form').submit();"></a>
  </body>
</html>
