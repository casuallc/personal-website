$(function() {
	$("#username").prop("disabled", false).val("").focus();
	
	loadUser();
	
	$("#username").keydown(function(event) {
		if(event.keyCode != 13) {
			return;
		}
		nameDone(this);
	});
	
	
});

function nameDone(obj) {
	var username = $(obj).val();
	if(isEmpty(username)) {
		alert("enter your name");
		return;
	}
	$(".login-user").text("当前操作员：" + username);
	$(obj).prop("disabled", true);
	var html = '';
	html += '<div>输入密码</div>';
	html += '<div class="login-input-focus"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span><input type="password" id="password" class="login-input"></div>';
	$(".login-operate").append(html);
	$("#password").focus();
	pwdBindKeydown();
}

function pwdBindKeydown() {
	$("#password").keydown(function(event) {
		if(event.keyCode != 13) {
			return;
		}
		var password = $(this).val();
		if(REGISTED) {
			login($("#username").val(), password);
		} else {
			registe($("#username").val(), password);
		}
		
	});
}

function login(username, password) {
	var url = PATH + "/user/login.htm";
	var params = new Object();
	params.username = username;
	params.password = password;
	$.getJSON(url, params, function(data) {
//		if(data.code == "0000") {
//			alert("success");
//		} else if(data.code == "0002") {
//			alert("用户名不存在");
//		} else if(data.code == "0003") {
//			alert("用户名密码不匹配");
//		} else {
//			alert(data.msg);
//		}
		$("#loginA").click();
	});
}

function registe(username, password) {
	var url = PATH + "/user/registe.htm";
	var params = new Object();
	params.username = username;
	params.password = password;
	$.getJSON(url, params, function(data) {
//		if(data.code == "0000") {
//			alert("success");
//		} else if(data.code == "0002") {
//			alert("用户名已经存在");
//		} else {
//			alert(data.msg);
//		}
		$("#loginA").click();
	});
}

var REGISTED = false;

function loadUser() {
	var url = PATH + "/user/loadUser.htm";
	$.getJSON(url, "", function(data) {
		if(data.code == "0000") {
			$("#username").val(data.obj.username);
			REGISTED = true;
			nameDone($("#username"));
		}
	});
}
