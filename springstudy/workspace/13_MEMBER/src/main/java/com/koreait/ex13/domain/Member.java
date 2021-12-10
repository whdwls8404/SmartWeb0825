package com.koreait.ex13.domain;

import java.sql.Date;

public class Member {

	private Long no;
	private String id, pw, name, email;
	private int state;
	private Date registed;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getRegisted() {
		return registed;
	}
	public void setRegisted(Date registed) {
		this.registed = registed;
	}
	
}
