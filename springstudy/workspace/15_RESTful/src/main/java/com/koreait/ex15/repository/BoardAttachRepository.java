package com.koreait.ex15.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.BoardAttach;

@Repository
public interface BoardAttachRepository {
	public int insertBoardAttach(BoardAttach boardAttach);
}
