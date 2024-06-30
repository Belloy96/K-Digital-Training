<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data"
		name="updateForm">
		<table>
			<tr>
				<th>회원 정보 수정</th>
			</tr>		
			
			<tr>
				<td>ID : </td>			
				<td> 
					<input name="m_id">
				</td>
			</tr>
		
			<tr>
				<td>PW : </td>			
				<td> 
					<input name="m_pw">
				</td>
			</tr>
		
			<tr>
				<td>PWChk : </td>			
				<td> 
					<input name="m_pwchk">
				</td>
			</tr>
		
			<tr>
				<td>이름 : </td>			
				<td> 
					<input name="m_name">
				</td>
			</tr>
		
			<tr>
				<td>번호 : </td>			
				<td> 
					<input name="m_number">
				</td>
			</tr>
		
			<tr>
				<td>생일 : </td>			
				<td> 
					<input name="m_birth">
				</td>
			</tr>
			
			<tr>
				<td>사진 : </td>			
				<td> 
					<input type="file" name="m_photo">
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>