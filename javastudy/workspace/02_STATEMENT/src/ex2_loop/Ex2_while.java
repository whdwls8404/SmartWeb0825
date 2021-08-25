package ex2_loop;

public class Ex2_while {

	public static void main(String[] args) {
		
		// 통장에서 돈 빼기
		// 100 -> 200 -> 300 -> 400 -> ...
		int bank = 100000;
		int money = 100;
		
		while (bank >= money) {
			System.out.println(bank + "원에서 " + money + "원 뺀다.");
			bank -= money;
			money += 100;
		}
		
		System.out.println("잔고 : " + bank + "원");
		System.out.println("빼려던 돈 : " + money + "원");
		
	}
	
}
