package com.belloy.may225.avengers;

import com.belloy.may225.driver.Driver;
import com.belloy.may225.smoker.Smoker;

public class Ironman extends Avengers implements Smoker, Driver{
	int property;
	
	public Ironman() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Ironman(String name, int age, int property) {
		super(name, age);
		this.property = property;
	}
	
	
	public int getProperty() {
		return property;
	}



	public void setProperty(int property) {
		this.property = property;
	}



	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(property);
	}
	
	@Override
	public void attack() {
		System.out.println("탈모 빔-----");
	}
	
	@Override
	public void smoke() {
		System.out.println("스모크챌린지");
	}
	
	@Override
	public void drive() {
		System.out.println("날아도 되는데 비싼차 타는게 더 쌈@뽕함");
	}
	
}
