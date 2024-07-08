package com.belloy.jul082.fruit;

import java.math.BigDecimal;

public class Fruit {
	private String f_name;
	private BigDecimal f_price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String f_name, BigDecimal f_price) {
		super();
		this.f_name = f_name;
		this.f_price = f_price;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public BigDecimal getF_price() {
		return f_price;
	}

	public void setF_price(BigDecimal f_price) {
		this.f_price = f_price;
	}
	
}
