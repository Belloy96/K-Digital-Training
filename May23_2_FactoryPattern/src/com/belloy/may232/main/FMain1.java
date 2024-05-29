package com.belloy.may232.main;

import com.belloy.may232.register.Academy;
import com.belloy.may232.register.Student;

// 학원에서 학생을 상담한 후 해당 커리큘럼 대기자로 등록하려고 함
// 학생의 정보는 이름 / 나이 !
// 등록 순서대로 번호를 부여하고 싶은데 어떻게 해야할까 ?

// 객체가 필요없다(= 멤버변수가 필요없다) : static 메소드 기반
// 객체가 있기는 해야함
//		하나	: Singleton 패턴
//		여러개 : 
//			대량 생산, 자동화된 : Factory 패턴
//			나머지 : 여태껏 우리가 했던대로!	
public class FMain1 {
	public static void main(String[] args) {
		Academy ac = new Academy();
		
		Student s1 = ac.consult("aa", 20);
		s1.printInfo();
		System.out.println("===========");
		Student s2 = ac.consult("bb", 21);
		s2.printInfo();
		System.out.println("===========");
		Student s3 = ac.consult("cc", 21);
		s3.printInfo();
		System.out.println("===========");
	}
}
