package org.spring.exam.models.board.service;

import java.util.List;

import org.spring.exam.models.board.domain.BoardVO;
import org.spring.exam.models.board.repository.IBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardMapper boardMapper;
	
	@Override
	public void postBoard(BoardVO dto) {
		boardMapper.postBoard(dto);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.getBoardList();
	}

	@Override
	public BoardVO getBoardDetail(Long id) {
		return boardMapper.getBoardDetail(id);
	}
	@Override
	public void increaseViewCount(Long id) {
		boardMapper.increaseViewCount(id);
	}

	@Override
	public void modifyBoard(BoardVO dto) {
		boardMapper.modifyBoard(dto);
	}

	@Override
	public void deleteBoard(Long id) {
		boardMapper.deleteBoard(id);
	}

}
