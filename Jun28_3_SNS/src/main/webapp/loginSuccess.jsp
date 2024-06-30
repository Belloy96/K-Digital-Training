<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateInfoController">
		<table>
			<tr>
				<td>
					<img src="${등록한 이미지 파일 }">
				</td>
				
				<td>
					${param.m_name }님
				</td>			
			</tr>
			
			<tr>
				<td>
					<button>정보수정</button>
				</td>
							
				<td>
					<button>회원탈퇴</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>