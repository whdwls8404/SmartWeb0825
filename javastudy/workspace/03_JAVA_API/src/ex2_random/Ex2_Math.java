package ex2_random;

public class Ex2_Math {

	public static void main(String[] args) {
		
		// Math 클래스의 난수 생성
		// Math.random() 메소드
		
		// 실수형 난수
		System.out.println(Math.random());
		
		// 정수형 난수 (주사위)
		// 1. Math.random()                 0.0 <= 난수 < 1.0
		// 2. Math.random() * 6             0.0 <= 난수 < 6.0
		// 3. (int)(Math.random() * 6)      0 <= 난수 < 6
		// 4. (int)(Math.random() * 6) + 1  1 <= 난수 < 7
		
		// 정수형 난수 일반화
		// (int)(Math.random() * 갯수) + 시작값
		
		// 연습문제.
		// 0 ~ 9 사이 난수 생성
		System.out.println((int)(Math.random() * 10));
		
		// 숫자로 구성된 6자리 인증번호 생성
		// authCode += 난수;  6번 반복
		String authCode = "";
		for (int n = 0; n < 6; n++) {
			authCode += (int)(Math.random() * 10);
			// authCode = authCode + (int)(Math.random() * 10);
		}
		System.out.println("6자리 인증번호: " + authCode);
		
		// 1 ~ 5 중 하나를 생성한다.
		// 4 이상 생성하면 하나 더 생성한다.
		while (true) {
			int yut = (int)(Math.random() * 5) + 1;
			System.out.println(yut + "칸 이동한다.");
			if (yut <= 3) {
				break;
			}
		}

	}

}
