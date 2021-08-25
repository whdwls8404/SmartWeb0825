package ex2_loop;

public class Ex6_continue {

	public static void main(String[] args) {
		
		// 1 ~ 10 사이 정수 중에서 4 ~ 6만 제외하고 출력하기
		
		for (int n = 1; n <= 10; n++) {
			if (n >= 4 && n <= 6) {
				continue;  // for문으로 되돌아간다. continue문 아래 코드는 실행에서 제외된다.
			}
			System.out.println(n);
		}
		
		for (int n = 1; n <= 10; n++) {
			if (n < 4 || n > 6) {
				System.out.println(n);
			}
		}

	}

}
