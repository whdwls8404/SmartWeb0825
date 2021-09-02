package practice1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		// text4-1.txt 파일을 읽어서
		// 임의의 저장소(변수, 배열, 객체 등)에 저장한 뒤
		// 저장소의 내용을 text4-1-1.txt 파일로 보낸다.
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			br = new BufferedReader(new FileReader("text4-1.txt"));
			bw = new BufferedWriter(new FileWriter("text4-4-1.txt"));
			
			char[] cbuf = new char[512];
			int readCount = 0;
			
			while ( (readCount = br.read(cbuf)) != -1 ) {
				bw.write(cbuf, 0, readCount);
			}

			System.out.println("text4-4-1.txt 파일이 복사되었습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (br != null) br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
