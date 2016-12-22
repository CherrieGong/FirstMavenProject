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
<script src="${pageContext.request.contextPath}/js/userHomePage.js"
	type="text/javascript" charset="utf-8">
	
</script>
<script src="${pageContext.request.contextPath}/js/search.js"
	type="text/javascript" charset="utf-8">
	
</script>


</head>
<body>
	<div data-role="page">
		<div data-role="header" data-position="fixed" data-fullscreen="true">
			<a href="search.jsp" data-rel="dialog" data-icon="search">搜索</a>
			<h1>欢迎访问我的主页</h1>
			<a href="javascript:(0);" data-icon="back" onclick="logout();">退出</a>
		</div>

		<div data-role="content">
			<hr>
			<hr>
			<div data-role="controlgroup" data-type="vertical" data-inline="true">
				<div>
					<h2>功能选项</h2>
					<a href="#" data-role="button" onclick="findAll()"
						data-inline="true">图书信息查询</a> <a href="#" data-role="button"
						data-inline="true" onclick="findHistory()">历史借阅信息查询</a>
				</div>
			</div>
			<div id="dataGrid" style="display: none;">
				<div class="ui-grid-c">
					<div class="ui-block-a">
						<div class="ui-grid-a">
							<div class="ui-block-a" id="zdjh">总登记号：</div>
							<div class="ui-block-b" id="sm">书名：</div>
						</div>
					</div>
					<div class="ui-block-b">
						<div class="ui-grid-a">
							<div class="ui-block-a" id="zz">作者：</div>
							<div class="ui-block-b" id="cbs">出版社：</div>
						</div>
					</div>
					<div class="ui-block-c">
						<div class="ui-grid-a">
							<div class="ui-block-a" id="tslb">图书类别：</div>
							<div class="ui-block-b" id="cbrq">出版日期：</div>
						</div>
					</div>
					<div class="ui-block-d">
						<div class="ui-grid-a">
							<div class="ui-block-a" id="jyr">借阅人：</div>
							<div class="ui-block-b" id="yghrq">应归还日期：</div>
						</div>
					</div>
				</div>
				<div id="grid"></div>
			</div>
			<div id="hisGrid" style="display: none;">
				<div class="ui-grid-a">
					<div class="ui-block-a">
						<div class="ui-grid-b">
							<div class="ui-block-a" id="yhmz">用户名字：</div>
							<div class="ui-block-b" id="sh">所借书的登记号：</div>
							<div class="ui-block-c" id="sm">书名：</div>
						</div>
					</div>
					<div class="ui-block-b">
						<div class="ui-grid-b">
							<div class="ui-block-a" id="jsrq">借书日期：</div>
							<div class="ui-block-b" id="yhrq">应还日期：</div>
							<div class="ui-block-c" id="yhrq">Y/N（Y代表已还，N代表未还）：</div>
						</div>
					</div>
				</div>
				<div id="data"></div>
			</div>
		</div>
		<div data-role="footer" data-position="fixed" data-fullscreen="true">
			<a href="#" data-role="button" data-icon="plus">转播到新浪微博</a> <a
				href="#" data-role="button" data-icon="plus">转播到腾讯微博</a> <a href="#"
				data-role="button" data-icon="plus">转播到QQ空间</a>
		</div>
	</div>
</body>
</html>
