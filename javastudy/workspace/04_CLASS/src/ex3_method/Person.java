package ex3_method;

public class Person {

	// 메소드 구성
	// 1. 반환타입 : 결과값의 타입
	// 2. 메소드명
	// 3. 매개변수 : 메소드에 전달되는 입력
	
	
	// 물과 밀가루를 넣으면 밀반죽, 물과 쌀가루를 넣으면 쌀반죽이 나오는 메소드
	// 1. 반환타입 : String (밀반죽 or 쌀반죽)
	// 2. 메소드명 : bibigi
	// 3. 매개변수 : String 2개
	String bibigi(String arg1, String arg2) {
		String result;
		if (arg1.equals("물")) {
			if (arg2.equals("밀가루")) {
				result = "밀반죽";
			} else if (arg2.equals("쌀가루")) {
				result = "쌀반죽";
			} else {
				result = "모름";
			}
		} else {
			result = "모름";
		}
		return result;
	}
	
}
