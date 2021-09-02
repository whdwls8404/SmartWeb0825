package ex9_byte_BufferedInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("byte2.txt"))) {
			
			byte[] b = new byte[5];
			int readCount = 0;
			
			while ( (readCount = bis.read(b)) != -1 ) {
				// 바이트 배열 b -> 문자열 String
				// new String(b)
				System.out.print(new String(b, 0, readCount));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
