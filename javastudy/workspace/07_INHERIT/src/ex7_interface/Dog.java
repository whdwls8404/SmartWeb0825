package ex7_interface;

// 상속과 인터페이스 구현은 함께 처리할 수 있다.
// 상속 먼저, 구현 나중

// 애완동물이다.    extends Pet
// 산책할 수 있다.  implements Walkable

public class Dog extends Pet implements Walkable {
	public Dog(String name) {
		super(name);
	}
}
