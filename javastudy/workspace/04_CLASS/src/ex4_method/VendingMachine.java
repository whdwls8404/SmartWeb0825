package ex4_method;

public class VendingMachine {

	// 돈을 받아서 음료를 반환하는 메소드
	// 돈		음료
	// 500		생수
	// 1000		사이다
	// 1500		콜라
	
	// 1. 반환타입 : String (생수, 사이다, 콜라)
	// 2. 메소드명 : pushButton
	// 3. 매개변수 : int 1개
	
	String pushButton(int money) {
		if (money == 500) {
			return "생수";
		} else if (money == 1000) {
			return "사이다";
		} else if (money == 1500) {
			return "콜라";
		} else {
			return money + "원";
		}
	}
	
}
