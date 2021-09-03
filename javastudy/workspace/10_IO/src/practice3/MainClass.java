package practice3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		// 파일 이동
		
		// 원본   D:\SmartWeb0825\installer\eclipse-jee-2020-06-R-win32-x86_64.zip
		// 복사본 C:\MyDir\eclipse-jee-2020-06-R-win32-x86_64.zip
		
		// 복사한 뒤 원본 삭제
		
		// 원본
		File src = new File("D:\\SmartWeb0825\\installer\\eclipse-jee-2020-06-R-win32-x86_64.zip");
		
		// 복사본 경로 만들기
		File dir = new File("C:\\MyDir");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 복사본
		File cpy = new File(dir, src.getName());
		
		// 원본 읽을 스트림
		BufferedInputStream bis = null;
		
		// 복사본 만들 스트림
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			// 이동 전 시간 측정
			long start = System.currentTimeMillis();
			
			// 원본 이동
			
			// 1. 복사
			byte[] b = new byte[1024];  // 1KB
			int readCount = 0;
			while ( (readCount = bis.read(b)) != -1 ) {
				bos.write(b, 0, readCount);
			}
			
			// 2. 원본 삭제
			if (src.exists()) {
				// src.delete();
				src.deleteOnExit();
			}
			
			// 이동 후 시간 측정
			long end = System.currentTimeMillis();
			
			// 성공 메시지
			System.out.println(cpy.getPath() + " 이동 완료");
			
			// 시간 출력
			System.out.println("이동 시간: " + (end - start) * 0.001 + "초");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) bos.close();
				if (bis != null) bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
