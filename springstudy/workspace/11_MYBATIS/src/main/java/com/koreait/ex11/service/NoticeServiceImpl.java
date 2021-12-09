package com.koreait.ex11.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex11.domain.Notice;
import com.koreait.ex11.repository.NoticeRepository;

public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Notice> selectNoticeList() {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.selectNoticeList();
		// NoticeRepository의 selectNoticeList() 호출 -> notice.xml의 id="selectNoticeList" 실행
	}
	
	@Override
	public Notice selectNoticeByNo(Long no) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.selectNoticeByNo(no);
	}
	
	@Override
	public int insertNotice(Notice notice) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.insertNotice(notice);
	}
	
	@Override
	public int updateNotice(Notice notice) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.updateNotice(notice);
	}
	
	@Override
	public int deleteNotice(Long no) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.deleteNotice(no);
	}
	
}
