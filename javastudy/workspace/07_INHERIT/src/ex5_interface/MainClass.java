package ex5_interface;

public class MainClass {

	public static void main(String[] args) {
		
		// 모든 도형을 저장할 수 있는 Shape 클래스
		Shape[] shapes = new Shape[10];
		
		shapes[0] = new Rectangle(2, 3);  // 사각형, 너비2, 높이3
		shapes[1] = new Square(5);  // 정사각형, 너비5, 높이5
		shapes[2] = new Triangle(2, 3);  // 삼각형, 너비2, 높이3
		shapes[3] = new Circle(1);  // 원, 반지름1
		
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null) {
				System.out.println((i + 1) + "번째 도형 크기: " + shapes[i].getArea());
			}
		}

	}

}
