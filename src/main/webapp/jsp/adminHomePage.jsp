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
<script src="${pageContext.request.contextPath}/js/adminHomePage.js"
	type="text/javascript" charset="utf-8">
	
</script>
<title>EHTH Library</title>
</head>
<body>
	<div data-role="page">
		<div data-role="header" data-position="fixed" data-fullscreen="true">
			<h1>EHTH Library</h1>

			<a href="#" data-rel="dialog" data-icon="search">搜索</a> <a
				href="javascript:window.close();" data-icon="back" onclick="logout()">退出</a>

		</div>

		<div data-role="content">
			<br> <br>
			<hr>
			<p>Admin Welcome!</p>
			<div data-role="controlgroup" data-type="vertical" data-inline="true">
				<p>
					<strong>功能选项</strong>
				</p>
				<div>
					<form id=faddBook>
						<fieldset data-role="collapsible">
							<legend>增加新的图书</legend>
							<label for="registrationNumber">总登记号：</label><input type="text"
								name="registrationNumber" id="registrationNumber"> <label
								for="title">书名：</label> <input type="text" name="title"
								id="title"> <label for="author">作者：</label><input
								type="text" name="author" id="author"> <label
								for="publishingCompany">出版社：</label><input type="text"
								name="publishingCompany" id="publishingCompany"> <label
								for="category">图书类别：</label><input type="text" name="category"
								id="category"> <label for="publishingDate">出版日期：</label><input
								type="date" name="publishingDate" id="publishingDate"> <label
								for="notes">备注：</label> <input type="text" name="notes"
								id="notes">
							<div>
								<table>
									<tr>
										<td>&nbsp;&nbsp;</td>
										<td><button id=add onclick="addBook();">提交</button></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td><button type="reset">重置</button></td>
									</tr>
								</table>
							</div>
						</fieldset>
					</form>
				</div>
				<div>
					<form id=fdeleteBook>
						<fieldset data-role="collapsible">
							<legend>删除图书</legend>
							<label for="_registrationNumber">总登记号：</label><input type="text"
								name="_registrationNumber" id="_registrationNumber">
							<div>
								<table>
									<tr>
										<td>&nbsp;&nbsp;</td>
										<td><button id=delete onclick="deleteBook()">提交</button></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td><button type="reset">重置</button></td>
										<td><span id=tip>*</span></td>
									</tr>
								</table>
							</div>


						</fieldset>
					</form>
				</div>
				<div>
					<form id=fborrowBook>
						<fieldset data-role="collapsible">
							<legend>借书登记</legend>
							<label for="userName">用户名：</label><input type="text"
								name="userName" id="userName"> <label for="bookName">书名：</label><input
								type="text" name="bookName" id="bookName"> <label
								for="registrationNumber_">总登记号：</label><input type="text"
								name="registrationNumber_" id="registrationNumber_">
							<div>
								<table>
									<tr>
										<td>&nbsp;&nbsp;</td>
										<td><button id=b_Book onclick="borrowBook()">提交</button></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td><button type="reset">重置</button></td>
										<td><span id=tip>*</span></td>
									</tr>
								</table>
							</div>


						</fieldset>
					</form>
				</div>
				<div>
					<form id=freturnBook>
						<fieldset data-role="collapsible">
							<legend>还书登记</legend>
							<label for="userName_r">用户名：</label><input type="text"
								name="userName_r" id="userName_r"> <label
								for="bookName_r">书名：</label><input type="text" name="bookName_r"
								id="bookName_r"> <label for="registrationNumber_r">总登记号：</label><input
								type="text" name="registrationNumber_r"
								id="registrationNumber_r">
							<div>
								<table>
									<tr>
										<td>&nbsp;&nbsp;</td>
										<td><button id=r_Book onclick="returnBook()">提交</button></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td><button type="reset">重置</button></td>
										<td><span id=tip>*</span></td>
									</tr>
								</table>
							</div>


						</fieldset>
					</form>
				</div>
			</div>

		</div>
		<div data-role="footer" class="ui-btn" data-position="fixed"
			data-fullscreen="true">
			<a href="#" data-role="button" data-icon="plus">转播到新浪微博</a> <a
				href="#" data-role="button" data-icon="plus">转播到腾讯微博</a> <a href="#"
				data-role="button" data-icon="plus">转播到QQ空间</a>
		</div>
	</div>
</body>
</html>