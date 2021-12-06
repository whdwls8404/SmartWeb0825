package com.koreait.ex06.service;

import java.util.List;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {
	
	// field
	private BoardRepository repository = BoardRepository.getInstance();
	
	@Override
	public List<Board> selectBoardList() {
		return repository.selectBoardList();
	}
	
}





