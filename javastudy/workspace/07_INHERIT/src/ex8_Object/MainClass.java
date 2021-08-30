package ex8_Object;

public class MainClass {

	public static void main(String[] args) {
		
		// Member와 Board를 모두 저장할 수 있는 타입은? Object

		Object obj = null;
		
		obj = new Member("admin");
		// ((Member)obj).setPassword("123456");
		
		Member member = (Member)obj;
		member.setPassword("123456");
		System.out.println("아이디: " + member.getId());
		System.out.println("비밀번호: " + member.getPassword());
		
		
		obj = new Board("공지사항", "내일도 수업입니다.");
		
		Board board = (Board)obj;
		System.out.println("제목: " + board.getTitle());
		System.out.println("내용: " + board.getContent());
		
		
	}

}
