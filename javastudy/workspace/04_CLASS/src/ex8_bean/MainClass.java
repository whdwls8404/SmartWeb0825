package ex8_bean;

public class MainClass {

	public static void main(String[] args) {
		
		Member m = new Member();
		
		m.setId("admin");
		m.setPassword("1234");
		m.setKorean(true);
		
		System.out.println("아이디: " + m.getId());
		System.out.println("비밀번호: " + m.getPassword());
		System.out.println(m.isKorean() ? "내국인" : "외국인");

	}

}
