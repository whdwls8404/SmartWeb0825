package ex3_method;

public class MainClass {

	public static void main(String[] args) {
		
		Person p = new Person();

		String result1 = p.bibigi("물", "밀가루");
		String result2 = p.bibigi("물", "쌀가루");
		String result3 = p.bibigi("술", "우유");
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}

}
