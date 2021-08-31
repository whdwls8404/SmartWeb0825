
public class MainClass {

	public static void main(String[] args) {
		
		Member m1 = new Member();
		Member m2 = new Member("admin", "1234");
		
		m1.setId("user");
		m1.setPassword("123456");
		
		System.out.println(m1.getId());
		System.out.println(m1.getPassword());
		
		System.out.println(m2);

	}

}
