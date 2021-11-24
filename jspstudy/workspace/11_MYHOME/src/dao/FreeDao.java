package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Free;
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
	
	public List<Free> selectFreeList(Map<String, Integer> map) {
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.selectFreeList", map);
		ss.close();
		return list;
	}
	public int selectTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.free.selectTotalCount");
		ss.close();
		return totalCount;
	}
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.free.insertFree", free);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public Free selectFreeByfNo(Long fNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne("dao.free.selectFreeByfNo", fNo);
		ss.close();
		return free;
	}
	public int updateHit(Long fNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updateHit", fNo);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updateFree", free);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int deleteFree(Long fNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.deleteFree", fNo);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int insertReply(Free reply) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.free.insertReply", reply);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int updatePreviousReplyGroupOrd(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updatePreviousReplyGroupOrd", free);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
}













