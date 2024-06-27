package com.belloy.jun261.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().getAppleDetail(request)) {
			request.setAttribute("contentPage", "apple/detail.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("contentPage", "apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().update(request)) {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("contentPage", "apple.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("contentPage", "apple.jsp"); // 실패한 값도 보여줘야하니!
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
