package ex14_File;

import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MainClass {

	public static void method1() {

		// 전체 경로 작성

		// File(String pathname)
		File file1 = new File("D:\\SmartWeb0825\\javastudy\\workspace\\10_IO\\text1.txt");
		File file2 = new File("D:" + File.separator + "SmartWeb0825" + File.separator + "javastudy" + File.separator + "workspace" + File.separator + "10_IO" + File.separator + "text2.txt");

		// 경로, 파일 분리 작성
		
		// File(File dir, String filename)
		File dir = new File("D:\\SmartWeb0825\\javastudy\\workspace\\10_IO");
		File file3 = new File(dir, "text3.txt");
		
		// File(String dir, String filename)
		File file4 = new File("D:\\SmartWeb0825\\javastudy\\workspace\\10_IO", "text4.txt");
		
		System.out.println("파일명: " + file1.getName());
		System.out.println("저장된 디렉터리: " + file1.getParent());
		System.out.println("전체 경로: " + file1.getPath());
		System.out.println("수정한 날짜: " + file1.lastModified());
		System.out.println("존재하는가? " + file1.exists());
		System.out.println("파일인가? " + file1.isFile());
		System.out.println("디렉터리인가? " + file1.isDirectory());
		
	}
	
	public static void method2() {
		
		// 디렉터리 조작하기
		
		File dir = new File("C:" + File.separator + "MyDir");
		
		if (dir.exists() == false) {  // 존재하지 않으면,
			dir.mkdirs();  // 디렉터리를 만든다.
			System.out.println("C:\\MyDir 디렉터리 생성 완료");
		}
		
		if (dir.exists()) {  // 존재하면,
			dir.delete();  // 삭제한다.
			System.out.println("C:\\MyDir 디렉터리 삭제 완료");
		}
		
	}
	
	public static void method3() {
	
		File javaHome = new File("C:\\Program Files\\Java\\jdk1.8.0_202");
		File[] files = javaHome.listFiles();  // 전체 File 정보를 가져옴
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		for (File file : files) {
			String date = sdf.format(new Date(file.lastModified()));
			String info = null;
			if (file.isDirectory()) {  // 디렉토리이면,
				info = "<DIR>";
			} else if (file.isFile()) {  // 파일이면,
				info = new DecimalFormat("#,##0").format(file.length());  // file.length() : 파일의 바이트 크기
			}
			String name = file.getName();
			System.out.println(date + "\t" + info + "\t" + name);
		}
		
	}
	
	public static void main(String[] args) {
		method3();
	}

}
