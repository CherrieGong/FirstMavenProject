/**
 * 在输入用户名以后，失去焦点执行checkName(),实现功能如下： 1、如果没有输入，提示“用户名不能为空”
 * 2、如果输入为“name_text”,用ajax提交输入的“name_text”给控制层“/mc/mclogin/checkRegister”进行处理
 * 返回一个字符串类型的提示信息 3、将返回的提示信息输出到jsp页面
 */
// 判断登录页面输入的用户名是否存在
function checkUser() {
	if (($("#userName").val()).length == 0
			|| ($("#passWord").val()).length == 0) {
		$("#txtHint").html("<font color = 'red'>用户名或密码不能为空,请确认...</font>");
	} else {
		$("#txtHint").html("");
		$
				.ajax({
					type : "post",
					url : "http://localhost:8888/mc/mclogin/checkUser",
					data : {
						userName : $("#userName").val(),
						passWord : $("#passWord").val(),
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							if ($("#userName").val() == "yf") {
								window.location.href = "http://localhost:8888/mc/jsp/adminHomePage.jsp";
							} else {
								window.location.href = "http://localhost:8888/mc/jsp/userHomePage.jsp";
							}
						} else {
							$("#txtHint").html(
									"<font color = 'red'>" + data.msg
											+ "</font>");
						}
					},
					error : function(data) {
						$("#txtHint").html(
								"<font color = 'red'>" + data.msg + "</font>");
					}
				});
	}
}

function goToRegist() {
	window.location.href = "http://localhost:8888/mc/jsp/register.jsp";
}