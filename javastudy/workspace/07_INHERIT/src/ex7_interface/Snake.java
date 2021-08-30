package ex7_interface;

// 애완동물이다.   extends Pet
// 산책할 수 없으므로 implements Walkable 하지 않는다.

public class Snake extends Pet {  // Dog, Cat과 달리 Walkable 타입이 없는 Snake
	public Snake(String name) {
		super(name);
	}
}
