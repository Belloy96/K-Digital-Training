<%@page import="java.util.ArrayList"%>
<%@page import="com.belloy.jun211.main.Belloy"%>
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
		// EL (Expression Language)
		//		값 받을 때 Java 대신 가능
		// 		.jsp에서만 사용 가능
		//			(.jsp를 톰캣이 Servlet으로 바꿀 때 EL을 Java코드로 바꿔줌)
		//		문법 : ${XXX }
		//			연산자 사용 가능
		//			형 변환 자동
		//			값이 없으면 그냥 넘어감
		//			import가 없어도 됨
		
		//		파라미터값 읽기 : ${param.파라미터명 }
		
		//		어트리뷰트값 읽기(int, double, String, ... 포함)
		//			: ${어트리뷰트명 }
		
		//		어트리뷰트 값 읽기(객체)
		//			주소값 - ${어트리뷰트명 }
		//			속성값 - ${어트리뷰트명.멤버변수명 }
		
		//		어트리뷰트값 읽기(List, [])
		//			AL(ArrayList), [] 자체 - ${어트리뷰트명 }
		//			인덱스 위치의 객체 - ${어트리뷰트명[인덱스] } 
		//			인덱스 위치의 객체 속성 - ${어트리뷰트명[인덱스].멤버변수명 }
		
		//		반복문, 조건문 - EL (X) / CustomTag (O)
		//	->	EL에서 반복문, 조건문 없음 but, 이후에 배울 CustomTag로 사용 가능!				
		
	%>
	
	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int z = (Integer) request.getAttribute("z");
		
		Belloy b = (Belloy) request.getAttribute("b");
		
		ArrayList<Belloy> bls = (ArrayList<Belloy>) request.getAttribute("bls");
	%>
	<h1>결과</h1>
	<%=x %> x <%=y %> = <%=z %> <br>
	<%=b.getName() %> : <%=b.getAge() %> : <%=b.getHeight() %> : <%=b.getWeight() %> <p>
	<%=b %> <p>
	
	<%=bls %> <p>
	<%=bls.get(1) %> <p>
	<%=bls.get(2).getName() %>, <%=bls.get(3).getAge() %> <p>
	
	<%
		for (int i = 0; i < bls.size(); i++){
	%>
		<%=bls.get(i).getName() %>	:	<%=bls.get(i).getAge() %>살 <br>
	<% 
		}
	%>		
	<hr>
	${param.x } <p>
	${param.y } <p>
	${param.x * param.y } <p>
	${z } <p>
	<hr>
	${b.name } : ${b.age } : ${b.height } : ${b.weight } <p>
	<hr>
	${param.sdfsfgsgsadfsafa } <!-- 값이 없을 때 -->
	<hr>
	${bls } <p>
	${bls[1] } <p>
	${bls[2].name }, ${bls[3].age } <p>
	
	
</body>
</html>