package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDao {

	// MyBatis는 SqlSession 객체를 이용해서 DB에 접근한다.
	// SqlSession 객체는 메소드별로 만들고 닫는 것이 좋다.
	// SqlSession 객체를 만들 수 있는 SqlSessionFactory를 준비해 둔다.
	
	private SqlSessionFactory factory;
	
	/* singleton */
	private static MemberDao instance;
	private MemberDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	public Member selectMember(Member member) {
		SqlSession ss = factory.openSession();
		Member user = ss.selectOne("dao.member.selectMember", member);
		ss.close();
		return user;
	}
	public int loginLog(String id) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.loginLog", id);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int deleteMember(Long mNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", mNo);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int deleteMemberLog(String id) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMemberLog", id);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
}
