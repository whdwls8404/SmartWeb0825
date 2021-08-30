package ex6_interface;

// 인터페이스는 2개 이상을 구현할 수 있다.

public class SmartPhone implements Phone, Computer {

	@Override
	public void sendCall() {
		System.out.println("전화걸기");
	}

	@Override
	public void sendSMS() {
		System.out.println("문자보내기");
	}
	
	@Override
	public void playGame() {
		System.out.println("게임하기");
	}
	
	@Override
	public void listenMusic() {
		System.out.println("음악듣기");
	}
	
}
