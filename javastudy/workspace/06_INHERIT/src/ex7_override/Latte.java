package ex7_override;

public class Latte extends Espresso {
	@Override  // annotation (JVM에게 오버라이드하는 메소드라고 알림)
	public void taste() {  // 슈퍼 클래스의 taste() 메소드를 똑같은 모습으로 다시 만듬. -> 메소드 오버라이드(메소드 다시 만들기)
		System.out.println("고소해~");
	}
}
