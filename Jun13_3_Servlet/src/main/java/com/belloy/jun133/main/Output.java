package com.belloy.jun133.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String gd = request.getParameter("GD");
		String lc = request.getParameter("LC");
		String[] hb = request.getParameterValues("HB");
		String ind = request.getParameter("IND");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>결과</title><meta charset='utf-8'></head>");
		out.print("<body>");
		out.printf("<h2>ID = %s</h2>", id);
		out.printf("<h2>PW = %s</h2>", pw);
		out.printf("<h2>성별 = %s</h2>", gd);
		out.printf("<h2>지역 = %s</h2>", lc);
		if (hb != null) {
			out.print("<h2>취미 :");
			for (String s : hb) {
				out.print(s + " ");
			}
			out.print("</h2>");
		}
		out.printf("<h2>자기소개 = %s</h2>", ind);
		out.print("</body>");
		out.print("</html>");
	}

}
