package ex10_overloading;

public class Calculator {

	// 메소드 오버로딩
	// 1. 이름이 같은 메소드를 2개 이상 만들 수 있다.
	// 2. 매개변수가 달라야 한다.
	// 3. 반환타입은 상관이 없다. 
	
	int addition(int a, int b) {
		return a + b;
	}
	double addition(double a, double b) {
		return a + b;
	}
	
}