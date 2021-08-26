package ex10_overloading;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println( calc.addition(1, 2) );
		System.out.println( calc.addition(1.5, 1.5) );

	}

}
