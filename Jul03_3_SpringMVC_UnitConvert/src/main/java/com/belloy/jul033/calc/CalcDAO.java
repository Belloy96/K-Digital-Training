package com.belloy.jul033.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class CalcDAO {
	
	public void getCalc(CalcNum cn, HttpServletRequest req) {
		double length = cn.getNumber() / 2.54;
		req.setAttribute("r", length + "inch");
		req.setAttribute("r2", "cm → inch");
		
		double area = cn.getNumber() / 3.306;
		req.setAttribute("r", area + "평");
		req.setAttribute("r2", "㎡ → 평");
		
		double temperature = (cn.getNumber() * 1.8) + 32;
		req.setAttribute("r", temperature + "℉");
		req.setAttribute("r2", "℃ → ℉");
		
		double velocity = cn.getNumber() * 1.609;
		req.setAttribute("r", velocity + "km/h");
		req.setAttribute("r2", "mi/h → km/h");
	}
	
}
