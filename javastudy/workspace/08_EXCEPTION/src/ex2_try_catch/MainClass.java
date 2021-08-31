package ex2_try_catch;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			String strAge = "44";
			int age = Integer.parseInt(strAge);
			System.out.println("당신은 " + age + "살입니다.");
		} catch (NumberFormatException e) {  // try 블록에서 NumberFormatException이 발생하면
			System.out.println("예외 발생"); // 실행된다.
		}
		
		try {
			String name = "앨리스";
			if (name.equals("제임스")) {
				System.out.println("안녕 제임스~");
			} else {
				System.out.println("누구냐 넌?");
			}
		} catch (NullPointerException e) {
			System.out.println("예외 발생");
		}
		
		try {
			int[] arr = new int[5];
			arr[0] = 10;
			System.out.println(arr[0]);
		} catch (Exception e) {  // 모든 예외를 처리할 수 있는 Exception
			System.out.println("예외 발생");
		}

	}

}
