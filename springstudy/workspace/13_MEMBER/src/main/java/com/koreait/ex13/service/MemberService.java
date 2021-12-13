package com.koreait.ex13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.koreait.ex13.domain.Member;

public interface MemberService {
	public Map<String, Object> idCheck(String id);
	public Map<String, Object> emailCheck(String email);
	public Map<String, Object> sendAuthCode(String email);
	public void join(Member member);
	public void login(HttpServletRequest request);
}
