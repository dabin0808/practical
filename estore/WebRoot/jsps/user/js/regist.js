/**
 * 注册 用户名，密码，手机号码验证
 */

/*
 * var xmlhttp; var flag;
 */
/*
 * 创建XMLHttpRequest
 */
/*
 * function creat() { if (window.XMLHttpRequest) {// code for IE7+, Firefox,
 * Chrome, Opera, Safari xmlhttp = new XMLHttpRequest(); } else {// code for
 * IE6, IE5 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); } }
 */
/*
 * 查找手机号码的
 */
function checkName(userid) {
	console.log(userid);
	// // 创建xmlHttp
	// creat();
	var pspan = document.getElementById("msg"); // 返回信息的变量
	//	 	
	/*
	 * 判断是否为空符号 if (userid == null || userid.trim().length == 0) {
	 * pspan.style.color = "red"; pspan.innerHTML = "字符不能为空"; flag = false; }
	 * else if(userid.length>50){ pspan.style.color = "red"; pspan.innerHTML =
	 * "字符过长"; flag = false; }
	 */

	// //
	//
	// // 设置回调请求
	// xmlhttp.open("POST", "VerifyUserId?userid="+userid);
	// // 请求之后处理回调函数
	// xmlhttp.oneradystatechange = checkUseridCallback;
	// //
	// xmlhttp.send(null);
	if (userid == null || userid.trim().length == 0) {
		pspan.style.color = "red";
		pspan.innerHTML = "字符不能为空";
		flag = false;

	} else if (userid.length > 20) {
		pspan.style.color = "red";
		pspan.innerHTML = "字符过长";
		flag = false;

	} else {
		$.ajax({
			url : "/estore/VerifyUserId",
			type : "post",
			data : "userid=" + userid,
			dataType : "html",
			success : function(tip) {

				msg.innerHTML = tip;
				msg.style.color = "red";
				console.log("成功了,输出：" + tip);
				flag = true;
			},
			error : function() {
				msg.innerHTML = tip;
				msg.style.color = "red";
				console.log("失败了");
				flag = false;
			},
		});

	}
}

// 检查Email是否存在
function checkEmail(email) {

	$.ajax({
		url : "/estore/VerifyUserId",
		type : "post",
		data : "userid=" + userid,
		dataType : "html",
		success : function(tip) {

			msg.innerHTML = tip;
			msg.style.color = "red";
			console.log("成功了,输出：" + tip);
			flag = true;
		},
		error : function() {
			console.log("失败了");
			flag = false;
		},
	});
}

/*
 * 返回给表单
 */
function checkForm() {
	return flag;
}

/*
 * function checkPhone() { var isPhone = false; //根据id得到 input标签 var pinput =
 * document.getElementById("new_phone"); var pspan =
 * document.getElementById("phonemsg"); // pinput的value值 var strPhone =
 * pinput.value;
 * 
 * if (strPhone == null || strPhone.trim().length == 0) { pspan.style.color =
 * "red"; pspan.innerHTML = "手机号不能为空"; isPhone = false; } else {
 * //对内容进行判断：是否符合手机号码的格式 11 正则表达式 ：手机号 var reg = new RegExp("^1[0-9]{10}$"); if
 * (!reg.test(strPhone)) { pspan.style.color = "red"; pspan.innerHTML =
 * "手机号不符合格式"; isPhone = false; } else pspan.innerHTML = "手机号符合格式"; } } function
 * checkName() { var isName = false; var ninput =
 * document.getElementById("userName"); var nspan =
 * document.getElementById("namemsg");
 * 
 * var str = ninput;
 * 
 * if (str == null || str.trim().length == 0) { nspan.style.color = "red";
 * nspan.innerHTML = "用户名不能为空"; isName = false; } else { if (str.trim().length <
 * 3) { nspan.style.color = "red"; nspan.innerHTML = "用户名少于三位"; isName = false; }
 * else { if (str.trim().length > 8) { nspan.style.color = "red";
 * nspan.innerHTML = "用户名超过八位"; isName = false; } else nspan.innerHTML =
 * "用户名格式正确"; } } }
 */