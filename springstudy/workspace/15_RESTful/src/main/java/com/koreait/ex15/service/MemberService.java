package com.koreait.ex15.service;

import java.util.Map;

import com.koreait.ex15.domain.Member;

public interface MemberService {
	public Map<String, Object> findAllMember();
	public Member findMember(Long memberNo);
	public int addMember(Member member);
	public int modifyMember(Member member);
	public int removeMember(Long memberNo);
}
