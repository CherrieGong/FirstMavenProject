function findAll() {
	document.getElementById("hisGrid").style.display = "none";
	document.getElementById("dataGrid").style.display = "";
	$("#grid").html("");

	$
			.ajax({
				type : "post",
				url : "http://localhost:8888/mc/mcbook/findAllBooks",
				data : {},
				success : function(data) {
					var json = eval(data);
					$
							.each(
									json,
									function(index, item) {
										var s = "<div class='ui-grid-c'><div class='ui-block-a'><div class='ui-grid-a'><div class='ui-block-a'>"
												+ item.registrationNumber + "</div>";
										s = s
												+ "<div class='ui-block-b'>"
												+ item.title
												+ "</div></div></div><div class='ui-block-b'><div class='ui-grid-a'>";
										s = s
												+ "<div class='ui-block-a'>"
												+ item.author
												+ "</div><div class='ui-block-b'>"
												+ item.publishingCompany
												+ "</div></div></div><div class='ui-block-c'>";
										s = s
												+ "<div class='ui-grid-a'><div class='ui-block-a'>"
												+ item.category
												+ "</div><div class='ui-block-b'>"
												+ item.publishingDate
												+ "</div></div>";
										s = s
												+ "</div><div class'ui-block-d'><div class='ui-grid-a'><div class='ui-block-a'>"
												+ item.userName
												+ "</div>";
										s = s
												+ "<div class='ui-block-b'>"
												+ item.backTime
												+ "</div></div></div>";
										$("#grid").append(s);
									})

				},
				error : function(data) {
					alert(data.msg);
				}
			});
}

function findHistory() {
	document.getElementById("dataGrid").style.display = "none";
	document.getElementById("hisGrid").style.display = "";
	$("#data").html("");
	$
			.ajax({
				type : "post",
				url : "http://localhost:8888/mc/mcbook/findHistory",
				data : {},
				success : function(data) {
					var json = eval(data);
					if (json.length == 0) {
						alert("截止到当前时间还没有人借书！");
					} else {
						$
								.each(
										json,
										function(index, item) {
											var s = "<div class='ui-grid-a'><div class='ui-block-a'><div class='ui-grid-b'><div class='ui-block-a'>";
											s = s
													+ item.userName
													+ "</div><div class='ui-block-b'>"
													+ item.registrationNumber;
											s = s
													+ "</div><div class='ui-block-c'>"
													+ item.bookName
													+ "</div></div></div><div class='ui-block-b'>";
											s = s
													+ "<div class='ui-grid-b'><div class='ui-block-a'>"
													+ item.time + "</div>";
											s = s
													+ "<div class='ui-block-b'>"
													+ item.backTime
													+ "</div><div class='ui-block-c'>"
													+ item.tag;
											s = s + "</div></div></div></div>";
											$("#data").append(s);
										})
					}
				},
				error : function(data) {
					alert(data.msg);
				}
			});
}

// 扩展Date的format方法
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

function longToDate(data) {
	var time = $(data).text();
	$(data).html(new Date(parseInt(time, 10)).format("yyyy-MM-dd hh:mm:ss"));
}
function logout() {
	window.location.href = "http://localhost:8888/mc";
}