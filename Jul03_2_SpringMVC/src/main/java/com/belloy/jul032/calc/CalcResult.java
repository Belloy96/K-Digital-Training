package com.belloy.jul032.calc;

// 요청파라미터와 JavaBean(객체를 찍어낼 클래스) 멤버변수명을 같게!
// 자동으로 요청파라미터의 값을 JavaBean객체에 넣어줌!
public class CalcResult {
	private String n;
	private int x;
	private int y;
	
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}

	public CalcResult(String n, int x, int y) {
		super();
		this.n = n;
		this.x = x;
		this.y = y;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
