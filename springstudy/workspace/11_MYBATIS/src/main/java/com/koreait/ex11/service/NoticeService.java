package com.koreait.ex11.service;

import java.util.List;

import com.koreait.ex11.domain.Notice;

public interface NoticeService {

	public List<Notice> selectNoticeList();
	public Notice selectNoticeByNo(Long no);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(Long no);
	
}
