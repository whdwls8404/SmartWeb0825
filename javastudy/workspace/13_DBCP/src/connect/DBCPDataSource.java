package connect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBCPDataSource {

	// DataSource 타입의 객체 : Connection Pool 관리
	
	// DataSource 반환 메소드
	public static DataSource getDataSource() {

		Properties properties = new Properties();  // properties (프로퍼티) 처리
		OracleDataSource ds = null;  // 오라클 전용
		InputStream fis = null;
		
		try {
			fis = new FileInputStream("db.properties");
			properties.load(fis);
			ds = new OracleDataSource();
			ds.setURL(properties.getProperty("url"));
			ds.setUser(properties.getProperty("username"));
			ds.setPassword(properties.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ds;
		
	}
}
