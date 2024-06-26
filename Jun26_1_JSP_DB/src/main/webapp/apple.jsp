<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/apple.css">
</head>
<body>
	<table id="appleTbl" border="1">
		<tr>
			<td align="right">${r } <a href="AppleRegController">등록</a></td>
		</tr>
		
		<tr align="center">
			<td>
				<table id="contentTbl" border="1">
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr class="dataTr">
							<td>${apple.a_location }</td>
							<td>
								<fmt:formatNumber value="${apple.a_price }" type="number" />
							</td>
						</tr>
					</c:forEach>
					
				</table>
			</td>
		</tr>
	</table>
	<img src="appleMokoko.jpg" id="img1" align="left">
</body>
</html>