package com.belloy.may232.register;

// 공장 역할을 할 클래스(계속 찍어내기 때문)
public class Academy {
	private int studentCount; 	

	// 객체 만들때 사용할 메소드
	public Student consult(String name, int age) {
		studentCount++;
		Student s = new Student(studentCount, name, age);
		return s;
	}
}
