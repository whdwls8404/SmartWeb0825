package ex2_loop;

public class Ex3_while_break {

	public static void main(String[] args) {
		
		// 통장에서 돈 빼기
		int bank = 100000;
		int money = 100;
		
		while (true) {
			
			// while문 시작
			// 그만하고 싶은 조건 처리를 한다.
			if (bank < money) {
				break;  // while문 종료
			}
			
			System.out.println(bank + "원에서 " + money + "원 뺀다.");
			bank -= money;
			money += 100;
			
		}

	}

}
