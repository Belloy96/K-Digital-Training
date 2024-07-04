package com.belloy.jul042.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDAO {

	@Autowired
	private SqlSession ss;
	
	public void regTest(Test t, HttpServletRequest req) {
		try {
			// View 파라미터 3개(t_y, t_m, t_d -> t_when 합쳐줄리없죠? ㅋㅋ)
			// DAO에서 처리!
			String t_y = req.getParameter("t_y");
			
			// 2024 1 1 값을 받아왔다고 쳤을 때 => SimpleDateFormat
			// 202411 => 2024년 11월 ? / 2024년 1월 1일 ? sdf는 헷갈릴수있는 여지가 있음!
			int t_m = Integer.parseInt(req.getParameter("t_m"));
			int t_d = Integer.parseInt(req.getParameter("t_d"));
			
			String t_when2 = String.format("%s%02d%02d", t_y, t_m, t_d); // 20240101
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			Date t_when = sdf.parse(t_when2);
			t.setT_when(t_when);
			
			if (ss.getMapper(TestMapper.class).regTest(t) == 1) { // 앞전의 예시의 부분을 통합해서 한줄로 표현(if 조건)
				req.setAttribute("r", "시험날짜 등록 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "시험날짜 등록 실패");
		}
		
	}
	
	public void getAllTest(HttpServletRequest req) {
		try {
			req.setAttribute("tests", ss.getMapper(TestMapper.class).getAllTest()); // tests라는 어트리뷰트에 담아낸 상태
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
