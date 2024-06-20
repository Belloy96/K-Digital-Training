<%@page import="com.belloy.jun202.main.Guest_Answer"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI REPORT</title>
<link rel="stylesheet" href="css/BMIInput_Answer.css">
</head>
<body>
	<%
	response.setCharacterEncoding("UTF-8");
	Guest_Answer g = (Guest_Answer) request.getAttribute("g");
	%>
	<table id="resultTbl">
		<tr>
			<th colspan="2">BMI Result</th>
		</tr>
		
		<tr>
			<td class="td1">이름</td>
			<td class="td2"><%=g.getName() %> </td>
		</tr>
	
		<tr>
			<td class="td1">키</td>
			<td class="td2"><%=g.getHeight() * 100%>cm</td>
		</tr>
	
		<tr>
			<td class="td1">몸무게</td>
			<td class="td2">${g.weight }kg</td>
		</tr>
	
		<tr>
			<td class="td1">BMI</td>
			<td class="td2"><%=g.getBmi() %></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<marquee>당신은 <%=g.getStatus() %></marquee>
			</td>
		</tr>
		
		<tr>
			<td>
				<img src="img/<%=g.getPhoto() %>" style="max-width: 40%">
			</td>
		</tr>
	</table>
</body>
</html>