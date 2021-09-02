package ex5_char_BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("text3.txt"))) {
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[5];
			
			// read() 메소드가 -1이면 종료한다.
			// read() 메소드가 -1이 아니면 계속한다.
			int readCount = 0;
			
			while ( (readCount = br.read(cbuf)) != -1 ) {
				// 읽은 파일 내용 : cbuf
				// 읽은 글자 수   : readCount
				// cbuf에서 readCount만큼 읽기
				sb.append(cbuf, 0, readCount);
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
