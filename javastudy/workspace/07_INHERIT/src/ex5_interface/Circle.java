package ex5_interface;

// public class Circle extends Shape {  // 클래스를 상속 받는 경우

public class Circle implements Shape {  // 인터페이스를 상속 받는 경우 (X)
										// 인터페이스를 구현하는 경우 (O)

	private int r;

	public Circle(int r) {
		super();
		this.r = r;
	}
	
	@Override
	public double getArea() {
		return Math.PI * r * r;
	}
	
}
