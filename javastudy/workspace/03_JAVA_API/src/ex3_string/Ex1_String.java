package ex3_string;

public class Ex1_String {

	public static void main(String[] args) {
		
		// 1. 길이
		String str = "java";
		System.out.println(str.length());

		// 2. 동등 비교
		System.out.println(str.equals("JAVA"));
		System.out.println(str.equalsIgnoreCase("JAVA"));  // 대소문자 무시하고 비교
		
		// 인덱스 (index)
		// 문자마다 부여된 고유 번호
		// 0부터 순차적으로 부여
		
		// 3. 특정 문자 하나 추출
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		
		// 4. 특정 문자열 추출
		// substring(begin) : 인덱스 begin부터 끝까지 추출한다.
		// substring(begin, end) : begin <= 추출범위 < end
		System.out.println(str.substring(1));  // ava
		System.out.println(str.substring(0, 2));  // ja
		
		
		// 5. 특정 문자(열)의 인덱스 반환
		// 발견된 첫 번째 문자(열)의 인덱스를 반환
		System.out.println(str.indexOf("j"));
		System.out.println(str.indexOf("a"));
		System.out.println(str.indexOf("v"));
		
		
		// 6. 특정 문자(열)의 인덱스 반환
		// 발견된 마지막 문자(열)의 인덱스를 반환
		System.out.println(str.lastIndexOf("j"));  // 0
		System.out.println(str.lastIndexOf("a"));  // 3
		System.out.println(str.lastIndexOf("v"));  // 2
		
		
		// 연습문제.
		// 파일이름을 파일명 + 확장자로 분리하기
		String origin = "butter.mp3";
		String filename = null;
		filename = origin.substring(0, origin.lastIndexOf("."));
		String extname = null;
		extname = origin.substring(origin.lastIndexOf(".") + 1);
		System.out.println(filename);
		System.out.println(extname);
		
		// 7. 특정 패턴으로 시작하는가?
		System.out.println(str.startsWith("ja"));  // "ja"로 시작하면 true, 아니면 false
		
		// 8. 특정 패턴으로 끝나는가?
		System.out.println(str.endsWith("va"));  // "va"로 끝나면 true, 아니면 false
		
		// 9. 치환 (찾아 바꾸기)
		System.out.println(origin.replace("mp3", "mp4"));
		origin = origin.replace("mp3", "mp4");
		System.out.println(origin);
		
		// 10. 문자열 좌우의 공백문자 제거 (중간은 안 됨)
		String name = "tom cruise ";
		System.out.println(name.trim().length());
		
	}

}
