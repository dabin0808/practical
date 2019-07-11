<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- js倒计时 刷新跳转页面 -->

<span id="remainSeconds">3</span>

<script type="text/javascript">
var sec =6;
    window.onload=function(){
    	 
    	jump();
    }
    
    function jump(){
        sec--;
        if(sec > 0){
            document.getElementById('remainSeconds').innerHTML = sec;
            
            setTimeout(this.jump,1000);
            
        }else{
        	//跳转页面
            window.location.href = 'msg.jsp';
        }
    }
    setTimeout(jump,1000);
</script>

<div align="center"><img src="${pageContext.request.contextPath }/images/pay.jpg"></div>

</body>
</html>