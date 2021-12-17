package com.koreait.ex15.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.repository.MemberRepository;
import com.koreait.ex15.util.PageUtils;

public class MemberServiceImpl implements MemberService {

	private MemberRepository repository;
	
	public MemberServiceImpl(SqlSessionTemplate sqlSession) {
		repository = sqlSession.getMapper(MemberRepository.class);
	}
	
	@Override
	public Map<String, Object> findAllMember(Integer page) {
		
		int totalRecord = repository.selectMemberCount();
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("beginRecord", pageUtils.getBeginRecord());
		m.put("endRecord", pageUtils.getEndRecord());
		List<Member> list = repository.selectMemberList(m);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageUtils", pageUtils);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> findMember(Long memberNo) {
		Member member = repository.selectMemberByNo(memberNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", member);
		return map;
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
		int result = repository.updateMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

	@Override
	public Map<String, Object> removeMember(Long memberNo) {
		int result = repository.deleteMember(memberNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

}
