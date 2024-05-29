package com.belloy.may225.bite;

// 클래스 : 멤버변수, 메소드

// 추상메소드 : 멤버변수, 메소드, 추상메소드
//		=> 객체생성 불가능

// 인터페이스 : 추상메소드, 멤버 상수(변하지 않는 값)
//		=> 객체생성 불가능

public interface Bite {
//	private int a;					// 멤버변수 X
	public static final int B = 3;  // 멤버상수 O
	
//	public void c() {
//		System.out.println("c");
//	} 								// 메소드 X
	
	public abstract void bite();	// 추상메소드 O
		
}
