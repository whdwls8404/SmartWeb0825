package com.koreait.ex14.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex14.service.EmployeeService;

@Controller
@RequestMapping("search/*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value="searchPage")
	public String searchPage() {
		return "employee/search";
	}
	
	@GetMapping(value="findAll")
	public String findAll(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.findAllEmployee(model);
		return "employee/search";
	}
	
	@GetMapping(value="findEmployee")
	public String findEmployee(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.findEmployee(model);
		return "employee/search";
	}
	
	@PostMapping(value="autoComplete", produces="application/json; charset=UTF-8")
	@ResponseBody
	public void autoComplete(@RequestBody Map<String, Object> map, HttpServletResponse response) {
		service.autoComplete(map, response);
	}
	
	
	
	
	
	
	
	
}
