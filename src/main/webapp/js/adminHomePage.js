function addBook() {
	var d = $("#publishingDate").val();
	$.ajax({
		type : "post",
		url : "http://localhost:8888/mc/mcbook/addBook",
		data : {
			registrationNumber : $("#registrationNumber").val(),
			title : $("#title").val(),
			author : $("#author").val(),
			publishingCompany : $("#publishingCompany").val(),
			category : $("#category").val(),
			publishingDate : new Date(d.replace(/-/g, "/")),
			notes : $("#notes").val(),
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			window.location.reload();
		},
		error : function(data) {
			alert(data.msg);
		}
	});
}

function deleteBook() {
	$.ajax({
		type : "post",
		url : "http://localhost:8888/mc/mcbook/deleteBook",
		data : {
			registrationNumber : $("#_registrationNumber").val(),
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			window.location.reload();
		},
		error : function(data) {
			alert(data.msg);
		}
	});
}
function borrowBook() {
	$.ajax({
		type : "post",
		url : "http://localhost:8888/mc/mcbook/borrowBook",
		data : {
			userName : $("#userName").val(),
			bookName : $("#bookName").val(),
			registrationNumber : $("#registrationNumber_").val(),
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			window.location.reload();
		},
		error : function(data) {
			alert(data.msg);
		}
	});
}
function returnBook() {
	$.ajax({
		type : "post",
		url : "http://localhost:8888/mc/mcbook/returnBook",
		data : {
			userName : $("#userName_r").val(),
			bookName : $("#bookName_r").val(),
			registrationNumber : $("#registrationNumber_r").val(),
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			window.location.reload();
		},
		error : function(data) {
			alert(data.msg);
		}
	});
}
function logout(){
	window.location.href = "http://localhost:8888/mc";
}