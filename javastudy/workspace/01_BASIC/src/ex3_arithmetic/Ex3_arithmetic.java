package ex3_arithmetic;

public class Ex3_arithmetic {

	public static void main(String[] args) {
		
		// 대입 연산
		// = : assignment(대입)
		// 오른쪽 값을 왼쪽에 넣는다.
		int x = 10;
		
		// 값 교환하기 (swap)
		int a = 1;
		int b = 2;
		int temp;  // 임시 변수
		
		// 라인이동 : 선택 후 Alt + 방향키
		System.out.println(a);
		System.out.println(b);
		temp = a; a = b; b = temp;  // 교환
		System.out.println(a);
		System.out.println(b);
		System.out.println(temp);

	}

}
