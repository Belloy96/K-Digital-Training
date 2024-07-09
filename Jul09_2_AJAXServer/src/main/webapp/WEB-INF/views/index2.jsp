<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function () {
		// alert(123);
/* 		$.ajax({
			url: "error.getJSON",
			success: function (zxc) {
				// alert(zxc);
				// JavaScript 객체 => 문자열 그대로 변환이 가능 O
				alert(JSON.stringify(zxc));
			}
		}); */
		
		// JSON으로 AJAX하기 간단한 ver.
		// $.getJSON("요청주소?파라미터=값&...", 값을 받아오는데 성공하면 발동하는 콜백함수)
		$.getJSON("error.getJSON", function (zxc) {
			// alert(JSON.stringify(zxc));
			// let ar = zxc.error;
			// alert(ar[0].e_where); // DAO 값이 alert 되었음
			
			// jQuery의 반복문 - 배열을 대상으로
			$.each(zxc.error, function (i, e) {
				let td1 = $("<td></td>").text(e.e_what);
				let td2 = $("<td></td>").text(e.e_where);
				
				let tr = $("<tr></tr>").append(td1, td2);
				$("table").append(tr);
			});
		});
		
		// 버튼을 클릭 시 => input에 e_what에 대한 내용이 error테이블에 있으면
		//		=> 그 데이터를 테이블의 형태로 출력
		$("button").click(function () {
			let iVal = $("input").val();
			
			$.getJSON("error.searchJSON?e_what=" + iVal, function (asd) {
				$("table").empty(); // 누를 때마다 붙어서 나오니 비워주도록 함
				$.each(asd.error, function (i, e) {
					let td1 = $("<td></td>").text(e.e_what);
					let td2 = $("<td></td>").text(e.e_where);
					
					let tr = $("<tr></tr>").append(td1, td2);
					$("table").append(tr);
				});
			});
		});
		$("input").keyup(function(e) {
			if (e.keyCode == 13) {
				$("button").trigger("click");
			}
		});
		
	});
</script>
</head>
<body>
	<input> <button>button</button>
	<hr>
	<table border="1"></table>
</body>
</html>