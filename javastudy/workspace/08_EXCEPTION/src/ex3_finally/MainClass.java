package ex3_finally;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			System.out.println("입력된 나이는 " + age + "살입니다.");
			
		} catch (Exception e) {
			
			System.out.println("예외가 발생했습니다.");
			
		} finally {  // 무조건 마지막에 실행된다.
			
			sc.close();  // finally 블록은 주로 "자원 반납" 코드가 들어간다.
			System.out.println("프로그램이 종료되었습니다.");
			
		}

	}

}