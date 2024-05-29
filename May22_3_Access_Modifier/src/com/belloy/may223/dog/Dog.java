package com.belloy.may223.dog;

// 접근제어자 (Access Modifier)
//		멤버변수 or 클래스에서 사용
//		외부에서 (멤버변수나 클래스에) 접근하지 못하도록 제한하는 역할
public class Dog {
							// 접근 범위
	public int a;			// 접근 제한 없음
	
	protected int b;		// 같은 패키지 내 or
							// 다른 패키지라면 그 하위 클래스
							// + 하위 클래스의 객체(인스턴스)를 통해서 접근이 가능 O
	
	/* default */ int c; 	// 같은 패키지 내
							// (default : 아무것도 쓰지 않은 상태)
	
	private int d;			// 같은 클래스 내부에서만 O / 외부에서는 접근 X
}
