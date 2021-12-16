package com.koreait.ex15.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.Member;

@Repository
public interface MemberRepository {
	public List<Member> selectMemberList();
	public Member selectMemberByNo(Long memberNo);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(Long memberNo);
}
