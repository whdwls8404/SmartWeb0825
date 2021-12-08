package com.koreait.ex09.dto;

public class Contact {

	// field
	private int no;
	private String name;
	private String tel;
	private String address;
	private String birthday;
	
	// getter/setter
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
	public String getBirthday() {
		return birthday;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	// constructor
	public Contact(ContactBuilder builder) {
		this.no = builder.no;
		this.name = builder.name;
		this.tel = builder.tel;
		this.address = builder.address;
		this.birthday = builder.birthday;
	}
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	// ContactBuilder 클래스
	public static class ContactBuilder {
		
		// field
		private int no;
		private String name;
		private String tel;
		private String address;
		private String birthday;
		
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
		public ContactBuilder setBirthday(String birthday) {
			this.birthday = birthday;
			return this;
		}
		
		// build() : Contact 반환
		public Contact build() {
			return new Contact(this);
		}
		
	}
	
}
