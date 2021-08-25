package ex1_branch;

public class Ex3_if_elseif {

	public static void main(String[] args) {

		// if - else if문

		// if (비교 연산) {
		//     true 일 때 실행문;
		// } else if (비교 연산) {
		//     true 일 때 실행문;
		// }

		// 첫 번째 분기는 if로 처리하고,
		// 두 번째 분기부터는 else if로 처리한다.

		int score = 75;

		if (score < 0 || score > 100) {
			System.out.println("잘못된 점수이다.");
		} else if (score >= 90) {
			System.out.println("A등급이다.");
		} else if (score >= 80) {
			System.out.println("B등급이다.");
		} else if (score >= 70) {
			System.out.println("C등급이다.");
		} else if (score >= 60) {
			System.out.println("D등급이다.");
		} else {
			System.out.println("F등급이다.");
		}
		
		if (score < 0 || score > 100)
			System.out.println("잘못된 점수이다.");
		else if (score >= 90)
			System.out.println("A등급이다.");
		else if (score >= 80)
			System.out.println("B등급이다.");
		else if (score >= 70)
			System.out.println("C등급이다.");
		else if (score >= 60)
			System.out.println("D등급이다.");
		else
			System.out.println("F등급이다.");

	}

}
