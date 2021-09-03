package ex01_char_FileWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
	FileWriter 클래스
	
	1. 문자 기반의 출력 스트림이다.
	2. 문자를 보낼 때 사용한다.
	   1) 통신 : 상대방에게 문자를 보낼 때
	   2) 파일 : 텍스트 파일을 만들 때
	3. 출력 메소드
	   write()
	4. 출력 단위
	   int, char[], String
*/

public class MainClass {

	public static void method1() {

		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("text1.txt");  // 여기서 text1.txt 파일이 생성된다.
			
			// text1.txt 파일로 보낼 데이터
			char[] cbuf = {'h', 'e', 'l', 'l', 'o'};
			String str = " java";
			int ch = '!';
			
			fw.write(cbuf);
			fw.write(str);
			fw.write(ch);
			fw.write('\n');
			fw.write(cbuf, 0, 1);  // 배열 cbuf, 인덱스 0부터, 1개만 쓴다.
			// fw.write(cbuf, 0, cbuf.length);  // 배열 cbuf 전체 내용 쓰기
			
			System.out.println("text1.txt 파일이 생성되었다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void method2() {
		
		/*
			try - catch - resources 문
			1. close() 메소드를 자동으로 호출하는 try문
			2. 형식
			   try (자원 생성) {
			   
			   } catch () {
			   
			   }
		*/
		
		try (FileWriter fw = new FileWriter("text2.txt")) {
			
			fw.write("안녕하세요\n");
			fw.write("반갑습니다\n");
			System.out.println("text2.txt 파일이 생성되었다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		method2();
	}

}
