package ex6_interface;

public class MainClass {

	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone();
		phone.sendCall();
		phone.sendSMS();
		phone.playGame();
		phone.listenMusic();
		
		// 생각해 본다.
		Phone phone2 = new SmartPhone();
		phone2.sendCall();
		phone2.sendSMS();
		((SmartPhone)phone2).playGame();
		((SmartPhone)phone2).listenMusic();
		
		Computer phone3 = new SmartPhone();
		phone3.playGame();
		phone3.listenMusic();
		if (phone3 instanceof SmartPhone) {  // phone3가 SmartPhone인지 확인
			((SmartPhone) phone3).sendCall();
			((SmartPhone) phone3).sendSMS();
		}

	}

}
