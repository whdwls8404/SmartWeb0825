package ex6_byte_FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
	FileOutputStream 클래스
	
	1. 바이트 기반의 출력 스트림이다.
	2. 모든 것을 보낼 때 사용하다.
	   1) 통신 : 상대방에게 데이터를 보낼 때
	   2) 파일 : 모든 파일을 만들 때
	3. 출력 메소드
	   write()
	4. 출력 단위
	   int, byte[]
*/

public class MainClass {

	public static void main(String[] args) {
		
		try (FileOutputStream fos = new FileOutputStream("byte1.txt")) {
			
			String str1 = "Hello. Nice to meet you.";
			String str2 = "안녕. 만나서 반가워.";
			
			fos.write( str1.getBytes() );  // 문자열 -> 바이트 배열 : getBytes()
			fos.write('\n');
			fos.write( str2.getBytes() );
			
			System.out.println("byte1.txt 파일이 생성되었다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}







