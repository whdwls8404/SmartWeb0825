package ex1_branch;

public class Ex2_if_else {

	public static void main(String[] args) {
		
		// if - else문

		// if (비교 연산) {
		//     true 일 때 실행문;
		// } else {
		//     false 일 때 실행문;
		// }
		
		int n = 14;
		
		if (n % 2 == 0) {
			System.out.println(n + " 짝수이다.");
		} else {
			System.out.println(n + " 홀수이다.");
		}
		
		if (n % 2 == 0)
			System.out.println(n + " 짝수이다.");
		else
			System.out.println(n + " 홀수이다.");
		
	}

}
