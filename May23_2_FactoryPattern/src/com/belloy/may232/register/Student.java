package com.belloy.may232.register;

public class Student {
	private int num; 		// 번호값을 넣을 멤버변수 생성
	private String name;
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(age);
	}
}
