package ex1_branch;

public class Ex4_switch {

	public static void main(String[] args) {
		
		// switch문

		// switch (표현식) {
		// case 결과1:
		//     표현식의 결과가 결과1 일 때 실행문; break;
		// case 결과2:
		//     표현식의 결과가 결과2 일 때 실행문; break;
		// default:
		//     표현식의 결과가 다른 값 일 때 실행문;
		// }

		// 가능한 표현식   : int, char, String
		// 불가능한 표현식 : double, boolean
		
		int n = 14;
		
		switch (n % 2) {
		case 0:
			System.out.println(n + " 짝수이다.");
			break;
		case 1:
			System.out.println(n + " 홀수이다.");
			break;
		}
		
		int score = 70;
		
		switch (score / 10) {
		case 10: case 9:
			System.out.println("A등급이다.");
			break;
		case 8:
			System.out.println("B등급이다.");
			break;
		case 7:
			System.out.println("C등급이다.");
			break;
		case 6:
			System.out.println("D등급이다.");
			break;
		default:
			System.out.println("F등급이다.");
		}
		
		
		// switch문의 주된 용도
		// 명령에 따른 처리 분리
		
		String command = "login";
		switch (command) {
		case "join":
			System.out.println("회원가입하자.");
			break;
		case "login":
			System.out.println("로그인하자.");
			break;
		}
		
	}

}
