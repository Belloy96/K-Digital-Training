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
		// 값
		//	(요청)parameter
		// 			html에서 만들어낸 값(a, b)
		//			request에 저장
		//			String or String[]
				
		//		attribute
		//			Java에서 만들어낸 값(c, d, e)
		//			request에 저장
		//			Object (최상위 객체) / 즉 불러올때 형 변환이 필요하다 !!
		
		// 이동
		//		First => Second : 사용자가 뭔가 액션을 해서 넘어옴
		//			=> request(요청)!!!
		
		//		Second => Third : 그냥 넘어감 (자동)
		//			- redirect : 단순 자동이동 (점검중)
		//			response.sendRedirect("Third.jsp");
		
		//			- forward : 자동 이동(값이 전달되는) // 이 예시에서는 Second에서 만든 값!
		// RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");	
		// rd.forward(request, response);
		
		//			- include : 포함(Second 속에 Third가 포함되는)
		//			위치 조절이 안됨(Third가 무조건 상단에 들어옴) - 비추 !!!
		//			조만간 ! 위치 조절이 되는 include를 보도록 합시다 !!!
		// RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");	
		// rd.include(request, response);
		
	%>
	
	<% 
		request.setCharacterEncoding("UTF-8");
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// RequestDispatcher : 클라이언트로부터 들어온 요청을
		//						원하는 쪽으로 넘기는 기능
		// 호출된 페이지에서는 request.setAttribute(key, value) 메서드를 통해서
		//	넘겨받은 데이터를 처리할 수 있음
		// => Redirect와는 다르게
		//		request와 response 객체를 가지고 넘어가기 때문에
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp"); // 자동 이동할 곳 지정	
		
									  //  	← 
		int c = a + b;				  //  ↓	  ↑
		request.setAttribute("c", c); // "c", c  c로 저장하고 c를 적으면 불러옴
		
		String d = "ㅋ";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		rd.include(request, response);		// forward 주석처리하고 include 실행(Third와 Second가 같이 나오게 됨)
		// rd.forward(request, response); 	// forward 매서드 불러옴
		// forward는 호출, 응답 객체를 필요로 함	    // 호출, 응답 객체를 담아서 가져감 -> Third로
		// 만약 forward 대신 redirect를 사용하게 되면 값을 가져갈 수가 없어서(응답, 호출값 담지않음)
		// null 오류 발생함
		
	%>
	<h1>Second</h1>
	<hr>
	a : <%=a %> <br>
	b : <%=b %> <br>
	
</body>
</html>