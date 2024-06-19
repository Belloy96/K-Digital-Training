<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td></td>
			<td>
				<%for(int i = 2; i <= 9; i++){%>
				<td><%=i %>단<%}%>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<%for(int i = 2; i <= 9; i++){%>
				<td><%for(int j = 1; j <= 9; j++){%>
					<%=i %> * <%=j %> = <%=i * j %><br><%}%>
				<%}%>
			</td>
		</tr>	
	</table>
</body>
</html>