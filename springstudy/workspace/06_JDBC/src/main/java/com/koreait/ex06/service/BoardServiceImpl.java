package com.koreait.ex06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {
	
	// field
	@Autowired
	private BoardRepository repository;

	@Override
	public List<Board> selectBoardList() {
		return repository.selectBoardList();
	}
	
}
