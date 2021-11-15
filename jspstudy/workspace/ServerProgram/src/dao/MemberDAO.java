package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {
	
	private SqlSessionFactory factory;
	
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public List<MemberDTO> selectAllMember() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList("dao.members.selectAllMember");
		ss.close();
		return list;
	}
	public MemberDTO selectMember(MemberDTO member) {
		SqlSession ss = factory.openSession();
		MemberDTO dto = ss.selectOne("dao.members.selectMember", member);
		ss.close();
		return dto;
	}
	public int insertMember(MemberDTO member) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.members.insertMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int deleteMember(Long no) {
		SqlSession ss = factory.openSession();
		int result = ss.delete("dao.members.deleteMember", no);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int updateMember(MemberDTO member) {
		SqlSession ss = factory.openSession();
		int result = ss.update("dao.members.updateMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public MemberDTO selectTop() {
		SqlSession ss = factory.openSession();
		MemberDTO top = ss.selectOne("dao.members.selectTop");
		ss.close();
		return top;
	}

}
