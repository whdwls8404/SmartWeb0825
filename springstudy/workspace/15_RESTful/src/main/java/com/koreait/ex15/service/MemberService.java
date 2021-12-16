package com.koreait.ex15.service;

import java.util.Map;

import com.koreait.ex15.domain.Member;

public interface MemberService {
	public Map<String, Object> findAllMember();
	public Member findMember(Long memberNo);
	public Map<String, Object> addMember(Member member);
	public Map<String, Object> modifyMember(Member member);
	public Map<String, Object> removeMember(Long memberNo);
}
