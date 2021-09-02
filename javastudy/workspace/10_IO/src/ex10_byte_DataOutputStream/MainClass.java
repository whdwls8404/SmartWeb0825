package ex10_byte_DataOutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("byte3.dat"))) {
			
			int age = 44;
			double height = 177.5;
			String name = "민경태";
			
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeUTF(name);
			
			System.out.println("byte3.dat 파일이 생성되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
