package com.belloy.jun202.main;

public class Guest_Answer {
	private String name;
	private double height;
	private double weight;
	private double bmi;
	private String photo;
	private String status;
	
public Guest_Answer() {
	// TODO Auto-generated constructor stub
}

public Guest_Answer(String name, double height, double weight, double bmi, String photo, String status) {
	super();
	this.name = name;
	this.height = height;
	this.weight = weight;
	this.bmi = bmi;
	this.photo = photo;
	this.status = status;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public double getBmi() {
	return bmi;
}

public void setBmi(double bmi) {
	this.bmi = bmi;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	
}
