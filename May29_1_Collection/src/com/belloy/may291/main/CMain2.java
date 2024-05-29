package com.belloy.may291.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.belloy.may291.student.Student;

public class CMain2 {
	public static void main(String[] args) {
		// 학생 객체 - 이름 / 국어 / 영어 / 수학 + 속성들 출력 기능
		
		// 학생의 번호를 입력하면 => 그 학생의 정보를 출력할건데
		// 이 때 어떤걸 써야 할까요 ?
		// 학생 4명 생성
		
		// [] -> x
		// List -> o
		// Set -> x
		// Map -> o
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("ㅋㅋ", 30, 20, 10));
		students.add(new Student("ㅎㅎ", 70, 50, 40));
		students.add(new Student("ㅇㅇ", 80, 90, 20));
		students.add(new Student("ㅁㅁ", 50, 100, 60));
		
		Scanner k = new Scanner(System.in);
		System.out.print("번호 : ");
		int no = k.nextInt();
		
		// 해당 번호 학생의 전체 정보가 출력되게
		students.get(no - 1).printInfo();
		
		
	}
}
