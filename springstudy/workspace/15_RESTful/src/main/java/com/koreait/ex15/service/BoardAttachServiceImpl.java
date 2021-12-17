package com.koreait.ex15.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.koreait.ex15.domain.BoardAttach;
import com.koreait.ex15.repository.BoardAttachRepository;

@Service
public class BoardAttachServiceImpl implements BoardAttachService {

	private BoardAttachRepository repository;
	
	public BoardAttachServiceImpl(SqlSessionTemplate sqlSession) {
		repository = sqlSession.getMapper(BoardAttachRepository.class);
	}
	
	@Override
	public int addBoardAttach(BoardAttach boardAttach) {
		// TODO Auto-generated method stub
		return 0;
	}

}
