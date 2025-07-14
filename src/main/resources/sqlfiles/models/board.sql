--------------------------------- 게시판

CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;

-- CREATE TABLE
CREATE TABLE board_tbl (
	board_index			NUMBER(10, 0),
	board_child_count	NUMBER(5) DEFAULT 0,
	board_title			VARCHAR2(200),
	board_content		VARCHAR2(2000),
	board_view_count	NUMBER(10, 0) DEFAULT 0,
	board_create_date	DATE DEFAULT SYSDATE,
	board_update_date	DATE DEFAULT SYSDATE,
	deleted 			CHAR(1) DEFAULT 'N',
	
	user_id				VARCHAR2(50),
	PRIMARY KEY (board_index)
)
DROP TABLE board_tbl;
SELECT * FROM board_tbl;

-- 더미 INSERT
INSERT INTO board_tbl (board_index, board_title, board_content, user_id)
VALUES (board_seq.nextVal,
	'테스트 게시글1',
	'내용1234',
	'junotest'
);



-- 1. 게시글 작성 ( 제목, 내용, 작성자 )
INSERT INTO board_tbl (
	board_index, 
	board_title,
	board_content,
	user_id
)
VALUES (
	board_seq.nextVal,
	'title',
	'content',
	'junotest'
);


-- 2. 게시글 목록 조회
SELECT * FROM (
	SELECT 
		board_index as boardIndex,
		board_child_count as childCount,
		board_title as title,
		board_content as content,
		board_view_count as viewCount,
		board_update_date as updateDate,
		deleted as deletedYn,
		user_name as writer
	FROM board_tbl B JOIN user_tbl U
		ON B.user_id = U.user_id
	ORDER BY board_index DESC
)
ORDER BY ROWNUM



-- 3. 게시글 상세 조회 ( 보드 ID )
SELECT 
	board_index as boardIndex,
	board_child_count as childCount,
	board_title as title,
	board_content as content,
	board_view_count as viewCount,
	board_create_date as createDate,
	board_update_date as updateDate,
	deleted as deletedYn,
	user_name as writer
FROM board_tbl B JOIN user_tbl U
	ON B.user_id = U.user_id
WHERE
	board_index = 1;
	
-- 3. 게시글 조회시 조회수 업데이트 ( 보드 ID )
UPDATE board_tbl 
SET
	board_view_count = board_view_count + 1

WHERE board_index = 1;

	

-- 4. 게시글 수정 ( 제목, 내용, 보드ID )
UPDATE board_tbl 
SET
	board_title = '테스트 게시글 수정',
	board_content = '수정된 내용',
	board_update_date = SYSDATE

WHERE board_index = 1;




-- 5. 게시글 SOFT 삭제 ( 보드 ID )
UPDATE board_tbl 
SET
	deleted = 'Y'

WHERE board_index = 1;


