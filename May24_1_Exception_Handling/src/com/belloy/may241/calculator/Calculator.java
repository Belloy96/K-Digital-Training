package com.belloy.may241.calculator;

public class Calculator {
	// 1. 여기서 아예 끝장을 보자! : try - catch - finally
	// 정상 : 7 - 8 - 9 - [14 - 15 - 16] - 10 ( [] : finally)
	// 무게값으로 0 : 7 - 8 - 9(Arith) - 11 - 12 - [14 - 15 - 16] - 13
	public static int divide(int price, int weight) {
		try {
			int d = price / weight;
			return d;
		} catch (Exception e) {
			System.out.println("으엑!");
			return -9999;
		} finally {
			System.out.println("zzzzzz");
		}
	}
	
	// 2. 미루기 : throws => try보다 더 주력
	//	divide2를 실행하다가 Exception이 터지면 
	//	divide2를 호출한 쪽에서 해결해라!!!
	public static int divide2(int price, int weight) throws Exception{
		int d = price / weight;
		return d;
	}
	
//	private int price;
//	private int gram;
//	private double result;
//	
//	public Calculator() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Calculator(int price, int gram, double result) {
//		super();
//		this.price = price;
//		this.gram = gram;
//		this.result = result;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public int getGram() {
//		return gram;
//	}
//
//	public void setGram(int gram) {
//		this.gram = gram;
//	}
//
//	public double getResult() {
//		return result;
//	}
//
//	public void setResult(double result) {
//		this.result = result;
//	}
//	
//	public void calculate() {
//		result = price / gram;
//		System.out.printf("g당 가격은 %.1f원 입니다.", result);
//	} 강사님은 1회성이라고 판단 static으로 진행
	
	
}
