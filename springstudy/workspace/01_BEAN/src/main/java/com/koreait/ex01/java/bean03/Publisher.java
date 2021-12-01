package com.koreait.ex01.java.bean03;

public class Publisher {

	private String name;
	private String tel;
	
	public Publisher() {
		
	}
	public Publisher(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
