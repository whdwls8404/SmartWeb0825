package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

	/* SqlSessionFactory */
	private SqlSessionFactory factory;
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
	/* singleton */
	private static DBService instance;
	private DBService() {
		/* SqlSessionFactory 빌드 */
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBService getInstance() {
		if (instance == null) {
			instance = new DBService();
		}
		return instance;
	}
	
}
