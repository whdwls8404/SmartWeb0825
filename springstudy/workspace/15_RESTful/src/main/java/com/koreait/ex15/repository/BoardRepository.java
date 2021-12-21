package com.koreait.ex15.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.Board;
import com.koreait.ex15.domain.BoardAttach;

@Repository
public interface BoardRepository {
	public int insertBoard(Board board);
	public int insertBoardAttach(BoardAttach boardAttach);
}
