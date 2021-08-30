package ex5_interface;

// 인터페이스
// 1. 일반 메소드가 없는 추상 클래스를 인터페이스로 작성한다.
// 2. jdk 1.8 이후로 default 메소드, static 메소드를 포함할 수 있다.
// 3. 모든 필드는 final 상수를 가진다.

public interface Shape {
	
	double getArea();  // public abstract로 처리된다.

}
