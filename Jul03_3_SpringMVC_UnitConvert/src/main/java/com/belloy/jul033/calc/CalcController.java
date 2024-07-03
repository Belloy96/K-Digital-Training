package com.belloy.jul033.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalcController {
	
	@Autowired
	private CalcDAO cDAO;
	
	@RequestMapping(value = "calculate.do", method = RequestMethod.POST)
	public String calculate(CalcNum cn, HttpServletRequest req) {
		cDAO.getCalc(cn, req);
		return "output";
	}
	
}
