<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setCharacterEncoding("UTF-8");
	String path = request.getServletContext().getRealPath("img");
	System.out.println(path);
	
	MultipartRequest mr = new MultipartRequest(request, path, 
			30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
	
	String name = mr.getParameter("name");
	double height = Double.parseDouble(mr.getParameter("height"));
	double weight = Double.parseDouble(mr.getParameter("weight")); // 여기서 mr 대신 request를 쓰면 결과가 null이 나올 것
	height /= 100;
	double bmi = weight / (height * height);
	String result = "저체중";
	if (bmi >= 40) {
		result = "고도비만";
	} else if (bmi >= 35) {
		result = "중증도비만";
	} else if (bmi >= 30) {
		result = "경도비만";
	} else if (bmi >= 25) {
		result = "과체중";
	} else if (bmi >= 18.5) {
		result = "정상";
	} 
	
	// BMI 수치 => 소수점 둘째자리까지만 (** 아래에서는 안되니까 여기에서 해결)
	String bmi2 = String.format("%.2f", bmi);
			
	String image = mr.getFilesystemName("photo");
	image = URLEncoder.encode(image, "UTF-8");
	image = image.replace("+", " ");	// out 위로 복붙함	
	%>
	
	<%=name %> <p>
	<%=height * 100 %>cm <p>
	<%=weight %>kg <p>
	<%=bmi2 %> <p>
	당신은 <%=result %> 입니다 <p>
	<img src="img/<%=image %>" style="max-width: 40%";>
	
</body>
</html>











<!-- JSP : HTML + JAVA / SERVLET : JAVA + HTML -->