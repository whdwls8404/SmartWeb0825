package com.koreait.ex13.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex13.service.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping(value="loginPage")
	public String loginPage() {
		return "member/login";
	}
	
	@GetMapping(value="joinPage")
	public String joinPage() {
		return "member/join";
	}
	
	@PostMapping(value="idCheck", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idCheck(@RequestParam("id") String id) {
		return service.idCheck(id);
	}
	
	@PostMapping(value="emailCheck", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> emailCheck(@RequestParam("email") String email) {
		return service.emailCheck(email);
	}
	
	@PostMapping(value="sendAuthCode", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> sendAuthCode(@RequestParam("email") String email) {
		return service.sendAuthCode(email);
	}

	
	
	
	
	
	
}
