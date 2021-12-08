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
		return sqlSession.insert("mapper.notice.insertNotice", notice);
	}
	
	public int updateNotice(Notice notice) {
		return sqlSession.update("mapper.notice.updateNotice", notice);
	}
	
	public int deleteNotice(Long no) {
		return sqlSession.delete("mapper.notice.deleteNotice", no);
	}
	
}
