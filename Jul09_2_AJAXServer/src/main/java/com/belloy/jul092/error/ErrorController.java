package com.belloy.jul092.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
	
	@Autowired
	private ErrorDAO eDAO;
	
	@RequestMapping(value = "/error.getJSON", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors getErrorJSON(HttpServletRequest req) {
		return eDAO.getJSON(req);
		
	}
	
	@RequestMapping(value = "/error.searchJSON", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors searchErrorJSON(Error e, HttpServletRequest req) {
		return eDAO.searchJSON(e, req);
		
	}
	
	
	
	
}
