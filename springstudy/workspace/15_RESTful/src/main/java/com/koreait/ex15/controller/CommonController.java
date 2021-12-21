package com.koreait.ex15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping(value="/")
	public String index() {
		return "index";  // jsp로 이동
	}
	
	@GetMapping(value="member/manage")
	public String memberManage() {
		return "member/memberManage";  // jsp로 이동
	}
	
	@GetMapping(value="board/manage")
	public String boardManage() {
		return "board/boardManage";  // jsp로 이동
	}
	
}
