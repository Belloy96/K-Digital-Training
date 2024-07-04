package com.belloy.jul042.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.belloy.jul042.test.TestDAO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private TestDAO tDAO;
	
	@RequestMapping(value="/student.reg", method = RequestMethod.GET)
	public String regStudent(Student s, HttpServletRequest req) {
		sDAO.regStudent(s, req);
		sDAO.getAllStudent(req);
		tDAO.getAllTest(req);
		return "input";
	}
	
}
