package ex1_exception;

// Exception
// 1. 코드 작성으로 처리할 수 있는 오류이다.
// 2. 모든 예외는 클래스로 구성되어 있다.
// 3. 모든 예외 클래스는 Exception 클래스를 상속받는다.
//    모든 예외 객체는 Exception 타입으로 저장할 수 있다.

public class MainClass {

	public static void main(String[] args) {
		
		// int a = Integer.parseInt("12.3");   // NumberFormatException
		// long a = Long.parseLong("십억");    // NumberFormatException
		// double a = Double.parseDouble("");  // NumberFormatException
		
		// String s = null;
		// s.equals("제임스");  // null.equals("제임스"), NullPointerException (null이 메소드를 호출하는 경우)
		// "제임스".equals(s);  // "제임스".equals(null), NullPointerException이 아니다.
		
		// int[] arr = new int[5];
		// arr[5] = 10;  // 예외 발생
		
		// int a = 4 / 0;  // 예외 발생
		// System.out.println(a);
		
	}

}
