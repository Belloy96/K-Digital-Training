package com.belloy.jun241.main;

import java.util.Random;

public class Test {

	// 001 ~ 011
	// 012 ~ 987 - 답이 될 수 있음
	// 988 ~ 999
	
	public static String pickAns() {
		int a = new Random().nextInt(976) + 12;	// 12 ~ 987
		String ans = String.format("%03d", a);	// "012" ~ "987"
		
		// charAt() : 해당 인덱스에 있는 문자를 반환
		// char 자료형은 acsii (특정 정수값) 코드값으로 사용되기 때문에(==사용함)
		if (ans.charAt(0) == ans.charAt(1) 
				|| ans.charAt(0) == ans.charAt(2)
				|| ans.charAt(1) == ans.charAt(2)) {
			return pickAns();
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String ans = pickAns();
		System.out.println(ans);
	}
	
	
	
}












