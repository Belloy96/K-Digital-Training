package com.belloy.may223.main;

import com.belloy.may223.dog.Dog;

public class AMain1 extends Dog {
	public static void main(String[] args) {
//		Dog dog = new Dog();
//		
//		dog.a = 1;		// public => 접근 o
//		dog.b = 2;		// protected => 상위 클래스이기 때문에 접근 x
//		dog.c = 3;		// default => 같은 패키지가 아니기 때문에 접근 x
//		dog.d = 4;		// private => 같은 클래스가 아니기 때문에 접근 x
		
		AMain1 amain = new AMain1();
		amain.a = 1;	// 'a'는 public, 접근 가능!
		amain.b = 2;	// 'b'는 protected, 접근 가능!
		// AMain1이 Dog의 하위 클래스이고, AMain1의 인스턴스를 통해
		//		protected 멤버변수에 접근 O
		amain.c = 3;	// 'c'는 default, 다른 패키지에 있어서 접근 불가능 !
		amain.d = 4;	// 'd'는 private, 다른 클래스에 있어서 접근 불가능 !
		
		// 접근 범위 순서대로 나열
		// private < default < protected < public
		
		
	}
}
