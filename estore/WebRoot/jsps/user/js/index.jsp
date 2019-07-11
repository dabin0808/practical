<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JavaScript  -->

	<script type="text/javascript" scr="Myjs.js"></script>

	<script type="text/javascript">
		function checkName() {
			//
			var username = document.getElementsByTagName("input")[0];
			// 1,获取xmlHttpRequest
			var req = getXMLHttpRequest();
			// 2,
			req.onreadystatechange = function() {
				if (req.readyState == 4) {
					if (req.status == 200) {
						var msg = document.getElementById("msg");
						if (req.responseText == "true") {
							//msg.innerHTML = "用户名已经存在";
							msg.innerHTML = "<font color='red'>用户已经存在</font>";
						} else {
							//msg.innerHTML = "可以使用";
							msg.innerHTML = "<font color='green'>可以使用</font>";
						}
					}
				}
			}
			// 3, 发送一个请求
			req.open("post",
					"${pageContext.request.contextPath}/CheckName?username="
							+ username.value);
			req.send(null);
		}
	</script>

	用户名：
	<input type="text" name="username" onblur="checkName()" />
	<span id="msg"></span>
	<br />密码：
	<input type="password" name="password" />
</body>
</html>