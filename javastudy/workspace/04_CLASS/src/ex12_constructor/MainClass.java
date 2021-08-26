package ex12_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		Member m = new Member();
		m.setId("admin");
		m.setPassword("1234");
		System.out.println( m.getId() );
		System.out.println( m.getPassword() );
		
		Member m2 = new Member("alsrudxo", "123456");
		System.out.println( m2.getId() );
		System.out.println( m2.getPassword() );
		
	}

}
