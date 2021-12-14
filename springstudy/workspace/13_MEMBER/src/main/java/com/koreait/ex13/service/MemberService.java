package com.koreait.ex13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.koreait.ex13.domain.Member;

public interface MemberService {
	public Map<String, Object> idCheck(String id);
	public Map<String, Object> findMemberByEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
	public void join(Member member);
	public void login(HttpServletRequest request);
	public void updatePw(Member member);
	public void updateMember(Member member, HttpSession session);
	public Map<String, Object> presentPwCheck(HttpServletRequest request);
	public void leave(Long no, HttpSession session);
}
