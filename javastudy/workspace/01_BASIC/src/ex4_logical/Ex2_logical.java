package ex4_logical;

public class Ex2_logical {

	public static void main(String[] args) {
		
		// 논리 연산
		// 1. && : 논리 AND, 모든 비교 연산 결과가 true이면 true, 아니면 false
		// 2. || : 논리 OR,  비교 연산 결과가 하나라도 true이면 true, 아니면 false
		// 3. !  : 논리 NOT, 비교 연산 결과를 반대로 변경
		
		int x = 10;
		int y = 10;
		
		System.out.println(x == 10 && y == 10);  // true
		System.out.println(x == 20 && y == 10);  // false
		
		System.out.println(x == 10 || y == 10);  // true
		System.out.println(x == 20 || y == 10);  // true
		System.out.println(x == 20 || y == 20);  // false
		
		System.out.println( !(x == 10) );  // false
		System.out.println( !(x == 20) );  // true
		
		
		// 1. ! 연산은 가급적 사용하지 않는다.
		// 2. && 연산은 false 발생 시 더 이상 연산을 진행하지 않고,
		//    || 연산은 true 발생 시 더 이상 연산을 진행하지 않는다.
		
		System.out.println(x == 20 && ++y > 10);  // false
		System.out.println(y);  // 10
		
		System.out.println(x == 10 || ++y > 10);  // true
		System.out.println(y);  // 10
		
	}

}
