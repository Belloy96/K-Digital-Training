package com.belloy.jun251.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int add = x + y;
		int subtract = x - y;
		int multiply = x * y;
		double divide = x / (double)y;
		String divide2 = String.format("%.2f", divide);
		
		request.setAttribute("a", add);
		request.setAttribute("s", subtract);
		request.setAttribute("m", multiply);
		request.setAttribute("d", divide2);
		
	}
	
}
