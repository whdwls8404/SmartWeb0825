package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDAO {
	private SqlSessionFactory factory;

	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		if(instance == null ) {
			instance = new MemberDAO();
		}return instance;
	}

	// 1. 멤버리스트
	public List<Member> memberList(){
		SqlSession ss = factory.openSession();
		List<Member> list = ss.selectList("dao.member.memberList");
		ss.close();
		return list;
	}
	// 2, 멤버 등록
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if( result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	
	// 3. 멤버 삭제
	public int deleteMember(String no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", no);
		if( result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	// 4. 번호 중복 확인 
	public boolean noCheck(String no) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne("dao.member.noCheck", no);
		ss.close();
		return member == null;
	}
	
} // end of class
