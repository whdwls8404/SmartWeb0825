package com.koreait.ex13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex13.domain.Member;
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
	
	@PostMapping(value={"emailCheck", "findId"}, produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> findMemberByEmail(@RequestParam("email") String email) {
		return service.findMemberByEmail(email);
	}
	
	@PostMapping(value="sendAuthCode", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> sendAuthCode(@RequestParam("email") String email) {
		return service.sendAuthCode(email);
	}

	@PostMapping(value="join")
	public String join(Member member) {
		service.join(member);
		return "redirect:/";  // index.jsp로 redirect
	}
	
	@PostMapping(value="login")
	public String login(HttpServletRequest request) {
		service.login(request);
		return "redirect:/";
	}
	
	@GetMapping(value="logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@GetMapping(value="findIdPage")
	public String findIdPage() {
		return "member/findId";
	}
	
	@GetMapping(value="findPwPage")
	public String findPwPage() {
		return "member/findPw";
	}
	
	@GetMapping(value="updatePwPage")
	public String updatePwPage(@ModelAttribute("email") String email) {
		return "member/updatePw";
	}
	
	@PostMapping(value="updatePw")
	public String updatePw(Member member) {
		service.updatePw(member);
		return "redirect:loginPage";
	}
	
	
	
	
	
	
	
}
