package ex2_random;

import java.util.Random;

public class Ex1_Random {

	public static void main(String[] args) {
		
		/*
		 * Random 클래스
		 * 1. 난수를 생성하는 클래스이다.
		 * 2. java.util 패키지 소속이다.
		 */
		
		// Random 타입의 random 객체 생성
		Random random = new Random();
		
		// 정수형 난수 - 1
		System.out.println("int 난수: " + random.nextInt());
		
		// 정수형 난수 - 2
		System.out.println("0 ~ 9 사이 난수: " + random.nextInt(10));  // 0부터(정해진 값) 10(bound)개 중 하나의 난수 발생
		
		// 연습문제.
		// 주사위 던지기
		int dice = random.nextInt(6) + 1;
		System.out.println("이번에 던진 주사위는 " + dice + "입니다.");
		
		// 실수형 난수
		System.out.println("0.0 <= 난수 < 1.0 : " + random.nextDouble());
		
		// 0.0 ~ 1.0 범위는 백분율 범위로 보는 것이 타당하다.
		// 0% ~ 100% 범위 = 확률 생성

		// 확률 연습
		// 5% 확률로 "강화 성공", 나머지는 "강화 실패"
		if (random.nextDouble() < 0.05) {
			System.out.println("강화 성공");
		} else {
			System.out.println("강화 실패");
		}
		
	}

}
