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
<script src="${pageContext.request.contextPath}/js/search.js"
	type="text/javascript" charset="utf-8">
	
</script>
<style>
html, body {
	padding: 0;
	margin: 0;
}

html, .ui-mobile, .ui-mobile body {
	height: 415px;
}

.ui-mobile, .ui-mobile .ui-page {
	min-height: 415px;
}

.ui-content {
	padding: 10px 15px 0px 15px;
}
</style>
</head>
<body>
	<div data-role="dialog">
		<div data-role="header" data-theme="d">
			<h1>搜索图书记录</h1>
		</div>
		<div data-role="content" data-theme="c">
			<h1>请输入书名关键词：</h1>
			<div>
				<input type="text" name="keyWord" id="keyWord"
					placeholder="关键字/词...">
			</div>
			<a href="#" data-role="button" data-rel="back" data-theme="c"
				onclick="findBook()">确定</a> <a href="#" data-role="button"
				data-rel="back" data-theme="c">取消</a>
		</div>
	</div>

</body>
</html>