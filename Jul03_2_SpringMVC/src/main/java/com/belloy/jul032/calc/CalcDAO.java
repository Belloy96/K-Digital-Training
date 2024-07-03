package com.belloy.jul032.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 멤버변수가 없으면 : static method 기반
//	M / DAO에는 게시판 같은 기능을 구현한다면 멤버변수가 생김(JSP의 사과 데이터 수 구하는 멤버변수 생각하면..!)
//		=> static 기반 method는 포기 => 객체를 만들어서 사용해야 하는데(CalcDAO cDAO = new CalcDAO();)
//		=> 요청 or 새로고침 => calculate.do로 요청할 때마다 새로운 cDAO가 생성됨
//		=> 메모리 폭발(메모리를 계속 사용하게 됨, 비효율적)
//			+ allCalcCount도 제대로 카운팅 X !

// 해결방안 : CalcDAO를 singleton 처리

// Spring식의 singleton 처리방법(@Service를 활용해서 singleton으로 처리..!)
@Service // servlet-context.xml에 CalcDAO 객체 하나를 등록해놓은 효과!
public class CalcDAO {
	private int allCalcCount; // 몇 번 계산했는지
	
//	public void calculate(CalcResult cr, HttpServletRequest req) {
//		allCalcCount++;
//		System.out.println(allCalcCount);
//		int add = cr.getX() + cr.getY();
//		System.out.println(add);
//		
//	}
	
	public void calculate(CalcResult cr, HttpServletRequest req) {
		allCalcCount++;
		System.out.println(allCalcCount);
		int add = cr.getX() + cr.getY();
		System.out.println(add);
		req.setAttribute("r", add); 				// 더한 결과를 어트리뷰트로 심어주기
		req.setAttribute("r2", "계산 결과 : " + add); // 문구까지 넣어서 처리하기
		
	}
	
	
}
