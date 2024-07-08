package com.belloy.jul082.fruit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FruitController {
	
	@Autowired
	private FruitDAO fDAO;
	
	@RequestMapping(value="/fruit.print", method=RequestMethod.GET)
	public String printFruit(Fruit f, HttpServletRequest req) {
		fDAO.printFruit(req);
		
		return "index";
	}
	
	
	
}
