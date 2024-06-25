<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BelloyValidChecker.js"></script>
<script type="text/javascript" src="js/calcCheck.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/calc.css">
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitle">
				<marquee>
					2024년 6월 25일
				</marquee>
			</th>		
		</tr>
		
		<tr>
			<td id="siteMenu" align="center">
				<a href="HomeController">Home</a>		
				<a href="CalcController">사칙연산</a>
				<a href="JSTLCController">JLTL-C</a>
				<a href="JSTLFController">JLTL-F</a>
			</td>
		</tr>
		
		<tr>
			<td id="siteContent"><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
		
	</table>
</body>
</html>