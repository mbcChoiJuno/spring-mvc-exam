package org.spring.exam.models.board.service;

import java.util.List;

import org.spring.exam.models.board.domain.BoardVO;

public interface IBoardService {

	public void postBoard(BoardVO dto);

	public List<BoardVO> getBoardList();
	public BoardVO getBoardDetail(Long id);
	public void increaseViewCount(Long id);
	
	public void modifyBoard(BoardVO dto);
	
	public void deleteBoard(Long id);
	
}
