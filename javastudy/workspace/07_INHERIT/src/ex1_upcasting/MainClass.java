package ex1_upcasting;

public class MainClass {

	// upcasting
	// 1. 자식 객체를 부모 타입에 저장할 수 있다.
	// 2. 별도의 코드 없이 자동으로 진행된다.
	// 3. 부모 클래스의 메소드만 호출할 수 있다.
	// 4. 자식 클래스의 메소드를 호출하려면 강제 casting을 해야 한다.
	
	public static void main(String[] args) {
		
		// casting이 없는 경우
		EV ev1 = new EV();
		ev1.drive();
		ev1.charge();
		
		// upcasting을 사용하는 경우
		Car ev2 = new EV();
		ev2.drive();
		// ev2.charge();
		((EV)ev2).charge();
		
	}

}
