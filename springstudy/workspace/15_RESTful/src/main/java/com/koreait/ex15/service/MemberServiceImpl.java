package com.koreait.ex15.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Map<String, Object> findAllMember() {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
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
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		return repository.selectMemberByNo(memberNo);
	}

	@Override
	public Map<String, Object> addMember(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		int memberNo = repository.insertMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		return map;
	}

	@Override
	public Map<String, Object> modifyMember(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		return null;  // repository.updateMember(member);
	}

	@Override
	public Map<String, Object> removeMember(Long memberNo) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		return null;  //repository.deleteMember(memberNo);
	}

}
