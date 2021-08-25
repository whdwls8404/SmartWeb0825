package ex1_variable;

public class Ex2_type {

	public static void main(String[] args) {
		
		// 선행 지식
		// 1. 모든 데이터 저장은 "메모리"에 한다.
		// 2. "메모리(램)"는 1바이트마다 고유번호(0부터 시작하는 16진수)를 부여해서 관리한다.

		/*
		 * 1. byte
		 *    1) 1바이트
		 *    2) 정수
		 *    3) 의미 : 모든 데이터(숫자, 문자, 파일 등)의 기본 단위 byte를 의미한다.
		 */
		
		/*
		 * 2. short
		 *    1) 2바이트
		 *    2) 정수
		 *    3) 의미 : 과거 호환용으로 남아 있다.
		 */
		
		/*
		 * 3. int
		 *    1) 4바이트
		 *    2) 정수
		 *    3) 의미 : 정수 기본값이다.
		 */
		
		int age;  // 변수 age의 선언. 4바이트 정수 저장이 가능한 변수 age가 메모리에 생긴다.
		age = 44;
		System.out.println(age);
		
		/*
		 * 4. Integer
		 *    1) int 데이터를 한 번 감싸 놓은 형태이다.
		 *    2) int 데이터 이외에 추가 데이터를 함께 감싸 놓았다.
		 *    3) int 데이터를 처리할 수 있는 기능을 함께 감싸 놓았다.
		 */
		Integer score = 70;  // int 데이터 저장용.
		
		// Integer 클래스에 쌓여 있는 데이터
		System.out.println(Integer.MAX_VALUE);  // int 데이터의 최댓값
		System.out.println(Integer.MIN_VALUE);  // int 데이터의 최솟값
		
		// Integer 클래스에 쌓여 있는 기능(메소드)
		// 문자열 "123" -> 정수 123 변환하는 기능
		int n = Integer.parseInt("123");
		System.out.println(n);
		
		/*
		 * 5. long
		 *    1) 8바이트
		 *    2) 정수
		 *    3) 의미 : int 범위를 벗어나는 정수 저장용이다.
		 */
		long money = 10000000000L;  // int 범위를 벗어나는 정수는 suffix로 L(l)이 필요하다.
		System.out.println(money);
		
		/*
		 * 6. Long
		 *    1) long의 wrapper class이다.
		 *    2) 추가 데이터와 추가 기능이 있다.
		 */
		Long balance = 10000000000L;
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		long number = Long.parseLong("123");
		System.out.println(number);
		
	}

}
