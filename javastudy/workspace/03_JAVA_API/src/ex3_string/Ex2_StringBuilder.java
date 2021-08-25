package ex3_string;

public class Ex2_StringBuilder {

	public static void main(String[] args) {

		
		// String + 연산자
		// 많이 사용하면 성능이 떨어진다.

		
		// StringBuilder 생성 (single thread)
		StringBuilder sb = new StringBuilder();
		
		// 추가 메소드
		for (int i = 0; i < 6; i++) {
			sb.append( (int)(Math.random() * 10) );
		}
		
		// StringBuilder -> String 변환
		String authCode = sb.toString();
		System.out.println(authCode);
		
		
		// StringBuffer 생성 (multiple thread -> thread safe)
		StringBuffer sbf = new StringBuffer();
		
		for (int i = 0; i < 6; i++) {
			sbf.append( (char)((int)(Math.random() * 26) + 'A') );
		}
		
		String authCode2 = sbf.toString();
		System.out.println(authCode2);
		
	}

}
