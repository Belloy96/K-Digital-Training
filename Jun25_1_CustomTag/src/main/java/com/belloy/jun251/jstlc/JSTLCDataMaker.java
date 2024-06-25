package com.belloy.jun251.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	public static void make(HttpServletRequest request) {
		int[] ar = { 123, 456, 78, 91, 245 };
		request.setAttribute("ar", ar);
		
		ArrayList<Belloy> al = new ArrayList<Belloy>();
		al.add(new Belloy("벨로이", 3, 50.5, 10.1));
		al.add(new Belloy("벨루이", 2, 40.4, 9.9));
		al.add(new Belloy("발로이", 5, 30.3, 6.6));
		al.add(new Belloy("벨뤄이", 1, 10.1, 3.3));
		request.setAttribute("al", al);
		
	}
}






