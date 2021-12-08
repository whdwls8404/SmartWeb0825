package com.koreait.ex10.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex10.domain.Notice;

public class NoticeRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Notice> selectNoticeList() {
		return sqlSession.selectList("mapper.notice.selectNoticeList");
	}
	
	public Notice selectNoticeByNo(Long no) {
		return sqlSession.selectOne("mapper.notice.selectNoticeByNo", no);
	}
	
	public int insertNotice(Notice notice) {
		int result = sqlSession.insert("mapper.notice.insertNotice", notice);
		if (result > 0) {
			sqlSession.commit();
		}
		return result;
	}
	
	public int updateNotice(Notice notice) {
		int result = sqlSession.update("mapper.notice.updateNotice", notice);
		if (result > 0) {
			sqlSession.commit();
		}
		return result;
	}
	
	public int deleteNotice(Long no) {
		int result = sqlSession.delete("mapper.notice.deleteNotice", no);
		if (result > 0) {
			sqlSession.commit();
		}
		return result;
	}
	
}
