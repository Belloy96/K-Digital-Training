package com.belloy.may291.student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("국어 : %d점\n", kor);
		System.out.printf("영어 : %d점\n", eng);
		System.out.printf("수학 : %d점\n", math);
	}
}
