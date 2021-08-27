package ex4_constructor;

public class EV extends Car {
	public EV() {  // 자식이 생기려면 부모가 먼저 생겨야 한다.
		super();  // super (부모 클래스) -> 부모 클래스의 생성자 호출
		System.out.println("EV 생성 완료!");
	}
}
