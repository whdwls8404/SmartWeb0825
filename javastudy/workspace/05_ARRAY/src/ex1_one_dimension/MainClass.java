package ex1_one_dimension;

public class MainClass {

	// static 메소드는 static 메소드만 호출할 수 있다.
	
	private static void method1() {
		
		// Array 이전
		int a, b, c, d, e;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
		e = 50;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		// Array
		// 배열
		// 변수를 여러 개 모아 놓은 자료형이다.
		// 같은 이름 + 식별 번호 조합으로 사용한다.
		
		// 배열 생성
		// 배열의 길이를 결정해서 생성한다.
		int[] arr = new int[5];
		
		// 같은 이름 : arr
		// 식별 번호 : 0, 1, 2, 3, 4 - 인덱스
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
	}
	
	private static void method2() {
		
		int[] arr = new int[5];
		
		// 배열의 길이는 length 필드로 확인 가능하다.
		System.out.println(arr.length);
		
		for (int i = 0; i <= 4; i++) {  // 변수 i는 인덱스를 의미함.
			arr[i] = (i + 1) * 10;
		}
		
		// 배열의 for문 사용 시 반드시 배열의 길이(length)가 표현되도록 코드 작성.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	private static void method3() {
		
		// 배열은 자동으로 0으로 초기화된다.
		
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	private static void method4() {
		
		int[] arr1 = new int[] { 10, 20, 30, 40, 50 };
		int[] arr2 = { 60, 70, 80, 90, 100 };
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
	}
	
	private static void method5() {
		
		// for - each문
		// for ( 변수 : 배열 ) {
		//     변수 사용
		// }
		
		String[] foods = new String[] { "모닝커피", "런치커피" };
		String[] hobbies = { "넷플릭스", "운동" };
		
		for ( String food : foods ) {
			System.out.println(food);
		}
		for ( String hobby : hobbies ) {
			System.out.println(hobby);
		}
		
	}
	
	private static void method6() {
		
		// 배열 요소 수정 : 일반 for문 사용
		// 배열 요소 수정이 없는 경우 : for - each문 사용
		
		int[] arr = new int[5];
		
		// 10 ~ 50까지 저장하기 (수정이므로 일반 for문 사용)
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 10;
		}
		
		// 출력하기 (for - each문 사용)
		for (int number : arr) {
			System.out.println(number);
		}
		
	}
	
	private static void method7() {
		
		// 배열의 이름은 참조 값이다.
		
		// 배열의 크기 늘이기
		// 1. 한 번 생성된 배열은 크기 변경이 불가능하다.
		// 2. 새로운 다른 배열을 만들고, 값을 모두 옮긴 뒤, 참조값을 수정해야 한다.
		
		int[] arr = new int[] { 10, 20, 30, 40, 50 };
		
		// 새로운 다른 배열을 만들고,
		int[] arr2 = new int[10];
		
		// 값을 모두 옮긴 뒤,
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		
		// 참조값을 수정한다.
		arr = arr2;
		
		for ( int number : arr ) {
			System.out.println(number);  // 10 20 30 40 50 0 0 0 0 0
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		method7();
	}

}
