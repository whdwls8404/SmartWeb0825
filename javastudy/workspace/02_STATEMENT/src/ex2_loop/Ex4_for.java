package ex2_loop;

public class Ex4_for {

	public static void main(String[] args) {
		
		// for문
		
		// for ( 1 ; 2 ; 4 ) {
		//     3
		// }
		// 실행순서 : 1 -> 2 -> 3 -> 4 -> 2 -> 3 -> 4 -> 2 -> ...
		
		// for ( 초기화 ; 비교연산 ; 증감문 ) {
		//     비교연산 결과가 true 일 때 실행문;
		// }
		
		
		// 1. 0부터 9사이 모든 정수 출력
		for ( int n = 0; n <= 9; n++ ) {
			System.out.println(n);
		}
		
		// 2. 0부터 9사이 모든 정수 역순으로 출력
		for (int n = 9; n >= 0; n--) {
			System.out.println(n);
		}
		
		// 연습문제.
		// 구구단 2단만 출력
		for (int n = 1; n <= 9; n++) {
			System.out.println("2x" + n + "=" + (2 * n));
		}

		// 연습문제.
		// 변수 start부터 변수 stop사이 모든 정수 출력
		int start = 5;
		int stop = 1;
		int temp;
		
		if (start > stop) {  // start > stop 이면 교환(swap)
			temp = start;
			start = stop;
			stop = temp;
		}
		
		for (int n = start; n <= stop; n++) {  // start <= stop
			System.out.println(n);
		}
		
	}

}
