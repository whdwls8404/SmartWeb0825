package connect;

// singleton 패턴 작업 (오직 하나의 객체만 만들어서 사용하는 방식)

public class DBCPConnection {

	// field
	//   singleton : DBCPConnection 객체(인스턴스, instance)를 하나만 선언한다.
	private static DBCPConnection instance;
	
	// constructor
	//   singleton : 외부 호출을 막는다. (외부에서는 DBCPConnection 객체를 만들 수 없다.)
	private DBCPConnection() {
		
	}
	
	// method
	//   singleton : instance 만들기 + 외부에 instance 반환하기
	public static DBCPConnection getInstance() {
		if (instance == null) {
			instance = new DBCPConnection();
		}
		return instance;
	}
	
	// Connection 대여
	
	
	// Connection 반납
	
	
}
