<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>
    
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
	* {
		font-size: 11pt;
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
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>购物车</h1>

	<!-- 没有购物项 -->
<c:if test="${ fn:length(cart.cartItems) eq 0}">
	<h2>亲，您的购物车为空</h2>
	<img alt="" src="${pageContext.request.contextPath }/images/cart.png" width="130" height="150" border="0"/>
</c:if>

	<!-- 购物项输出 -->
<c:if test="${ fn:length(cart.cartItems) ne 0}">
<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="${pageContext.request.contextPath }/CartServlet?method=clearCart">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
	
	<!-- 循环输出购物车列表 -->
	<c:forEach var="cartItem" items="${cart.cartItems }">
	<tr>
		<td><div><img src="${pageContext.request.contextPath }/${cartItem.book.image}" width="130" height="150" border="0"/></div></td>
		<td>${cartItem.book.bname}</td>
		<td>${cartItem.book.author}</td>
		<td>${cartItem.book.price}</td>
		<td>${cartItem.count}</td>
		<td>${cartItem.subtotal}</td>
		<td><a href="${pageContext.request.contextPath }/CartServlet?method=removeCart&bid=${cartItem.book.bid}">删除</a></td>
	</tr>
	</c:forEach>


		<!-- 总计  -->
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计："${cart.total}"元
		</td>
	</tr>
	<tr>
		<!-- 购物车中的一键购买，跳转创建当前订单 , 清空购物车 -->
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="${pageContext.request.contextPath }/OrderServlet?method=addOrder"></a>
		</td>
	</tr>
</table>
</c:if>
  </body>
</html>