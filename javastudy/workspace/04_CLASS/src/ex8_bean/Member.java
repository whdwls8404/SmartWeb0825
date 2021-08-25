package ex8_bean;

public class Member {

	// bean
	// 데이터를 저장하는 객체
	// 반드시 getter와 setter가 필요
	
	// field
	private String id;
	private String password;
	private boolean korean;
	
	// setter
	public void setId(String str) {
		id = str;
	}
	public void setPassword(String str) {
		password = str;
	}
	public void setKorean(boolean kor) {
		korean = kor;
	}
	// getter
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public boolean isKorean() {
		return korean;
	}
	
}
