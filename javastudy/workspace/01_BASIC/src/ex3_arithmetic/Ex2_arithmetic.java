package ex3_arithmetic;

public class Ex2_arithmetic {

	public static void main(String[] args) {
		
		// 증감연산
		
		int x = 10;
		int y = 10;
		
		System.out.println(x++);  // x 출력 후 증가, 10
		System.out.println(++x);  // 증가 후 x 출력, 12
		
		System.out.println(--y);  // 감소 후 y 출력, 9
		System.out.println(y--);  // y 출력 후 감소, 9
		
		System.out.println(x++ + --y);  // 12 + 7
		
	}

}
