package com.belloy.jul031.fruit;

// 객체를 여러 개 등록해서 사용하려면...
//		=> src/main/resources에 xxx.beans.xml ... // beans에 한 것은 고정된 값이여서... 컨셉에 맞지 않음
// singleton
//		root-context.xml		: 톰캣에 실려있는 '프로젝트 전체'에 영향
//		servlet-context.xml		: 이 프로젝트에 영향
//			└ 여기에 객체 등록(singleton패턴을 이용시 사용하는 건 나쁘지 않음)


public class Fruit {
	private String name;
	private int price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
