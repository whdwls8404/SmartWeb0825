package com.koreait.ex13.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex13.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Override
	public Map<String, Object> idCheck(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", repository.selectMemberById(id));
		return map;
	}

}





