package ex3_arithmetic;

public class Ex4_arithmetic {

	public static void main(String[] args) {
		
		// 복합대입 연산
		// +=, -=, *=, /=, %=
		
		int money = 1000;
		
		money = money + 1000;  // 기존 money를 1000 증가시킨다.
		money += 1000;  // 위 코드와 완벽히 같다.
		
		System.out.println(money);
		
		money =+ 1000;
		System.out.println(money);	

	}

}
