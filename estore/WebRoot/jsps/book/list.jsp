<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
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
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>
  
  <!-- 循环输出一个类型的所有书籍 -->
  		<!-- 从Bookservlet 跳转入 当点击图片，或者文字再跳转desc.jsp(单个图书详情) -->
	<c:forEach var="book" items="${booklist }">
	  <div class="icon">
	    <a href="${pageContext.request.contextPath }/BookServlet?method=findBid&bid=${book.bid}"><img src="${pageContext.request.contextPath }/${ book.image}" width="130" height="150" border="0"/></a>
	      <br/>
	   	<a href="${pageContext.request.contextPath }/BookServlet?method=findBid&bid=${book.bid}">${book.bname}</a>
	  </div>
	</c:forEach>
  
  </body>
 
</html>

