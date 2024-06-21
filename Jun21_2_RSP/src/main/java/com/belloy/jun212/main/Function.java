package com.belloy.jun212.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Function {
	public static void getResult(HttpServletRequest request) {
		Random r = new Random();
		
		int userRSP = Integer.parseInt(request.getParameter(""));
		
		int comRSP = r.nextInt(3) + 1;
		
		int result = userRSP - comRSP;
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		if (result != 1 || result != -2) {
			lose ++;
		} else if (result == 0) {
			draw ++;
		} else {
			win ++;
		}
		
		request.setAttribute("win", win);
		request.setAttribute("lose", lose);
		request.setAttribute("draw", draw);
		
	}
}
