package ex2_casting;

public class Ex2_String {

	public static void main(String[] args) {
		
		// 1. String -> int, long, double
		int a = Integer.parseInt("123");
		long b = Long.parseLong("123");
		double c = Double.parseDouble("3.14");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		// 2. int, long, double -> String
		// 방법이 많다.
		String str1 = String.valueOf(123);
		Long n = 123L;
		String str2 = n.toString();
		String str3 = 3.14 + "";
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

	}

}
