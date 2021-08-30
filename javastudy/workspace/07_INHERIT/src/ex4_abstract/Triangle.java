package ex4_abstract;

public class Triangle extends Shape {

	private int width;
	private int height;
	
	public Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height * 0.5;
	}
	
}
