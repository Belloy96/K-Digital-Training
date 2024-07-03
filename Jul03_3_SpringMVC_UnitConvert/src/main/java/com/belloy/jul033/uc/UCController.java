package com.belloy.jul033.uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UCController {

	@Autowired
	private UCDAO ucd; // @Autowired를 하고 UCDAO로 불러오고, 
					   // 이 ucd 값과 servlet-context의 <beans> id값이랑 일치할 것
	
	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String unitConvert(UCResult ur, HttpServletRequest req) {
		ucd.convert(ur, req);
		return "output";
	}
	
}
