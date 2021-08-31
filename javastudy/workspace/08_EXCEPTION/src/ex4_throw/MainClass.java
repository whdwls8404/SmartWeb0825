package ex4_throw;

import java.util.Scanner;

public class MainClass {

	private static Scanner sc = new Scanner(System.in);
	
	// 만약에 exception 처리를 따로따로 하고 싶으면 어떻게 하나요?
	// 예외 클래스를 직접 만들어서 던지면 된다.
	
	public static void method1() {
		try {
			System.out.print("점수 입력(0~100) >>> ");
			int score = sc.nextInt();
			if (score < 0 || score > 100) {  // 예외의 직접 처리
				throw new RuntimeException();
			}
			if (score >= 60) {
				System.out.println("합격입니다.");
			} else {
				System.out.println("불합격입니다.");
			}
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
	}
	
	public static void method2() throws NumberFormatException, NullPointerException {  // 던지는 예외를 throws 명시
		if (Math.random() < 0.5) {
			throw new NumberFormatException();
		} else {
			throw new NullPointerException();
		}
	}
	
	public static void main(String[] args) {
		// method1();
		try {
			method2();
		} catch (Exception e) {
			System.out.println("예외 발생");
		}
	}

}
