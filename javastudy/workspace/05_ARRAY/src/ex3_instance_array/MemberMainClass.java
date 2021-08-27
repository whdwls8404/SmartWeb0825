package ex3_instance_array;

public class MemberMainClass {

	public static void main(String[] args) {
		
		// Member 3명을 저장할 수 있는 배열
		Member[] members = new Member[3];
		
		members[0] = new Member();
		members[0].setId("user1");
		members[0].setPassword("1234");

		members[1] = new Member("user2", "1234");
		members[2] = new Member("user3", "1234");
		
		for (int i = 0; i < members.length; i++) {
			System.out.println("아이디: " + members[i].getId());
			System.out.println("비밀번호: " + members[i].getPassword());
		}
		
		for (Member m : members) {
			System.out.println("아이디: " + m.getId());
			System.out.println("비밀번호: " + m.getPassword());
		}
		
	}

}
