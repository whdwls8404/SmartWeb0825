package ex11_byte_DataInputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		try (DataInputStream dis = new DataInputStream(new FileInputStream("byte3.dat"))) {
			
			int age = dis.readInt();
			double height = dis.readDouble();
			String name = dis.readUTF();
			
			System.out.println(age + ", " + height + ", " + name);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
