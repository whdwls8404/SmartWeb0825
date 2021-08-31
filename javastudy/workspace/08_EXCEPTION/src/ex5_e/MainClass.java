package ex5_e;

public class MainClass {

	public static void method1() {
		try {
			String strAge = "44.8";
			int age = Integer.parseInt(strAge);
			System.out.println("나이는 " + age + "살입니다.");
		} catch (NumberFormatException e) {  // 예외 객체 e
			System.out.println(e.getMessage());  // 메시지 : 예외가 발생한 이유
			e.printStackTrace();  // 예외 추적하기
		}
	}

	public static void method2() {
		try {
			throw new RuntimeException("내가 발생시킨 예외이다. 이유 없어.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void method3() {
		try {
			throw new RuntimeException("예외 발생");
		} catch (Exception e) {
			throw new RuntimeException("다시 예외 발생", e);
		}
	}
	
	public static void main(String[] args) {
		method3();
	}

}
