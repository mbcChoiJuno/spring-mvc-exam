package org.spring.exam.models.board.controller;

import java.util.List;

import org.spring.exam.core.ApiResult;
import org.spring.exam.models.board.domain.BoardVO;
import org.spring.exam.models.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board") //192.168.111.104:80/exam/api/board
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	/**
	 * 게시글 목록 조회
	 * [GET] 192.168.111.104:80/exam/api/board/boards
	 * @param request
	 * @return
	 */
	@GetMapping("/boards") 
	@ResponseBody
	public ApiResult<List<BoardVO>> getBoardList() {
		var boardList = boardService.getBoardList();
		
		return new ApiResult<List<BoardVO>>(boardList);
	}
	
	/**
	 * 게시글 상세 조회
	 * [GET] 192.168.111.104:80/exam/api/board/boards/11
	 * @param boardIndex
	 */
	@GetMapping("/boards/{boardIndex}")
	@Transactional
	@ResponseBody
	public ApiResult<BoardVO> getBoardDetail(
			@PathVariable("boardIndex")
			Long boardIndex) {
		
		boardService.increaseViewCount(boardIndex);
		var board = boardService.getBoardDetail(boardIndex);
		
		return new ApiResult<BoardVO>(board);
	}
	
	/**
	 * 신규 게시글 등록
	 * [POST] 192.168.111.104:80/exam/api/board/boards
	 * {
	 *  "title":"글추가테스트",
	 *  "content":"추가게시글내용",
	 *  "writer":"junotest"
	 * }
	 * @param dto
	 */
	@PostMapping("/boards")
	@ResponseBody
	public ApiResult<BoardVO> postBoard(@RequestBody BoardVO dto) {
		boardService.postBoard(dto);
		
		return new ApiResult<BoardVO>(null);
	}
	
	/**
	 * 게시글 수정
	 * [PUT] 192.168.111.104:80/exam/api/board/boards
	 *	{
	 *	    "boardIndex":2,
	 *	    "title":"글수정테스트",
	 *	    "content":"수정게시글내용"
	 *	}
	 * @param dto
	 */
	@PutMapping("/boards")
	@ResponseBody
	public ApiResult<BoardVO> modifyBoard(@RequestBody BoardVO dto) {
		boardService.modifyBoard(dto);

		return new ApiResult<BoardVO>(null);
	}
	
	/**
	 * 게시글 삭제
	 * [DELETE] 192.168.111.104:80/exam/api/board/boards
	 * @param boardIndex
	 */
	@DeleteMapping("/boards/{boardIndex}")
	@ResponseBody
	public ApiResult<BoardVO> deleteBoard(
			@PathVariable("boardIndex")
			Long boardIndex) {
		
		boardService.deleteBoard(boardIndex);

		return new ApiResult<BoardVO>(null);
	}
}
