package org.spring.exam.models.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long boardIndex;
	private int childCount;
	private String title;
	private String content;
	private Long viewCount;
	private Date createDate;
	private Date updateDate;
	private String deletedYn;
	private String writer;
}
