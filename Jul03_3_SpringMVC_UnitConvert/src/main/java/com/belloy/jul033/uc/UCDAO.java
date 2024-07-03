package com.belloy.jul033.uc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class UCDAO {
	
	private HashMap<String, String> unit; // HashMap으로 단위를 받아오려고 함. setter만 남기고 지움
										  // servlet-context로 넘어감
	public void setUnit(HashMap<String, String> unit) {
		this.unit = unit;
	}
	
	public void convert(UCResult ur, HttpServletRequest req) {
		double n1 = ur.getN1();
		String what = req.getParameter("what");
		double n2 = n1 * 1.61; //속도를 기본값으로 넣고 감
		if (what.equals("l")) {
			n2 = n1 * 0.39;
		} else if (what.equals("d")) {
			n2 = n1 * 0.3;
		} else if (what.equals("t")) {
			n2 = n1 * 1.8 + 32;
		}
		
		// 단위들은 어떻게 받아올 것인가? servlet-context작업하고 넘어옴
		System.out.println(unit);
		System.out.println(unit.get(what));
		
		String[] u = unit.get(what).split(","); // servlet에서 ,로 각 변환 전 단위와 변환 후 단위를 지정해놓았음
		
		ur.setN2(n2);
		ur.setU1(u[0]);
		ur.setU2(u[1]);
		
		req.setAttribute("ur", ur); // 이거하고 class에 @Service어노테이션 추가!
		
		
	}
	
	
}
