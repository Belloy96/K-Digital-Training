<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BelloyValidChecker.js"></script>
<script type="text/javascript" src="js/NBValidChecker_Answer.js"></script>
<script type="text/javascript" src="js/go_Answer.js"></script>
<link rel="stylesheet" href="css/nb_Answer.css">
</head>
<body>
	<form action="HomeController_Answer" name="nbForm" onsubmit="return check();">
		<table id="nbTbl">
			<tr>
				<th align="center">숫자야구</th>
			</tr>
			
			<tr>
				<td align="center">
					<input class="ip" name="userAns"
					maxlength="3" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			
			<tr>
				<td class="td1" align="left">
					<marquee behavior="alternate">숫자만 3자리, 중복 숫자 X</marquee>
				</td>
			</tr>
			
			<tr>
				<td align="center"><button class="btn">확인</button></td>
			</tr>
			
			<tr>
				<td class="td1" align="left">${ua }</td>
			</tr>
			
			<tr>
				<td class="td1" align="left">${s }</td>
			</tr>
			
			<tr>
				<td class="td1" align="left">${b }</td>
			</tr>
			
			<tr>
				<td class="td1" align="left">${t }</td>
			</tr>
			
			<tr>
				<td class="td1" align="left">${r }</td>
			</tr>
			
		</table>
	</form>
	
	<div align="center">
		${btn }
	</div>
	${con }
</body>
</html>