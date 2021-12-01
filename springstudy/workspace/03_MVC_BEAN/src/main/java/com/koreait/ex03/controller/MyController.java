package com.koreait.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	// Spring4부터 @GetMapping, @PostMapping 지원
	
	// @RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String a() {
		return "index";
	}
	
	// @RequestMapping(value="memberView.do", method=RequestMethod.GET)
	@GetMapping("memberView.do")
	public String b() {
		return "member/memberDetail";
	}
	
}




