package ex2_casting;

public class Ex1_casting {

	public static void main(String[] args) {
		
		// casting
		// 1. 다른 타입으로 변경하는 작업이다.
		// 2. 변경할 변수 앞에 괄호 붙여서 변경할 타입을 작성한다.
		// 3. casting 순간에만 잠깐 변경된다.
		
		int a = 97;
		
		System.out.println( (double)a );
		System.out.println( (char)a );
		
		// 알아두면 좋은 코드 값
		// 48 : '0'
		// 65 : 'A'
		// 97 : 'a'
		
		double b = 99.9;
		System.out.println( (int)b );  // 99 (소수 이하는 모두 잘린다.)
		System.out.println( (char)b );  // 'c'
		
		
		// boolean 타입은 casting 하지 않는다.
		
		
		// String 타입은 casting 이 아니라 parsing 이다.
		

	}

}
