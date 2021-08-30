package ex4_abstract;

public class Circle extends Shape {

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
