package ex1_user_type;

public class MainClass {

	public static void main(String[] args) {
		
		// Member를 만들어 본다.
		// Member : 클래스
		// m      : 객체, 인스턴스
		Member m = new Member();
		
		// m의 필드 사용하기
		m.id = "admin";
		m.password = "1234";
		
		// m의 값 출력하기
		System.out.println(m);
		System.out.println(m.id);
		System.out.println(m.password);
		System.out.println(m.memberNo);  // 0
		System.out.println(m.korean);  // false

	}

}
