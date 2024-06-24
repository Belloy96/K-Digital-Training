<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/output.css">
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitle">
				<marquee>
					2024년 6월 24일
				</marquee>
			</th>		
		</tr>
		
		<tr>
			<td id="siteMenu" align="center">
				<a href="HomeController">Home</a>		
				<a href="A.jsp">A</a>
				<a href="B.jsp">B</a>
				<a href="C.jsp">C</a>
			</td>
		</tr>
		
		<tr>
			<td id="siteContent"><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
		
	</table>
</body>
</html>