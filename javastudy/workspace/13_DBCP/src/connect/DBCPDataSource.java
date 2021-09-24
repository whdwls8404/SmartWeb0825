package connect;

import java.sql.Connection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;

public class DBCPDataSource {

	// field
	//   DBCP
	private static OracleDataSource ds;
	
	// static field 초기화 : static 블록
	static {
		//ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		try {
			ds = new OracleConnectionPoolDataSource();
			ds.setServerName("localhost");
			ds.setPortNumber(1521);
			ds.setUser("SCOTT");
			ds.setPassword("TIGER");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private DBCPDataSource() {
		
	}
	
	public static Connection getConnection() throws Exception {
		// Connection Pool 관리는 BasicDataSource ds 객체 담당
		return ds.getConnection();
	}
	
}
