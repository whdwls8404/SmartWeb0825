package ex5_String;

public class Ex2_equal {

	public static void main(String[] args) {
		
		// 문자열 동등 비교
		// 1. == 를 이용할 수 없다.
		// 2. equals() 메소드를 이용해서 비교할 수 있다.

		String str1 = new String("hello");
		String str2 = "hello";
		
		System.out.println(str1 + ", " + str2);
		System.out.println(str1 == str2);  // false (참조 비교, 주소 비교)
		
		System.out.println(str1.equals(str2));  // 문자열 자체 비교
		System.out.println(str2.equals(str1));
		
		// 문자열이 같은 위치에 있다면,
		// == 결과는 true이다.
		String str3 = "apple";
		String str4 = "apple";  // 문자열 리터럴("apple")은 JVM에 의해서 최적화된다.
		
		// str4의 "apple"은 str3에서 만든 "apple"이 사용된다. 
		System.out.println(str3 == str4);  // true (문자열 비교를 한 것이 아니고 주소가 같아서 true이다.)
		
	}

}
