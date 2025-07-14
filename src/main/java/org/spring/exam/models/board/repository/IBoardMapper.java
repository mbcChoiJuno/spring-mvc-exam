package org.spring.exam.models.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.spring.exam.models.board.domain.BoardVO;

@Mapper
public interface IBoardMapper {
	
	public void postBoard(BoardVO dto);

	public List<BoardVO> getBoardList();
	public BoardVO getBoardDetail(Long id);
	public void increaseViewCount(Long id);
	
	public void modifyBoard(BoardVO dto);
	
	public void deleteBoard(Long id);
}
