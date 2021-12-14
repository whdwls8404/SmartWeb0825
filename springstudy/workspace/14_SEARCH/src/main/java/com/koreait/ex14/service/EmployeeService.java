package com.koreait.ex14.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface EmployeeService {
	public void findAllEmployee(Model model);
	public void findEmployee(Model model);
}
