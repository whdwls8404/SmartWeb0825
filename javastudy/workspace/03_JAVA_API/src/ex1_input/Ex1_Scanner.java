package ex1_input;

// 클래스 import
// import는 직접 작성하지 않는다. 클래스를 입력할 때 자동 완성(Ctrl + Spacebar)을 이용한다.
import java.util.Scanner;

public class Ex1_Scanner {

	public static void main(String[] args) {
		
		/*
			패키지(package)
			1. 모든 클래스는 특정 패키지 소속이다.
			2. JVM은 java.lang(자바랭) 패키지에 저장된 모든 클래스를 import 없이 인식한다. (기본 패키지 : java.lang)
			   java.lang.String
			   java.lang.System
			   java.lang.Integer
			   java.lang.Long
			   java.lang.Double
			3. java.lang 이외의 패키지에 저장된 모든 클래스는 import가 필요하다.
		*/

		/*
		 * Scanner 클래스
		 * 1. 입력 받는 메소드를 제공하는 클래스이다.
		 * 2. java.util 패키지 소속이다.
		 * 3. import가 필요하다.
		 */
		
		// Scanner 클래스를 이용해서 객체를 생성한 뒤 사용한다.
		// 클래스명 : Scanner  (타입)
		// 객체명   : sc       (변수)
		
		// 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 객체 sc는 입력 메소드를 사용할 수 있다.
		// nextInt() : int 입력
		// nextLong() : long 입력
		// nextDouble() : double 입력
		// nextLine() : String 입력 - 엔터를 입력의 끝으로 본다.
		// next() : String 입력 - 공백문자(white space : 스페이스바, 탭, 엔터)를 입력의 끝으로 본다.
		
		System.out.print("몇 살이니? ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("이름이 뭐니? ");
		String name = sc.nextLine();
				
		System.out.println("넌 " + name + "이고, " + age + "살이구나~");
		
		// 생략 가능한 코드. JVM이 스스로 닫는다.
		sc.close();
		
	}

}
