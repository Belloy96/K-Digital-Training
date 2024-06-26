package com.belloy.db.franc.reservation;

import java.util.Date;

// DTO, VO(value object), JavaBean
public class Reservation {
	private int no;
	private String name;
	private Date when;
	private String phonenum;
	private String location;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(int no, String name, Date when, String phonenum, String location) {
		super();
		this.no = no;
		this.name = name;
		this.when = when;
		this.phonenum = phonenum;
		this.location = location;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
