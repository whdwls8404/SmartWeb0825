/*
	댓글형 게시판
	1. 공지사항 : notice
	2. 댓글 : reply
*/
DROP TABLE REPLY;
DROP TABLE NOTICE;

CREATE TABLE NOTICE
(
	/* 게시글번호 */	NNO				NUMBER,
	/* 작성자 */		WRITER			VARCHAR2(50),
	/* 제목 */			TITLE			VARCHAR2(2000),
	/* 내용 */			CONTENT			VARCHAR2(4000),
	/* 조회수 */		HIT				NUMBER,
	/* 작성자IP */		IP				VARCHAR2(32),
	/* 작성일 */		NDATE			DATE,
	/* 최종수정일 */	NLASTMODIFIED	DATE
);
CREATE TABLE REPLY
(
	/* 댓글번호 */		RNO		NUMBER,
	/* 작성자 */		WRITER	VARCHAR2(50),
	/* 댓글내용 */		CONTENT	VARCHAR2(2000),
	/* 작성자IP */		IP		VARCHAR2(32),
	/* 게시글번호 */	NNO		NUMBER,
	/* 댓글작성일 */	RDATE	DATE
);

ALTER TABLE NOTICE ADD CONSTRAINT NOTICE_PK PRIMARY KEY(NNO);
ALTER TABLE REPLY ADD CONSTRAINT REPLY_PK PRIMARY KEY(RNO);

ALTER TABLE REPLY ADD CONSTRAINT REPLY_NOTICE_FK FOREIGN KEY(NNO) REFERENCES NOTICE(NNO) ON DELETE CASCADE;

DROP SEQUENCE NOTICE_SEQ;
DROP SEQUENCE REPLY_SEQ;
CREATE SEQUENCE NOTICE_SEQ NOCACHE;
CREATE SEQUENCE REPLY_SEQ NOCACHE;

INSERT INTO NOTICE 
VALUES (NOTICE_SEQ.NEXTVAL, '관리자', '이용 시 주의사항', '바른말 사용하기', 0, '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE);
COMMIT














