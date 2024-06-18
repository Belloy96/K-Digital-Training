package com.belloy.jun183.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BMIOutput")
public class BMIOutput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String image = mr.getFilesystemName("photo");
		image = URLEncoder.encode(image, "UTF-8");
		image = image.replace("+", " ");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>BMI Result</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.print("<h1>BMI 결과</h1>");
		out.printf("이름 : %s<p>", name);
		out.printf("키 : %.1fcm<p>", height * 100);
		out.printf("체중 : %.1fkg<p>", weight);
		out.printf("BMI수치 : %.2f<p>", bmi);
		out.printf("<h2> 당신은 %s입니다</h2><p>", result);
		
		out.printf("<img src='img/%s' style='max-width:400px;'>", image);
		// 만약 여기서 오류(Not a ~)가 뜨면 절대경로에 이미지를 넣을 파일이 만들어지지 않았으니 직접 들어가서
		// 폴더를 만들어 줄 것!
		out.print("</body>");
		out.print("</html>");
	}

}
