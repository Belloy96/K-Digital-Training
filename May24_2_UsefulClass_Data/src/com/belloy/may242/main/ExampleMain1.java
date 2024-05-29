package com.belloy.may242.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExampleMain1 {
	// 학생의 ( 이름/생년월일(yyyy.MM.dd)/국어/수학/영어 ) 를 입력받아서
	// 학생의 나이, 총점, 평균점수 값을 출력
	// split으로 만들었다면 StringTokenizer로도 만들어 보기(새로운 Class에서)
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("이름/생년월일(yyyy.MM.dd)/국어/수학/영어 입력 : ");
		String s = k.next();
		String[] sData = s.split("/");
		
		//이름
		String name = sData[0];
		System.out.printf("이름 : %s\n", name);
		
		try {
			// 생일(나이)
			String bd = sData[1];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			Date birthday = sdf.parse(bd);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E");
			String birthdayStr = sdf2.format(birthday);
			System.out.printf("생일 : %s\n", birthdayStr);
			
			Date now = new Date();
			SimpleDateFormat yrFmt = new SimpleDateFormat("yyyy");
			String nowYr = yrFmt.format(now);
			String birthdayYr = yrFmt.format(birthday);
			
			int ny = Integer.parseInt(nowYr);
			int by = Integer.parseInt(birthdayYr);
			int age = ny - by;
			System.out.printf("나이 : %d살\n", age);
//	둘다가능	System.out.printf("나이 : %d살\n", now.getYear() - birthday.getYear());
			
			int kor = Integer.parseInt(sData[2]);
			int math = Integer.parseInt(sData[3]);
			int eng = Integer.parseInt(sData[4]);
			
			System.out.printf("국어 : %d점\n", kor);
			System.out.printf("수학 : %d점\n", math);
			System.out.printf("영어 : %d점\n", eng);
			
			int sum = kor + math + eng;
			System.out.printf("총점 : %d점\n", sum);
			
			double avg = (double) sum / 3;
			System.out.printf("총점 : %.2f점\n", avg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
