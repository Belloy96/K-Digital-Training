<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BelloyValidChecker.js"></script>
<script type="text/javascript" src="js/Nb.js"></script>
<link rel="stylesheet" href="css/Nb.css">
</head>
<body>
	<form action="HomeController" name="nbform" onsubmit="return nbCheck();">
		<table class="nbTbl">
			<tr>
				<th>숫자 야구 게임</th>
			</tr>		
			
			<tr>
				<td>
					3자리 숫자 입력<input type="text" name="userNum" id="userNum" 
					placeholder="0시작 가능, 숫자 중복 불가" autofocus="autofocus"
					>
				</td>
			</tr>
			
			<tr>
				<td>
					정답유무 : ${c }  
				</td>			
			</tr>
			
			<tr>
				<td>
					판정 : ${t }번째 시도 ${s } ${b }
				</td>			
			</tr>
			
			<tr>
				<td align="center" colspan="2">
					<form action="HomeController" method="post">
						<button >초기화</button>
					</form>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>