<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reg.css">
<script type="text/javascript" src="js/BelloyValidChecker.js"></script>
<script type="text/javascript" src="js/AppleValidChecker.js"></script>
</head>
<body>
	<form action="AppleRegController" method="post"
	name="arForm" onsubmit="return check();">
	<table id="regTbl" border="1">
		<tr>
			<td align="center" id="tdTitle">지역</td>
			<td>
				<input id="a_location" name="a_location" autocomplete="off">
			</td>
		</tr>
		
		<tr>
			<td align="center" id="tdTitle">색</td>
			<td>
				<input id="a_color" name="a_color" autocomplete="off">
			</td>
		</tr>
		
		<tr>
			<td align="center" id="tdTitle">맛</td>
			<td>
				<input id="a_flavor" name="a_flavor" autocomplete="off">
			</td>
		</tr>
		
		<tr>
			<td align="center" id="tdTitle">가격</td>
			<td>
				<input id="a_price" name="a_price" autocomplete="off">
			</td>
		</tr>
		
		<tr>
			<td align="center" id="tdTitle">소개</td>
			<td>
				<input id="a_introduce" name="a_introduce" autocomplete="off">
			</td>
		</tr>
	</table>
	<table id="btnTbl">
		<tr>
			<td align="center">
				<button class="btn">등록하기</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>