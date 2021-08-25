package ex1_variable;

/*
 * 1. 자바 이름 규칙
 *    1) 패키지 : 모두 소문자로 작성
 *    2) 클래스 : Upper Camel Case
 *    3) 변수, 메소드 : Lower Camel Case
 *    4) 상수 : Snake Case
 * 2. Case
 *    1) Upper Camel Case : MyFirstName, MyLastName 등
 *    2) Lower Camel Case : myFirstName, myLastName 등
 *    3) Snake Case : MY_FIRST_NAME, MY_LAST_NAME 등
 */

/*
 * 3. 자바 프로젝트 구조
 *    project
 *      ㄴsrc
 *        ㄴpackage
 *          ㄴclass
 * 4. main() 메소드
 *    1) 반드시 있어야 자바 프로젝트가 실행된다.
 *    2) JVM(Java Virtual Machine)은 현재 main() 메소드를 실행하고,
 *       만약 실행에 실패하면, 최근 main() 메소드를 실행한다.
 */

/*
 * 5. 자바 코드 작성
 *    1) 모든 코드는 class(클래스) 내부에 작성한다.
 *    2) 실행 코드는 main() 메소드에 작성한다.
 *    3) 대소문자를 확실히 구분한다.
 * 6. 이클립스의 인텔리전스
 *    1) 코드를 완성해 준다.
 *    2) 입력할 수 있는 코드를 보여준다.
 *    3) Ctrl + Spacebar
 */

public class Ex1_literal {

	public static void main(String[] args) {
		
		// TODO 구현해야 될 내용 작성
		
		/*
		 * 일반 주석
		 */

		/**
		 * javadoc
		 * 자바 문서 만드는 주석
		 */
		
		/*
		System.out.println();  // 출력 + 줄바꿈
		System.out.print();  // 출력
		System.out.printf();  // C 포맷 심볼 호환용  
		*/
		
		/*
		 * 리터럴 (literal)
		 *    1) 데이터를 표기하는 방법
		 *    2) 숫자 : 1, 1.5, 1.5E+5 등
		 *    3) 문자 : 'a', 'A', '한'
		 *    4) 문자열 : "a", "Apple", "한국"
		 *    5) 논리 : true, false
		 *    6) 널 : null
		 */
		
		System.out.println(10);
		System.out.println(1.5);
		System.out.println(1.5555555555);
		System.out.println('a');
		System.out.println('한');
		System.out.println("Apple");
		System.out.println(true);
		System.out.println(false);
		// System.out.println(null);
		
	}  // end main
	
	// main() 메소드 바깥쪽

}  // end class
