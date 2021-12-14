package com.koreait.ex14.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex14.domain.Employee;
import com.koreait.ex14.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Employee> findAllEmployee() {
		
		EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		
		// 전체 레코드 갯수
		int totalRecord = repository.selectTotalRecord();
		
		
		return null;
		
	}

}
