package com.belloy.jun211.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x * y;
		request.setAttribute("z", z);
		
		Belloy b = new Belloy("벨로이", 3, 50.5, 10.1);
		request.setAttribute("b", b);
		
		ArrayList<Belloy> bls = new ArrayList<Belloy>();
		bls.add(b);
		bls.add(new Belloy("벨로잉", 2, 40.4, 9.4));
		bls.add(new Belloy("벨루이", 5, 30.3, 6.6));
		bls.add(new Belloy("벨뤄이", 1, 50.5, 3.3));
		request.setAttribute("bls", bls);
	}
}
