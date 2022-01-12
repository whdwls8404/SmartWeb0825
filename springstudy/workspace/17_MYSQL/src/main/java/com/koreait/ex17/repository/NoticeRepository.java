package com.koreait.ex17.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koreait.ex17.domain.Notice;

@Repository
public interface NoticeRepository {

	public int selectTotalCount();
	public List<Notice> selectTotalList(Map<String, Object> map);
	
	public int selectFindCount(Map<String, Object> map);
	public List<Notice> selectFindList(Map<String, Object> map);
	
	public Notice selectByNo(Long no);
	
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(Long no);
	
}