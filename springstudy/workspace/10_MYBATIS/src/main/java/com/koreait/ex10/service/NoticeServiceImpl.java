package com.koreait.ex10.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex10.domain.Notice;
import com.koreait.ex10.repository.NoticeRepository;

public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository repository;
	
	@Override
	public List<Notice> selectNoticeList() {
		return repository.selectNoticeList();
	}

	@Override
	public void insertNotice(Notice notice, HttpServletResponse response) {
		int result = repository.insertNotice(notice);
		message(result, response, "등록성공", "등록실패", "/ex10/notice/selectNoticeList");
	}
	
	@Override
	public Notice selectNoticeByNo(Long no) {
		return repository.selectNoticeByNo(no);
	}
	
	@Override
	public void updateNotice(Notice notice, HttpServletResponse response) {
		int result = repository.updateNotice(notice);
		message(result, response, "수정성공", "수정실패", "/ex10/notice/selectNoticeByNo?no=" + notice.getNo());
	}
	
	@Override
	public void deleteNotice(Long no, HttpServletResponse response) {
		int result = repository.deleteNotice(no);
		message(result, response, "삭제성공", "삭제실패", "/ex10/notice/selectNoticeList");
	}

}
