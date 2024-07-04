package com.belloy.jul042.student;

import java.math.BigDecimal;

// MyBatis : ORM Framework (Object Relationship Mapping)
//	=> 객체와 데이터베이스의 데이터를 자동으로 연결(매핑)해주는 프레임워크
//	=> 결과가 자바객체로 나타남
//		DB컬럼명 = Java멤버변수명 (조건)
//		Oracle) number => Java) BigDecimal(실수와 정수 둘 다 담아낼 수 있는 자료형)

// Spring MVC : 요청파라미터를 자동으로 객체로...
//		요청파라미터명 = Java멤버변수명 (조건) 이 두 개가 같아야 가능!

// Spring MVC + MyBatis + Maven
//		요청파라미터명 = Java멤버변수명 = DB컬럼명 (조건) ***
//		Oracle) number => Java) BigDecimal(실수와 정수 둘 다 담아낼 수 있는 자료형)

public class Student {
	private BigDecimal s_no;
	private String s_name;
	private String s_nickname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(BigDecimal s_no, String s_name, String s_nickname) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_nickname = s_nickname;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_nickname() {
		return s_nickname;
	}

	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}
	
}
