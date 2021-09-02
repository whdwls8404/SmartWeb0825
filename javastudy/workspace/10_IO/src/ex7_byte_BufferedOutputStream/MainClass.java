package ex7_byte_BufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("byte2.txt"))) {
			
			String str = "안녕하세요. 반갑습니다.";
			byte[] b = str.getBytes();
			bos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
