<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController">
		<table class="rspTbl">
			<tr>
				<th colspan="4" align="center"><h1>가위바위보 게임</h1></th>
			</tr>
			
			<tr>
				<td align="center">
					<a href="HomeController?userHand=1"><img src="1.png"></a>
				</td>
				
				<td align="center">
					<a href="HomeController?userHand=2"><img src="2.png"></a>
				</td>
				
				<td align="center">
					<a href="HomeController?userHand=3"><img src="3.png"></a>
				</td>
			</tr>
			
			<tr>
				<td class="td2" align="center">유저(↓)</td>
				<td class="td2" align="center">vs</td>
				<td class="td2" align="center">상대(↓)</td>
			</tr>
			
			<tr>
				<td align="center"><img src="${uh }"></td>
				
				<td align="center"><img src="lostark4.gif"></td>
				
				<td align="center"><img src="${ch }"></td>
			</tr>
		
			<tr>
				<td colspan="3" align="center">판정 : ${r } </td>
			</tr>

			<tr>
				<td colspan="3" align="center">${t } ${w } ${d } ${l }</td>
			</tr>
			
			<tr>
				<td class="td1" colspan="3" align="center">
					<form action="HomeController" method="post">
						<button>다시하기</button>
					</form>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>