package com.belloy.may241.main;

public class EMain2 {
	public static void main(String[] args) {
		// Exception의 종류
		
		// 1. NullPointerException
		//		객체참조가 없는 상황
		//		null값이 있는 참조변수로 .XXX()를 사용할 때 자주 발생
//		String s = null;
//		System.out.println(s.length());
		
		// 2. ArrayIndexOutOfBoundsException
		//		배열에서 인덱스의 범위를 초과하게 되는 상황에서 발생
//		int[] ar = { 1, 2, 3 };
//		System.out.println(ar[3]);
		
		// 3. NumberFormatException
		//		문자열(String) => 숫자(int, double)로 바꾸는 상황에서
		//		변환할 수 없는 문자가 있는 상황에서 발생
		String s = "a12345";
		int i = Integer.parseInt(s);
		System.out.println(i + 20);
		
	}
}
