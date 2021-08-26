package ex12_constructor;

public class Member {

	private String id;
	private String password;

	// constructor
	// 생성자
	// 객체를 생성할 때 호출되는 메소드
	// 반환타입이 없는 메소드
	// 메소드명이 클래스명과 같은 메소드
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
