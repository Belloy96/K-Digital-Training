<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hj.css">
</head>
<body>
	<form action="HomeController">
		<table id="hjTbl">
			<tr>
				<th align="center" colspan="3">홀짝게임</th>
			</tr>
			
			<tr>
				<td align="center">
					<a href="HomeController?userHand=1"><img src="1.png"></a>
				</td>		
				<td align="center">
					<a href="HomeController?userHand=2"><img src="2.png"></a>
				</td>		
			</tr>
			
			<tr>
				<td align="center">↓나의 선택↓</td>		
				<td align="center">↓상대의 선택↓</td>		
			</tr>
			
			<tr>
				<td align="center"><img src="${uh }"></td>
				<td align="center"><img src="${ch }"></td>
			</tr>
			
			<tr>
				<td class="td1" colspan="2" align="center">판정 : ${r }</td>		
			</tr>
			
			<tr>
				<td class="td1" colspan="2" align="center">상대가 뽑은 개수 : ${q }</td>		
			</tr>
			
			<tr>
				<td class="td1" colspan="2" align="center">${t } ${w } ${l } ${p }</td>		
			</tr>
			
			<tr>
				<td class="td1" colspan="2" align="center">
					<form action="HomeController" method="post" >
						<button>다시하기</button>
					</form>
				</td>		
			</tr>
			
		</table>
	</form>

</body>
</html>