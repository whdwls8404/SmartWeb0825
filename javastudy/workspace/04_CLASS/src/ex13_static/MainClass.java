package ex13_static;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		System.out.println(calc.addition(1, 2));  // 객체를 이용한 static method 호출은 권장하지 않음.

		Calculator calc2 = new Calculator();
		System.out.println(calc2.addition(1, 2));
		
		// static way
		// 객체를 만들지 않고, 클래스를 이용해서 호출
		System.out.println( Calculator.addition(1, 2) );
		
	}

}
