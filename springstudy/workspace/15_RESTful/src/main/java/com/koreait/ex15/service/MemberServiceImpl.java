package com.koreait.ex15.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

	private MemberRepository repository;
	
	public MemberServiceImpl(SqlSessionTemplate sqlSession) {
		repository = sqlSession.getMapper(MemberRepository.class);
	}
	
	@Override
	public Map<String, Object> findAllMember() {
		List<Member> list = repository.selectMemberList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("length", list.size());
		if (list.size() == 0) {
			map.put("list", null);
		} else {
			map.put("list", list);
		}
		return map;
	}

	@Override
	public Member findMember(Long memberNo) {
		return repository.selectMemberByNo(memberNo);
	}

	@Override
	public Map<String, Object> addMember(Member member) {
		int result = repository.insertMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("memberNo", member.getMemberNo());
		return map;
	}

	@Override
	public Map<String, Object> modifyMember(Member member) {
		return null;  // repository.updateMember(member);
	}

	@Override
	public Map<String, Object> removeMember(Long memberNo) {
		return null;  //repository.deleteMember(memberNo);
	}

}
