package com.koreait.ex14.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface EmployeeService {
	public void findAllEmployee(Model model);
	public void findEmployee(Model model);
	public void autoComplete(Map<String, Object> map, HttpServletResponse response);
}
