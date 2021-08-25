package ex4_logical;

public class Ex3_condition {

	public static void main(String[] args) {
		
		// 조건 연산 (삼항 연산)
		// 연산 결과가 true/false일 때 다르게 구성되는 연산
		// 비교(논리) 연산 ? true : false
		
		int score = 50;
		int money = score >= 70 ? 10000 : 100;  // 70점 이상 10000, 아니면 100
		System.out.println(money);
		
		// 연습문제.
		// 짝수 : 2로 나눈 나머지 값이 0인 수
		// 홀수 : 2로 나눈 나머지 값이 1인 수
		int n = 0;
		System.out.println(n % 2 == 0 ? "짝수" : "홀수");
		
		// 3의 배수 : 3으로 나눈 나머지 값이 0인 수
		System.out.println(n != 0 && n % 3 == 0 ? "3의배수" : "3의배수아님");

	}

}
