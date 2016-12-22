// 根据输入的关键字进行查询，并显示在页面
function findBook() {
	document.getElementById("hisGrid").style.display = "none";
	document.getElementById("dataGrid").style.display = "";
	$("#grid").html("");
	$
			.ajax({
				type : "post",
				url : "http://localhost:8888/mc/mcbook/findBook",
				data : {
					keyWord : $("#keyWord").val(),
				},
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
												+ item.publishingDate + "</div></div>";
										s = s
												+ "</div><div class'ui-block-d'><div class='ui-grid-a'><div class='ui-block-a'>"
												+ item.userName + "</div>";
										s = s
												+ "<div class='ui-block-b'>"
												+ item.backTime
												+ "</div></div></div>";
										$("#grid").html(s);
									})

				},
				error : function(data) {
					alert(data.msg);
				}
			});
}
