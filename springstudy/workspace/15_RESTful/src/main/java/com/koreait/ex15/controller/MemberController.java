package com.koreait.ex15.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.service.MemberService;

import lombok.AllArgsConstructor;

// REST 방식

// 1. URL + Method에 의해서 동작이 결정
// 2. URL에 파라미터가 경로의 일부로 포함
// 3. URL + Method
//    1) 목록 : members      + GET
//    2) 개별 : members/1    + GET


@RestController
@AllArgsConstructor  // 생성자를 만들면 field에 @Autowired 처리된다.
public class MemberController {

	private MemberService service;
	
	@GetMapping(value="api/members", produces="application/json; charset=UTF-8")
	public Map<String, Object> findAllMember() {
		return service.findAllMember();
	}
	
}
