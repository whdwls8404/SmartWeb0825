package com.koreait.ex11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex11.domain.Notice;
import com.koreait.ex11.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService service;

	@GetMapping(value="selectNoticeList")
	public String selectNoticeList(Model model) {
		model.addAttribute("list", service.selectNoticeList());
		return "notice/list";
	}
	
	@GetMapping(value="selectNoticeByNo")
	public String selectNoticeByNo(@RequestParam("no") Long no, Model model) {
		model.addAttribute("notice", service.selectNoticeByNo(no));
		return "notice/detail";
	}
	
	@GetMapping(value="noticePage")
	public String noticePage() {
		return "notice/insert";
	}
	
	@PostMapping(value="insertNotice")
	public String insertNotice(Notice notice) {
		service.insertNotice(notice);
		return "redirect:selectNoticeList";
	}
	
	@GetMapping(value="updateNotice")
	public String updateNotice(Notice notice) {
		service.updateNotice(notice);
		return "redirect:selectNoticeByNo?no=" + notice.getNo();
	}
	
	@GetMapping(value="deleteNotice")
	public String deleteNotice(@RequestParam("no") Long no) {
		service.deleteNotice(no);
		return "redirect:selectNoticeList";
	}
	
}
