package connect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBCPDataSource {

	public static DataSource getDataSource() {

		Properties properties = new Properties();
		OracleDataSource ds = null;
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
