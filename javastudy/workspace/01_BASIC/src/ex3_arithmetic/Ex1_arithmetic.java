package ex3_arithmetic;

public class Ex1_arithmetic {

	public static void main(String[] args) {
		
		// 라인복사 : 선택 후 Ctrl + Alt + 방향키
		
		// 수치 연산 (사칙 연산)
		int a = 7;
		int b = 2;
		System.out.println(a + b);  // 9
		System.out.println(a - b);  // 5
		System.out.println(a * b);  // 14
		System.out.println(a / b);  // 7 / 2 => 3 (7을 2로 나눈 몫)
		System.out.println((double)a / (double)b);  // 7.0 / 2.0 => 3.5
		System.out.println((double)a / b);  // 7.0 / 2 => 7.0 / 2.0 (스스로 실수로 맞춤) => 3.5
		System.out.println(a % b);  // 7 % 2 => 1 (7을 2로 나눈 나머지)
		
		// 사칙연산 평가문제 예정
		
	}

}
