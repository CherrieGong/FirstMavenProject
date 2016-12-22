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
<script src="${pageContext.request.contextPath}/js/index.js"
	type="text/javascript" charset="utf-8"></script>
<title>MC</title>
</head>
<body>
	<div data-role="page" id="login_page">
		<div data-role="header">
			<h1>eHealth.Inc</h1>
		</div>
		<div data-role="content" class="T1">
			<table>
				<tbody>
					<tr>
						<td>
							<h3>Medicare Library</h3>
						</td>
					</tr>
					<tr>
						<td>
							<form id="fuser">
								<div>
									<table>
										<tbody>
											<tr>
												<td><label>用户名：</label></td>
												<td><input id="userName" type="text" name="userName"
													placeholder="您的用户名..."></td>
												<!--  <td><form>
														<fieldset data-role="fieldcontain">
															<label for="auth">选择权限</label> <select name="auth"
																id="auth" data-native-menu="false">
																<option value="user">用户</option>
																<option value="admin">管理员</option>
															</select>
														</fieldset>
													</form></td> -->
											</tr>
										</tbody>
									</table>
								</div>
								<div>
									<table>
										<tbody>
											<tr>
												<td><label>密&nbsp;&nbsp;&nbsp;码：</label></td>
												<td><input id="passWord" type="password"
													name="passWord" placeholder="您的密码..."></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div>
									<table>
										<tr>
											<td>&nbsp;&nbsp;</td>
											<td><a id="sub" data-role="button"
												onclick="checkUser();">登录</a></td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td><button type="reset">重置</button></td>
										</tr>
									</table>
								</div>
								<div id="txtHint"></div>
								<a href="#" onclick="goToRegist()"
									data-role="button">新用户注册</a>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div data-role="footer"></div>
	</div>
</body>
</html>