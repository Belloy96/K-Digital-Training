package com.belloy.may231.Belloy;

public class Belloy {
	private String name;
	private int age;
	private String nickname;
	
	private static final Belloy BELLOY = new Belloy("흰니", 24, "고양이");
	
	
	public static Belloy getBelloy() {
		return BELLOY;
	}
	
	public Belloy() {
		// TODO Auto-generated constructor stub
	}

	public Belloy(String name, int age, String nickName) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickName;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickName(String nickname) {
		this.nickname = nickname;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(nickname);
	}
	
}
