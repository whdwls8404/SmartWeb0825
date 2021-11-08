package test;

// TestInterface를 구현하는 클래스
// TestInterface(부모)
// TestA(자식)
public class TestA implements TestInterface {
	// 반드시 모든 추상메소드를 오버라이드 해야 한다.
	@Override
	public void doSome() {
		// TODO Auto-generated method stub
		System.out.println("TestA");
	}
}
