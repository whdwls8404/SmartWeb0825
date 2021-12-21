package com.koreait.ex15.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
//    3) 삽입 : members      + POST
//    4) 수정 : members      + PUT  (수정할 정보는 body에 포함시켜서 처리됨)
//    5) 삭제 : members/1    + DELETE


@RestController
@AllArgsConstructor  // 생성자를 만들면 field에 @Autowired 처리된다.
public class MemberController {

	private MemberService memberService;
	
	// 회원 목록
	@GetMapping(value="api/members/page/{page}", produces="application/json; charset=UTF-8")
	public Map<String, Object> findAllMember(@PathVariable(value="page", required=false) Optional<String> opt) {
		String page = opt.orElse("1");
		return memberService.findAllMember(Integer.parseInt(page));
	}
	
	// 회원 등록
	@PostMapping(value="api/members", produces="application/json; charset=UTF-8")
	public Map<String, Object> addMember(@RequestBody Member member, HttpServletResponse response) {
		try {
			return memberService.addMember(member);
		} catch (DuplicateKeyException e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.setStatus(500);
				response.getWriter().println("이미 사용 중인 아이디입니다.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (DataIntegrityViolationException e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.setStatus(501);
				response.getWriter().println("필수 정보가 누락되었습니다.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;  // 동작할 일 없음.
	}
	
	// 회원 조회
	@GetMapping(value="api/members/{memberNo}", produces="application/json; charset=UTF-8")
	public Map<String, Object> findMember(@PathVariable(value="memberNo") Long memberNo) {  // 경로에 변수가 있다. @PathVariable
		return memberService.findMember(memberNo);
	}
	
	// 회원 정보 수정
	@PutMapping(value="api/members", produces="application/json; charset=UTF-8")
	public Map<String, Object> modifyMember(@RequestBody Member member) {
		return memberService.modifyMember(member);
	}
	
	// 회원 삭제
	@DeleteMapping(value="api/members/{memberNo}", produces="application/json; charset=UTF-8")
	public Map<String, Object> removeMember(@PathVariable(value="memberNo") Long memberNo) {
		return memberService.removeMember(memberNo);
	}
	
}
