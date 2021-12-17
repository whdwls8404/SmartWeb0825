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
	public Map<String, Object> addMember(Member member) {  // 받아온 member에는 memberNo 없음.
		int result = repository.insertMember(member);  // DB로 member를 보내면 selectKey 태그로 member에 memberNo가 저장됨.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);  // 성공 유무 판단용 0 또는 1
		map.put("memberNo", member.getMemberNo());  // DB를 다녀온 뒤에는 member에 memberNo가 있음.
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
