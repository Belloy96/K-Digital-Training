<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> /* 고른 것에 따라서 색을 변환하기 위해 css 추가함 */
	.l {
		color: red;
	}

	.d {
		color: green;
	}
	
	.t {
		color: blue;
	}

	.v {
		color: pink;
	}
</style>
</head>
<body>
	<h1 class="${param.what }">변 환 결 과</h1> <!-- 색을 부여하기 위해 class 추가 -->
	${ur.n1 } ${ur.u1 } → ${ur.n2 } ${ur.u2 }
</body>
</html>