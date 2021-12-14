package com.koreait.ex14.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koreait.ex14.domain.Employee;

@Repository
public interface EmployeeRepository {
	public int selectTotalRecord();
	public List<Employee> selectEmployeeList(Map<String, Object> map);
}
