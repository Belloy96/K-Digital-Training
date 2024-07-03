<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>단 위 변 환</h1>
	<form action="unit.convert">
		숫자 : <input name="n1"> <p>
		<select name="what">
			<option value="l">cm → inch</option>
			<option value="d">㎡ → 평</option>
			<option value="t">℃ → ℉</option>
			<option value="v">mi/h → km/h</option>
		</select> <p>
		<button>변환</button>
	</form>
</body>
</html>