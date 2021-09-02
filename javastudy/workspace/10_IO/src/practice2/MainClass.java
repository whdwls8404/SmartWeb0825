package practice2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("Lemon.mp4"));
			bos = new BufferedOutputStream(new FileOutputStream("Lemon2.mp4"));
			byte[] b = new byte[1024];
			int readCount = 0;
			while ( (readCount = bis.read(b)) != -1 ) {
				bos.write(b, 0, readCount);
			}
			System.out.println("Lemon2.mp4 파일이 복사되었습니다.");
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





