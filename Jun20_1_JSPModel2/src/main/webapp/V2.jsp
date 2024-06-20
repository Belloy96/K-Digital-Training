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
		// V
		//		웹디자이너 B
		request.setCharacterEncoding("UTF-8"); 			// 지금은 POST방식이기 때문에 인코딩이 필요!
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y")); // 출력하기 위해 값 가져옴
		int z = (Integer) request.getAttribute("z");		// 최상위 객체 Object여서 형변환 필요
	%>
	<h1>V2</h1>
	<%=x %> + <%=y %> = <%=z %>
</body>
</html>