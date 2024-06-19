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
		// GET / POST
		// 원래 ) 요청파라미터 => 한글처리
		//		GET - 한글처리를 안함(Tomcat xml 63번줄에 설정했기 때문)
		//		POST - 한글처리 해야함
		// 할지 말지 고민이 될때는 일단 하고 보자!
		request.setCharacterEncoding("UTF-8");
		
		// 원래) 응답 한글처리 (위에서 해주고 있어서 필요 없음!)
		//		ex) 1 ~ 2 번줄의 'UTF-8'
		// response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int x = Integer.parseInt(request.getParameter("x"));		
		int y = Integer.parseInt(request.getParameter("y"));		
		int z = x + y;
	%>
	이름 : <%=name %> <p>
	<h1><%=x %> + <%=y %> = <%=z %></h1>
	
</body>
</html>