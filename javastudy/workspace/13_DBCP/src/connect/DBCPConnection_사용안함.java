package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

// singleton 패턴 작업 (오직 하나의 객체만 만들어서 사용하는 방식)

public class DBCPConnection_사용안함 {

	// field
	//   singleton : DBCPConnection 객체(인스턴스, instance)를 하나만 선언한다.
	private static DBCPConnection_사용안함 instance;

	// field
	//   DBCP
	private static BasicDataSource ds = new BasicDataSource();
	
	// static field 초기화 : static 블록
	static {
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		ds.setUsername("SCOTT");
		ds.setPassword("TIGER");
	}
	
	// constructor
	//   singleton : 외부 호출을 막는다. (외부에서는 DBCPConnection 객체를 만들 수 없다.)
	private DBCPConnection_사용안함() {
		
	}
	
	// method
	//   singleton : instance 만들기 + 외부에 instance 반환하기
	public static DBCPConnection_사용안함 getInstance() {
		if (instance == null) {
			instance = new DBCPConnection_사용안함();
		}
		return instance;
	}
	
	// Connection 대여 : DBCPConnection.getInstance().getConnection()
	public Connection getConnection() throws Exception {
		// Connection Pool 관리는 BasicDataSource ds 객체 담당
		return ds.getConnection();
	}
	
	// Connection 반납 : DBCPConnection.getInstance().close()
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();  // 반납의 개념
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
