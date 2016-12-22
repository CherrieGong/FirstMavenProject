<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-mobile/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-mobile/my-mobile.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery-mobile/jquery.mobile-1.4.5.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/register.js"
	type="text/javascript" charset="utf-8"></script>

<title>Welcome to register...</title>
</head>

<body>
	<div data-role="page" id="register_page">
		<div data-role="header">
			<h1>图书借阅系统注册</h1>
			<h2>eHealthChina.Inc</h2>
		</div>
		<div data-role="content">
			<div>
				<form id="fregister" class="reg">
					<table>
						<tbody>
							<tr>
								<td><label for="userName">用户名：</label></td>
								<td><input type="text" name="userName" id="userName"
									placeholder="请输入您的真实姓名..." onblur="checkRegisterName()"></td>
								<td><span id="tip_name" value="n">*</span></td>
							</tr>
							<tr>
								<td><label for="passWord">密码：</label></td>
								<td><input type="text" type="password" name="passWord"
									id="passWord" onblur="checkRegisterPSW()"></td>
								<td><span id="tip_PSW" value="n">*</span></td>
							</tr>

							<tr>
								<td><label for="check_password">密码确认：</label></td>
								<td><input type="text" name="check_password"
									id="check_password" type="password" onblur="check()"></td>
								<td><span id="tip" value="n">*</span></td>
							</tr>

							<tr>
								<td><label for="telephone">电话：</label></td>
								<td><input type="text" name="telephone" id="telephone"
									onblur="isMobilePhone(this.value)"></td>
								<td><span id="tip_phone" value="n">*</span></td>
							</tr>
							<tr>
								<td><label for="email">电邮：</label></td>
								<td><input type="email" name="email" id="email"
									placeholder="您的邮箱地址..." onblur="email_check()"></td>
								<td><span id="tip_" value="n">*</span></td>
							</tr>
							<tr>
								<td><input type="button" onclick="register()"
									data-inline="true" value="提交" id="sub"></td>
								<td><a href="#" onclick="cancle()" data-role="button"
									data-inline="true">取消</a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div data-role="footer">联系我们</div>
	</div>
</body>
</html>