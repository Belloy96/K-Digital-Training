<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// Parameter 읽기
		int a = Integer.parseInt(request.getParameter("a"));
		
		// 위의 식을 b에 대입해서 풀어보면 다음과 같은 식이 나옴
		String bbb = request.getParameter("b");
		Integer bb = Integer.parseInt(bbb);
		int b = bb.intValue();
		
		// Attribute 읽기
		Object ccc = request.getAttribute("c"); // Object
		Integer cc = (Integer) ccc;				// Object -> Integer / Second에서 지정한 그 이름으로! "c", c
		int c = cc.intValue();					// Integer => int
		
		// 위의 3줄 한줄로 줄이기 ↓
		String d = (String)request.getAttribute("d");
		Random e = (Random)request.getAttribute("e");
	%>
	<h1>Third</h1>
	a : <%=a %> <br>
	b : <%=b %> <br>
	c : <%=c %> <br>
	d : <%=d %> <br>
	e : <%=e.nextInt(100) + 1 %> <br>
</body>
</html>