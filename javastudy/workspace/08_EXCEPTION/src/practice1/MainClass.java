package practice1;

public class MainClass {

	public static void main(String[] args) {
		
		// 메소드에서 예외가 발생하는 경우
		// 1. 메소드 내부에서 처리한다.
		// 2. 메소드 호출에서 처리한다.
		
		Calculator calc = new Calculator();
		
		try {
			System.out.println(calc.plus(1, 1));
			System.out.println(calc.plus(1.5, 1.2));
			System.out.println(calc.plus("1", "1"));
			System.out.println(calc.plus("1.5", "1.2"));
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}

	}

}
