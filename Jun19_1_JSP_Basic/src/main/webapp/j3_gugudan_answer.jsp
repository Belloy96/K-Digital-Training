<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		float: left;
		margin-right: 
	}
</style>
</head>
<body>
	<%
		for (int i = 2; i <= 9; i++){
	%>
		<table border="1">
			<tr>
				<th><%=i %>단			
			</tr>
		<%
			for (int j = 1; j <= 9; j++){
		%>
			<tr>
				<td><%=i %> x <%=j %> = <%=i * j %></td>
			</tr>
		<%
			}
		%>
		</table>
	<%
		}
	%>
		
</body>
</html>