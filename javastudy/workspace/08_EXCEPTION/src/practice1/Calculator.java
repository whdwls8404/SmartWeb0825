package practice1;

public class Calculator {

	public int plus(int a, int b) {
		return a + b;
	}
	
	public double plus(double a, double b) {
		return a + b;
	}
	
	public int plus(String a, String b) {
		return Integer.parseInt(a) + Integer.parseInt(b);  // NumberFormatException 발생 가능
	}
	
}
