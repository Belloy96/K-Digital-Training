package com.belloy.may231.main;

import com.belloy.may231.Belloy.Belloy;

// 원하는 객체 하나 생성
// 이름, 나이, 별명
// 출력

// 유일한 벨로이(강의에서는 비버Beaver)였으면 좋겠음!
// 디자인 패턴 프로그래밍 중에
//		*** 싱글톤 패턴 (Singleton Pattern)
// 클래스가 최초 한 번만 메모리를 할당하고(Static)
//		그 메모리에 객체를 만들어서 사용하는 디자인 패턴
// 고정된 메모리 영역을 얻으면서하나의 객체를 사용하기 때문에
//		메모리 낭비를 방지할 수 있음
public class SMain1 {
	public static void main(String[] args) {
//		Belloy b1 = new Belloy("김세훈", 27, "벨로이");
//		b1.printInfo();
//		System.out.println(b1);
//		System.out.println("----------");
//		Belloy b2 = new Belloy("김세훈", 27, "벨로이");
//		b2.printInfo();
//		System.out.println(b2);
//		System.out.println("----------");
		
		Belloy b1 = Belloy.getBelloy();
		b1.printInfo();
		System.out.println(b1);
		System.out.println("==========");
		
		Belloy b2 = Belloy.getBelloy();
		b2.printInfo();
		System.out.println(b2);
		System.out.println("==========");
		
		
	}
}
