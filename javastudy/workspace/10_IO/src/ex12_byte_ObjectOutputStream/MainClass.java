package ex12_byte_ObjectOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

// ObjectOutputStream 클래스
// 객체를 파일로 보낼 수 있는 클래스

public class MainClass {

	public static void main(String[] args) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.dat"))) {
			
			// 객체 하나 보내기
			Member member1 = new Member("user1", "1111");
			oos.writeObject(member1);
			
			// 객체 모아서 보내기
			Member member2 = new Member("user2", "2222");
			Member member3 = new Member("user3", "3333");
			List<Member> members = Arrays.asList(member2, member3);
			oos.writeObject(members);
			
			System.out.println("member.dat 파일 생성 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
