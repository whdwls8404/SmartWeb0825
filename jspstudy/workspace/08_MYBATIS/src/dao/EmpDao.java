package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.EmpDto;
import mybatis.config.MybatisSetting;

public class EmpDao {

	// SqlSessionFactory를 받아서 필드로 저장해 두고,
	// 각 메소드(삽입, 수정, 삭제, 조회)들이 SqlSessionFactory를 사용함.
	private SqlSessionFactory factory;
	
	/* singleton */
	private static EmpDao instance;
	private EmpDao() {
		factory = MybatisSetting.getInstance().getFactory();
	}
	public static EmpDao getInstance() {
		if (instance == null) {
			instance = new EmpDao();
		}
		return instance;
	}
	
	/* 메소드 */
	
	/*
	 * 앞으로 하게 될 작업 약속
	 * "메소드이름"을 매퍼의 태그 id 속성으로 사용한다.
	 */
	
	// 1. 사원 목록 반환
	public List<EmpDto> selectEmpList() {
		
		// 1) 쿼리는 sqlmap.xml(매퍼)에 <select> 태그에 작성
		// SELECT num, name, salary, hire FROM emp ORDER BY num DESC
		
		// 2) sqlmap.xml(매퍼)에 있는 <select> 태그 실행
		// <select> 태그의 id 속성으로 호출
		
		// 3) <select> 태그 호출 방법 - 메소드 이용
		//     (1) selectOne()  : 반환 결과가 1개
		//     (2) selectList() : 반환 결과가 여러 개
		
		
		// 실제 구현
		
		// 1. SqlSession 객체 구하기
		SqlSession ss = factory.openSession();
		
		// 2. <select id="selectEmpList"> 태그를 호출할 메소드 호출하기
		
		// sqlmap.xml 구성
		// <mapper namespace="mybatis.mapper.sqlmap">
		//      <select id="selectEmpList">
		
		List<EmpDto> list = ss.selectList("mybatis.mapper.sqlmap.selectEmpList");  // namespace + id
		
		// 3. SqlSession 객체 반납하기
		ss.close();
		
		// 4. 결과 반환
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
