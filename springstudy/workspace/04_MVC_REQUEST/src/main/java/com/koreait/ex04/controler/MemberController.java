package com.koreait.ex04.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		System.out.println(idx + "," + id + "," + name);
		return "member/memberDetail";
	}
	
	
}





