package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class FreeDao {

	// MyBatis는 SqlSession 객체를 이용해서 DB에 접근한다.
	// SqlSession 객체는 메소드별로 만들고 닫는 것이 좋다.
	// SqlSession 객체를 만들 수 있는 SqlSessionFactory를 준비해 둔다.
	
	private SqlSessionFactory factory;
	
	/* singleton */
	private static FreeDao instance;
	private FreeDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static FreeDao getInstance() {
		if (instance == null) {
			instance = new FreeDao();
		}
		return instance;
	}
	
	
	
}
