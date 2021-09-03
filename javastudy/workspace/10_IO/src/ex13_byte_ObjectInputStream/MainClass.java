package ex13_byte_ObjectInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import ex12_byte_ObjectOutputStream.Member;

public class MainClass {

	public static void main(String[] args) {
	
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("member.dat"))) {
			
			Member member = (Member)ois.readObject();
			member.info();
			
			List<Member> members = (List<Member>)ois.readObject();
			for (Member m : members) {
				m.info();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
