package practice1;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		// ArrayList에 Member 3명 입력하기
		// Member 정보는 알아서 처리

		List<Member> members = new ArrayList<Member>();
		
		members.add( new Member("user1", "1111") );
		members.add( new Member("user2", "1111") );
		members.add( new Member("user3", "1111") );
		
		System.out.println(members);
		
		for (Member member : members) {
			System.out.println(member);
		}
		
	}

}
