package ex04_char_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
	FileReader 클래스
	
	1. 문자 기반의 입력 스트림이다.
	2. 문자를 읽을 때 사용한다.
	   1) 통신 : 상대방이 보낸 문자를 읽을 때
	   2) 파일 : 텍스트 파일을 읽을 때
	3. 입력 메소드
	   read()
	4. 입력 단위
	   int, char[]
*/

public class MainClass {

	public static void method1() {
		
		try (FileReader fr = new FileReader("text1.txt")) {
			
			// int 단위로 읽기 (한 글자씩 읽기)
			while (true) {
				
				int ch = fr.read();  // 읽은 문자 또는 -1(파일이 끝난 경우)이 ch에 저장
				if (ch == -1) {
					System.out.println("\ntext1.txt 파일을 모두 읽었습니다.");
					break;
				}
				System.out.print((char)ch);  // ch는 코드값으로 저장되므로 char로 캐스팅
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void method2() {
		
		try (FileReader fr = new FileReader("text2.txt")) {
			
			char[] cbuf = new char[5];

			while (true) {
				
				int readCount = fr.read(cbuf);  // 읽은 내용은 cbuf에 저장되고, 실제로 읽은 글자 수는 readCount에 반환된다.
				                                // 파일이 끝나면 readCount는 -1이다.
				// cbuf : 안 녕 하 세 요 , readCount : 5
				// cbuf : \n 반 갑 습 니 , readCount : 5
				// cbuf : 다 \n 갑 습 니 , readCount : 2
				
				if (readCount == -1) {
					System.out.println("\ntext2.txt 파일을 읽었습니다.");
					break;
				}
				for (int i = 0; i < readCount; i++) {
					System.out.print(cbuf[i]);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		method2();
	}

}
