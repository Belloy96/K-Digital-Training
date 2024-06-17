package com.belloy.jun141.main;

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

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String fileName = request.getParameter("photo");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>제목 : %s</h1>", title);
		out.printf("<h1>파일명 : %s</h1>", fileName);
		out.printf("<img src='%s'>", fileName); // 이미지태그로 불러옴(여기까지만 하면 출력x)
		
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존(주황색) 방식으로 전송된 파라미터 한글 처리
//		request.setCharacterEncoding("UTF-8");
		
		// 기존(주황색) 방식으로 전송된 파라미터 읽기
//		String title = request.getParameter("title");
		
		response.setCharacterEncoding("UTF-8");
		
		// 파일 업로드를 해봅시다 !
		
		// 파일이 업로드 될 서버상의 폴더의 절대경로
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path); // 절대 경로의 위치
		
		// 파일 업로드(처음으로 꼭 숙지하라고 말씀하심!!! 꼭 !!!)
		MultipartRequest mr = new MultipartRequest(
				request, path,
				// 허용할 파일의 최대크기(byte)
				10 * 1024 * 1024,
				// 요청파라미터 인코딩 방식
				"UTF-8",
				// 사용자가 업로드한 파일명이 중복될 때 처리
				// 중복시에 파일명 뒤에 숫자를 붙이게 하는 방식
				new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		
		// 업로드 한 파일명(중복처리된)
		String fileName = mr.getFilesystemName("photo");
		
		// DB에 파일명 저장할 때 => 용량을 상당히 여유있게 만들어야!!
		//		f_name varchar2(200 char)
		
		// 그 이유는 : 톰캣이 한글로 된 파일명 인식 못함
		//		ㅋ.png => %2A.png (URL 인코딩이면 인식)
		fileName = URLEncoder.encode(fileName, "UTF-8");
		
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2, "UTF-8"); 
		fileName2 = fileName2.replace("+", " "); // 파일명 띄어쓰기가 +로 되어있음
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<h1>제목 : %s</h1>", title);
		out.printf("<h1>파일명 : %s</h1>", fileName);
		out.printf("<img src='img/%s'>", fileName); // img라는 폴더의 /파일명, 상대경로 O
		out.printf("<h1>%s</h1>", fileName2);
		out.printf("<a href='img/%s'>다운</a>", fileName2); // 원래 파일명으로 하려면 URL디코딩!추가
		
		out.print("</body>");
		out.print("</html>");
	}

}
