package com.koreait.ex08.domain;

import java.sql.Date;

public class Contact {

	// field
	private int no;
	private String name;
	private String tel;
	private String address;
	private Date birthday;
	
	// getter
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthday() {
		return birthday;
	}
	
	// constructor
	public Contact(ContactBuilder builder) {
		this.no = builder.no;
		this.name = builder.name;
		this.tel = builder.tel;
		this.address = builder.address;
		this.birthday = builder.birthday;
	}
	
	// ContactBuilder 클래스
	public static class ContactBuilder {
		
		// field
		private int no;
		private String name;
		private String tel;
		private String address;
		private Date birthday;
		
		// constructor
		public ContactBuilder() {
			// TODO Auto-generated constructor stub
		}

		// setter
		// ContactBuilder 반환
		public ContactBuilder setNo(int no) {
			this.no = no;
			return this;
		}
		public ContactBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public ContactBuilder setTel(String tel) {
			this.tel = tel;
			return this;
		}
		public ContactBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		public ContactBuilder setBirthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}
		
		// build() : Contact 반환
		public Contact build() {
			return new Contact(this);
		}
		
	}
	
}
