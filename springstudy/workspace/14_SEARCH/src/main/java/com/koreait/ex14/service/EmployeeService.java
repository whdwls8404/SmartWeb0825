package com.koreait.ex14.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.koreait.ex14.domain.Employee;

@Service
public interface EmployeeService {
	public void findAllEmployee(Model model);
}
