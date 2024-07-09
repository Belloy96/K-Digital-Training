<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		MyBatis 활용
		전체 과일데이터를 가격순으로
		이름 - 가격 형태로 출력
		(ex : 귤 - ￦2,800)
	 -->
	<form action="fruit.print">
		<button>전체 과일 데이터 불러오기</button>
	</form>
	<hr>
	<c:forEach var="f" items="${fruits }">
		${f.f_name } - <fmt:formatNumber type="currency" value="${f.f_price }">
		</fmt:formatNumber> <p>
	</c:forEach>
	<hr>
</body>
</html>