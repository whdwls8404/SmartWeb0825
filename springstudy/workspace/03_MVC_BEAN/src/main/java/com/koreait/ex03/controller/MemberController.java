package com.koreait.ex03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ex03.config.MemberConfig;
import com.koreait.ex03.domain.Member;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class); 
	
	
	// Spring4부터 @GetMapping, @PostMapping 지원
	
	// @RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String a(HttpServletRequest request) {
		
		// member1을 만들어서 index.jsp로 보내기
		Member member1 = ctx.getBean("member1", Member.class);
		request.setAttribute("member1", member1);
		
		return "index";  // 기본 이동은 forward이므로 request가 전달됨.
		
	}
	
	// @RequestMapping(value="memberView.do", method=RequestMethod.GET)
	@GetMapping("memberView1.do")
	public String b(Model model) {
		
		// Model
		// 안녕 난 request를 사용하는 인터페이스야 보안이 더 좋지
		// addAttribute()를 사용하면 실제로는 request.setAttribute() 처럼 동작하지
		
		// member2을 만들어서 memberDetail.jsp로 보내기
		Member member2 = ctx.getBean("member2", Member.class);
		model.addAttribute("member", member2);
		
		return "member/memberDetail";
		
	}
	
	@Autowired
	@Qualifier(value="member3")  // <qualifier value="member3" />
	private Member member3;

	@GetMapping("memberView2.do")
	public String c(Model model) {
		model.addAttribute("member", member3);
		return "member/memberDetail";
	}
	
}
