package ex14_singleton;

public class Calculator {

	// field
	private static Calculator calc;  // static 필드는 1개만 만들어 진다.
	
	// new Calculator() 호출은 클래스 내부에서 한다.
	private Calculator() {
		
	}
	
	// method
	public static Calculator getCalc() {
		if (calc == null) {
			calc = new Calculator();
		}
		return calc;
	}
	
}
