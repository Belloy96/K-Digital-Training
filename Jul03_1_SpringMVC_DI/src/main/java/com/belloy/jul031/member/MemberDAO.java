package com.belloy.jul031.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 우리 눈에는 보이진 않지만 servlet-context.xml에 등록한 효과!
@Service
public class MemberDAO {
	
	// 연/월/일 의 형태...
	
	// 운영자가 시 분 초까지 저장하고 싶다고 요청
	// 연/월/일 => 연-월-일 시:분:초
	
	@Autowired
	private SimpleDateFormat sdf;
	
	public void test() {
		Date now = new Date();
		System.out.println(sdf.format(now));
	}
	
}
