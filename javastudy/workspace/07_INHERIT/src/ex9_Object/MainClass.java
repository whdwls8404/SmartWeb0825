package ex9_Object;

public class MainClass {

	public static void main(String[] args) {
		
		Member m1 = new Member("admin", "1234");
		Member m2 = new Member("admin", "1234");
		
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		
		System.out.println(m1);  // m1.toString() 자동으로 호출된다.

	}

}
