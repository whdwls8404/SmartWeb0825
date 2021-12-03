package com.koreait.ex04.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex04.domain.Member;
import com.koreait.ex04.domain.MemberBuilder;

@Controller
public class MemberController {

	// welcome page 작업
	@GetMapping( { "/", "index.do" } )
	public String a() {
		return "index";
	}
	
	// @GetMapping("/member/v1.do")  :  슬래시(/)로 시작해도 된다.
	@GetMapping("member/v1.do")
	public String b() {
		// return "/member/memberDetail";  :  슬래시(/)로 시작해도 된다.
		return "member/memberDetail";
	}
	
	//  <a href="member/v2.do?idx=1&id=user&name=james">
	@GetMapping("member/v2.do")
	public String c(HttpServletRequest request) {  // 파라미터 처리를 매개변수가 해야 한다.
		
		Long idx = Long.parseLong(request.getParameter("idx"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// Member 생성 - 1
		Member member1 = new Member();
		member1.setIdx(idx);
		member1.setId(id);
		member1.setName(name);
		
		// Member 생성 - 2
		Member member2 = new Member(idx, id, name);
		
		// Member 생성 - 3 (Builder Pattern 이용하기)
		Member member3 = new MemberBuilder()
				.setIdx(idx)
				.setId(id)
				.setName(name)
				.build();
		
		// request를 이용해서 Member 넘기기
		request.setAttribute("member", member3);
		
		return "member/memberDetail";
	}
	
	//  <a href="member/v3.do?idx=1&id=user&name=james">
	@GetMapping("member/v3.do")
	public String d(@RequestParam(value="idx") Long idx,  // @RequestParam(value="파라미터명") 저장할 변수
					@RequestParam(value="id") String id,
					@RequestParam(value="name") String name, Model model) {
		
		// Model은 JSP에 값을 넘기는 역할이다
		model.addAttribute("member", new Member(idx, id, name));
		
		return "member/memberDetail";
		
	}
	
	//  <a href="member/v4.do">
	@GetMapping("member/v4.do")
	public String e(@RequestParam(value="idx", required=false, defaultValue="999") Long idx,
					@RequestParam(value="id", required=false, defaultValue="chul") String id,
					@RequestParam(value="name", required=false, defaultValue="철이") String name, Model model) {
		
		model.addAttribute("member", new Member(idx, id, name));
		return "member/memberDetail";
		
	}
	
	//  <a href="member/v5.do?idx=1&id=user&name=james">
	@GetMapping("member/v5.do")
	public String f(Member member,  // Member 클래스의 setter가 파라미터를 모두 받아 준다.
					Model model) {
		
		model.addAttribute("member", member);
		return "member/memberDetail";
		
	}
	
	//  <a href="member/v6.do?idx=1&id=user&name=james">
	@GetMapping("member/v6.do")
	public String g(@ModelAttribute(value="member") Member member) {
		return "member/memberDetail";
	}
	
}
