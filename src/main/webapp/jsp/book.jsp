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
</head>
<body>
	<div data-role="page" id="pageone">
		<div data-role="header">
			<h1>在此处写入标题</h1>
		</div>

		<div data-role="content">
			<p>在此处写入正文</p>
		</div>

		<div data-role="footer">
			<h1>在此处写入页脚文本</h1>
		</div>
	</div>
</body>