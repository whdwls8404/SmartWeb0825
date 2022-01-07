package com.koreait.ex17.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex17.domain.Notice;
import com.koreait.ex17.service.NoticeService;

@Controller
@RequestMapping("notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping(value="findAll")
	public String findAll(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		noticeService.findAll(model);
		return "notice/list";
	}
	
	@GetMapping(value="find")
	public String find(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		noticeService.find(model);
		return "notice/list";
	}
	
	@GetMapping(value="detail")
	public String detail(@RequestParam("no") Long no, Model model) {
		model.addAttribute("notice", noticeService.detail(no));
		return "notice/detail";
	}
	
	@GetMapping(value="addForm")
	public String addForm() {
		return "notice/insert";
	}
	
	@PostMapping(value="add")
	public void add(Notice notice, HttpServletResponse response) {
		noticeService.add(notice, response);
	}
	
	@GetMapping(value="modify")
	public void modify(Notice notice, HttpServletResponse response) {
		noticeService.modify(notice, response);
	}
	
	@GetMapping(value="remove")
	public void remove(@RequestParam("no") Long no, HttpServletResponse response) {
		noticeService.remove(no, response);
	}
	
}
