package com.koreait.ex14.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex14.domain.Employee;
import com.koreait.ex14.repository.EmployeeRepository;
import com.koreait.ex14.util.PageUtils;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void findAllEmployee(Model model) {
		
		EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		
		// Model에 저장된 request 꺼내기
		Map<String, Object> m = model.asMap();
		HttpServletRequest request = (HttpServletRequest) m.get("request");
		
		// 전체 레코드 갯수
		int totalRecord = repository.selectTotalRecordCount();
		
		// 전달된 페이지 번호 (전달 안 되면 page = 1 사용)
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 페이징 처리 PageUtils 객체 생성 및 계산
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		// beginRecord + endRecord => HashMap
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		// beginRecord ~ endRecord 목록 가져오기
		List<Employee> list = repository.selectEmployeeList(map);
		
		// View(employee/list.jsp)로 보낼 데이터
		model.addAttribute("list", list);
		model.addAttribute("startNum", totalRecord - (page - 1) * pageUtils.getRecordPerPage());
		model.addAttribute("paging", pageUtils.getPageEntity("findAll"));  // 목록을 출력하는 매핑값 전달
		
	}
	
	@Override
	public void findEmployee(Model model) {
		
		EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		
		// Model에 저장된 request 꺼내기
		Map<String, Object> m = model.asMap();
		HttpServletRequest request = (HttpServletRequest) m.get("request");
		
		// column + query => HashMap (검색할 칼럼 + 검색어)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		
		// 검색된 레코드 갯수
		int totalRecord = repository.selectFindRecordCount(map);
		
		// 전달된 페이지 번호 (전달 안 되면 page = 1 사용)
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 페이징 처리 PageUtils 객체 생성 및 계산
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		// map + beginRecord + endRecord
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		// 검색된 목록 중 beginRecord ~ endRecord 사이 목록 가져오기
		List<Employee> list = repository.selectFindList(map);
		
		// View(employee/list.jsp)로 보낼 데이터
		model.addAttribute("list", list);
		model.addAttribute("startNum", totalRecord - (page - 1) * pageUtils.getRecordPerPage());
		
		// 검색 조건에 따라서 파라미터가 달라짐
		switch (request.getParameter("column")) {
		case "EMPLOYEE_ID":
			model.addAttribute("paging", pageUtils.getPageEntity("findEmployee?column=EMPLOYEE_ID&query=" + request.getParameter("query")));  // 목록을 출력하는 매핑값 전달
			break;
		}
		
	}

}






