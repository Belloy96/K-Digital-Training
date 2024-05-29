package com.belloy.may242.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2 {
	// 뭔가 입력 받을건데
	// a/b/c/f/d/e/f/g/...
	// ex) 1/2/a/3 => 총합 : 6 / 평균 : 2
	// 숫자라면.. 총합을 구하고 / 평균을 구하고 => 출력
	// 글자라면.. 넘기게
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력(a/b/c/d/... : ");
		String s = k.next();
		System.out.println(s);
		
		StringTokenizer st = new StringTokenizer(s, "/");
		
		int n = 0;
		int sum = 0;
		int count = 0;
		
		while (st.hasMoreTokens()) {	// 토큰 다 사라질 때까지 반복문 돌림
			try {
				n = Integer.parseInt(st.nextToken());
				count++;
				sum += n;
			} catch (Exception e) {
				
			}
		}
		System.out.printf("총합 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", (double)sum / count);
	}
	
}
