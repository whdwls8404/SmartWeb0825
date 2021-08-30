package ex7_interface;

// 애완동물이다.   extends Pet
// 산책할 수 있다. implements Walkable

public class Cat extends Pet implements Walkable {
	public Cat(String name) {
		super(name);
	}
}
