<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BelloyValidChecker.js"></script>
<script type="text/javascript" src="js/RegValidChecker.js"></script>
</head>
<body>
	<form action="RegisterController" name="regForm" method="post" 
		enctype="multipart/form-data" onsubmit="return check();">
		<table>
			<tr>
				<th>회원가입</th>
			</tr>
			
			<tr>
				<td>ID : </td>
				<td>
					<input autocomplete="off" autofocus="autofocus" name="m_id">
				</td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td>
					<input type="password" autocomplete="off" autofocus="autofocus"
						name="m_pw">	
				</td>
			</tr>
			
			<tr>
				<td>PWChk : </td>
				<td>
					<input type="password" autocomplete="off" autofocus="autofocus"
						name="pwchk" placeholder="비밀번호 한 번 더 입력">
				</td>
			</tr>
			
			<tr>
				<td>이름 : </td>
				<td>
					<input autocomplete="off" name="m_name">
				</td>
			</tr>
			
			<tr>
				<td>핸드폰번호 : </td>
				<td>
					<input placeholder="숫자만 입력" autocomplete="off" name="m_number">
				</td>
			</tr>
			
			<tr>
				<td>생년월일 : </td>
				<td>
					<input placeholder="8자리로 입력 ex.19960707" autocomplete="off"
						name="m_birth">
				</td>
			</tr>
			
			<tr>
				<td>사진 : </td>
				<td>
					<input type="file" name="m_photo">
				</td>
			</tr>
			
			<tr>
				<td align="center" colspan="2">
					<button>등록</button>		
				</td>
			</tr>
		</table>
	</form>
</body>
</html>