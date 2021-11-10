package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSessionFactory 반환하는 클래스
public class MybatisSetting {

	/* SqlSessionFactory 선언 */
	private SqlSessionFactory factory;
	
	/* singleton */
	private static MybatisSetting instance;
	private MybatisSetting() {
		/* SqlSessionFactory 빌드 */
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static MybatisSetting getInstance() {
		if (instance == null) {
			instance = new MybatisSetting();
		}
		return instance;
	}

	/* SqlSessionFactory 반환 */
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
}
