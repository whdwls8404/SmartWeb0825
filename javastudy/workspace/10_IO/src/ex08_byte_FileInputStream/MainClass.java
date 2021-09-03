package ex08_byte_FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
	FileInputStream 클래스
	
	1. 바이트 기반의 입력 스트림이다.
	2. 모든 데이터를 읽을 때 사용한다.
	   1) 통신 : 상대방이 보낸 데이터를 읽을 때
	   2) 파일 : 모든 파일을 읽을 때
	3. 입력 메소드
	   read()
	4. 입력 단위
	   int, byte[]
*/

public class MainClass {

	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("byte1.txt")) {
			
			int ch = 0;
			while ( (ch = fis.read()) != -1 ) {
				System.out.print((char)ch);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
