package ex1_variable;

public class Ex3_type {

	public static void main(String[] args) {
		
		/*
		 * 1. double
		 *    1) 8바이트
		 *    2) 실수
		 *    3) 의미 : 실수의 기본값이다.
		 */
		double weight = 60.5;
		System.out.println(weight);
		
		/*
		 * 2. Double
		 *    1) double의 wrapper class이다.
		 *    2) 추가 기능으로 parseDouble() 메소드가 많이 사용된다.
		 */
		Double height = 165.5;
		// "123.5" -> 123.5
		double n = Double.parseDouble("123.5");
		System.out.println(n);

		/*
		 * 3. char
		 *    1) 2바이트 (유니코드)
		 *    2) 문자 (정수)
		 *    3) 의미 : 한 글자를 저장한다. 실제로 저장되는 데이터는 코드값(정수)이다.
		 */
		char a = 'A';
		System.out.println(a);
		
		/*
		 * 4. boolean
		 *    1) JVM이 알아서 저장(이론적으로는 1bit만 필요)
		 *    2) true(참), false(거짓) : 논리데이터
		 */
		boolean korean = true;
		System.out.println(korean);
		
	}

}
