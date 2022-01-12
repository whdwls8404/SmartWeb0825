package com.koreait.ex17.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.koreait.ex17.domain.Notice;
import com.koreait.ex17.repository.NoticeRepository;
import com.koreait.ex17.util.PageUtils;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private NoticeRepository repository;
	
	@Override
	public void findAll(Model model) {
		
		repository = sqlSession.getMapper(NoticeRepository.class);

		Map<String, Object> m = model.asMap();
		HttpServletRequest request = (HttpServletRequest) m.get("request");
		
		int totalRecord = repository.selectTotalCount();
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRecord", pageUtils.getBeginRecord() - 1);
		map.put("recordPerPage", pageUtils.getRecordPerPage());
		
		for (Notice notice : repository.selectTotalList(map)) {
			System.out.println(notice);
		}
		
		model.addAttribute("list", repository.selectTotalList(map));
		model.addAttribute("startNum", totalRecord - (page - 1) * pageUtils.getRecordPerPage());
		model.addAttribute("paging", pageUtils.getPageEntity("findAll"));
	
	}
	
	@Override
	public void find(Model model) {
		
		repository = sqlSession.getMapper(NoticeRepository.class);
		
		Map<String, Object> m = model.asMap();
		HttpServletRequest request = (HttpServletRequest) m.get("request");
		
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		
		int totalRecord = repository.selectFindCount(map);
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		map.put("beginRecord", pageUtils.getBeginRecord() - 1);
		map.put("recordPerPage", pageUtils.getRecordPerPage());
		
		model.addAttribute("list", repository.selectFindList(map));
		model.addAttribute("startNum", totalRecord - (page - 1) * pageUtils.getRecordPerPage());
		model.addAttribute("paging", pageUtils.getPageEntity("find?column=" + column + "&query=" + query));
		
	}
	
	@Override
	public Notice detail(Long no) {
		repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.selectByNo(no);
	}
	
	@Override
	public void add(Notice notice, HttpServletResponse response) {
		repository = sqlSession.getMapper(NoticeRepository.class);
		int result = repository.insertNotice(notice);
		message(result, response, "등록성공", "등록실패", "/ex17/notice/findAll");
	}
	
	@Override
	public void modify(Notice notice, HttpServletResponse response) {
		repository = sqlSession.getMapper(NoticeRepository.class);
		int result = repository.updateNotice(notice);
		message(result, response, "수정성공", "수정실패", "/ex17/notice/detail?no=" + notice.getNo());
	}
	
	@Override
	public void remove(Long no, HttpServletResponse response) {
		repository = sqlSession.getMapper(NoticeRepository.class);
		int result = repository.deleteNotice(no);
		message(result, response, "삭제성공", "삭제실패", "/ex17/notice/findAll");
	}
	
}
