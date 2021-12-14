package com.koreait.ex14.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.koreait.ex14.domain.Employee;

@Service
public interface EmployeeService {
	public List<Employee> findAllEmployee(HttpServletRequest request);
}
