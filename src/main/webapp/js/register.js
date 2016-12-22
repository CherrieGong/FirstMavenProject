//判断注册页面输入的用户名是否已经被注册
function checkRegisterName() {
	$.ajax({
		type : "post",
		url : "http://localhost:8888/mc/mclogin/checkRegisterName",
		data : {
			userName : $("#userName").val(),
		},
		dataType : "json",
		success : function(data) {
			if (data.success) {
				$("#tip_").value = "y";
				$("#tip_name").html(
						"<font color='green'>" + data.msg + "</font>");
			} else {
				$("#tip_name")
						.html("<font color='red'>" + data.msg + "</font>");
			}
		},
		error : function(data) {
			$("#tip_name").html("<font color='red'>" + data.msg + "</font>");
		},
	});
}

// 验证第一次输入的密码是否为空
function checkRegisterPSW() {
	var p = $("#passWord").val();
	if (p == "" || p.length == 0) {
		$("#tip_PSW").html("<font color='red'>密码不能为空，请输入...</font>");
	} else {
		$("#tip_").value = "y";
		$("#tip_PSW").html("<font color='green'>ok</font>");
	}
}

// 验证第二次输入的密码和第一次是否一致
function check() {
	var pw1 = $("#passWord").val();
	var pw2 = $("#check_password").val();
	// var pw2 = document.getElementById("check_password");
	if (pw1 == pw2) {
		$("#tip_").value = "y";
		document.getElementById("tip").innerHTML = "<font color='green'>ok</font>";
		document.getElementById("sub").disabled = false;
	} else {
		document.getElementById("tip").innerHTML = "<font color='red'>两次密码不相同</font>";
		document.getElementById("sub").disabled = true;
	}
}

// 判断手机号码格式是否正确
function isMobilePhone(phone) {
	var partten = /^1[0-9]{10}$/;
	if (partten.test(phone)) {
		$("#tip_").value = "y";
		$("#tip_phone").html("<font color='green'>ok</font>");
	} else {
		$("#tip_phone").html("<font color='red'>手机格式不正确，请重新输入...</font>");
	}
}

// 提交正确的注册信息表单
function register() {
	if ($("#tip_name").value == "y" && $("#tip_PSW").value == "y"
			&& $("#tip").value == "y" && $("#tip_phone").value == "y"
			&& $("#tip_").value == "y") {
		$.ajax({
			type : "post",
			url : "http://localhost:8888/mc/mclogin/addRegister",
			data : {
				userName : $("#userName").val(),
				passWord : $("#passWord").val(),
				telephone : $("#telephone").val(),
				email : $("#email").val(),
			},
			dataType : "json",
			success : function(data) {

				alert(data.msg);
				window.location.href = "http://localhost:8888/mc/index.jsp";
			},
			error : function(data) {
				alert(data.msg);
			},
		});
	} else {
		alert("信息尚未正确填写...");
	}

}

function email_check() {
	if ($("#email").val() == "") {
		$("#tip_").html("<font color='red'>邮箱地址不能为空！</font>");
		return false;
	}
	var email = $("#email").val();
	if (!email
			.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
		$("#tip_").html("<font color='red'>邮箱格式不正确！请重新输入</font>");
	} else {
		$("#tip_").value = "y";
		$("#tip_").html("<font color='green'>ok</font>");
	}
}

function cancle() {
	window.location.href = "http://localhost:8888/mc"
}
