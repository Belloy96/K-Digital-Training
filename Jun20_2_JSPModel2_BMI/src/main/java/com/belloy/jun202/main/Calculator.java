package com.belloy.jun202.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calcBMI(HttpServletRequest request) {
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		height /= 100;
		double bmi = weight / (height * height);
		request.setAttribute("bmi", bmi);
		
		String result = "저체중";
		
		if (bmi >= 40) {
			result = "고도비만";
			request.setAttribute("result", result);
		} else if (bmi >= 35) {
			result = "중증도비만";
			request.setAttribute("result", result);
		} else if (bmi >= 30) {
			result = "경도비만";
			request.setAttribute("result", result);
		} else if (bmi >= 25) {
			result = "과체중";
			request.setAttribute("result", result);
		} else if (bmi >= 18.5) {
			result = "정상";
			request.setAttribute("result", result);
		} 
	}
}
