<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<form action="RegisterController">
		<table id="mainTbl">
			<tr>
				<th align="center">MOKOKO</th>
			</tr>	
			
			<tr>
				<td align="center">
					<a href="">메뉴</a>
				</td>
			</tr>		

			<tr>
				<td align="center">
					<jsp:include page="${contentPage }"></jsp:include>
				</td>		
			</tr>
		</table>
		
		<table id="loginTbl">
			<tr>
				<td align="center">로그인</td>
			</tr>
			
			<tr>
				<td>ID : </td>
				<td align="center">
					<input name="id" placeholder="아이디 입력" autocomplete="off"
						autofocus="autofocus">
				</td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td align="center">
					<input name="pw" placeholder="비밀번호 입력" autocomplete="off"
						 type="password">
				</td>
			</tr>
			
			<tr>
				<td>
					<button>로그인</button>
				</td>			
				
				<td>
					<button>회원가입</button>
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>