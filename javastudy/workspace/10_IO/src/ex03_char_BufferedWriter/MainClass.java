package ex03_char_BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
	BufferedWriter 클래스
	
	1. 문자 기반의 출력 보조 스트림이다.
	2. FileWriter 클래스와 같은 메인 스트림과 함께 사용한다.
	3. 내부 버퍼를 이용해서 동작 속도를 향상시킨다.
*/
public class MainClass {

	public static void method1() {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter("text3.txt");
			bw = new BufferedWriter(fw);
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			
			System.out.println("text3.txt 파일이 생성되었다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 보조 스트림만 닫는다.
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static void method2() {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			// 데이터
			char[] cbuf = {
				'a', 'b', 'c', 'd', 'e', 'f',
				'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', '0', '1', '2', '3'
			};
			
			// cbuf의 요소 중 임의로 20개를 선정하여 한 줄에 연속 배치하되,
			// 총 1000 줄을 만든다.
			
			/*
			fw = new FileWriter("text4-1.txt");
			long start1 = System.currentTimeMillis();
			for (int line = 1; line <= 10000; line++) {
				for (int i = 0; i < 100; i++) {
					fw.write(cbuf[(int)(Math.random() * cbuf.length)]);
				}
				fw.write('\n');
			}
			long end1 = System.currentTimeMillis();
			System.out.println( (end1 - start1) * 0.001 + "초 소요");
			*/
			bw = new BufferedWriter(new FileWriter("text4-2.txt"));
			long start2 = System.currentTimeMillis();
			for (int line = 1; line <= 10000; line++) {
				for (int i = 0; i < 100; i++) {
					bw.write(cbuf[(int)(Math.random() * cbuf.length)]);
				}
				bw.write('\n');
			}
			long end2 = System.currentTimeMillis();
			System.out.println( (end2 - start2) * 0.001 + "초 소요");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		method2();
	}
	
}
